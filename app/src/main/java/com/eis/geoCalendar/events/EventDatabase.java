package com.eis.geoCalendar.events;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Handles memorization of events in phone memory.
 *
 * @param <E> Event type.
 * @author Luca Crema
 * @version 1.0
 * @since 21/21/2019
 */
public interface EventDatabase<E extends Event> {

    /**
     * Saves an event in memory.
     *
     * @param event The event.
     */
    void saveEvent(@NonNull final E event);

    /**
     * Saves a list of events in memory.
     *
     * @param events The list of events.
     */
    void saveEvents(@NonNull final Collection<E> events);

    /**
     * Removes an event from memory.
     *
     * @param event The event.
     * @return {@code true} if the event was present and has been removed, {@code false} otherwise.
     */
    boolean removeEvent(@NonNull final E event);

    /**
     * Removes a list of events from memory.
     *
     * @param events The list of events.
     * @return A map that associates to every event if it was present and has been removed or not.
     */
    Map<E,Boolean> removeEvents(@NonNull final Collection<E> events);

    /**
     * Retrieves all saved events from memory.
     *
     * @return An {@link ArrayList} of saved events.
     */
    ArrayList<E> getSavedEvents();
}
