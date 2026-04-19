package entities;


import values.Day;
import values.TimeRange;

public record Lesson(Day day, TimeRange time, String subjectName) {

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Lesson(Day day1, TimeRange time1, String subjectName1)))
            return false;
        if (this == object)
            return true;
        return day1.equals(day) && time1.equals(time) && subjectName1.equals(subjectName);
    }


    @Override
    public String toString() {
        return "DAY: " + day.toString() + " " + time.toString() + "SUBJECT: " + subjectName;
    }
}
