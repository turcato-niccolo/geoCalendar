package com.eis.geoCalendar.demo.Dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.eis.geoCalendar.demo.Behaviour.listener.ResultEventListener;
import com.eis.geoCalendar.demo.R;
import com.google.android.gms.maps.model.LatLng;

/**
 * This class defines a DialogFragment to Create a Localized Event with Description defined by user
 *
 * @author Turcato
 */
public class AddEventDialog extends AbstractAddEventDialog {
    private ResultEventListener resultListener;
    private LatLng latLng;


    /**
     * Creates the dialog fragment using AlertDialog.Builder
     *
     * @param savedInstanceState System parameter
     * @return An AlertDialog object defined for creating a located event
     */
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Builder builder = new Builder(getActivity());
        builder.setTitle(R.string.CreateEventDialogTitle); //defined in strings.xml

        // Set up the input
        final EditText input = new EditText(getContext());
        // Specify the type of input expected; this, for example, sets the input as a normal text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        // Add the buttons
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                if (input.getText() != null && input.getText().length() > 0) {
                    resultListener.onEventReturn(latLng, input.getText().toString());
                }
                //Does nothing
            }
        });
        builder.setNegativeButton(R.string.CANCEL, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog

                dialog.cancel();
            }
        });

        return builder.create();
    }


    /**
     * @param resultEventListener Listener to call when result is available
     */
    public void setResultListener(ResultEventListener resultEventListener) {
        resultListener = resultEventListener;
    }

    /**
     * This method is used to store a gps Position
     *
     * @param latLng The position for an Event that must be created (in this dialog is not canceled)
     */
    public void setEventPosition(LatLng latLng) {
        this.latLng = latLng;
    }
}