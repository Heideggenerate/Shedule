package domain;

import entities.Day;
import entities.Lesson;
import entities.Teacher;
import repository.Lessons;
import repository.Teachers;
import java.util.ArrayList;
import java.util.List;
import values.Time;

public class SheduleCreator {

    public record TeacherLesson(Lesson lesson, Teacher teacher) { }

    private final Lessons lessonsRepo;
    private final Teachers teachersRepo;
    private final List<Teacher> chosenTeachers = new ArrayList<>();
    public final List<TeacherLesson> chosenTeacherLessons = new ArrayList<>();


    public SheduleCreator(Lessons lessonsRepo, Teachers teachersRepo) {
        this.lessonsRepo = lessonsRepo;
        this.teachersRepo = teachersRepo;
    }


    public List<Teacher> sheduleCreate() {
        sheduleCreator(0, lessonsRepo.getLessons(), teachersRepo.getTeachers());
        return chosenTeachers;
    }


    //TODO: Исправить баг с добавлением вреемни урока, вместо времени преподавателя
    private boolean sheduleCreator(int lessonIdx, List<Lesson> lessons, List<Teacher> teachers) {
        int lessonsSize = lessons.size();
        int teachersSize = teachers.size();

        if (lessonsSize == 0)
            return true;

        for (int i = lessonIdx; i < lessonsSize; i++) {
            boolean foundTeacher = false;
            for (int j = 0; j < teachersSize; j++) {
                Lesson lesson = lessons.get(i);
                Teacher teacher = teachers.get(j);
                Day day = lesson.getDay();
                Time start = lesson.getStartTime();
                Time end = lesson.getEndTime();

                if (!teacher.isAvailableTime(day, start, end))
                    continue;
                chosenTeachers.add(teacher);
                //Тест
                chosenTeacherLessons.add(new TeacherLesson(lesson, teacher));
                int k = chosenTeachers.size() - 1;
                lessons.remove(i);
                Time[] removedTeacherTime = teacher.deleteAvailableTime(day, start, end);
                if (sheduleCreator(i, lessons, teachers))
                    return true;
                else {
                    chosenTeachers.remove(k);
                    //Тест
                    chosenTeacherLessons.remove(k);
                }
                lessons.add(i, lesson);
                teachers.get(j).addAvailableTime(day, removedTeacherTime[0], removedTeacherTime[1]);
            }
            if (!foundTeacher)
                return false;
        }
        return false;
    }

    public int chooseTeacher(Day day, Time lessonsStart, Time lessonEnd, List<Teacher> teachers) {
        int teachersSize = teachers.size();
        for (int i = 0; i < teachersSize; i++) {

        }
        return -1;
    }

















//    private boolean sheduleCreator(int lessonIdx, List<Lesson> lessons, List<Teacher> teachers) {
//        int lessonsSize = lessons.size();
//        int teachersSize = teachers.size();
//
//        if (lessonsSize == 0)
//            return true;
//
//        for (int i = lessonIdx; i < lessonsSize; i++) {
//            boolean foundTeacher = false;
//            for (int j = 0; j < teachersSize; j++) {
//                Lesson lesson = lessons.get(i);
//                Teacher teacher = teachers.get(j);
//                Day day = lesson.getDay();
//
//                if (!isTeacherAvailable(day, lesson, teacher))
//                    continue;
//                chosenTeachers.add(teacher);
//                lessons.remove(i);
//                Time[] removedTeacherTime = teacher.deleteAvailableTime(day, start, end);
//                if (sheduleCreator(i, lessons, teachers))
//                    return true;
//                else
//                    chosenTeachers.remove(teacher);
//                lessons.add(i, lesson);
//                teachers.get(j).addAvailableTime(day, removedTeacherTime[0], removedTeacherTime[1]);
//            }
//            if (!foundTeacher)
//                return false;
//        }
//        return false;
//    }
}
