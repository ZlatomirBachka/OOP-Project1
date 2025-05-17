package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import util.PlanetChecker;

public class JediRemover {
    public void removeJedi (String jedi_name, String planet_name) {
        Planet assignedPlanet = PlanetChecker.validateAndGet(planet_name);
        if (assignedPlanet == null) return;

        Jedi removed = null;

        for (Jedi jedi : assignedPlanet.getInhabitants()) {
            if (jedi_name.equals(jedi.getJediName())) {
                removed = jedi;
                break;
            }
        }

        if (removed == null) {
            System.out.printf("Jedi %s doesn't inhabit planet %s.%n", jedi_name, planet_name);
        } else {
            assignedPlanet.getInhabitants().remove(removed);
            System.out.printf("Jedi %s was removed from planet %s.%n", jedi_name, planet_name);
        }
    }
}
