package lt.techin.gjezepcikas;

import org.openqa.selenium.WebElement;

import java.util.Random;

public class RandomDataGenerator {
    private static final Random random = new Random();

    public static String getRandomFirstName() {
        String[] firstName = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Thomas", "Charles",
                "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth",
                "George", "Joshua", "Kevin", "Brian", "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan",
                "Jacob", "Gary", "Nicholas", "Eric", "Jonathan", "Stephen", "Larry", "Justin", "Scott", "Brandon"};
        return firstName[random.nextInt(firstName.length)];
    }

    public static String getRandomPassword() {
        int length = 8 + random.nextInt(9); // Password length between 8 and 16
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkl56789@#$%+";
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    public static String getRandomNumberOne() {
        String[] randomNumberOne = {"10","20","30","40","50","60","70"};
        return randomNumberOne[random.nextInt(randomNumberOne.length)];
    }

    public static String getRandomNumberTwo() {
        String[] randomNumberTwo = {"9","8","7","6","5","4","3"};
        return randomNumberTwo[random.nextInt(randomNumberTwo.length)];
    }

}

