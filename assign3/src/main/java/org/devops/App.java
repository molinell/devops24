package org.devops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "*** \"FaceBook\" ***" );

        ArrayList<Profile> profiles = new ArrayList<>();

        profiles.add(new Profile("Harry Potter",new String[]{"Ron Weasley", "Hermione Granger", "Luna Lovegood"}));
        profiles.add(new Profile("Frodo Baggins",new String[]{"Samwise Gamgee", "Gandalf", "Aragorn"}));
        profiles.add(new Profile("Sherlock Holmes",new String[]{"Dr. John Watson", "Mycroft Holmes", "Irene Adler"}));
        profiles.add(new Profile("Donald Duck",new String[]{"Mickey Mouse", "Scrooge McDuck", "Bombie the Zombie"}));
        profiles.add(new Profile("Tony Stark",new String[]{"Steve Rogers", "Bruce Banner", "Peter Parker"}));

        while (true) {
            System.out.println("*** Query a profile by number [q to quit] ***");
            int i = 0;
            for (Profile p : profiles) {
                System.out.println(i++ + ": " + p.getProfileName());
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    String ans = scanner.nextLine();
                    if (!ans.matches("[0-" + (profiles.size() - 1) + "]") && !ans.matches("[q]"))
                        throw new IllegalArgumentException("Invalid input, try again");
                    if (ans.matches("[q]")) System.exit(0);

                    System.out.println(profiles.get(Integer.parseInt(ans)).getFriendList().toString() + "\n");
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
