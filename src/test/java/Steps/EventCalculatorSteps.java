package Steps;

import EventCalculator.EventCalculator;
import EventCalculator.EventHallRental;
import EventCalculator.SecurityAgency;
import SampleObjects.SampleEventHallRental;
import SampleObjects.SampleSecurityAgency;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class EventCalculatorSteps {

    private SecurityAgency sampleSecurityAgency;
    private EventHallRental sampleHallRental;
    private EventCalculator eventCalculator;

    private String eventSize;
    private String riskAssessment;
    private int eventTime;
    private int participantsNumber;

    @Before
    public void createEventCalculator() {
        eventCalculator = new EventCalculator();
    }

    @Given("I am negotiating with {string} event hall provider")
    public void iAmNegotiatingWithEventHallProvider(String arg0) {
        sampleHallRental = SampleEventHallRental.getEventHallRental(arg0);
        eventCalculator.addCostCalculator(sampleHallRental);
    }

    @Given("I am negotiating with {string} security agency")
    public void iAmNegotiatingWithSecurityAgency(String arg0) {
        sampleSecurityAgency = SampleSecurityAgency.getSecurityAgency(arg0);
        eventCalculator.addCostCalculator(sampleSecurityAgency);
    }

    @When("I want to organize Wrestling Game large event")
    public void iWantToOrganizeWrestlingGameLargeEvent() {
        // wrestling game is considered high risk
        riskAssessment = "high";
        eventSize = "big";
        eventTime = 3;
    }

    @When("I want to organize cameral concert")
    public void iWantToOrganizeCameralConcert() {
        // cameral concert is low risk small event
        riskAssessment = "low";
        eventSize = "small";
        eventTime = 2;
    }

    @When("I want to organize local football game")
    public void iWantToOrganizeFootballGame() {
        // football game
        riskAssessment = "high";
        eventSize = "normal";
        eventTime = 2;
    }

    @When("I want to organize {string}  event with {string} risk with duration {int} hours")
    public void iWantToOrganizeEvent(String eventSizeArg, String riskAssessmentArg, int eventTimeArg) {
        // football game
        riskAssessment = riskAssessmentArg;
        eventSize = eventSizeArg;
        eventTime = eventTimeArg;
    }

    @When("I expect {int} participants")
    public void iExpectParticipants(int arg0) {
        participantsNumber = arg0;
    }

    @When("I want to organize big music festival")
    public void iWantToOrganizeMusicFestival() {
        // music festival
        riskAssessment = "high";
        eventSize = "big";
        eventTime = 10;
    }

    @Then("I get {int} PLN event cost")
    public void iGetPLNEventCost(int arg0) {
        setupSecurityAgency();
        setupHallRental();

        Assertions.assertEquals(arg0, eventCalculator.getTotalPrice());
    }

    @Then("I get {int} PLN for single ticket to cover cost")
    public void iGetPLNForSingleTicketToCoverCost(int arg0) {
        setupSecurityAgency();
        setupHallRental();

        Assertions.assertEquals(arg0, eventCalculator.getSingleTicketPrice(participantsNumber));
    }

    @Then("I get {int} PLN for single ticket with {int} PLN distribution to cover cost")
    public void iGetPLNForSingleTicketWitDistributionToCoverCost(int price, int distribution ) {
        setupSecurityAgency();
        setupHallRental();

        Assertions.assertEquals(price+distribution, eventCalculator.getSingleTicketPriceDistributionCost(participantsNumber, distribution));
    }

    private void setupSecurityAgency() {
        sampleSecurityAgency.setEventSize(eventSize);
        sampleSecurityAgency.setRiskAssesment(riskAssessment);
        sampleSecurityAgency.setEventTime(eventTime);
    }

    private void setupHallRental() {
        sampleHallRental.setEventSize(eventSize);
        sampleHallRental.setEventTime(eventTime);
    }


}
