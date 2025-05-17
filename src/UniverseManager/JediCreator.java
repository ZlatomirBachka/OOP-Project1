package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import GeneralClasses.Universe;
import GeneralClasses.Rank;
import util.PlanetChecker;

public class JediCreator {
    public void create_jedi(String planet_name, String jedi_name, Rank jedi_rank, short jedi_age, String saber_color, float jedi_strength) {
        Universe universe = Universe.getInstance();

        if (universe.getPlanets().isEmpty()) {
            System.out.println("There aren't any planets in the universe yet.");
            return;
        }

        Planet assignedPlanet = PlanetChecker.validateAndGet(planet_name);
        if (assignedPlanet == null) return;

        for (Planet planet : universe.getPlanets()) {
            for (Jedi jedi : planet.getInhabitants()) {
                if (jedi_name.equals(jedi.getJediName())) {
                    System.out.printf("Jedi named %s already exist in the universe.%n", jedi_name);
                    return;
                }
            }
        }

        try {
            Jedi newJedi = new Jedi(jedi_name, jedi_rank, jedi_age, saber_color, jedi_strength);
            assignedPlanet.getInhabitants().add(newJedi);
            System.out.printf("Jedi %s successfully created on planet %s.%n", jedi_name, planet_name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
