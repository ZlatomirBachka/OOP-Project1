package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Planet;
import GeneralClasses.Rank;
import util.PlanetChecker;

public class YoungestJedi {
    public void get_youngest_jedi (String planet_name, Rank jedi_rank) {
        Planet planet = PlanetChecker.validateAndGet(planet_name);
        if (planet == null) return;

        Jedi youngestJedi = null;

        for (Jedi jedi : planet.getInhabitants()) {
            if (!jedi.getRank().equals(jedi_rank)) continue;

            if (youngestJedi == null) {
                youngestJedi = jedi;
            } else {
                if (jedi.getAge() < youngestJedi.getAge()) {
                    youngestJedi = jedi;
                } else if (jedi.getAge() == youngestJedi.getAge()) {
                    if(jedi.getRank().ordinal() > youngestJedi.getRank().ordinal()) {
                        youngestJedi = jedi;
                    } else if (jedi.getRank().ordinal() == youngestJedi.getRank().ordinal() && jedi.getJediName().compareToIgnoreCase(youngestJedi.getJediName()) < 0) {
                        youngestJedi = jedi;
                    }
                }
            }
        }

        if (youngestJedi == null) {
            System.out.printf("There is no Jedi with rank %s on planet %s.%n", jedi_rank, planet_name);
        } else {
            System.out.printf("Youngest Jedi with rank %s on planet %s is: %s (Age: %d)%n", jedi_rank, planet_name, youngestJedi.getJediName(), youngestJedi.getAge());
        }
    }
}
