import domain.SheduleCreator;
import entities.Day;
import entities.Lesson;
import entities.Teacher;
import repository.Lessons;
import repository.Teachers;
import values.Time;

void main() {
    Lessons lessons = new Lessons();
    Teachers teachers = new Teachers();

// ===================== LESSONS (22) =====================


// ===================== LESSONS =====================
// Листаем уроки в обратном порядке по времени.
// Это делает первый урок самым "свободным" и заставляет алгоритм глубоко перебирать.

    lessons.addLesson(new Lesson(Day.MONDAY, new Time(15, 0), new Time(15, 20))); // L1
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 40), new Time(15, 0))); // L2
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 20), new Time(14, 40))); // L3
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(14, 0), new Time(14, 20))); // L4
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 40), new Time(14, 0))); // L5
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 20), new Time(13, 40))); // L6
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(13, 0), new Time(13, 20))); // L7
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 40), new Time(13, 0))); // L8
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 20), new Time(12, 40))); // L9
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(12, 0), new Time(12, 20))); // L10
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 40), new Time(12, 0))); // L11
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 20), new Time(11, 40))); // L12
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(11, 0), new Time(11, 20))); // L13
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 40), new Time(11, 0))); // L14
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 20), new Time(10, 40))); // L15
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(10, 0), new Time(10, 20))); // L16
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(9, 40), new Time(10, 0))); // L17
    lessons.addLesson(new Lesson(Day.MONDAY, new Time(9, 20), new Time(9, 40))); // L18



// ===================== TEACHERS =====================
// Каждый преподаватель имеет ровно один атомарный блок.
// Блоки идут от раннего к позднему старту.
// Это создаёт уникальное решение, но очень глубокий перебор.

    Teacher t1 = new Teacher("T1");
    t1.addAvailableTime(Day.MONDAY, new Time(8, 0), new Time(16, 0));
    teachers.addTeacher(t1);

    Teacher t2 = new Teacher("T2");
    t2.addAvailableTime(Day.MONDAY, new Time(8, 20), new Time(16, 0));
    teachers.addTeacher(t2);

    Teacher t3 = new Teacher("T3");
    t3.addAvailableTime(Day.MONDAY, new Time(8, 40), new Time(16, 0));
    teachers.addTeacher(t3);

    Teacher t4 = new Teacher("T4");
    t4.addAvailableTime(Day.MONDAY, new Time(9, 0), new Time(16, 0));
    teachers.addTeacher(t4);

    Teacher t5 = new Teacher("T5");
    t5.addAvailableTime(Day.MONDAY, new Time(9, 20), new Time(16, 0));
    teachers.addTeacher(t5);

    Teacher t6 = new Teacher("T6");
    t6.addAvailableTime(Day.MONDAY, new Time(9, 40), new Time(16, 0));
    teachers.addTeacher(t6);

    Teacher t7 = new Teacher("T7");
    t7.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(16, 0));
    teachers.addTeacher(t7);

    Teacher t8 = new Teacher("T8");
    t8.addAvailableTime(Day.MONDAY, new Time(10, 20), new Time(16, 0));
    teachers.addTeacher(t8);

    Teacher t9 = new Teacher("T9");
    t9.addAvailableTime(Day.MONDAY, new Time(10, 40), new Time(16, 0));
    teachers.addTeacher(t9);

    Teacher t10 = new Teacher("T10");
    t10.addAvailableTime(Day.MONDAY, new Time(11, 0), new Time(16, 0));
    teachers.addTeacher(t10);

    Teacher t11 = new Teacher("T11");
    t11.addAvailableTime(Day.MONDAY, new Time(11, 20), new Time(16, 0));
    teachers.addTeacher(t11);

    Teacher t12 = new Teacher("T12");
    t12.addAvailableTime(Day.MONDAY, new Time(11, 40), new Time(16, 0));
    teachers.addTeacher(t12);

    Teacher t13 = new Teacher("T13");
    t13.addAvailableTime(Day.MONDAY, new Time(12, 0), new Time(16, 0));
    teachers.addTeacher(t13);

    Teacher t14 = new Teacher("T14");
    t14.addAvailableTime(Day.MONDAY, new Time(12, 20), new Time(16, 0));
    teachers.addTeacher(t14);

    Teacher t15 = new Teacher("T15");
    t15.addAvailableTime(Day.MONDAY, new Time(12, 40), new Time(16, 0));
    teachers.addTeacher(t15);

    Teacher t16 = new Teacher("T16");
    t16.addAvailableTime(Day.MONDAY, new Time(13, 0), new Time(16, 0));
    teachers.addTeacher(t16);

    Teacher t17 = new Teacher("T17");
    t17.addAvailableTime(Day.MONDAY, new Time(13, 20), new Time(16, 0));
    teachers.addTeacher(t17);

    Teacher t18 = new Teacher("T18");
    t18.addAvailableTime(Day.MONDAY, new Time(13, 40), new Time(16, 0));
    teachers.addTeacher(t18);

    Teacher t19 = new Teacher("T19");
    t19.addAvailableTime(Day.MONDAY, new Time(14, 0), new Time(16, 0));
    teachers.addTeacher(t19);

    Teacher t20 = new Teacher("T20");
    t20.addAvailableTime(Day.MONDAY, new Time(14, 20), new Time(16, 0));
    teachers.addTeacher(t20);

    Teacher t21 = new Teacher("T21");
    t21.addAvailableTime(Day.MONDAY, new Time(14, 40), new Time(16, 0));
    teachers.addTeacher(t21);

    Teacher t22 = new Teacher("T22");
    t22.addAvailableTime(Day.MONDAY, new Time(15, 0), new Time(16, 0));
    teachers.addTeacher(t22);

/*
Проверка вручную:

- L1 (15:00–15:20) могут вести T1..T22
- L2 (14:40–15:00) могут вести T1..T21
- ...
- L22 (08:00–08:20) может вести только T1

Поэтому единственное полное решение:
L1  -> T22
L2  -> T21
L3  -> T20
L4  -> T19
L5  -> T18
L6  -> T17
L7  -> T16
L8  -> T15
L9  -> T14
L10 -> T13
L11 -> T12
L12 -> T11
L13 -> T10
L14 -> T9
L15 -> T8
L16 -> T7
L17 -> T6
L18 -> T5
L19 -> T4
L20 -> T3
L21 -> T2
L22 -> T1
*/

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
}

