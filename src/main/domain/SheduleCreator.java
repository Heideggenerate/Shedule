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

                if (!teacher.isAvailableTime(day, new TimeRange(start, end)))
                    continue;
                chosenTeachers.add(teacher);
                //Тест
                chosenTeacherLessons.add(new TeacherLesson(lesson, teacher));
                int k = chosenTeachers.size() - 1;
                lessons.remove(i);
                if (sheduleCreator(i, lessons, teachers))
                    return true;
                else {
                    chosenTeachers.remove(k);
                    //Тест
                    chosenTeacherLessons.remove(k);
                }
                lessons.add(i, lesson);
                teachers.get(j).addAvailableTime(day, new TimeRange(start, end));
            }
            if (!foundTeacher)
                return false;
        }
        return false;
    }


    private Map<Lesson, Teacher> findAvailableTeachers() {

    }


    private static final Comparator<Lesson> COMPARE_BY_ONE_SUBJECT_START_TIME = new Comparator<Lesson>() {
        @Override
        public int compare(Lesson o1, Lesson o2) {
            int res = o1.getSubjectName().compareTo(o2.getSubjectName());
            if (res != 0)
                return res;
            res = o1.getStartTime().compare(o2.getStartTime());
            return res != 0 ? res : o1.getEndTime().compare(o2.getEndTime());
        }
    };



/*
Заводим дерево TreeMap<Integer, TreeMap<Lesson, TreeSet<Teacher>> теперь treemap<lesson,treeset<teacher>> даём компаратор на проверку сначала по имени предмета, потом если они совпали по времени
 (Это нужно, чтобы быстрее находить доступны ли промежутки и быстрее заполнять таблицу, также можно будет сразу исключать преподавателей).
Во внешний treemap мы отдаём компаратор, дающий возрастающее дерево.
 В итоге мы будем идти по дереву и удалять преподавателей в разных промежутках (Это будет достаточно быстро благодаря первому компаратору).
 Зная текущее количество пройденных узлов мы сможем просто взять количество элементов с количество преподаватлей 0, благодаря чему тут же будем отсекать ненужные варианты.
 Фактически это и forward checking, и эвристика, и ускорение благодаря тому, что таблицу заполняем сразу, а не пересчитываем всё десятки раз и ускорение за счёт структуры дерева, так как мы будем знать каких учителей можно сразу будет отброосить и динамика.
 */













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
