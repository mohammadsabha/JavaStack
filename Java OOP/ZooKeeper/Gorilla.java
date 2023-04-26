import java.util.*;

public class Gorilla extends Mammal {
    public void throwSomething() {
        setEnergy(getEnergy() -5);
        System.out.println("The gorilla throw things at people lose 5 energy");
        displayEnergy();
    }
    public void eatBananas() {
        setEnergy(getEnergy() +10);
        System.out.println("The gorrilla eat banana gains 10 energy");
        displayEnergy();
    }
    public void climb() {
        setEnergy(getEnergy() -10);
        System.out.println("The gorilla climb lose 10 energy");
        displayEnergy();
    }
}