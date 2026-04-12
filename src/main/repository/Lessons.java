package repository;

import entities.Lesson;

import java.util.ArrayList;
import java.util.List;

public class Lessons {

    private final List<Lesson> lessons = new ArrayList<>();

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

}
