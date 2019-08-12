package core;

import java.util.HashMap;

public class Data {
    HashMap<String, Double> listData = new HashMap();

    public void addDataItem(String key, double value){
        listData.put(key, value);
    }

    public double getValueByKey(String name){
        return listData.get(name);
    }

    public String getStringValueByKey(String name){
        return listData.get(name).toString();
    }
}
