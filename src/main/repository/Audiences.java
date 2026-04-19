package repository;

import entities.Audience;

import java.util.ArrayList;
import java.util.List;

public class Audiences {

    List<Audience> audiences = new ArrayList<>();

    public void add(Audience audience) {
        audiences.add(audience);
    }

    public List<Audience> get() {
        return audiences;
    }
}
