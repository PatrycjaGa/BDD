package EventCalculator;

import org.json.JSONArray;
import org.json.JSONObject;

public class EventHallRental implements CostCalculator {

    private String priceList;

    private String eventSize;
    private int eventTime;

    public EventHallRental(String priceList) {
        this.priceList = priceList;
        eventTime = 1;
    }

    @Override
    public double getCost() {
        return getPrice(eventSize, eventTime);
    }

    @Override
    public String getName() {
        JSONObject jsonObject = new JSONObject(priceList);

        return (String) jsonObject.get("name");
    }

    public void setEventSize(String eventSize) {
        this.eventSize = eventSize;
    }

    // zmodyfikowałem return (int)object.get("price") na return (int)object.get("price")*eventTime;
    private int getPrice(String eventSize, int eventTime) {
        JSONObject jsonObject = new JSONObject(priceList);
        JSONArray array = (JSONArray) jsonObject.get("prices");


        for (int i = 0; i < array.length(); i++) {
            JSONObject object = (JSONObject) array.get(i);
            if (object.get("size").equals(eventSize)) {
                if (eventSize.equals("big")) {
                    if (eventTime >= 5) {
                        return (int) object.get("price") * eventTime;
                    }
                    return 0;
                }
                if (eventTime > 0) {
                    return (int) object.get("price") * eventTime;
                }
            }
        }
        return 0;
    }



    // koniec modyfikacji
    public void setEventTime(int eventTime) {
        this.eventTime = eventTime;
    }

}
