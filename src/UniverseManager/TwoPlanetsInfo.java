package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import util.PlanetChecker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoPlanetsInfo {
    public void printJedisFromThePlanets (String planet_name1, String planet_name2) {
        Planet planet1 = PlanetChecker.validateAndGet(planet_name1);
        Planet planet2 = PlanetChecker.validateAndGet(planet_name2);

        if (planet1 == null || planet2 == null) return;

        List<Jedi> combinedJediList = new ArrayList<>();
        combinedJediList.addAll(planet1.getInhabitants());
        combinedJediList.addAll(planet2.getInhabitants());

        if (combinedJediList.isEmpty()) {
            System.out.printf("No Jedi found on planet %s and %s.%n", planet_name1, planet_name2);
            return;
        }

        combinedJediList.sort(Comparator.comparing(Jedi::getJediName));

        System.out.printf("Jedi from planet %s and %s:%n", planet_name1, planet_name2);
        for (Jedi jedi : combinedJediList) {
            System.out.printf("- %s (Rank: %s, Age: %d, Saber Color: %s, Strength: %.2f)%n", jedi.getJediName(), jedi.getRank(), jedi.getAge(), jedi.getLightsaberColor(), jedi.getStrength());
        }
    }
}
