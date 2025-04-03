package UniverseManager;

import GeneralClasses.Planet;
import GeneralClasses.Universe;
import u.PlanetChecker;

public class PlanetAdder {
    public void add_planet(String planetName) {
        Universe universe = Universe.getInstance();

        if (PlanetChecker.findByName(planetName) != null) {
            System.out.printf("Planet %s already exists in the universe.%n", planetName);
            return;
        }

        Planet planet = new Planet(planetName);
        universe.getPlanets().add(planet);
        System.out.printf("Planet %s was successfully added to the universe.%n", planetName);

    }
}
