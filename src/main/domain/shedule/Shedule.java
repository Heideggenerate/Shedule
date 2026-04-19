package domain.shedule;

import dto.CompiledLesson;
import entities.Lesson;
import entities.Teacher;
import dto.builders.CompiledLessonsBuilder;
import repository.Lessons;
import repository.Teachers;

import java.util.*;

public class Shedule {

    private final Lessons lessonsRepo;
    private final Teachers teachersRepo;
    private Map<Lesson, HashSet<Teacher>> table;


    public Shedule(Lessons lessonsRepo, Teachers teachersRepo) {
        this.lessonsRepo = lessonsRepo;
        this.teachersRepo = teachersRepo;
    }



    public List<CompiledLesson> shedule() {
        this.table = tableLessonsTeachers();
        if (!forwardCheck())
            return null;
        List<CompiledLesson> compiledLessons = new ArrayList<>();
        sheduleCreate(lessonsRepo.get().size(), compiledLessons);
        return compiledLessons;
    }

    private boolean sheduleCreate(int count, List<CompiledLesson> compiledLessons) {
        if (count == 0)
            return true;

        Lesson leastTeachersLesson = leastTeachersLesson();
        HashSet<Teacher> teachersOnLesson = table.get(leastTeachersLesson);
        int size = teachersOnLesson.size();

        while (size-- > 0) {
            Teacher chosenTeacher = chooseTeacher(teachersOnLesson);
            chosenTeacher.deleteTime(leastTeachersLesson.day(), leastTeachersLesson.time());
            List<Lesson> lessonRemovedTeachers = updateTeachers(chosenTeacher);

            if (lessonRemovedTeachers == null) {
                chosenTeacher.addAvailableTime(leastTeachersLesson.day(), leastTeachersLesson.time());
                return false;
            }
            CompiledLesson compiledLesson = new CompiledLessonsBuilder(leastTeachersLesson).setTeacher(chosenTeacher).build();
            compiledLessons.add(compiledLesson);
            table.remove(leastTeachersLesson);
            if (sheduleCreate(count - 1, compiledLessons))
                return true;
            table.put(leastTeachersLesson, teachersOnLesson);
            addTeacherToLessons(lessonRemovedTeachers, chosenTeacher);
            compiledLessons.remove(compiledLesson);
            chosenTeacher.addAvailableTime(leastTeachersLesson.day(), leastTeachersLesson.time());
        }
        return false;
    }



    //TODO: Добавить логику выбора учителя с наибольшим диапазоном времени
    private Teacher chooseTeacher(HashSet<Teacher> teacherOnLesson) {
        return teacherOnLesson.iterator().next();
    }

    private void addTeacherToLessons(List<Lesson> lessons, Teacher teacher) {
        if (lessons == null)
            return;
        for (Lesson lesson : lessons) {
            table.get(lesson).add(teacher);
        }
    }

    private List<Lesson> updateTeachers(Teacher usedTeacher) {
        Set<Lesson> lessons = table.keySet();
        List<Lesson> chosenLessons = new ArrayList<>(lessons.size());
        int count = 0;
        for (Lesson lesson : lessons) {
            HashSet<Teacher> teachers = table.get(lesson);
            if (!teachers.contains(usedTeacher))
                continue;
            if (!usedTeacher.isAvailableTime(lesson.day(), lesson.time())) {
                teachers.remove(usedTeacher);
                chosenLessons.add(lesson);
            }
            if (isLessonNoTeachers(lesson) && count++ != 0) {
                addTeacherToLessons(chosenLessons, usedTeacher);
                return null;
            }
        }
        return chosenLessons;
    }

    private boolean isLessonNoTeachers(Lesson lesson) {
        return table.get(lesson).isEmpty();
    }

    private boolean forwardCheck() {
        Set<Lesson> lessons = table.keySet();
        for (Lesson lesson : lessons) {
            if (isLessonNoTeachers(lesson))
                return false;
        }
        return true;
    }

    private Lesson leastTeachersLesson() {
        Set<Lesson> lessons = table.keySet();
        int minTeachersSize = Integer.MAX_VALUE;
        Lesson minTeachersLesson = null;
        for (Lesson lesson : lessons) {
            int size = table.get(lesson).size();
            if (minTeachersSize > size) {
                minTeachersSize = size;
                minTeachersLesson = lesson;
            }
        }
        return minTeachersLesson;
    }

    private Map<Lesson, HashSet<Teacher>> tableLessonsTeachers() {
        Map<Lesson, HashSet<Teacher>> table = new HashMap<>();
        List<Lesson> lessons = lessonsRepo.get();
        List<Teacher> teachers = teachersRepo.get();

        for (Lesson lesson : lessons) {
            if (!table.containsKey(lesson))
                table.put(lesson, new HashSet<>());
            for (Teacher teacher : teachers) {
                if (teacher.isAvailableTime(lesson.day(), lesson.time()))
                    table.get(lesson).add(teacher);
            }
        }
        return table;
    }


}
