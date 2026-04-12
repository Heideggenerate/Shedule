package values;

public class Time {

    private final int hours;
    private final int minutes;

    public Time(int hours, int minutes) {
      if (hours > 24 || minutes > 60 || hours < 0 || minutes < 0)
          throw new RuntimeException("Некорректный формат даты");
      this.hours = hours;
      this.minutes = minutes;
    }

    public int compare(Time time) {
        int res = this.hours - time.hours;
        return res != 0 ? res : this.minutes - time.minutes;
    }

    @Override
    public String toString() {
        return "[hours = " + hours + " | " + "minutes = " + minutes + "]";
    }
}
