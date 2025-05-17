package GeneralClasses;

import java.io.Serializable;

public class Jedi implements Serializable {
    private String jediName;
    private Rank rank;
    private short age;
    private String lightsaberColor;
    private float strength;

    public Jedi(String jediName, Rank rank, short age, String lightsaberColor, float strength) {
        if (strength < 1.0f || strength > 2.0f) {
            throw new IllegalArgumentException("Jedi strength must be between 1.0 and 2.0.");
        }
        this.jediName = jediName;
        this.rank = rank;
        this.age = age;
        this.lightsaberColor = lightsaberColor;
        this.strength = strength;
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

    public float getStrength() {
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

    public void setStrength(float strength) {
        this.strength = strength;
    }
}
