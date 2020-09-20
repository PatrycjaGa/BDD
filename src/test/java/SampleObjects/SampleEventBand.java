package SampleObjects;

import EventCalculator.BandRental;

import java.util.HashMap;
import java.util.Map;

// Hint: Java does not support multiline strings. However, many IDEs helps us with this task. When you paste
// multiline string inside "", Idea will automatically add '\n' characters and escape special characters like \"
// source: https://www.baeldung.com/java-multiline-string

public class SampleEventBand {

    private final static Map<String, String> bandRentals = new HashMap<String, String>() {{
        put( "Korona Nocnego Kochanka","{ \n" +
                "   \"name\": \"Korona Nocnego Kochanka\",\n" +
                "   \"prices\": 360\n" +
    "}" );}
    };


    public static BandRental getBand(String BandName) {
        return new BandRental(bandRentals.get(BandName));
    }

}
