package GeneralClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universe implements Serializable {
    private static final Universe instance = new Universe();

    private List<Planet> planets;

    private Universe() {
        this.planets = new ArrayList<>();
    }

    public static Universe getInstance() {
        return instance;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
