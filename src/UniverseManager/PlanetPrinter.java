package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import GeneralClasses.Rank;
import util.PlanetChecker;

import java.util.Comparator;
import java.util.List;

public class PlanetPrinter {
    public void printJediFromPlanet(String planet_name) {
        Planet planet = PlanetChecker.validateAndGet(planet_name);
        if (planet == null) return;

        List<Jedi> inhabitants = planet.getInhabitants();
        if (inhabitants.isEmpty()) {
            System.out.printf("There are no Jedi on planet %s.%n", planet_name);
            return;
        }

        inhabitants.sort(Comparator.comparing(Jedi::getRank, Comparator.comparingInt(Rank::ordinal)).thenComparing(Jedi::getJediName));

        System.out.printf("Jedi on planet %s:%n", planet_name);
        for (Jedi jedi : inhabitants) {
            System.out.printf(" - %s (Rank: %s, Age: %d, Saber Color: %s, Strength: %.2f)%n", jedi.getJediName(), jedi.getRank(), jedi.getAge(), jedi.getLightsaberColor(), jedi.getStrength());
        }
    }
}
