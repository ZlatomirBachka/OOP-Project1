package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import GeneralClasses.Rank;
import util.PlanetChecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MostUsedSaberColor {
    public void getMostUsedSaberColor(String planet_name) {
        Planet planet = PlanetChecker.validateAndGet(planet_name);
        if (planet == null) return;

        if (planet.getInhabitants().isEmpty()) {
            System.out.printf("There are no Jedi on planet %s.%n", planet_name);
            return;
        }

        Map<String, Integer> colorFrequency = new HashMap<>();
        Set<String> usedByGrandMaster = new HashSet<>();

        for (Jedi jedi : planet.getInhabitants()) {
            String color = jedi.getLightsaberColor();
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);

            if (jedi.getRank() == Rank.GRAND_MASTER) {
                usedByGrandMaster.add(color);
            }
        }

        Map<String, Integer> filteredColors = new HashMap<>();
        for (Map.Entry<String, Integer> entry : colorFrequency.entrySet()) {
            if (usedByGrandMaster.contains(entry.getKey())) {
                filteredColors.put(entry.getKey(), entry.getValue());
            }
        }

        if (filteredColors.isEmpty()) {
            System.out.printf("No saber color used by a GRAND_MASTER on planet %s.%n", planet_name);
            return;
        }

        printMostUsedColor(filteredColors,planet_name,null);
    }

    public void getMostUsedSaberColor(String planet_name, Rank jedi_rank) {
        Planet planet = PlanetChecker.validateAndGet(planet_name);
        if (planet == null) return;

        Map<String, Integer> colorFrequency = new HashMap<>();

        for (Jedi jedi : planet.getInhabitants()) {
            if (jedi.getRank().equals(jedi_rank)) {
                String color = jedi.getLightsaberColor();
                colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            }
        }

        if (colorFrequency.isEmpty()) {
            System.out.printf("There are no Jedi with rank %s on planet %s.%n", jedi_rank, planet_name);
            return;
        }

        printMostUsedColor(colorFrequency, planet_name, jedi_rank);
    }

    private void printMostUsedColor(Map<String, Integer> frequencyMap, String planet_name, Rank jedi_rank) {
        String mostUsedSaberColor = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            String color = entry.getKey();
            int count = entry.getValue();

            if (mostUsedSaberColor == null || count > maxCount || (count == maxCount && color.compareTo(mostUsedSaberColor) < 0)) {
                mostUsedSaberColor = color;
                maxCount = count;
            }
        }

        if (jedi_rank == null) {
            System.out.printf("Most used saber color on planet %s (used by at least one GRAND_MASTER) is: %s%n", planet_name, mostUsedSaberColor);
        } else {
            System.out.printf("Most used saber color among Jedi with rank %s on planet %s is: %s%n", jedi_rank, planet_name, mostUsedSaberColor);
        }
    }
}
