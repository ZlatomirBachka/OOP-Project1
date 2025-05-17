package UniverseManager;
import GeneralClasses.Jedi;
import GeneralClasses.Rank;
import util.JediChecker;

public class JediPromoter {
    public void promote_jedi (String jedi_name, float multiplier) {
        if (multiplier <= 0) {
            System.out.println("Multiplier must be positive number.");
            return;
        }

        Jedi jedi = JediChecker.findByName(jedi_name);
        if (jedi == null) {
            System.out.printf("Jedi named %s does not exist in the universe.%n", jedi_name);
            return;
        }

        Rank currentRank = jedi.getRank();
        if (currentRank == Rank.GRAND_MASTER) {
            System.out.printf("Jedi %s is already at the highest rank(%s);%n", jedi_name, currentRank);
            return;
        }

        Rank newRank = Rank.values()[currentRank.ordinal() + 1];
        jedi.setRank(newRank);

        try {
            float newStrength = jedi.getStrength() + (multiplier * jedi.getStrength());
            jedi.setStrength(newStrength);
            System.out.printf("Jedi %s was promoted to %s with new strength: %.2f.%n", jedi_name, newRank, newStrength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
