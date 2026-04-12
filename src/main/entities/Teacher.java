package entities;

import values.Time;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

public class Teacher {

    private final String name;
    private final EnumMap<Day, List<Time[]>> availableDaysTime = new EnumMap<>(Day.class);

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAvailableTime(Day day, Time startTime, Time endTime) {
        Time[] availableTime = {startTime, endTime};
        if (!availableDaysTime.containsKey(day))
            availableDaysTime.put(day, new ArrayList<Time[]>());
        availableDaysTime.get(day).add(availableTime);
    }

    //Ввести разбиение на 2 времени в случае, если был удалён внутренний промежуток
    public Time[] deleteAvailableTime(Day day, Time startTime, Time endTime) {
        Time[] time = null;
        List<Time[]> availableDayTime = availableDaysTime.get(day);
        int size = availableDayTime.size();
        for (int i = 0; i < size; i++) {
            Time start = availableDayTime.get(i)[0];
            Time end = availableDayTime.get(i)[1];
            if (start.compare(startTime) <= 0 && end.compare(endTime)>= 0) {
                time = availableDayTime.get(i);
                availableDayTime.remove(i--);
                break;
            }
        }
        return time;
    }

    public boolean isAvailableTime(Day day, Time start, Time end) {
        if (!availableDaysTime.containsKey(day))
            return false;
        List<Time[]> daysTimes = availableDaysTime.get(day);
        for (Time[] timeRange : daysTimes) {
            if (timeRange[0].compare(start) <= 0 && timeRange[1].compare(end) >= 0)
                return true;
        }
        return false;
    }

    public void printAvailableTimes() {
        Set<Day> days = availableDaysTime.keySet();
        for (Day day : days) {
            System.out.println("main.entities.Day: " + day.name());
            List<Time[]> dayTimes = availableDaysTime.get(day);
            for (Time[] timeRange : dayTimes)
                System.out.println("Start: " + timeRange[0] + "| End: " + timeRange[1]);
        }
    }
}
