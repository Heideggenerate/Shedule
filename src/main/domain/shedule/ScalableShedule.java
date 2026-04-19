package domain.shedule;

import entities.Audience;
import entities.Lesson;
import entities.Teacher;
import repository.Audiences;
import repository.Lessons;
import repository.Teachers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScalableShedule {

    private record Restrictions(Teacher teacher, Audience audience) {};


    private final Lessons lessons;
    private final Teachers teachers;
    private final Audiences audiences;
    private final Map<Lesson, Set<Restrictions>> table;


    public void shedule() {

    }


    private Map<Lesson, Set<Restrictions>> table() {
        HashMap<Lesson, Set<Restrictions>> table = new HashMap<>();

    }

    private void fillAudiences(Set<Restrictions> restrictions) {
        
    }
}
