package core;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class JSonAnalyzing {
    private static double getDataFromJSon(String jSon, String jSonPath){
        DocumentContext jsonContext = JsonPath.parse(jSon);

       // double needData = Double.parseDouble(jsonContext.read(jSonPath).toString().replace("[","").replace("]","").replace(",",""));

        NumberFormat formatter = new DecimalFormat("0.00000000000");
        String string = formatter.format(Double.parseDouble(jsonContext.read(jSonPath).toString().replace("[","").replace("]","").replace(",","")));

        double needData = Double.parseDouble(string);

        System.out.println(needData);
        return needData;
    }

    public static Data processData(JSonData jsData){
        Data data = new Data();

        data.addDataItem(STATICSTRING.DATA_CURRENT_EPS,getDataFromJSon(jsData.getJsonByName(STATICSTRING.FINANCE),STATICSTRING.DATA_CURRENT_EPS));
        data.addDataItem(STATICSTRING.DATA_OLD_EPS,getDataFromJSon(jsData.getJsonByName(STATICSTRING.FINANCE),STATICSTRING.DATA_OLD_EPS));
        data.addDataItem(STATICSTRING.DATA_CURRENT_EQUITY,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BANG_CAN_DOI_KE_TOAN),STATICSTRING.DATA_CURRENT_EQUITY));
        data.addDataItem(STATICSTRING.DATA_OLD_EQUITY,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BANG_CAN_DOI_KE_TOAN),STATICSTRING.DATA_OLD_EQUITY));

        return data;
    }
}
