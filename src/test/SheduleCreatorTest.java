//import domain.SheduleCreator;
//import entities.Day;
//import entities.Lesson;
//import entities.Teacher;
//import junit.framework.AssertionFailedError;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.Assert.*;
//import repository.Lessons;
//import repository.Teachers;
//import values.Time;
//
//public class SheduleCreatorTest {
//
//
//    @Test
//    public void sheduleCreateNonExistTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher = new Teacher("A");
//        teacher.addAvailableTime(Day.MONDAY, new Time(11, 0), new Time(13, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(0, sheduleCreator.sheduleCreate().size());
//    }
//
//    @Test
//    public void sheduleCreateNonExistDay() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher = new Teacher("A");
//        teacher.addAvailableTime(Day.TUESDAY, new Time(10, 0), new Time(12, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(0, sheduleCreator.sheduleCreate().size());
//    }
//
//
//    @Test
//    public void sheduleCreateSameTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher = new Teacher("A");
//        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(1, sheduleCreator.sheduleCreate().size());
//    }
//
//
//    @Test
//    public void sheduleCreateExistTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher = new Teacher("A");
//        teacher.addAvailableTime(Day.MONDAY, new Time(9, 0), new Time(13, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(1, sheduleCreator.sheduleCreate().size());
//    }
//
//
//    @Test
//    public void sheduleCreateTeachersSameTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher1 = new Teacher("A");
//        teacher1.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher2 = new Teacher("A");
//        teacher2.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(1, sheduleCreator.sheduleCreate().size());
//    }
//
//
//    @Test
//    public void sheduleCreateTeacherExistAndNonExistTime() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher1 = new Teacher("A");
//        teacher1.addAvailableTime(Day.MONDAY, new Time(11, 0), new Time(12, 0));
//        Teacher teacher2 = new Teacher("A");
//        teacher2.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        boolean isCorrectTeacher =  sheduleCreator.sheduleCreate().size() == 1;
//        if (!isCorrectTeacher)
//            throw new AssertionFailedError("Ошибка размера списка");
//        isCorrectTeacher = sheduleCreator.sheduleCreate().getFirst().equals(teacher2);
//        Assert.assertTrue(isCorrectTeacher);
//    }
//
//
//    @Test
//    public void sheduleCreateTeacherExistAndNonExistDay() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher1 = new Teacher("A");
//        teacher1.addAvailableTime(Day.TUESDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher2 = new Teacher("A");
//        teacher2.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        lessons.addLesson(lesson);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(1, sheduleCreator.sheduleCreate().size());
//
//        boolean isCorrectTeacher =  sheduleCreator.sheduleCreate().size() == 1;
//        if (!isCorrectTeacher)
//            throw new AssertionFailedError("Ошибка размера списка");
//        isCorrectTeacher = sheduleCreator.sheduleCreate().getFirst().equals(teacher2);
//        Assert.assertTrue(isCorrectTeacher);
//    }
//
//    @Test
//    public void sheduleCreateTeacherIntersectedLessons() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson1 = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Lesson lesson2 = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher1 = new Teacher("A");
//        teacher1.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        lessons.addLesson(lesson1);
//        lessons.addLesson(lesson2);
//        teachers.addTeacher(teacher1);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(0, sheduleCreator.sheduleCreate().size());
//    }
//
//    @Test
//    public void sheduleCreateTeachersIntersectedLessons() {
//        Lessons lessons = new Lessons();
//        Teachers teachers = new Teachers();
//        Lesson lesson1 = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Lesson lesson2 = new Lesson(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher1 = new Teacher("A");
//        teacher1.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//        Teacher teacher2 = new Teacher("A");
//        teacher2.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
//
//        lessons.addLesson(lesson1);
//        lessons.addLesson(lesson2);
//        teachers.addTeacher(teacher1);
//        teachers.addTeacher(teacher2);
//        SheduleCreator sheduleCreator = new SheduleCreator(lessons, teachers);
//
//        Assert.assertEquals(2, sheduleCreator.sheduleCreate().size());
//    }
//}
