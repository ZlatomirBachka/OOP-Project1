package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import util.PlanetChecker;

public class StrongestJedi {
    public void get_strongest_jedi(String planet_name) {
        Planet planet = PlanetChecker.validateAndGet(planet_name);
        if (planet == null) return;

        if (planet.getInhabitants().isEmpty()) {
            System.out.printf("There are no Jedi on planet %s.%n", planet_name);
            return;
        }

        Jedi strongestJedi = null;

        for (Jedi jedi : planet.getInhabitants()) {
            if (strongestJedi == null) {
                strongestJedi = jedi;
            } else {
               float currentStrength = jedi.getStrength();
               float highestStrength = strongestJedi.getStrength();

               if (currentStrength > highestStrength) {
                   strongestJedi = jedi;
               } else if (currentStrength == highestStrength && jedi.getRank().ordinal() > strongestJedi.getRank().ordinal()) {
                   strongestJedi = jedi;
               }
            }
        }

        System.out.printf("Strongest Jedi on planet %s is: %s (Rank: %s, Strength: %.2f)%n", planet_name, strongestJedi.getJediName(), strongestJedi.getRank(), strongestJedi.getStrength());
    }
}
