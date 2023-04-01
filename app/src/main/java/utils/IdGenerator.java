package utils;

import org.joda.time.DateTime;

public class IdGenerator {

    public static String idGenerator(String one, String two){
        String time = DateTime.now().toString();
        String randId = String.valueOf(Math.floor(Math.random() * 512));
        return one + two + time + randId;
    }
}
