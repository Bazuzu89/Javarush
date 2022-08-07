package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private ArrayList<LogEvent> eventsList;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        eventsList = new ArrayList<>();
        populateEventsList();
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if (isDateBetween(logEvent.getDate(), after, before)) {
                ips.add(logEvent.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> resultIPsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if ((logEvent.getUser().equals(user)) && isDateBetween(logEvent.getDate(), after, before)) {
                resultIPsSet.add(logEvent.getIp());
            }
        }
        return resultIPsSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> resultIPsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(event.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                resultIPsSet.add(logEvent.getIp());
            }
        }
        return resultIPsSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> resultIPsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if ((logEvent.getStatus().equals(status.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                resultIPsSet.add(logEvent.getIp());
            }
        }
        return resultIPsSet;
    }

    private boolean isDateBetween(String eventDate, Date after, Date before) {

        Date date = parseStringToDate(eventDate);

        if ((after == null || date.after(after)) &&  (before == null || date.before(before))) {
            return true;
        } else {
            return false;
        }
    }

    private void populateEventsList() {
        for (File file : logDir.toFile().listFiles()) {
            if (file.getAbsolutePath().endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    while (reader.ready()) {
                        String log = reader.readLine();
                        String[] logParamsArray = log.split("\t");
                        String ip = logParamsArray[0];
                        String user = logParamsArray[1];
                        String date = logParamsArray[2];
                        String event = logParamsArray[3];
                        String status = logParamsArray[4];
                        LogEvent logEvent = new LogEvent(ip, user, date, event, status);
                        eventsList.add(logEvent);
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            allUsersSet.add(logEvent.getUser());
        }
        return allUsersSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        HashSet<String> setOfUsers = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if(isDateBetween(logEvent.getDate(), after, before)) {
                setOfUsers.add(logEvent.getUser());
            }
        }
        return setOfUsers.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        HashSet<String> eventsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if ((logEvent.getUser().equals(user)) && isDateBetween(logEvent.getDate(), after, before)) {
                String eventString = logEvent.getEvent().split(" ")[0];
                eventsSet.add(eventString);
            }
        }
        return eventsSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        HashSet<String> setOfUsers = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if((logEvent.getIp().equals(ip)) && isDateBetween(logEvent.getDate(), after, before)) {
                setOfUsers.add(logEvent.getUser());
            }
        }
        return setOfUsers;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(Event.LOGIN.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(Event.DOWNLOAD_PLUGIN.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(Event.WRITE_MESSAGE.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(Event.SOLVE_TASK.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if ((eventString.equals(Event.SOLVE_TASK.toString())) && isDateBetween(logEvent.getDate(), after, before) && i == task) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(Event.DONE_TASK.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        HashSet<String> usersSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if ((eventString.equals(Event.DONE_TASK.toString())) && isDateBetween(logEvent.getDate(), after, before) && i == task) {
                usersSet.add(logEvent.getUser());
            }
        }
        return usersSet;
    }

    private Date parseStringToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy H:m:s");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return date;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        HashSet<Date> dateSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String eventString = logEvent.getEvent().split(" ")[0];
            if ((eventString.equals(event.toString())) && isDateBetween(logEvent.getDate(), after, before) && user.equals(logEvent.getUser())) {
                dateSet.add(parseStringToDate(logEvent.getDate()));
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        HashSet<Date> dateSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String status = logEvent.getStatus();
            if ((status.equals(Status.FAILED.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                dateSet.add(parseStringToDate(logEvent.getDate()));
            }
        }
        return dateSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        HashSet<Date> dateSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            String status = logEvent.getStatus();
            if ((status.equals(Status.ERROR.toString())) && isDateBetween(logEvent.getDate(), after, before)) {
                dateSet.add(parseStringToDate(logEvent.getDate()));
            }
        }
        return dateSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date firstLoggingDate = null;
        Set<Date> loggingDates = getDatesForUserAndEvent(user, Event.LOGIN, after, before);
        if (loggingDates.size() > 0) {
            firstLoggingDate = new Date(Long.MAX_VALUE);
            for (Date date : loggingDates) {
                if (date.before(firstLoggingDate)) {
                    firstLoggingDate = date;
                }
            }
        }
        return firstLoggingDate;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date firstSolvedTaskDate = null;
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if ((eventString.equals(Event.SOLVE_TASK.toString())) && isDateBetween(logEvent.getDate(), after, before) && user.equals(logEvent.getUser()) && i == task) {
                Date loggingDate = parseStringToDate(logEvent.getDate());
                if (firstSolvedTaskDate == null) {
                    firstSolvedTaskDate = new Date(Long.MAX_VALUE);
                }
                if (loggingDate.before(firstSolvedTaskDate)) {
                    firstSolvedTaskDate = loggingDate;
                }
            }
        }
        return firstSolvedTaskDate;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date firstLoggingDate = null;
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if ((eventString.equals(Event.DONE_TASK.toString())) && isDateBetween(logEvent.getDate(), after, before) && user.equals(logEvent.getUser()) && i == task) {
                Date loggingDate = parseStringToDate(logEvent.getDate());
                if (firstLoggingDate == null) {
                    firstLoggingDate = new Date(Long.MAX_VALUE);
                }
                if (loggingDate.before(firstLoggingDate)) {
                    firstLoggingDate = loggingDate;
                }
            }
        }
        return firstLoggingDate;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user, Event.WRITE_MESSAGE, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDatesForUserAndEvent(user, Event.DOWNLOAD_PLUGIN, after, before);
    }

    private Event parseStringToEvent(String eventString) {
        Event event;
        switch (eventString) {
            case  "LOGIN" : event = Event.LOGIN;  break;
            case  "DOWNLOAD_PLUGIN" : event = Event.DOWNLOAD_PLUGIN;  break;
            case  "WRITE_MESSAGE" : event = Event.WRITE_MESSAGE;  break;
            case  "SOLVE_TASK" : event = Event.SOLVE_TASK;  break;
            case  "DONE_TASK" : event = Event.DONE_TASK;  break;
            default : event = null;
        }
        return event;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> allEventsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if (isDateBetween(logEvent.getDate(), after, before)) {
                String eventString = logEvent.getEvent().split(" ")[0];
                allEventsSet.add(parseStringToEvent(eventString));
            }
        }
        return allEventsSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> allEventsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if (isDateBetween(logEvent.getDate(), after, before) && ip.equals(logEvent.getIp())) {
                String eventString = logEvent.getEvent().split(" ")[0];
                allEventsSet.add(parseStringToEvent(eventString));
            }
        }
        return allEventsSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> allEventsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if (isDateBetween(logEvent.getDate(), after, before) && user.equals(logEvent.getUser())) {
                String eventString = logEvent.getEvent().split(" ")[0];
                allEventsSet.add(parseStringToEvent(eventString));
            }
        }
        return allEventsSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> allEventsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if (isDateBetween(logEvent.getDate(), after, before) && Status.FAILED.toString().equals(logEvent.getStatus())) {
                String eventString = logEvent.getEvent().split(" ")[0];
                allEventsSet.add(parseStringToEvent(eventString));
            }
        }
        return allEventsSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> allEventsSet = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            if (isDateBetween(logEvent.getDate(), after, before) && Status.ERROR.toString().equals(logEvent.getStatus())) {
                String eventString = logEvent.getEvent().split(" ")[0];
                allEventsSet.add(parseStringToEvent(eventString));
            }
        }
        return allEventsSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if (isDateBetween(logEvent.getDate(), after, before) && Event.SOLVE_TASK.toString().equals(eventString) && i == task) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if (isDateBetween(logEvent.getDate(), after, before) && Event.DONE_TASK.toString().equals(eventString) && i == task /* && Status.OK.toString().equals(logEvent.getStatus())*/) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if (isDateBetween(logEvent.getDate(), after, before) && eventString.equals(Event.SOLVE_TASK.toString())) {
                if (!resultMap.containsKey(i)) {
                    resultMap.put(i, 1);
                } else {
                    int qty = resultMap.get(i) + 1;
                    resultMap.put(i, qty);
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (LogEvent logEvent : eventsList) {
            String[] event = logEvent.getEvent().split(" ");
            String eventString = event[0];
            int i = -1;
            if (event.length > 1)  {
                i = Integer.parseInt(event[1]);
            }
            if (isDateBetween(logEvent.getDate(), after, before) && eventString.equals(Event.DONE_TASK.toString())) {
                if (!resultMap.containsKey(i)) {
                    resultMap.put(i, 1);
                } else {
                    int qty = resultMap.get(i) + 1;
                    resultMap.put(i, qty);
                }
            }
        }
        return resultMap;
    }

    private Status parseStringToStatus(String statusString) {
        Status status;
        switch (statusString) {
            case  "OK" : status = Status.OK;  break;
            case  "FAILED" : status = Status.FAILED;  break;
            case  "ERROR" : status = Status.ERROR;  break;
            default : status = null;
        }
        return status;
    }

    private Set<Date> getAllUniqueDates() {
        Set<Date> allDates = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            allDates.add(parseStringToDate(logEvent.getDate()));
        }
        return allDates;
    }

    private Set<Status> getAllUniqueStatuses() {
        Set<Status> allStatuses = new HashSet<>();
        for (LogEvent logEvent : eventsList) {
            allStatuses.add(parseStringToStatus(logEvent.getStatus()));
        }
        return allStatuses;
    }


    @Override
    public Set<? extends Object> execute(String query) {
        Set<? extends Object> resultSet;
        switch (query) {
            case "get ip" : {
                resultSet = getUniqueIPs(null, null);
                break;
            }
            case "get user" : {
                resultSet = getAllUsers();
                break;
            }
            case "get date" : {
                resultSet = getAllUniqueDates();
                break;
            }
            case "get event" : {
                resultSet = getAllEvents(null, null);
                break;
            }
            case "get status" : {
                resultSet = getAllUniqueStatuses();
                break;
            }
            default : resultSet = executeWithParams(query);
        }
        return resultSet;
    }

    private Set<? extends Object> executeWithParams(String query) {
        String[] queryWithDates = query.split(" and date between ");
        if (queryWithDates.length == 1) {
            return executeWithoutDates(query);
        } else {
            return executeWithDates(queryWithDates);
        }
    }

    private Set<? extends Object> executeWithoutDates(String query) {
        String[] queryParams = query.split(" = ");
        if (queryParams.length > 1) {
            String field2Value = queryParams[1].replace("\"", "");
            String[] queryArray = queryParams[0].split(" ");
            String field1 = queryArray[1];
            String field2 = queryArray[3];
            List<LogEvent> interList = getListOfLogEventsWithFieldValue(field2, field2Value);
            switch (field1) {
                case "ip": {
                    Set<String> resultSet = new HashSet<>();
                    interList.stream().map(logEvent -> logEvent.getIp()).forEach(resultSet::add);
                    return resultSet;
                }
                case "user": {
                    Set<String> resultSet = new HashSet<>();
                    interList.stream().map(logEvent -> logEvent.getUser()).forEach(resultSet::add);
                    return resultSet;
                }
                case "date": {
                    Set<Date> resultSet = new HashSet<>();
                    interList.stream().map(logEvent -> parseStringToDate(logEvent.getDate())).forEach(resultSet::add);
                    return resultSet;
                }
                case "event": {
                    Set<Event> resultSet = new HashSet<>();
                    interList.stream().map(logEvent -> parseStringToEvent(logEvent.getEvent().split(" ")[0])).forEach(resultSet::add);
                    return resultSet;
                }
                case "status": {
                    Set<Status> resultSet = new HashSet<>();
                    interList.stream().map(logEvent -> parseStringToStatus(logEvent.getStatus())).forEach(resultSet::add);
                    return resultSet;
                }
                default:
                    return new HashSet<>();
            }
        } else {
            return new HashSet<>();
        }
    }

    private Set<? extends Object> executeWithDates(String[] queryWithDates) {
        String[] queryParams = queryWithDates[0].split(" = ");
        String[] dates = queryWithDates[1].split(" and ");
        String afterString = dates[0]; Date after = parseStringToDate(afterString.replace("\"", ""));
        String beforeString = dates[1]; Date before = parseStringToDate(beforeString.replace("\"", ""));
        if (queryParams.length > 1) {
            String field2Value = queryParams[1].replace("\"", "");
            String[] queryArray = queryParams[0].split(" ");
            String field1 = queryArray[1];
            String field2 = queryArray[3];
            List<LogEvent> interList = getListOfLogEventsWithFieldValue(field2, field2Value).stream()
                    .filter(logEvent -> isDateBetween(logEvent.getDate(), after, before))
                    .collect(Collectors.toList());
            switch (field1) {
                case "ip": {
                    Set<String> resultSet = new HashSet<>();
                    interList.stream()
                            .map(logEvent -> logEvent.getIp())
                            .forEach(resultSet::add);
                    return resultSet;
                }
                case "user": {
                    Set<String> resultSet = new HashSet<>();
                    interList.stream()
                            .map(logEvent -> logEvent.getUser())
                            .forEach(resultSet::add);
                    return resultSet;
                }
                case "date": {
                    Set<Date> resultSet = new HashSet<>();
                    interList.stream()
                            .map(logEvent -> parseStringToDate(logEvent.getDate()))
                            .forEach(resultSet::add);
                    return resultSet;
                }
                case "event": {
                    Set<Event> resultSet = new HashSet<>();
                    interList.stream()
                            .map(logEvent -> parseStringToEvent(logEvent.getEvent().split(" ")[0]))
                            .forEach(resultSet::add);
                    return resultSet;
                }
                case "status": {
                    Set<Status> resultSet = new HashSet<>();
                    interList.stream()
                            .map(logEvent -> parseStringToStatus(logEvent.getStatus()))
                            .forEach(resultSet::add);
                    return resultSet;
                }
                default:
                    return new HashSet<>();
            }
        } else {
            return new HashSet<>();
        }
    }

    private List<LogEvent> getListOfLogEventsWithFieldValue(String field, String value) {
        switch (field) {
            case "ip" : {
                return eventsList.stream().filter(logEvent -> logEvent.getIp().equals(value)).collect(Collectors.toList());
            }
            case "user" : {
                return eventsList.stream().filter(logEvent -> logEvent.getUser().equals(value)).collect(Collectors.toList());
            }
            case "date" : {
                return eventsList.stream().filter(logEvent -> logEvent.getDate().equals(value)).collect(Collectors.toList());
            }
            case "event" : {
                return eventsList.stream().filter(logEvent -> logEvent.getEvent().split(" ")[0].equals(value)).collect(Collectors.toList());
            }
            case "status" : {
                return eventsList.stream().filter(logEvent -> logEvent.getStatus().equals(value)).collect(Collectors.toList());
            }
            default : return new ArrayList<>();
        }
    }
}