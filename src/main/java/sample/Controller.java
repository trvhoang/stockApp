package sample;

import core.*;
import javafx.fxml.FXML;

import javafx.scene.control.*;

public class Controller {

    @FXML
    private Label txtFullCompanyName;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtCurrentEPS;

    @FXML
    private TextField txtOldEPS;

    @FXML
    private TextField txtCurrentEquity;

    @FXML
    private TextField txtOldEquity;

    @FXML
    private TextField txtCurrentCashFlow;

    @FXML
    private TextField txtOldCashFlow;

    @FXML
    private TextField txtProfitAfterTax;

    @FXML
    private TextField txtInvestedCapital;

    @FXML
    private TextField txtLongTermDebt;

    @FXML
    private void printOutput()
    {
        String companyName = txtCode.getText();
        JSonData jsData = initialData(companyName);

        //System.out.println("test " +  jsData.getJsonByName(STATICSTRING.VNDIRECT_BAO_CAO_KQKD));

        System.out.println("test " +  jsData.getJsonByName(STATICSTRING.VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE));

        Data data = JSonAnalyzing.processData(jsData);

        setTextBoxData(data);

        String fullCompanyName =  Network.getCompanyName(companyName);
        txtFullCompanyName.setText("Company Name: " + fullCompanyName);

    }

    private JSonData initialData(String companyName){
        JSonData jsData = new JSonData();
        jsData.addJSDataItem(STATICSTRING.VNDIRECT_BANG_CAN_DOI_KE_TOAN, Network.getDataVNDirect_BCDKT(companyName));
        jsData.addJSDataItem(STATICSTRING.VNDIRECT_BAO_CAO_LUU_CHUYEN_TIEN_TE, Network.getDataVNDirect_CBLCTT(companyName));
        jsData.addJSDataItem(STATICSTRING.VNDIRECT_BAO_CAO_KQKD, Network.getDataVNDirect_BCKQKD(companyName));
        jsData.addJSDataItem(STATICSTRING.FINANCE, Network.getDataFinance(companyName));
        return jsData;
    }

    private void setTextBoxData(Data data){
        txtCurrentEPS.setText(data.getStringValueByKey(STATICSTRING.DATA_CURRENT_EPS));
        txtOldEPS.setText(data.getStringValueByKey(STATICSTRING.DATA_OLD_EPS));
        txtCurrentEquity.setText(data.getStringValueByKey(STATICSTRING.DATA_CURRENT_EQUITY));
        txtOldEquity.setText(data.getStringValueByKey(STATICSTRING.DATA_OLD_EQUITY));
        txtCurrentCashFlow.setText(data.getStringValueByKey(STATICSTRING.DATA_CURRENT_CASH_FLOW));
        txtOldCashFlow.setText(data.getStringValueByKey(STATICSTRING.DATA_OLD_CASH_FLOW));

        //txtProfitAfterTax.setText(data.getStringValueByKey(STATICSTRING.DATA_PROFIT_AFTER_TAX));
        txtInvestedCapital.setText(data.getStringValueByKey(STATICSTRING.DATA_INVESTED_CAPITAL));
        //txtLongTermDebt.setText(data.getStringValueByKey(STATICSTRING.DATA_LONGTERM_DEBT));

    }

}
