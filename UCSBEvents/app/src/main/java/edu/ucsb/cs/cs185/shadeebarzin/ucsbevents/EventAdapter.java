package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shadeebarzin on 6/5/16.
 */
public class EventAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Event> eventList;

    EventAdapter(Context context){
        this.context = context;

    }

    EventAdapter(Context context, ArrayList<Event> eventList){
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        if (eventList == null)
            return 0;
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        if (eventList == null)
            return null;
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (eventList == null)
            return 0;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.event_item, null);
        TextView eventTitle = (TextView) convertView.findViewById(R.id.event_title);
        TextView eventDate = (TextView) convertView.findViewById(R.id.event_date);
        TextView eventTime = (TextView) convertView.findViewById(R.id.event_time);
//        TextView eventHost = (TextView) convertView.findViewById(R.id.event_host);
        TextView eventLocation = (TextView) convertView.findViewById(R.id.event_location);
//        TextView eventDescription = (TextView) convertView.findViewById(R.id.event_description);

        eventTitle.setText(eventList.get(position).getEventTitle());
        eventDate.setText(eventList.get(position).getEventDateWords());
        eventTime.setText(eventList.get(position).getEventTimeString());
//        eventHost.setText(eventList.get(position).getEventHost());
        eventLocation.setText(eventList.get(position).getLocationName());
//        eventDescription.setText(eventList.get(position).getEventDescription());

        return convertView;
    }

    void resetEventList(ArrayList<Event> eventList){
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    void resetEventList(Context context, ArrayList<Event> eventList){
        this.context = context;
        this.eventList = eventList;
        notifyDataSetChanged();
    }

}
