package GeneralClasses;

public class Jedi {
    private String jediName;
    private Rank rank;
    private short age;
    private String lightsaberColor;
    private byte strength;

    public Jedi(String jediName, Rank rank, short age, String lightsaberColor, byte strength) {
        if (strength != 1 && strength != 2) {
            throw new IllegalArgumentException("Jedi strength must be 1 or 2.");
        }
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.lightsaberColor = lightsaberColor;
        this.strength = strength;
    }

    public static boolean isValidStrength(byte strength) {
        return strength == 1 || strength == 2;
    }

    public String getJediName() {
        return jediName;
    }

    public Rank getRank() {
        return rank;
    }

    public short getAge() {
        return age;
    }

    public String getLightsaberColor() {
        return lightsaberColor;
    }

    public byte getStrength() {
        return strength;
    }

    public void setJediName(String jediName) {
        this.jediName = jediName;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setLightsaberColor(String lightsaberColor) {
        this.lightsaberColor = lightsaberColor;
    }

    public void setStrength(byte strength) {
        if (strength != 1 && strength != 2) {
            throw new IllegalArgumentException("Jedi strength must be 1 or 2.");
        }
        this.strength = strength;
    }
}
