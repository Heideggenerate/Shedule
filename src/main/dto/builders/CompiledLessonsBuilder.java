package dto.builders;

import dto.CompiledAudience;
import dto.CompiledLesson;
import entities.Audience;
import entities.Lesson;
import entities.Teacher;

public class CompiledLessonsBuilder implements IBuilder<CompiledLesson> {

    private final Lesson lesson;
    private Teacher teacher;
    private Audience audience;

    public CompiledLessonsBuilder(Lesson lesson) {
        this.lesson = lesson;
    }

    public CompiledLessonsBuilder setAudience(Audience audience) {
        this.audience = audience;
        return this;
    }

    public CompiledLessonsBuilder setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    @Override
    public CompiledLesson build() {
        return new CompiledLesson(lesson, teacher, audience);
    }
}
