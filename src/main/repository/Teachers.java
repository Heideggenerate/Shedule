package repository;

import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Teachers {

    private final List<Teacher> teachers = new ArrayList<>();

    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> get() {
        return teachers;
    }

}
