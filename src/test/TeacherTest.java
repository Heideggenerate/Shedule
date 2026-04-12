import entities.Day;
import entities.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;
import values.Time;

public class TeacherTest {

    //----------------AvailableTime----------------

    @Test
    public void outOfRangeStartTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(9,0), new Time(12, 0));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeEndTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10, 0), new Time(13, 0));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeStartTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(9, 59), new Time(12, 0));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeEndTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 1));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(9, 0), new Time(13, 0));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(9, 59), new Time(12, 1));
        Assert.assertFalse(isAvailable);
    }


    @Test
    public void differentStartCorrectTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(11,0 ), new Time(12, 0));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentEndCorrectTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10, 0), new Time(11, 0));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentStartCorrectTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10,1), new Time(12, 0));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentEndCorrectTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10,0), new Time(11, 59));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentCorrectTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10,1), new Time(11, 59));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void sameCorrectTime() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Assert.assertTrue(isAvailable);
    }


    @Test
    public void incorrectDay() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        boolean isAvailable = teacher.isAvailableTime(Day.TUESDAY, new Time(10, 0), new Time(12, 0));
        Assert.assertFalse(isAvailable);
    }


    //-----------------DeleteTime------------------------

    @Test
    public void deleteNonExistStartTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(9, 0), new Time(12, 0));
        Assert.assertNull(deletedTime);
    }

    @Test
    public void deleteNonExistEndTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(10, 0), new Time(13, 0));
        Assert.assertNull(deletedTime);
    }


    @Test
    public void deleteNonExistStartTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(9, 59), new Time(12, 0));
        Assert.assertNull(deletedTime);
    }

    @Test
    public void deleteNonExistEndTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(9, 0), new Time(12, 1));
        Assert.assertNull(deletedTime);
    }

    @Test
    public void deleteNonExistTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(9, 0), new Time(13, 0));
        Assert.assertNull(deletedTime);
    }

    @Test
    public void deleteNonExistTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new Time(10, 0), new Time(12, 0));
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(9, 59), new Time(12, 1));
        Assert.assertNull(deletedTime);
    }

    @Test
    public void deleteSameTime() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, start, end);
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }

    @Test
    public void deleteCorrectDifferentStartTimeHours() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(11, 0), new Time(12, 0));
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }


    @Test
    public void deleteCorrectDifferentEndTimeHours() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(10, 0), new Time(11, 0));
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }


    @Test
    public void deleteCorrectDifferentTimeHours() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(11, 0), new Time(11, 0));
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }


    @Test
    public void deleteCorrectDifferentStartTimeMinutes() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(10, 1), new Time(12, 0));
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }


    @Test
    public void deleteCorrectDifferentEndTimeMinutes() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(10, 0), new Time(11, 59));
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }


    @Test
    public void deleteCorrectDifferentTimeMinutes() {
        Teacher teacher = new Teacher("A");
        Time start = new Time(10, 0);
        Time end = new Time(12, 0);
        teacher.addAvailableTime(Day.MONDAY, start, end);
        Time[] deletedTime = teacher.deleteAvailableTime(Day.MONDAY, new Time(10, 1), new Time(11, 59));
        Time deletedStart = deletedTime[0];
        Time deletedEnd = deletedTime[1];

        boolean isSameTimeDeleted = start.compare(deletedStart) == 0 && end.compare(deletedEnd) == 0;
        Assert.assertTrue(isSameTimeDeleted);
    }


}
