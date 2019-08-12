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
        data.addDataItem(STATICSTRING.DATA_CURRENT_CASH_FLOW,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE),STATICSTRING.DATA_CURRENT_CASH_FLOW));
        data.addDataItem(STATICSTRING.DATA_OLD_CASH_FLOW,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE),STATICSTRING.DATA_OLD_CASH_FLOW));

        //data.addDataItem(STATICSTRING.DATA_PROFIT_AFTER_TAX,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE),STATICSTRING.DATA_PROFIT_AFTER_TAX));
        data.addDataItem(STATICSTRING.DATA_INVESTED_CAPITAL,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BANG_CAN_DOI_KE_TOAN),STATICSTRING.DATA_INVESTED_CAPITAL));
        //data.addDataItem(STATICSTRING.DATA_LONGTERM_DEBT,getDataFromJSon(jsData.getJsonByName(STATICSTRING.VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE),STATICSTRING.DATA_LONGTERM_DEBT));

        return data;
    }
}
