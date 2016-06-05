package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import java.util.Date;

/**
 * Created by Forrest on 2016/6/1.
 */
public class Event {
    private int eid;
    private int uid;
    private String eventTitle;
    private Date eventDate;             // maybe use a date picker for this? (like in homework 3)
    private String eventDescription;

    //Location. Don't edit these three line
    private String locationName;
    private Double latitude;
    private Double longitude;

    private String eventHost;
    private String category;

}
