package entities;

public record Audience(int number, boolean isLecture) {

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Audience(int number1, boolean isLecture1)))
            return false;
        if (this == object)
            return true;
        return number1 == number && isLecture == isLecture1;
    }
}
