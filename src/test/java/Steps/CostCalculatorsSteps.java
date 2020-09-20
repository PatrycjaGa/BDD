package Steps;

import EventCalculator.BandRental;
import EventCalculator.EventHallRental;
import EventCalculator.SecurityAgency;
import SampleObjects.SampleEventBand;
import SampleObjects.SampleEventHallRental;
import SampleObjects.SampleSecurityAgency;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CostCalculatorsSteps {

    private SecurityAgency sampleSecurityAgency;
    private EventHallRental sampleHallRental;
    private String eventSize;
    private String riskAssessment;
    private BandRental sampleBandRental;

    @Given("There is {string} security agency")
    public void thereIsSecurityAgency(String securityAgencyName) {
        sampleSecurityAgency = SampleSecurityAgency.getSecurityAgency(securityAgencyName);
    }

    @Given("There is {string} event hall agency")
    public void thereIsEventHallAgency(String arg0) {
        sampleHallRental = SampleEventHallRental.getEventHallRental(arg0);
    }
    @Given("There is {string} band")
    public void thereIsBand(String bandName) {
        sampleBandRental = SampleEventBand.getBand(bandName);

    }


    @When("The event size is {string}")
    public void theEventSizeIs(String arg0) {
        eventSize = arg0;
    }

    @When("The event risk is {string}")
    public void theEventRiskIs(String arg0) {
        riskAssessment = arg0;
    }

// To zmienilem w 1 ćwiczeniu
    @Then("I get {string} PLN for {string} hr(s) protection cost")
    public void iGetPLNForProtectionCost(String cost, String hour) {
        int costNumber = Integer.parseInt(cost);
        int hourNumber = Integer.parseInt(hour);

        sampleSecurityAgency.setEventSize(eventSize);
        sampleSecurityAgency.setRiskAssesment(riskAssessment);
        sampleSecurityAgency.setEventTime(hourNumber);
        Assertions.assertEquals(costNumber, sampleSecurityAgency.getCost());
    }
// Koniec: To zmienilem w 1 ćwiczeniu

    @Then("I get {int} PLN for {int} hr(s) protection cost")
    public void iGetPLNForProtectionCost(int arg0, int arg1) {
        sampleSecurityAgency.setEventSize(eventSize);
        sampleSecurityAgency.setRiskAssesment(riskAssessment);
        sampleSecurityAgency.setEventTime(arg1);
        Assertions.assertEquals(arg0, sampleSecurityAgency.getCost());
    }

    @Then("I get {int} PLN for {int} hr(s) room rental price")
    public void iGetPLNForHrRoomRentalPrice(int arg0, int arg1) {
        sampleHallRental.setEventSize(eventSize);
        sampleHallRental.setEventTime(arg1);
        Assertions.assertEquals(arg0, sampleHallRental.getCost());
    }

    @Then("I get {int} PLN for {int} hr(s) band time play")
    public void iGetPLNForHrBandTimePlay(int price, int time) {
        sampleBandRental.setEventTime(time);
        Assertions.assertEquals(price, sampleBandRental.getCost());

    }

}
