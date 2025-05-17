package util;
import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import GeneralClasses.Universe;

public class JediChecker {
    public static Jedi findByName(String name) {
        for (Planet planet : Universe.getInstance().getPlanets()) {
            for (Jedi jedi : planet.getInhabitants()) {
                if (jedi.getJediName().equals(name)) {
                    return jedi;
                }
            }
        }
        return null;
    }

    public static Planet findPlanetOfJedi(String name) {
        for (Planet planet : Universe.getInstance().getPlanets()) {
            for (Jedi jedi : planet.getInhabitants()) {
                if (jedi.getJediName().equals(name)) {
                    return planet;
                }
            }
        }
        return null;
    }
}

