package hw7;

import java.util.Arrays;

public abstract class Pet implements Foul {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;



    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(String nickname, int age, int trickLevel) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
    }
    public void setSpecies(Species species){this.species=species;}

    Pet (Species species){
        species=Species.UNKNOWN;
    }



    public abstract void response();

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object has been removed");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}




