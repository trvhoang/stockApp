package core;

import java.util.HashMap;

public class JSonData {
    HashMap listData = new HashMap();

    public void addJSDataItem(String key, String value){
        listData.put(key, value);
    }

    public String getJsonByName(String name){
        return listData.get(name).toString();
    }
}
