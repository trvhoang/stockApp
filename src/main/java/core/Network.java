package core;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Network {
    public HashMap listJson;

    private static final String URL = "https://finance.vietstock.vn/VCB-ngan-hang-tmcp-ngoai-thuong-viet-nam.htm?tab=BCTN";

    public static String getDataFinance(final String companyCode) {
        String jSon = "";
        try {
            Map<String, String> postData  = new HashMap<String, String>() {{
                put("Code", companyCode);
                put("Page", "1");
                put("PageSize", "4");
                put("ReportTermType", "1");
                put("ReportType", "BCTQ");
                put("Unit", "1000000");
            }};

            //Document doc = Jsoup.connect("https://finance.vietstock.vn/data/financeinfo").ignoreContentType(true).method(Connection.Method.POST).data(postData).execute().parse();
            Connection.Response rs = Jsoup.connect("https://finance.vietstock.vn/data/financeinfo").ignoreContentType(true).method(Connection.Method.POST).data(postData).execute();
            System.out.println(rs.body());
            jSon = rs.body();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return jSon;
    }

    public static String getDataVNDirect_BCDKT(String companyCode) {
        String URL = "https://www.vndirect.com.vn/portal/bang-can-doi-ke-toan/" + companyCode + ".shtml";
        String data = "";
        try {
            Document doc = Jsoup.connect(URL).method(Connection.Method.POST).data("searchObject.fiscalQuarter", "IN_YEAR").execute().parse();
            //System.out.println(doc);
            data = doc.toString();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return converTableToJson(data);
    }

    public static String getDataVNDirect_CBLCTT(String companyCode) {
        String URL = "https://www.vndirect.com.vn/portal/bao-cao-luu-chuyen-tien-te/" + companyCode + ".shtml";
        String data = "";
        try {
            Document doc = Jsoup.connect(URL).method(Connection.Method.POST).data("searchObject.fiscalQuarter", "IN_YEAR").execute().parse();
            //System.out.println(doc);
            data = doc.toString();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return converTableToJson(data);
    }

    public static String getDataVNDirect_BCKQKD(final String companyCode) {
        String jSon = "";
        try {
            Map<String, String> postData  = new HashMap<String, String>() {{
                put("cacheData", "H4sIAAAAAAAAAI2TPWzTQBTHX50mbZICaSvBgKoW0aVSFTtp+VIlIE1TanBTmoYhLOESXxKjxGfO" +
                        "5zRlQEJILB3KAAMDSIi1GxIDEgMqgoUFNroAEhITO4UOnH2OmhQh9aTz3/fu/Lvn97H5E4I2hcGb" +
                        "qIniDjPq8QVk1xaRFezbfrN19MbHAEjzEKkTpM+jMiNUhTCrUWzXSF1vWRcugjsGVvv5M8ZngMGR" +
                        "cU1dyRcLmVSueCVTGOf4iaYZL5NGfBWXXG0Q047rpIEMM66X4isY0XIth22nzsKF0d3c50tzEvRo" +
                        "ELJQ1TCrDCa0pinzD2UOkH2ALACyXpKvesdUs0JmWhSG9/4lRSla0wybte5+Gnn8Hj0JQI8KvbZx" +
                        "G7cs7u3Qaq/7ZNCbVBLnhJwVckbIaSGnhEwLmRKSFJIQoniiCIoiKIqgKIKiCIoiKIqgKMmWxWBI" +
                        "xGz5WiqXz/hhuwV3IMDdC3pOulk64YexaeoGxWXWjqFaIXOIoRyuvHi3ff7Zws5TCUIahHVhVHUG" +
                        "Mc2NilxHZlXWiFmd0SCqY7tMDYsZxOQedBxYYdTwjoSrlDhWmujYdWZEg36D4UbHOlQnZVRvr/oI" +
                        "1TEtrXlLnonR//g7i2w8i5E5ufUjWZrbeClBRIWI6TRKmKr8AhWilp9SHbeuQ9Sx+UJkWYMBm9E0" +
                        "xYhhfXbNv/nwno1Hou3PULd1npKGvxPr3skT336I2xeJblSMDvhwh3EfZ3Dflg/yiividkaPJQbP" +
                        "3mGvLt0Ax70MrH9/8GHj5Bde6Zch2ER1B/OQxfYOZb143N98NBJ9+HVdAvCofDi/GITT3149HzPf" +
                        "3msw6PPLhr+pWa/vGEhN0/Iq6Pg/nrjWMZ+0wyC07Gy9Hkt0YqTlxIEJv9uEZDcheWDCnzZhqpsw" +
                        "dWDCbpsw3U2YFgS3wY6NLy5lM4ViLpXPFNNLmpZJ59WlrOiyIIdIXpdJDIKJSUXhzRz21J2t1l+5" +
                        "7Du1JgUAAA==");
                put("searchObject.fiscalQuarter", "IN_YEAR");
                put("searchObject.fiscalYear", "2019");
                put("searchObject.numberTerm", "5");
                put("searchObject.moneyRate", "1,000,000");
            }};

            Map<String, String> postHeader  = new HashMap<String, String>() {{
                put("Referer", "https://www.vndirect.com.vn/portal/bao-cao-ket-qua-kinh-doanh/acb.shtml");
            }};

            //Document doc = Jsoup.connect("https://finance.vietstock.vn/data/financeinfo").ignoreContentType(true).method(Connection.Method.POST).data(postData).execute().parse();
            Connection.Response rs = Jsoup.connect("https://www.vndirect.com.vn/portal/ajax/listed/SearchIncomeStatement.shtml").ignoreContentType(true).method(Connection.Method.POST).data(postData).header("Referer","https://www.vndirect.com.vn/portal/bao-cao-ket-qua-kinh-doanh/acb.shtml").headers(postHeader).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36").execute();
            System.out.println(rs.statusCode());
            System.out.println(rs.body());
            jSon = rs.body();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return jSon;
    }

    public static String converTableToJson(String source) throws JSONException {
        ArrayList<String> listColumnHeader = new ArrayList();
        Document doc = Jsoup.parse(source);
        JSONObject jsonParentObject = new JSONObject();
        int rowIndex = 0;
        Element rowCatch = null;
        Elements listTable = doc.select("table");
        listTable.remove(0);

        for (Element table : listTable) {
            try {
                Elements listRow = table.select("tr");
                for (Element row : listRow) {
                    //rowCatch for printing exception purpose
                    rowCatch = row;
                    Elements tds = row.select("td");

                    //Get the header of table which is the first row
                    if (rowIndex == 0) {
                        for (int i = 1; i < tds.size(); i++) {
                            listColumnHeader.add(tds.get(i).text());
                        }
                    }

                    if (rowIndex != 0) {
                        JSONObject jsonObject = new JSONObject();
                        for (int i = 0; i < listColumnHeader.size(); i++) {
                            jsonObject.put(listColumnHeader.get(i), tds.get(i + 1).text());
                        }
                        jsonParentObject.put(tds.get(0).text(), jsonObject);
                    }
                    rowIndex++;
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
                System.out.println(rowCatch.text());
            }
        }
        return jsonParentObject.toString();
    }

    public static String getCompanyName(String companyCode) throws JSONException {
        String URL = "https://www.vndirect.com.vn/portal/bao-cao-luu-chuyen-tien-te/" + companyCode + ".shtml";
        String data = "";
        try {
            Document doc = Jsoup.connect(URL).method(Connection.Method.POST).data("searchObject.fiscalQuarter", "IN_YEAR").execute().parse();
            data = doc.toString();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        Document doc = Jsoup.parse(data);
        Elements companyName = doc.select("title");
        return companyName.get(0).text().replace("VNDIRECT-Tổng quan | ","");
    }
}
