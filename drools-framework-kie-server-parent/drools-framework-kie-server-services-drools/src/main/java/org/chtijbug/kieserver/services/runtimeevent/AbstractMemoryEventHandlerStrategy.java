package org.chtijbug.kieserver.services.runtimeevent;

import org.chtijbug.drools.entity.history.HistoryEvent;

/**
 * Created by nheron on 11/06/15.
 */
public interface AbstractMemoryEventHandlerStrategy {

    public abstract void handleMessageInternally(HistoryEvent historyEvent, SessionContext sessionContext);

    public abstract boolean isEventSupported(HistoryEvent historyEvent);


}
