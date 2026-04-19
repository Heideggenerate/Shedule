package values;

public record TimeRange(Time start, Time end){

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TimeRange(Time start1, Time end1)))
            return false;
        if (this == object)
            return true;
        return start1.equals(start) && end1.equals(end);
    }

    @Override
    public String toString() {
        return "START: " + start.toString() + "END: " + end.toString();
    }
}
