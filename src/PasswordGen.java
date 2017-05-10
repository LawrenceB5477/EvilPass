/**
 * The purpose of this program is make a password generator
 *
 * @author EvilFrog
 * @version 1.01
 */

import java.util.Scanner;
import java.util.Random;

public class PasswordGen {

    /**
     * Static Method to prompt the user for input for each iteration
     */
    public static void prompt() {
        // Menu presentation
        System.out.println("    ___   _   _   ___   _      ____     _     ___    ___  ");
        System.out.println("   ) __( \\ ( ) / )_ _( ) |    )  _)\\   )_\\   (  _(  (  _( ");
        System.out.println("   | _)   )\\_/(  _| |_ | (__  | '__/  /( )\\  _) \\   _) \\ ");
        System.out.println("   )___(   \\_/  )_____()____( )_(    )_/ \\_()____) )____)");
        System.out.println("************************************************************");
        System.out.println("*   [1] Lowercase Letters                                  *");
        System.out.println("*   [2] Lowercase and  Numbers                             *");
        System.out.println("*   [3] Lowercase, Uppercase, and Numbers                  *");
        System.out.println("*   [4] Lowercase, uppercase, Numbers, Punctuation         *");
        System.out.println("*   [5] quit                                               *");
        System.out.println("************************************************************");
    }

    /**
     * Static method to ask the user for a selection
     */
    public static void select() {
        System.out.print("Enter Selection [1-5]: ");
    }

    /**
     * Static method to get the password length, prevents negative input
     * @return Returns the length of the password to be generated, as an int.
     */
    public static int length() {
        Scanner in = new Scanner(System.in);
        int length = 0;
        boolean passFound = false;

        while (passFound == false) {
            System.out.print("Password Length (0 Goes back to option selection): ");
            length = in.nextInt();
            if (length >= 0) {
                passFound = true;
            } else {
                System.out.println("\tPassword too short, please try again.");
            }
        }
        return length;
    }

    /**
     * Static method to generate a password made of only lowercase letters.
     * @param length The length of the password to be generated.
     * @return Returns the generated password.
     */
    public static String option1(int length) {
        String password = "";
        Random ranNum = new Random();
        for (int i = 1; i <= length; i++) {
            int generated = 0;
            while (!(generated >= 97 && generated <= 122)) {
                generated = ranNum.nextInt(127);
            }
            password += (char) generated;
        }
        return password;
    }

    /**
     * Static method to generate a password made of lowercase letters and numbers.
     * @param length The length of the password to be generated
     * @return Returns the generated password
     */
    public static String option2(int length) {
        String password = "";
        Random ranNum = new Random();
        for (int i = 1; i <= length; i++) {
            int generated = 0;
            while (!((generated >= 97 && generated <= 122) || (generated >= 48 && generated <= 57))) {
                generated = ranNum.nextInt(127);
            }
            password += (char) generated;
        }
        return password;
    }

    /**
     * Static method to generate a password made of lowercase letters, uppercase letters, and numbers.
     * @param length The length of the password to be generated
     * @return Returns the generated password
     */
    public static String option3(int length) {
        String password = "";
        Random ranNum = new Random();
        for (int i = 1; i <= length; i++) {
            int generated = 0;
            while (!((generated >= 97 && generated <= 122) || (generated >= 48 && generated <= 57)
                    || generated >= 65 && generated <= 90)) {
                generated = ranNum.nextInt(127);
            }
            password += (char) generated;
        }
        return password;
    }

    /**
     * Static method to generate a password made from almost all characters.
     * @param length The lenght of the password to be generated
     * @return Returns the generated password
     */
    public static String option4(int length) {
        String password = "";
        Random ranNum = new Random();
        for (int i = 1; i <= length; i++) {
            int generated = 0;
            while (!((generated >= 97 && generated <= 122) || (generated >= 48 && generated <= 57)
                    || generated >= 65 && generated <= 90 || generated >= 58 && generated <= 64
                    || generated >= 91 && generated <= 96 || generated >= 123 && generated <= 126)) {
                generated = ranNum.nextInt(127);
            }
            password += (char) generated;
        }
        return password;
    }

    // Main Program Loop.
    public static void main(String[] args) {
        // initialization, object creation
        boolean running = true;
        Scanner in = new Scanner(System.in);
        int length;
        String password;

        // User Prompt
        prompt();

        // Processing
        while (running == true) {
            select();
            int selection = in.nextInt();
            if (selection == 1) {
                length = length();
                if (length == 0) {
                    continue;
                }
                password = option1(length);
                System.out.println(password);

            } else if (selection == 2) {
                length = length();
                if (length == 0) {
                    continue;
                }
                password = option2(length);
                System.out.println(password);

            } else if (selection == 3) {
                length = length();
                if (length == 0) {
                    continue;
                }
                password = option3(length);
                System.out.println(password);

            } else if (selection == 4) {
                length = length();
                if (length == 0) {
                    continue;
                }
                password = option4(length);
                System.out.println(password);

            } else if (selection == 5) {
                running = false;
                System.out.println("Thank you, password generator will exit now");

            } else {
                System.out.println("Please try again, that was not a valid selection.");
                System.out.println();
            }
        }

    }
}
