package EventCalculator;

import java.util.ArrayList;
import java.util.List;

public class EventCalculator {

    private List<CostCalculator> costCalculatorList;

    public EventCalculator() {
        costCalculatorList = new ArrayList<>();
    }

    /**
     * Adds cost component
     * @param costCalculator cost component to add
     */
    public void addCostCalculator(CostCalculator costCalculator) {

        costCalculatorList.add(costCalculator);
    }

    /**
     * Calculates total cost for all cost components
     * @return total event price
     */
    public double getTotalPrice() {
        double total = 0.0;
        for(CostCalculator costCalculator : costCalculatorList) {
            total += costCalculator.getCost();
        }
        return total;
    }

    /**
     * Calculate single ticket price for given number of participants
     * @param participantsNumber No of participants expected on the event
     * @return single ticket price covering overall event cost, rounded up
     */
    public int getSingleTicketPrice(int participantsNumber) {
        return (int)Math.ceil(getTotalPrice() / (double)participantsNumber);
    }

    public int getSingleTicketPriceDistributionCost(int participantsNumber, int distributionCost) {
        return ((int)Math.ceil(getTotalPrice() / (double)participantsNumber)) + distributionCost;
    }

}
