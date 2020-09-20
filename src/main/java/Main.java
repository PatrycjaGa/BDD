import EventCalculator.EventCalculator;
import EventCalculator.EventHallRental;
import EventCalculator.SecurityAgency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    /**
     * Reads data from resources and creates SecurityAgency object
     * @return SecurityAgency object with loaded configuration
     * @throws IOException
     */
    private SecurityAgency getAgency() throws IOException {
        return new SecurityAgency(new String(
                Files.readAllBytes(
                        Paths.get(
                                Objects.requireNonNull(
                                        getClass().getClassLoader().getResource("BlueDragon.json")).getPath()))));
    }

    /**
     * Reads data from resources and creates EventHallRental object
     * @return SecurityAgency object with loaded configuration
     * @throws IOException
     */
    private EventHallRental getEventHallRental() throws IOException {
        return new EventHallRental(new String(
                Files.readAllBytes(
                        Paths.get(
                                Objects.requireNonNull(
                                        getClass().getClassLoader().getResource("Carnegie.json")).getPath()))));
    }


    public static void main(String[] args) throws IOException {

        // event params - values to be provided in more sophisticated user interface (eventually)
        String eventSize = "normal";
        String riskAssessment = "low";
        int eventTime = 3;
        int noOfParticipants = 100;

        // calculations and presentation of results
        Main m = new Main();

        SecurityAgency securityAgency = m.getAgency();
        EventHallRental eventHallRental = m.getEventHallRental();

        EventCalculator eventCalculator = new EventCalculator();
        eventCalculator.addCostCalculator(securityAgency);
        eventCalculator.addCostCalculator(eventHallRental);

        securityAgency.setEventSize(eventSize);
        securityAgency.setRiskAssesment(riskAssessment);
        securityAgency.setEventTime(eventTime);

        eventHallRental.setEventSize(eventSize);
        eventHallRental.setEventTime(eventTime);

        System.out.println("Event calculated price");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(String.format("Event size: %s", eventSize));
        System.out.println(String.format("Event place: %s", eventHallRental.getName()));
        System.out.println(String.format("Event length: %d hr(s)", eventTime));
        System.out.println(String.format("Minimal ticket price covering cost for %d participants: %d",
                noOfParticipants,
                eventCalculator.getSingleTicketPrice(noOfParticipants) ) );
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(String.format("Total Event price: %.02f", eventCalculator.getTotalPrice()));

    }

}
