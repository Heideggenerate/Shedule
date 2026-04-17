    package entities;

    import com.sun.source.tree.Tree;
    import values.Time;
    import values.TimeRange;

    import java.util.*;

    public class Teacher {

        private final String name;
        private final EnumMap<Day, TreeMap<Time, Time>> availableDaysTime = new EnumMap<>(Day.class);

        public Teacher(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addAvailableTime(Day day, TimeRange timeRange) {
            if (timeRange == null)
                return;
            if (!availableDaysTime.containsKey(day))
                availableDaysTime.put(day, new TreeMap<>(COMPARE_BY_TIME));
            TreeMap<Time, Time> availableTimeInDay = availableDaysTime.get(day);
            Time start = timeRange.start();
            Time end = timeRange.end();
            Time curEndTime = availableTimeInDay.get(start);
            if (curEndTime == null || curEndTime.compare(end) <= 0)
                availableTimeInDay.put(start, end);
            mergeTimes(day, timeRange);
        }

        public boolean isAvailableTime(Day day, TimeRange timeRange) {
            Time start = timeRange.start();
            Time end = timeRange.end();
            TreeMap<Time, Time> availableTimeInDay = availableDaysTime.get(day);
            if (availableTimeInDay == null)
                return false;
            Map.Entry<Time, Time> lowerStartMap = availableTimeInDay.floorEntry(start);
            if (lowerStartMap == null)
                return false;
            return lowerStartMap.getValue().compare(end) >= 0;
        }

        public boolean deleteTime(Day day, TimeRange timeRange) {
            if (!isAvailableTime(day, timeRange))
                return false;
            TimeRange firstPart = null;
            TimeRange secondPart = null;

            Time start = timeRange.start();
            Time end = timeRange.end();
            TreeMap<Time, Time> availableTimeInDay = availableDaysTime.get(day);
            Map.Entry<Time, Time> lowerStartMap = availableTimeInDay.floorEntry(start);
            Time lowerStart = lowerStartMap.getKey();
            Time lowerStartEnd = lowerStartMap.getValue();

            if (!start.equals(lowerStart))
                firstPart = new TimeRange(lowerStart, start);
            if (!end.equals(lowerStartEnd))
                secondPart = new TimeRange(end.getMinTime(lowerStartEnd), end.getMaxTime(lowerStartEnd));
            availableTimeInDay.remove(start);
            addAvailableTime(day, firstPart);
            addAvailableTime(day, secondPart);
            return true;
        }

        private void mergeTimes(Day day, TimeRange timeRange) {
            Time start = timeRange.start();
            Time end = timeRange.end();
            TreeMap<Time, Time> availableTimesInDay = availableDaysTime.get(day);
            if (availableTimesInDay == null)
                return;
            mergeByLowerStart(availableTimesInDay, start, end);
        }

        private void mergeByLowerStart(TreeMap<Time, Time> availableTimesInDay, Time start, Time end) {
            Map<Time, Time> lowerStart = availableTimesInDay.headMap(start, true);
            if (lowerStart == null)
                return;
            Set<Time> lowerStartKeys = new HashSet<>(lowerStart.keySet());

            for (Time lowerStartKey : lowerStartKeys) {
                Time curKeyEnd = lowerStart.get(lowerStartKey);
                if (curKeyEnd == null || curKeyEnd.compare(start) < 0)
                    continue;
                Time maxEnd = curKeyEnd.getMaxTime(end);
                availableTimesInDay.remove(start);
                availableTimesInDay.put(lowerStartKey, maxEnd);
                start = lowerStartKey;
            }
        }


        @Override
        public boolean equals(Object teacher) {
            if (!(teacher instanceof Teacher teacherInstance))
                return false;
            if (this == teacher)
                return true;
            return name.equals(teacherInstance.name);
        }




        private final static Comparator<Time> COMPARE_BY_TIME = new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.compare(o2);
            }
        };




    }
