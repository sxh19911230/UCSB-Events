package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by Forrest on 2016/6/1.
 */
public class CS185Connector {

    static String url = "http://184.189.236.125:8080/request.php";
    static String charset = "UTF-8";

    public static String sendRequest(String query)  {

        InputStream response;
        String responseBody = null;
        try {
            response = new URL(url + "?" + query).openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
        }


        return responseBody;
    }

    /**
     * Registration for users
     * @param username desired Username
     * @param password desired password
     * @param email user's email
     * @param shownname user's shownname
     * @return User ID ID number from created user
     * @throws SQLException throws exception if user could not be created
     */
    public static String Register(String username, String password, String email, String shownname) {


        StringBuilder sb = new StringBuilder("activity=register&");
        sb.append("user_name");
        sb.append('=');
        sb.append(username);
        sb.append("&user_password=");
        sb.append(password);
        sb.append("&email_address=");

        if (email.equals(""))
            sb.append("null");
        else
            sb.append(email);

        sb.append("&shown_name=");

        if (shownname.equals(""))
            sb.append("null");
        else
            sb.append(shownname);



        return sb.toString();
    }
    /**
     * Login with username and password
     * @param username input username
     * @param password input password to match username
     * @return User ID ID number for the user
     * -1 if no username
     * -2 if wrong password
     * @throws SQLException  throws exception if connection fails
     */
    public static String getID(String username, String password) throws SQLException {

        int id = 0;

        return "";
    }

    /**
     * get User Infomation
     * @param ID User ID
     * @return User
     * @throws SQLException  throws exception if connection fails
     */
    public static User getInfo(int ID) throws SQLException{
        User u = null;

        return u;
    }

    /**
     * Used to get the user with username and password
     * @param userName Input username
     * @param password Corresponding password
     * @return User
     * @throws SQLException throws exception if connection fails
     */
    public static User getInfo(String userName, String password) throws SQLException{
        User u = null;

        return u;
    }
    /**
     * update password
     * @param ID User ID number
     * @param pw new Password
     * @throws SQLException throws exception if connection fails
     */
    public static void setPassword(int ID, String pw) throws SQLException {

    }
    /**
     * update email
     * @param ID User ID number
     * @param email new Email
     * @throws SQLException throws exception if connection fails
     */
    public static void setEmail(int ID, String email) throws SQLException {

    }
    /**
     * update shown name
     * @param ID User ID number
     * @param mj new Email
     * @throws SQLException throws exception if connection fails
     */
    public static void setShownName(int ID, String mj) throws SQLException  {

    }
    /**
     * Save the User Data
     * @param u User
     * @param e Event to be added
     * @throws SQLException throws exception if event could not be saved
     */
    public static void saveEvent(User u, Event e) throws SQLException {

    }
    /**
     * delete single Event in the schedule
     * @param e Event to be deleted
     * @throws SQLException throws exception if connection fails
     */
    public static void deleteEvent(Event e) throws SQLException {

    }
    /**
     * get all the schedules saved in DB
     * @param u User
     * @return An ArrayList containing all the Courses in the user's schedule
     * @throws SQLException throws exception if connection fails
     */
    public static ArrayList<Event> getUserEvents(User u) throws SQLException {

        ArrayList<Event> ca = new ArrayList<Event>();

        return ca;
    }
    /**
     * delete entire schedule
     * @param u User
     * @throws SQLException throws exception if connection fails
     */
    public static void deleteUserEvents(User u) throws SQLException {

    }


}
