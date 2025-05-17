package GeneralClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Planet implements Serializable {
    private String planetName;
    private List<Jedi> inhabitants;

    public Planet(String planetName) {
        this.planetName = planetName;
        this.inhabitants = new ArrayList<>();
    }

    public String getPlanetName() {
        return planetName;
    }

    public List<Jedi> getInhabitants() {
        return inhabitants;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
}
