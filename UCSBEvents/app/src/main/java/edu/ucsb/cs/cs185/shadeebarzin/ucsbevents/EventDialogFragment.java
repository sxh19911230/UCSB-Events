package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;

/**
 * Created by shadeebarzin on 6/5/16.
 */
public class EventDialogFragment extends DialogFragment {

    String eventTitle;
    String eventDate;
    String eventTime;
    String eventHost;
    String eventLocation;
    String eventDescription;
    String eventCategory;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        eventTitle = getArguments().getString("title");
        eventDate = getArguments().getString("date");
        eventTime = getArguments().getString("time");
        eventHost = getArguments().getString("host");
        eventLocation = getArguments().getString("location");
        eventDescription = getArguments().getString("descrip");
        eventCategory = getArguments().getString("category");

        String toDisplay = "<html><b>Title: </b>" + eventTitle + "<br><br>" +
                "<b>Date: </b>" + eventDate + "<br><br>" +
                "<b>Time: </b>" + eventTime + "<br><br>" +
                "<b>Host: </b>" + eventHost + "<br><br>" +
                "<b>Location: </b>" + eventLocation + "<br><br>" +
                "<b>Description: </b>" + eventDescription + "<br><br>" +
                "<b>Category: </b>" + eventCategory;

        builder.setMessage(Html.fromHtml(toDisplay))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
