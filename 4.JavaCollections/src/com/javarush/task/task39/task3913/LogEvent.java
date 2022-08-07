package com.javarush.task.task39.task3913;

public class LogEvent {
    private String ip;
    private String user;
    private String date;
    private String event;
    private String status;

    public LogEvent(String ip, String user, String date, String event, String status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
