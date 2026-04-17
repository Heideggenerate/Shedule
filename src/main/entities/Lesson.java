package entities;


import values.Time;
import values.TimeRange;

public class Lesson {

    private final TimeRange time;
    private final Day day;
    private final String subjectName;
    private Teacher teacher;

    public Lesson(Day day, TimeRange timeRange, String subjectName) {
        this.time = timeRange;
        this.day = day;
        this.subjectName = subjectName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Day getDay() {
        return day;
    }

    public TimeRange getTime() {
        return time;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
