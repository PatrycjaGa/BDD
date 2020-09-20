package EventCalculator;

import org.json.JSONObject;

public class BandRental implements CostCalculator {

    private String priceList;
    private int eventTime;

    public BandRental(String priceList) {
        this.priceList = priceList;
    }

    @Override
    public double getCost() {
        return getPrice(eventTime);
    }


    @Override
    public String getName() {
        JSONObject jsonObject = new JSONObject(priceList);
        return (String)jsonObject.get("name");

    }

    private int getPrice(int eventTime) {
        JSONObject jsonObject = new JSONObject(priceList);
        int priceI = (int)jsonObject.get("prices");
        if (eventTime > 0) {
            return priceI * eventTime;
        }


        return 0;
    }

    public void setEventTime(int eventTime) {
        this.eventTime = eventTime;
    }

}

