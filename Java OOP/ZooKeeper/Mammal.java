import java.util.*;

public class Mammal {
    private int energyLevel;
    public Mammal() {
        energyLevel=100;
        //this.energyLevel=energyLevel;
    }
    public int displayEnergy() {
        System.out.println("Energy level: " + energyLevel);
        return energyLevel;
    }
    public void setEnergy(int energyLevel) {
        this.energyLevel=energyLevel;
    }
    public int getEnergy() {
        return energyLevel;
    }
}