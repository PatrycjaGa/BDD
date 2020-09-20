package SampleObjects;

import EventCalculator.SecurityAgency;

import java.util.HashMap;
import java.util.Map;

// Hint: Java does not support multiline strings. However, many IDEs helps us with this task. When you paste
// multiline string inside "", Idea will automatically add '\n' characters and escape special characters like \"
// source: https://www.baeldung.com/java-multiline-string

public class SampleSecurityAgency {

    private final static Map<String, String> agencies = new HashMap<String, String> () { {
        put( "Blue Dragon","{\n"+
                     "\"name\":\"Blue Dragon\",\n"+
                     "\"prices\":[\n"+
                     "{\n"+
                     "\"size\":\"small\",\n"+
                     "\"risk\":\"low\",\n"+
                     "\"price\":200\n"+
                     "},\n"+
                     "{\n"+
                     "\"size\":\"small\",\n"+
                     "\"risk\":\"high\",\n"+
                     "\"price\":600\n"+
                     "},\n"+
                     "{\n"+
                     "\"size\":\"normal\",\n"+
                     "\"risk\":\"low\",\n"+
                     "\"price\":400\n"+
                     "},\n"+
                     "{\n"+
                     "\"size\":\"normal\",\n"+
                     "\"risk\":\"high\",\n"+
                     "\"price\":1200\n"+
                     "},\n"+
                     "{\n"+
                     "\"size\":\"big\",\n"+
                     "\"risk\":\"low\",\n"+
                     "\"price\":2000\n"+
                     "},\n"+
                     "{\n"+
                     "\"size\":\"big\",\n"+
                     "\"risk\":\"high\",\n"+
                     "\"price\":6000\n"+
                     "}\n"+
                     "]\n"+
                     "}"); }
    };


    public static SecurityAgency getSecurityAgency(String AgencyName) {
        return new SecurityAgency(agencies.get(AgencyName));
    }

}
