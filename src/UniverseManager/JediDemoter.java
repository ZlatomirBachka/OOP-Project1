package UniverseManager;

import GeneralClasses.Jedi;
import GeneralClasses.Rank;
import util.JediChecker;

public class JediDemoter {
    public void demote_jedi (String jedi_name, double multiplier) {
        if (multiplier <= 0) {
            System.out.println("Mutiplier must be a positive number.");
            return;
        }

        Jedi jedi = JediChecker.findByName(jedi_name);
        if (jedi == null) {
            System.out.printf("Jedi named %s does not exist in the universe.%n", jedi_name);
            return;
        }

        Rank currentRank = jedi.getRank();
        if (currentRank == Rank.YOUNGLING) {
            System.out.printf("Jedi %s is already at the lowest rank (%s).%n", jedi_name, currentRank);
            return;
        }

        Rank newRank = Rank.values()[currentRank.ordinal() - 1];
        jedi.setRank(newRank);

        float newStrength = jedi.getStrength() - (float)(multiplier * jedi.getStrength());

        try {
            jedi.setStrength(newStrength);
            System.out.printf("Jedi %s was demoted to %s with new strength: %.2f.%n", jedi_name, newRank, newStrength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
