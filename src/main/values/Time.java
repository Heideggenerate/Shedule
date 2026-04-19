package values;

import java.util.Comparator;

public record Time(int hours, int minutes) {

    public Time {
      if (hours > 24 || minutes > 60 || hours < 0 || minutes < 0)
          throw new RuntimeException("Некорректный формат даты");
    }

    public int compare(Time time) {
        int res = this.hours - time.hours;
        return res != 0 ? res : this.minutes - time.minutes;
    }

    public Time getMinTime(Time time2) {
        int res = this.compare(time2);
        return res < 0 ? this : time2;
    }

    public Time getMaxTime(Time time2) {
        int res = this.compare(time2);
        return res < 0 ? time2 : this;
    }

    @Override
    public boolean equals(Object time) {
        if (!(time instanceof Time timeInstance))
            return false;
        if (this == time)
            return true;
        return this.compare(timeInstance) == 0;
    }


    @Override
    public String toString() {
        return "[hrs = " + hours + " | " + "min = " + minutes + "]";
    }
}
