package dto;

import entities.Audience;
import entities.Lesson;
import entities.Teacher;

public record CompiledLesson(Lesson lesson, Teacher teacher, Audience audience) {

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CompiledLesson(Lesson lesson1, Teacher teacher1, Audience audience1)))
            return false;
        if (this == object)
            return true;
        return lesson1.equals(lesson) && teacher1.equals(teacher) && audience1.equals(audience);
    }

    @Override
    public String toString() {
        return lesson.toString() + " " + teacher.toString() + " " + audience;
    }
}
