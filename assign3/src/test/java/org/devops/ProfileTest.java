package org.devops;

import junit.framework.Test;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfileTest extends TestCase {

    Profile profile = new Profile("Sherlock Holmes",new String[]{"Dr. John Watson", "Mycroft Holmes", "Irene Adler"});


    public void testGetProfileName() {
        //Succeeds
        assertEquals("Sherlock Holmes",profile.getProfileName());

        //Fails
        assertEquals("Holmes Sherlock",profile.getProfileName());
    }

    public void testGetFriendList() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Dr. John Watson", "Mycroft Holmes", "Irene Adler"));

        //Succeeds, so that getFriendList() actually returns something
        assertNotNull(profile.getFriendList());

        //succeeds
        assertEquals(expected, profile.getFriendList());

        //fails
        expected.removeLast();
        assertEquals(expected, profile.getFriendList());
    }


    public void testAddFriends(){
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Dr. John Watson", "Mycroft Holmes", "Irene Adler","Mrs. Hudson", "D.I. Greg Lestrade"));
        profile.addFriends(new String[]{"Mrs. Hudson", "D.I. Greg Lestrade"});

        //Succeeds
        assertEquals(expected, profile.getFriendList());

        //succeeds, adding empty shouldn't change anything
        profile.addFriends(new String[]{});
        assertEquals(expected, profile.getFriendList());

        //Fails, as a new friend is added
        profile.addFriends("Jim Moriarty");
        assertEquals(expected, profile.getFriendList());
    }



    /**
     * Idea for measuring performance:
     *
     * Logging the time before and after a function execution, and calculating the difference.
     * This obviously varies depending on the computer running the test.
     * There seems to be many ways to measure execution time, this was the simplest
     *
     * [https://stackoverflow.com/questions/3382954/measure-execution-time-for-a-java-method]
     * [https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java]
     *
     * Since the friend list of this program exists in local memory and doesn't involve any
     * complex logic / operations, external sources etc. it is straight forward and very fast
     * On my computer time varies from (less than) 0 ms to 3 ms
     * 10000 and 100000 profiles produced similar results
     *
     * This same logic could be applied to also constructing profiles or adding more friends
     */
    public void testGetFriendListPerformance(){
        //creating dummy profiles so that it queries a different each time, more realistic based on this programs idea
        int n = 100000;
        ArrayList<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            profiles.add(new Profile("Profile " + i, new String[]{"Friend" + i, "Friend" + (i+1), "Friend" + (i+2)}));
        }

        long start = System.currentTimeMillis();
        for(Profile p: profiles) p.getFriendList();
        long end = System.currentTimeMillis();

        long timeDiff = end - start;

        System.out.println("\n*** Testing fetch timing ***");
        System.out.println("start time: " + start);
        System.out.println("end time: " + end);
        System.out.printf("Total time taken for fetching %d friend lists: %d ms\nAverage time to fetch one friend list: %.6fms\n\n",
                n,
                timeDiff,
                ((float)timeDiff/(float)n));
    }
}