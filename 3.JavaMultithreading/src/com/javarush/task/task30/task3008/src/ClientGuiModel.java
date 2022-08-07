package com.javarush.task.task30.task3008.client;

import java.util.*;

public class ClientGuiModel {
    private final Set<String> allUserNames = new TreeSet<>();
    private String newMessage;

    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public String getNewMessage() {
        return this.newMessage;
    }

    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }

    public void deleteUser(String userName) {
        allUserNames.remove(userName);
    }
}
