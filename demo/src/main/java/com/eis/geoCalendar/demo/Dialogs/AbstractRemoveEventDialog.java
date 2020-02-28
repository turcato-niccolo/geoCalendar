package com.eis.geoCalendar.demo.Dialogs;

import androidx.fragment.app.DialogFragment;

import com.eis.geoCalendar.demo.Behaviour.listener.RemoveEventListener;
import com.google.android.gms.maps.model.Marker;

/**
 * This class defines a behaviour that a DialogFragment has to implement to define to be used
 * for interacting with the user for removing an Event through MapBehaviour objects
 *
 * @author Turcato
 */
public abstract class AbstractRemoveEventDialog extends DialogFragment {
    /**
     * @param marker Set the marker to be remove
     */
    public abstract void setMarker(Marker marker);

    /**
     * @param removeEventListener Listener to call when DELETE is pressed
     */
    public abstract void setRemoveEventListener(RemoveEventListener removeEventListener);
}