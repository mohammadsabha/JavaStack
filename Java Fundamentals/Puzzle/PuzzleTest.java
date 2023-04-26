import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PuzzleTest {
    public static void main(String[] args) {
        PuzzleJava randomsss = new PuzzleJava();

        int  randomNum = randomsss.getTenRolls();
        System.out.println(randomNum);

        char randomLetter  = randomsss.getRandomLetter();
        System.out.println(randomLetter); 
        
        String randompass = randomsss.generatePassword();
        System.out.println(randompass);

        String[] passwords = randomsss.getNewPasswordSet(10);
        List<String> passwordList = new ArrayList<String>(Arrays.asList(passwords));
        for (String password : passwordList) {
            System.out.println(password);
        }
        System.out.println(passwordList.toString());

    }
}