package EventCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityAgencyTest {

    @Test
    void getCost() {
        SecurityAgency securityAgency = new SecurityAgency(
                "{\n"+
                        "\"name\":\"Blue Dragon\",\n"+
                        "\"prices\":[\n"+
                        "{\n"+
                        "\"size\":\"small\",\n"+
                        "\"risk\":\"low\",\n"+
                        "\"price\":200\n"+
                        "}]}");

        securityAgency.setRiskAssesment("low");
        securityAgency.setEventSize("small");

        assertEquals(200.0, securityAgency.getCost(), 0.1);
    }
}