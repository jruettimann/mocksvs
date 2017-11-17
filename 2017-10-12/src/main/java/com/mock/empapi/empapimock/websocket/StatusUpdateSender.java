package com.mock.empapi.empapimock.websocket;

import com.google.common.collect.Lists;
import com.mock.empapi.empapimock.data.Dao;
import com.mock.empapi.empapimock.data.Employee;
import com.mock.empapi.empapimock.data.PresenceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class StatusUpdateSender {

    public static final String QUEUE = "/onlineStatus";

    private Random random = new Random(799);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private Dao dao;

    @Scheduled(fixedRate = 1000)
    public void simulateStatusChanges() throws Exception {
        List<Employee> all = Lists.newArrayList(dao.findAll());
        int amountOfStatesToChange = all.size() / 10; // Nur einen Bruchteil der Stati ändern
        changeStatesAndInformObservers(all, amountOfStatesToChange);
    }

    private void changeStatesAndInformObservers(List<Employee> all, int amountOfStatesToChange) {
        for (int i = 0; i < amountOfStatesToChange; i++) {
            Employee employee = all.get(random.nextInt(all.size()));
            PresenceState newState = PresenceState.values()[random.nextInt(PresenceState.values().length)];
            if (employee.getPresenceState() != newState) { // Keine Änderung
                employee.setPresenceState(newState);
                sendStatusUpdateToObservers(employee);
            }
        }
    }

    private void sendStatusUpdateToObservers(Employee employee) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        String stateString = employee.getPresenceState().toString();
        StatusUpdate updateMessage = new StatusUpdate(fullName, stateString);
        messagingTemplate.convertAndSend(WebSocketConfig.TOPIC + QUEUE + "/" + employee.getId(), updateMessage); // Für SPEZIFISCHE Listeners
        messagingTemplate.convertAndSend(WebSocketConfig.TOPIC + QUEUE + "/all", updateMessage); // Für ALLGEMEINE Listeners
    }
}
