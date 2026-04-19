package dto.builders;

import dto.CompiledTeacher;
import entities.Audience;
import entities.Lesson;
import entities.Teacher;

public class CompiledTeacherBuilder implements IBuilder<CompiledTeacher> {

    private final Teacher teacher;
    private Lesson lesson;
    private Audience audience;

    public CompiledTeacherBuilder(Teacher teacher) {
        this.teacher = teacher;
    }

    public CompiledTeacherBuilder setLesson(Lesson lesson) {
        this.lesson = lesson;
        return this;
    }

    public CompiledTeacherBuilder setAudience(Audience audience) {
        this.audience = audience;
        return this;
    }

    @Override
    public CompiledTeacher build() {
        return new CompiledTeacher(teacher, lesson, audience);
    }


}
