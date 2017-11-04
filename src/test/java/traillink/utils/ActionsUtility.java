package traillink.utils;

import java.util.Random;

public class ActionsUtility extends ExcelUtils {
	
	
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
	
	public boolean checkCountIncrease(String previouscount,String currentCount) {
        boolean  isOk=false;
        int previous = Integer.valueOf(previouscount);
        int expected  = previous+1;
        String expectedcount = String.valueOf(expected);
        
        if(expectedcount.equalsIgnoreCase(currentCount)){
        	isOk=true;
        	Log.info("Count is increased by one");
        }else{
        	isOk=false;
        	Log.info("Count is not increased by one");
        }
       
        return isOk;
    }
}
