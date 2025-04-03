package GeneralClasses;

import java.util.List;

public class Planet {
    private String planetName;
    private List<Jedi> inhabitants;

    public Planet(String planetName) {
        this.planetName = planetName;
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
