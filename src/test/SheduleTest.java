//import domain.shedule.Shedule;
//import values.Day;
//import entities.Lesson;
//import entities.Teacher;
//import org.junit.Assert;
//import org.junit.Test;
//import repository.Lessons;
//import repository.Teachers;
//import values.Time;
//import values.TimeRange;
//
//public class SheduleTest {
////
//
//
//
//
//    @Test
//    public void sheduleCreateNonExistTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher = new Teacher("T");
//        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(11, 0), new Time(13, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//        Assert.assertNull(lesson.getTeacher());
//    }
////
//    @Test
//    public void sheduleCreateNonExistDay() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher = new Teacher("T");
//        teacher.addAvailableTime(Day.TUESDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//        Assert.assertNull(lesson.getTeacher());
//    }
////
////
//    @Test
//    public void sheduleCreateSameTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher = new Teacher("T");
//        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//        Assert.assertEquals(teacher, lesson.getTeacher());
//    }
//
//
//    @Test
//    public void sheduleCreateExistTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher = new Teacher("T");
//        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(9, 0), new Time(13, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//        Assert.assertEquals(teacher, lesson.getTeacher());
//    }
//
//
//    @Test
//    public void sheduleCreateTeachersSameTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher1 = new Teacher("T1");
//        teacher1.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        Teacher teacher2 = new Teacher("T2");
//        teacher2.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//
//        boolean isChosenOneTeacher = (teacher1.equals(lesson.getTeacher()) && !teacher2.equals(lesson.getTeacher()))
//                || (teacher2.equals(lesson.getTeacher()) && !teacher1.equals(lesson.getTeacher()));
//        Assert.assertEquals(teacher1, lesson.getTeacher());
//    }
////
////
//    @Test
//    public void sheduleCreateTeacherExistAndNonExistTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher1 = new Teacher("T1");
//        teacher1.addAvailableTime(Day.MONDAY, new TimeRange(new Time(11, 0), new Time(12, 0)));
//        Teacher teacher2 = new Teacher("T2");
//        teacher2.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//
//        Assert.assertEquals(teacher2, lesson.getTeacher());
//    }
////
////
//    @Test
//    public void sheduleCreateTeacherExistAndNonExistDay() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L");
//        Teacher teacher1 = new Teacher("T1");
//        teacher1.addAvailableTime(Day.TUESDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        Teacher teacher2 = new Teacher("T2");
//        teacher2.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//
//        Assert.assertEquals(teacher2, lesson.getTeacher());
//    }
////
//    @Test
//    public void sheduleCreateTeacherIntersectedLessons() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson1 = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L1");
//        Lesson lesson2 = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L2");
//        Teacher teacher1 = new Teacher("L");
//        teacher1.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        lessons.addLesson(lesson1);
//        lessons.addLesson(lesson2);
//        teachers.addTeacher(teacher1);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//
//        boolean isNonTeachers = lesson1.getTeacher() == null && lesson2.getTeacher() == null;
//        Assert.assertTrue(isNonTeachers);
//    }
//
//    @Test
//    public void sheduleCreateTeachersIntersectedLessons() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson1 = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L1");
//        Lesson lesson2 = new Lesson(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)), "L2");
//        Teacher teacher1 = new Teacher("T1");
//        teacher1.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//        Teacher teacher2 = new Teacher("T2");
//        teacher2.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
//
//        lessons.addLesson(lesson1);
//        lessons.addLesson(lesson2);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        Shedule shedule = new Shedule(lessons, teachers);
//        shedule.shedule();
//
//        boolean isCorrectTeacherChoose = (teacher1.equals(lesson1.getTeacher()) && teacher2.equals(lesson2.getTeacher()))
//                || (teacher2.equals(lesson1.getTeacher()) && teacher1.equals(lesson2.getTeacher()));
//        Assert.assertTrue(isCorrectTeacherChoose);
//    }
//
//
//}
