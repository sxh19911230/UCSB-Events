package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Forrest on 2016/6/1.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String shownname;
    /**
     * @param id Id
     * @param u  username
     * @param p  password
     * @param e  email
     * @param s  shownname
     */
    User(int id, String u, String p, String e, String s){
        username=u;
        password=p;
        email=e;
        shownname=s;
        this.id=id;
    }
    /**
     @return username
     */
    public String getUsername(){return this.username;}
    /**
     @return password
     */
    public String getPassword(){return this.password;}
    /**
     @return email
     */
    public String getEmail(){return this.email;}
    /**
     @return shownname
     */
    public String getShownname(){return this.shownname;}
    /**
     @return id
     */
    public int getID(){return this.id;}
    /**
     @param password the password the user wishes to be used
     @throws SQLException throws exception if password could not be set
     */
    public void setPassword(String password) throws SQLException{
        this.password=password;
        CS185Connector.setPassword(id, password);
    }
    /**
     @param email the email the user wishes to be used
     @throws SQLException throws exception if email could not be set
     */
    public void setEmail(String email) throws SQLException{
        this.email=email;
        CS185Connector.setEmail(id, email);
    }
    /**
     @param shownname the shown name the user wishes to be used
     @throws SQLException throws exception if shown name could not be set
     */
    public void setShownname(String shownname) throws SQLException{
        this.shownname=shownname;
        CS185Connector.setShownName(id, shownname);
    }
    /**
     Adds event to by this user
     @param e The event to be added
     @throws SQLException throws exception if event could not be added
     */
    public void addEvent(Event e) throws SQLException {
        CS185Connector.saveEvent(this, e);
    }
    /**
     @return an ArrayList of all the events that belong to a user
     @throws SQLException throws exception if Schedule could not be retrieved
     */
    public ArrayList<Event> getSchedule() throws SQLException {
        return CS185Connector.getUserEvents(this);
    }
    /**
     Deletes all events that belong to a user
     @throws SQLException throws exception if schedule could not be deleted
     */
    public void deleteSchedule() throws SQLException {
        CS185Connector.deleteUserEvents(this);
    }
}
