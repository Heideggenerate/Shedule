
import domain.SheduleCreator;
import entities.Day;
import entities.Lesson;
import entities.Teacher;
import repository.Lessons;
import repository.Teachers;
import values.Time;
import values.TimeRange;

void main() {
    Lessons lessons = new Lessons();
    Teachers teachers = new Teachers();

// ===================== LESSONS =====================
// Перемешаны специально



// ===================== LESSONS (32) =====================
// Перемешаны специально

    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 0), new Time(14, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(9, 30), new Time(9, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 15), new Time(12, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 45), new Time(11, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 30), new Time(13, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(8, 30), new Time(8, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(15, 15), new Time(15, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 15), new Time(11, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 0), new Time(13, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(9, 0), new Time(9, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 0), new Time(12, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 30), new Time(14, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 0), new Time(10, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(8, 45), new Time(9, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 45), new Time(14, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 30), new Time(11, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 15), new Time(10, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(9, 45), new Time(10, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 30), new Time(12, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 15), new Time(14, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 0), new Time(11, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(8, 0), new Time(8, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(15, 0), new Time(15, 15)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 15), new Time(13, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 30), new Time(10, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(9, 15), new Time(9, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 45), new Time(13, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 45), new Time(15, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 45), new Time(12, 0)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(8, 15), new Time(8, 30)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(15, 30), new Time(15, 45)));
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(15, 45), new Time(16, 0)));


// ===================== TEACHERS =====================
// Каждый покрывает 2–3 зоны → нет универсальных

    Teacher t1 = new Teacher("T1");
    t1.addAvailableTime(Day.MONDAY, new TimeRange(new Time(8, 0), new Time(9, 0)));
    t1.addAvailableTime(Day.MONDAY, new TimeRange(new Time(12, 0), new Time(13, 0)));
    teachers.addTeacher(t1);

    Teacher t2 = new Teacher("T2");
    t2.addAvailableTime(Day.MONDAY, new TimeRange(new Time(8, 30), new Time(10, 0)));
    t2.addAvailableTime(Day.MONDAY, new TimeRange(new Time(13, 0), new Time(14, 0)));
    teachers.addTeacher(t2);

    Teacher t3 = new Teacher("T3");
    t3.addAvailableTime(Day.MONDAY, new TimeRange(new Time(9, 0), new Time(11, 0)));
    teachers.addTeacher(t3);

    Teacher t4 = new Teacher("T4");
    t4.addAvailableTime(Day.MONDAY, new TimeRange(new Time(9, 30), new Time(12, 0)));
    teachers.addTeacher(t4);

    Teacher t5 = new Teacher("T5");
    t5.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 30)));
    teachers.addTeacher(t5);

    Teacher t6 = new Teacher("T6");
    t6.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 30), new Time(13, 0)));
    teachers.addTeacher(t6);

    Teacher t7 = new Teacher("T7");
    t7.addAvailableTime(Day.MONDAY, new TimeRange(new Time(11, 0), new Time(13, 30)));
    teachers.addTeacher(t7);

    Teacher t8 = new Teacher("T8");
    t8.addAvailableTime(Day.MONDAY, new TimeRange(new Time(11, 30), new Time(14, 0)));
    teachers.addTeacher(t8);

    Teacher t9 = new Teacher("T9");
    t9.addAvailableTime(Day.MONDAY, new TimeRange(new Time(12, 0), new Time(14, 30)));
    teachers.addTeacher(t9);

    Teacher t10 = new Teacher("T10");
    t10.addAvailableTime(Day.MONDAY, new TimeRange(new Time(12, 30), new Time(15, 0)));
    teachers.addTeacher(t10);

    Teacher t11 = new Teacher("T11");
    t11.addAvailableTime(Day.MONDAY, new TimeRange(new Time(13, 0), new Time(15, 30)));
    teachers.addTeacher(t11);

    Teacher t12 = new Teacher("T12");
    t12.addAvailableTime(Day.MONDAY, new TimeRange(new Time(13, 30), new Time(16, 0)));
    teachers.addTeacher(t12);

    Teacher t13 = new Teacher("T13");
    t13.addAvailableTime(Day.MONDAY, new TimeRange(new Time(14, 0), new Time(16, 0)));
    teachers.addTeacher(t13);

    Teacher t14 = new Teacher("T14");
    t14.addAvailableTime(Day.MONDAY, new TimeRange(new Time(14, 30), new Time(16, 0)));
    teachers.addTeacher(t14);

    Teacher t15 = new Teacher("T15");
    t15.addAvailableTime(Day.MONDAY, new TimeRange(new Time(15, 0), new Time(16, 0)));
    teachers.addTeacher(t15);


// ===================== ГАРАНТИЯ РЕШЕНИЯ =====================
//
// Один из корректных вариантов:
//
// L14 (8:20–8:40) -> T1
// L6  (8:40–9:00) -> T2
// L2  (9:00–9:20) -> T3
// L10 (9:40–10:00)-> T4
// L4  (10:00–10:20)-> T5
// L16 (10:20–10:40)-> T3
// L8  (10:40–11:00)-> T6
// L13 (11:00–11:20)-> T7
// L1  (11:40–12:00)-> T8
// L11 (12:00–12:20)-> T9
// L5  (12:20–12:40)-> T7
// L9  (13:00–13:20)-> T11
// L3  (13:20–13:40)-> T9
// L15 (13:40–14:00)-> T10
// L12 (14:00–14:20)-> T11
// L7  (14:20–14:40)-> T12

    SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
    long start = System.currentTimeMillis();
    sheduleCreator.sheduleCreate();
    System.out.println("TIME: " + (System.currentTimeMillis() - start));
    for (SheduleCreator.TeacherLesson teacherLesson : sheduleCreator.chosenTeacherLessons) {
        Lesson lesson = teacherLesson.lesson();
        Teacher teacher = teacherLesson.teacher();
        Time startLesson = lesson.getStartTime();
        Time endLesson = lesson.getEndTime();
        System.out.println("NAME: " + teacher.getName() + "  LESSON: " + "start= " + startLesson + " | " + "end = " + endLesson);
    }



//    Teacher teacher = new Teacher("A");
//    teacher.addAvailableTime(Day.MONDAY, new Time(0, 0), new Time(0, 0));

}

