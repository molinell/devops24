package org.devops;

import java.util.ArrayList;
import java.util.Arrays;

public class Profile {

    private String profileName;
    private ArrayList<String> friendList;

    Profile(String profileName, String[] friendList){
        this.profileName = profileName;
        this.friendList = new ArrayList<>(Arrays.asList(friendList));
    }

    public void addFriends(String[] friendList){
        this.friendList.addAll(Arrays.asList(friendList));
    }

    public void addFriends(String friend){
        this.friendList.add(friend);
    }

    @Override
    public String toString() {
        return profileName + " --- " + friendList.toString();
    }

    public String getProfileName() {
        return profileName;
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }
}
