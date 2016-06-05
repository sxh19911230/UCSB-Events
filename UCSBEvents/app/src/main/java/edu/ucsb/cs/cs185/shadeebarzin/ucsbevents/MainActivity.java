package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_LOGIN = 0;
    private static final int REQUEST_SIGNUP = 1;
    private static final int REQUEST_GOOGLE_MAP = 2;

    private User user = null;
    private boolean loggedIn = false;

    private FloatingActionButton fab;

    ArrayList<Event> events = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user == null) ucsbeventlogin();
                createEvent();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        refreshEvents();





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem login = menu.findItem(R.id.action_login);
        MenuItem logout = menu.findItem(R.id.action_logout);

        if (loggedIn){
            login.setVisible(false);
            logout.setVisible(true);
        }
        else {
            login.setVisible(true);
            logout.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_list_view) {

        } else if (id == R.id.action_map_view) {
            googlemap();
        }
        else if (id == R.id.action_login) {
            ucsbeventlogin();
            //MOVED TO onActivityResult method. If the user cancel the login, the status doesn't change
            //loggedIn = true;
            //fab.setVisibility(View.VISIBLE);
        } else if (id == R.id.action_logout) {
            ucsbeventlogout();
        } else if (id == R.id.action_help){
            HelpDialogFragment helpDialogFragment = new HelpDialogFragment();
            helpDialogFragment.show(getFragmentManager(), "help clicked");
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.all) {

        } else if (id == R.id.club_meetings) {

        } else if (id == R.id.concerts) {

        } else if (id == R.id.fundraisers) {

        } else if (id == R.id.movies) {

        } else if (id == R.id.my_events) {

        } else if (id == R.id.my_help) {
            HelpDialogFragment helpDialogFragment = new HelpDialogFragment();
            helpDialogFragment.show(getFragmentManager(), "help clicked");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LOGIN || requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                user = new User(data.getIntExtra("id", -1), data.getStringExtra("username"), data.getStringExtra("password"), data.getStringExtra("email"), data.getStringExtra("name"));
                loggedIn = true;
                fab.setVisibility(View.VISIBLE);

            } else if (resultCode == RESULT_CANCELED) {

            }
        }
    }


    public void ucsbeventlogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivityForResult(intent, REQUEST_LOGIN);
    }


    public void ucsbeventlogout(){
        user = null;
        Toast.makeText(this, "Successfully logged out.", Toast.LENGTH_SHORT).show();
        loggedIn = false;
        fab.setVisibility(View.GONE);
    }


    public void googlemap() {
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivityForResult(intent, REQUEST_GOOGLE_MAP);
    }

    public void refreshEvents() {

        events = new ArrayList<>();

        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading Events...");
        progressDialog.show();

        class SendRequest extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String t = CS185Connector.sendRequest(params[0]);

                return t;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                String [] ra = result.split("\\n");

                for (int i = 0; i < ra.length/10; i+=10) {
                    String testDate = ra[i + 3];
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = null;
                    try {
                        date = formatter.parse(testDate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    events.add(new Event(Integer.parseInt(ra[i]), Integer.parseInt(ra[i + 1]), ra[i + 2], date, ra[i + 4], ra[i + 5], Double.parseDouble(ra[i + 6]), Double.parseDouble(ra[i + 7]), ra[i + 8], ra[i + 9]));


                }

            }
        }

        SendRequest sendRequest = new SendRequest();
        sendRequest.execute("activity=get_events");


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        progressDialog.dismiss();
                    }
                }, 3000);

    }

    void createEvent() {
        if (user != null) {
            Intent intent = new Intent(getApplicationContext(), EventCreateAcitvity.class);
            intent.putExtra("uid", user.getID());
            intent.putExtra("name", user.getShownname());
            startActivity(intent);
        }
    }
}
