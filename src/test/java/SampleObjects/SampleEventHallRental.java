package SampleObjects;

import EventCalculator.EventHallRental;

import java.util.HashMap;
import java.util.Map;

// Hint: Java does not support multiline strings. However, many IDEs helps us with this task. When you paste
// multiline string inside "", Idea will automatically add '\n' characters and escape special characters like \"
// source: https://www.baeldung.com/java-multiline-string

public class SampleEventHallRental {

    private final static Map<String, String> hallRentals = new HashMap<String, String>() { {
        put( "Carnegie Hall","{ \n" +
                "   \"name\": \"Carnegie Hall\",\n" +
                "\"prices\": [ \n" +
                "       {\n" +
                "          \"size\": \"small\",\n" +
                "          \"price\": 80\n" +
                "       },\n" +
                "       \n" +
                "       {\n" +
                "          \"size\": \"normal\",\n" +
                "          \"price\": 200\n" +
                "       },\n" +
                "       \n" +
                "       {\n" +
                "          \"size\": \"big\",\n" +
                "          \"price\": 1000,\n" +
                "          \"minimal_time\": 5\n" +
                "       }\n" +
                "   ]   \n" +
                "\n" +
                "}"); }
    };


    public static EventHallRental getEventHallRental(String AgencyName) {
        return new EventHallRental(hallRentals.get(AgencyName));
    }

}
