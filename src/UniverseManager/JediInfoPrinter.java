package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import util.JediChecker;

public class JediInfoPrinter {
    public void printJediInfo(String jedi_name) {
        Jedi jedi = JediChecker.findByName(jedi_name);
        if (jedi == null) {
            System.out.printf("Jedi named %s does not exist in the universe.%n", jedi_name);
            return;
        }

        Planet planet = JediChecker.findPlanetOfJedi(jedi_name);
        String planet_name = (planet != null) ? planet.getPlanetName() : "Unknown";

        System.out.printf("Jedi Information:%n");
        System.out.printf("- Name: %s%n", jedi.getJediName());
        System.out.printf("- Rank: %s%n", jedi.getRank());
        System.out.printf("- Age: %s%n", jedi.getAge());
        System.out.printf("- Saber Color: %s%n", jedi.getLightsaberColor());
        System.out.printf("- Strength: %.2f %n", jedi.getStrength());
        System.out.printf("- Planet: %s%n", planet_name);
    }
}
