package dto;

import entities.Audience;
import entities.Lesson;
import entities.Teacher;

public record CompiledAudience(Audience audience, Lesson lesson, Teacher teacher) {

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CompiledAudience(Audience audience1, Lesson lesson1, Teacher teacher1)))
            return false;
        if (this == object)
            return true;
        return audience1.equals(audience);
    }

    @Override
    public String toString() {
        return "NUM: " + audience.toString() + " " + lesson.toString() + " " + teacher.toString();
     }
}
