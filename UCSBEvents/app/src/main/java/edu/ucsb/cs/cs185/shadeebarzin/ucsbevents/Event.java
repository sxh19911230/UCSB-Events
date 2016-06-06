package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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

    public Event(int eid,int uid, String eventTitle,Date eventDate, String eventDescription, String locationName, Double latitude, Double longitude, String eventHost, String category) {
        this.eid = eid;
        this.uid = uid;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.eventHost = eventHost;
        this.category = category;
    }

    public Event(String eventTitle,Date eventDate, String eventDescription, String locationName, Double latitude, Double longitude, String eventHost, String category) {
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.eventHost = eventHost;
        this.category = category;
    }

    public int getEid() {
        return eid;
    }

    public int getUid() {
        return uid;
    }

    public String getEventTitle() {
        return eventTitle;
    }
    public Date getEventDate() {
        return eventDate;
    }
    public String getEventDescription() {
        return eventDescription;
    }
    public String getLocationName() {
        return locationName;
    }
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public String getEventHost() {
        return eventHost;
    }
    public String getCategory() { return category;}
    public String getEventDateString() { return new SimpleDateFormat("MM-dd-yyyy", Locale.US).format(eventDate); }
    public String getEventDateWords() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[eventDate.getMonth()] + " " + new SimpleDateFormat("dd, yyyy", Locale.US).format(eventDate);
    }
    public String getEventTimeString() { return new SimpleDateFormat("hh:mm a", Locale.US).format(eventDate); }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(eid);
        sb.append(' ');
        sb.append(uid);
        sb.append(' ');
        sb.append(eventTitle);
        sb.append(' ');
        sb.append(eventDate);
        sb.append(' ');
        sb.append(eventDescription);
        sb.append(' ');
        sb.append(locationName);
        sb.append(' ');

        return sb.toString();
    }

}
