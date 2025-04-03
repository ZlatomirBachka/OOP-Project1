package GeneralClasses;

import java.util.ArrayList;
import java.util.List;

public class Universe {
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
}
