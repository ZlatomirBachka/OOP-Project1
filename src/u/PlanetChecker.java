package u;

import GeneralClasses.Planet;
import GeneralClasses.Universe;

public class PlanetChecker {
    public static Planet findByName(String name) {
        for (Planet planet : Universe.getInstance().getPlanets()) {
            if (planet.getPlanetName().equals(name)) {
                return planet;
            }
        }
        return null;
    }

    public static Planet validateAndGet(String name) {
        Planet planet = findByName(name);
        if (planet == null) {
            System.out.printf("Planet %s does not exist in the universe.%n", name);
        }
        return planet;
    }
}
