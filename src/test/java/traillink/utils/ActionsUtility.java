package traillink.utils;

import java.util.Random;

import traillink.reports.ExtentFactory;

public class ActionsUtility extends ExtentFactory {
	
	
	public String getRandomString(int size) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < size) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
