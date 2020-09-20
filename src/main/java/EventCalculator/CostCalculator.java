package EventCalculator;

public interface CostCalculator {

    /**
     * Calculates an overall cost for certain cost component. Factors which influence the cost are provided
     * in a class which implements the interface.
     * @return Overall cost
     */
    public double getCost();

    /**
     * Returns the name of cost provider
     * @return Name
     */
    public String getName();

}
