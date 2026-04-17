package domain;

import entities.Day;
import entities.Lesson;
import entities.Teacher;
import repository.Lessons;
import repository.Teachers;

import java.util.*;

import values.Time;
import values.TimeRange;

public class SheduleCreator {

    public record TeacherLesson(Lesson lesson, Teacher teacher) { }

    private final Lessons lessonsRepo;
    private final Teachers teachersRepo;
    private Map<Lesson, HashSet<Teacher>> table;


    public SheduleCreator(Lessons lessonsRepo, Teachers teachersRepo) {
        this.lessonsRepo = lessonsRepo;
        this.teachersRepo = teachersRepo;
    }



    public boolean shedule() {
        this.table = tableLessonsTeachers();
        if (!forwardCheck())
            return false;
        return sheduleCreate(lessonsRepo.getLessons().size());
    }

    private boolean sheduleCreate(int count) {
        if (count == 0)
            return true;

        Lesson leastTeachersLesson = leastTeachersLesson();
        HashSet<Teacher> teachersOnLesson = table.get(leastTeachersLesson);
        int size = teachersOnLesson.size();
        while (size-- > 0) {
            Teacher chosenTeacher = chooseTeacher(teachersOnLesson);
            chosenTeacher.deleteTime(leastTeachersLesson.getDay(), leastTeachersLesson.getTime());
            List<Lesson> lessonRemovedTeachers = updateTeachers(chosenTeacher);
            leastTeachersLesson.setTeacher(chosenTeacher);

            if (lessonRemovedTeachers == null) {
                leastTeachersLesson.setTeacher(null);
                chosenTeacher.addAvailableTime(leastTeachersLesson.getDay(), leastTeachersLesson.getTime());
                return false;
            }
            table.remove(leastTeachersLesson);
            if (sheduleCreate(count - 1))
                return true;
            table.put(leastTeachersLesson, teachersOnLesson);
            addTeacherToLessons(lessonRemovedTeachers, chosenTeacher);
            leastTeachersLesson.setTeacher(null);
            chosenTeacher.addAvailableTime(leastTeachersLesson.getDay(), leastTeachersLesson.getTime());
        }
        leastTeachersLesson.setTeacher(null);
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
            if (!usedTeacher.isAvailableTime(lesson.getDay(), lesson.getTime())) {
                teachers.remove(usedTeacher);
                chosenLessons.add(lesson);
            }
            if (isLessonNoTeachers(lesson) && count != 0) {
                addTeacherToLessons(chosenLessons, usedTeacher);
                return null;
            }
            count++;
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
        List<Lesson> lessons = lessonsRepo.getLessons();
        List<Teacher> teachers = teachersRepo.getTeachers();

        for (Lesson lesson : lessons) {
            if (!table.containsKey(lesson))
                table.put(lesson, new HashSet<>());
            for (Teacher teacher : teachers) {
                if (teacher.isAvailableTime(lesson.getDay(), lesson.getTime()))
                    table.get(lesson).add(teacher);
            }
        }
        return table;
    }


}
