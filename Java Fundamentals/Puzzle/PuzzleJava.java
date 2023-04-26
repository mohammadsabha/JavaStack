import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    public int getTenRolls() {
        int randomNum = (int)(Math.random() * 20) +1;
        return randomNum;
        }
    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // create an array with all 26 letters of the alphabet
        int randomIndex = (int) (Math.random() * 26); // generate a random index between 0 and 25
        return alphabet[randomIndex]; // return the letter at the random index
    }
    public String generatePassword() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        ArrayList<Character> mypass = new ArrayList<Character>();

        for (int i=0; i<=8; i++) {
            int randomIndex = (int) (Math.random() * 26);
            char randomChar = alphabet[randomIndex];
            mypass.add(randomChar);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : mypass) {
            sb.append(c);
        }
        return sb.toString();
    }
    public String[] getNewPasswordSet(int length) {
        String[] passwords = new String[length];
        for (int i = 0; i < length; i++) {
            passwords[i] = generatePassword();
        }
        return passwords;
    }
    
}
