package org.chtijbug.kieserver.services.drools;

import org.chtijbug.drools.entity.history.HistoryEvent;
import org.chtijbug.drools.runtime.DroolsChtijbugException;
import org.chtijbug.drools.runtime.listener.HistoryListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nheron on 07/07/2016.
 */
public class ChtijbugHistoryListener implements HistoryListener {

    private List<HistoryEvent> historyEventLinkedList = new ArrayList<>();

    public List<HistoryEvent> getHistoryEventLinkedList() {
        return historyEventLinkedList;
    }

    @Override
    public void fireEvent(HistoryEvent newHistoryEvent) throws DroolsChtijbugException {
        historyEventLinkedList.add(newHistoryEvent);

    }
}
