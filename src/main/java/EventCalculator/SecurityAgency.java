package EventCalculator;


import org.json.JSONArray;
import org.json.JSONObject;

public class SecurityAgency implements CostCalculator {

    private String priceList;

    private String eventSize;
    private String riskAssesment;
    private int eventTime;

    public SecurityAgency(String priceList) {
        this.priceList = priceList;
        eventTime = 1;
    }

    @Override
    public String getName() {
        JSONObject jsonObject = new JSONObject(priceList);

        return (String)jsonObject.get("name");
    }

    @Override
    public double getCost() {
        return getPrice(eventSize, riskAssesment, eventTime);
    }

    private int getPrice(String eventSize, String riskAssesment, int eventTime) {
        JSONObject jsonObject = new JSONObject(priceList);

        JSONArray array = (JSONArray)jsonObject.get("prices");

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = (JSONObject)array.get(i);
            if (object.get("size").equals(eventSize) && object.get("risk").equals(riskAssesment) ) {
                if(eventTime > 0){
                    return (int)object.get("price") * eventTime;
                }
            }
        }
        return 0;
    }

    public void setEventSize(String eventSize) {
        this.eventSize = eventSize;
    }

    public void setRiskAssesment(String riskAssesment) {

        this.riskAssesment = riskAssesment;
    }

    public void setEventTime(int eventTime) {

        this.eventTime = eventTime;
    }
}
