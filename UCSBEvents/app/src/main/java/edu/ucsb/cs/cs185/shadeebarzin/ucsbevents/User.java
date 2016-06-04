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

    public int getID() {
        return id;
    }
    /**
     @return id
     */

}
