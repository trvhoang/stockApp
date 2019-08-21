package core;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Ref;

public class SurfData {
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtTrendSignal;
    @FXML
    private TextField txtReferPrice;
    @FXML
    private TextField txtBoughtPrice;
    @FXML
    private TextField txtUpcutPrice;
    @FXML
    private TextField txtDowncutPrice;
    @FXML
    private TextField txtStyle;
    @FXML
    private TextField txtRemark;
    public SimpleStringProperty  Type = new SimpleStringProperty();
    public SimpleStringProperty  Code = new SimpleStringProperty();
    public SimpleStringProperty  TrendSignal = new SimpleStringProperty();
    public SimpleStringProperty  ReferPrice = new SimpleStringProperty();
    public SimpleStringProperty  BoughtPrice = new SimpleStringProperty();
    public SimpleStringProperty  Rate = new SimpleStringProperty();
    public SimpleStringProperty  UpcutPrice = new SimpleStringProperty();
    public SimpleStringProperty  DowncutPrice = new SimpleStringProperty();
    public SimpleStringProperty  Style = new SimpleStringProperty();
    public SimpleStringProperty  Remark = new SimpleStringProperty();

    public SurfData(String Type, String Code, String TrendSignal, String ReferPrice, String BoughtPrice, String Rate, String UpcutPrice, String DowncutPrice, String Style, String Remark) {
            setType(Type);
            setCode(Code);
            setTrendSignal(TrendSignal);
            setReferPrice(ReferPrice);
            setBoughtPrice(BoughtPrice);
            setRate(Rate);
            setUpcutPrice(UpcutPrice);
            setDowncutPrice(DowncutPrice);
            setStyle(Style);
            setRemark(Remark);
    }



    public  SurfData(){
        this("","","","","","","","","","");
    }

    public String getType() {
        return Type.get();
    }


    public void setType(String type) {
        Type.set(type);
    }

    public String getCode() {
        return Code.get();
    }

    public void setCode(String code) {
        Code.set(code);
    }

    public String getTrendSignal() {
        return TrendSignal.get();
    }

    public void setTrendSignal(String trendSignal) {
        TrendSignal.set(trendSignal);
    }

    public String getReferPrice() {
        return ReferPrice.get();
    }

    public void setReferPrice(String referPrice) {
        ReferPrice.set(referPrice);
    }

    public String getBoughtPrice() {
        return BoughtPrice.get();
    }

    public void setBoughtPrice(String boughtPrice) {
        BoughtPrice.set(boughtPrice);
    }

    public String getRate() {
        return Rate.get();
    }

    public void setRate(String rate) {
        Rate.set(rate);
    }

    public String getUpcutPrice() {
        return UpcutPrice.get();
    }

    public void setUpcutPrice(String upcutPrice) {
        UpcutPrice.set(upcutPrice);
    }

    public String getDowncutPrice() {
        return DowncutPrice.get();
    }

    public void setDowncutPrice(String downcutPrice) {
        DowncutPrice.set(downcutPrice);
    }

    public String getStyle() {
        return Style.get();
    }

    public void setStyle(String style) {
        Style.set(style);
    }

    public String getRemark() {
        return Remark.get();
    }

    public void setRemark(String remark) {
        Remark.set(remark);
    }
}
