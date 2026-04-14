import entities.Day;
import entities.Teacher;
import org.junit.Assert;
import org.junit.Test;
import values.Time;
import values.TimeRange;

public class TeacherTest {

    //----------------AvailableTime----------------

    @Test
    public void outOfRangeStartTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(9,0), new Time(12, 0)));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeEndTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(13, 0)));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeStartTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(9, 59), new Time(12, 0)));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeEndTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 1)));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(9, 0), new Time(13, 0)));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void outOfRangeTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(9, 59), new Time(12, 1)));
        Assert.assertFalse(isAvailable);
    }


    @Test
    public void differentStartCorrectTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(11,0 ), new Time(12, 0)));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentEndCorrectTimeHours() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(11, 0)));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentStartCorrectTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10,1), new Time(12, 0)));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentEndCorrectTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10,0), new Time(11, 59)));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void differentCorrectTimeMinutes() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10,1), new Time(11, 59)));
        Assert.assertTrue(isAvailable);
    }

    @Test
    public void sameCorrectTime() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        Assert.assertTrue(isAvailable);
    }


    @Test
    public void incorrectDay() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.TUESDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        Assert.assertFalse(isAvailable);
    }


    @Test
    public void mergeOutOfRangeTime() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(13, 0), new Time(14, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.TUESDAY, new TimeRange(new Time(10, 0), new Time(13, 0)));
        Assert.assertFalse(isAvailable);
    }

    @Test
    public void mergeInRangeTime() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(12, 0), new Time(13, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.TUESDAY, new TimeRange(new Time(10, 0), new Time(13, 0)));
        Assert.assertFalse(isAvailable);
    }

//
//
//    //-----------------DeleteTime------------------------
//


    @Test
    public void deleteSmallerStart() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isDeleted = teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(9, 0), new Time(12, 0)));
        Assert.assertFalse(isDeleted);
    }

    @Test
    public void deleteBiggerEnd() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isDeleted = teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(13, 0)));
        Assert.assertFalse(isDeleted);
    }

    @Test
    public void deleteBiggerRangeOfTime() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isDeleted = teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(9, 0), new Time(13, 0)));
        Assert.assertFalse(isDeleted);
    }

    @Test
    public void deleteSameTime() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isDeleted = teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void deleteBiggerStart() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isDeleted = teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(11, 0), new Time(12, 0)));
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void deleteSmallerEnd() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(12, 0)));
        boolean isDeleted = teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(11, 0)));
        Assert.assertTrue(isDeleted);
    }

    @Test
    public void isAvailableDeletedRange() {
        Teacher teacher = new Teacher("A");
        teacher.addAvailableTime(Day.MONDAY, new TimeRange(new Time(10, 0), new Time(13, 0)));
        teacher.deleteTime(Day.MONDAY, new TimeRange(new Time(11, 0), new Time(12, 0)));
        boolean isAvailable = teacher.isAvailableTime(Day.TUESDAY, new TimeRange(new Time(11, 0), new Time(12, 0)));
        Assert.assertFalse(isAvailable);
    }


}
