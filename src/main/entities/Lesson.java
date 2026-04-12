package entities;


import values.Time;

public class Lesson {

    private final Time[] time;
    private final Day day;
    private String subjectName;
    private Teacher teacher;

    public Lesson(Day day, Time start, Time end) {
        this.time = new Time[]{start, end};
        this.day = day;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Day getDay() {
        return day;
    }

    public Time getStartTime() {
        return time[0];
    }

    public Time getEndTime() {
        return time[1];
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
