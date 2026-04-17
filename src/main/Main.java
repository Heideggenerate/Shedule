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

// ===================== LESSONS (36) =====================
// 20-минутные слоты с 08:00 до 20:00

    int h = 8;
    int m = 0;

    for (int i = 0; i < 36; i++) {
        lessons.addLesson(new Lesson(
                Day.MONDAY,
                new TimeRange(new Time(h, m), new Time(h, m + 20)),
                "A"
        ));
        m += 20;
        if (m == 60) {
            h++;
            m = 0;
        }
    }

// ===================== TEACHERS =====================

// 🔴 CORE (очень широкие — создают миллионы вариантов)
    for (int i = 0; i < 15; i++) {
        Teacher t = new Teacher("T_CORE_" + i);

        t.addAvailableTime(Day.MONDAY,
                new TimeRange(new Time(8 + (i % 3), 0),
                        new Time(18, 40))
        );

        teachers.addTeacher(t);
    }

// 🟡 SHIFT (сдвинутые — усиливают ветвление)
    for (int i = 0; i < 10; i++) {
        Teacher t = new Teacher("T_SHIFT_" + i);

        t.addAvailableTime(Day.MONDAY,
                new TimeRange(new Time(9 + (i % 4), 20),
                        new Time(19, 0))
        );

        teachers.addTeacher(t);
    }

// 🔵 CHAOS (почти одинаковые интервалы)
    for (int i = 0; i < 10; i++) {
        Teacher t = new Teacher("T_CHAOS_" + i);

        t.addAvailableTime(Day.MONDAY,
                new TimeRange(new Time(8, 40),
                        new Time(17 + (i % 3), 40))
        );

        teachers.addTeacher(t);
    }

// 🟣 TRAP (ломают решение ТОЛЬКО в конце)
    for (int i = 0; i < 8; i++) {
        Teacher t = new Teacher("T_TRAP_" + i);

        t.addAvailableTime(Day.MONDAY,
                new TimeRange(new Time(12 + (i % 4), 0),
                        new Time(20, 0))
        );

        teachers.addTeacher(t);
    }

// 🟢 FORCING (единственно правильные, но НЕ очевидные)
    for (int i = 0; i < 6; i++) {
        Teacher t = new Teacher("T_FORCE_" + i);

        int startH = 16 + i / 2;

        t.addAvailableTime(Day.MONDAY,
                new TimeRange(new Time(startH, 0),
                        new Time(startH, 40))
        );

        teachers.addTeacher(t);
    }

// ⚫ FAKE (создают ложные решения)
    for (int i = 0; i < 12; i++) {
        Teacher t = new Teacher("T_FAKE_" + i);

        t.addAvailableTime(Day.MONDAY,
                new TimeRange(new Time(8 + (i % 6), 0),
                        new Time(14 + (i % 4), 40))
        );

        teachers.addTeacher(t);
    }

// ===================== RUN =====================

    SheduleCreator sc = new SheduleCreator(lessons, teachers);

    long start = System.currentTimeMillis();
    boolean result = sc.shedule();
    long end = System.currentTimeMillis();

    System.out.println("TIME: " + (end - start));
    System.out.println(result);

    sc.shedule();
    List<Lesson> lessonsList = lessons.getLessons();
    for (Lesson lesson : lessonsList) {
        lesson.getTeacher();
    }
}