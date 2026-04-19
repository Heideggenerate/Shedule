package dto;

import entities.Audience;
import entities.Lesson;
import entities.Teacher;

public record CompiledTeacher(Teacher teacher, Lesson lesson, Audience audience) {

}
