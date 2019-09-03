package core;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Ref;

public class SurfData {
    
    public SimpleStringProperty  Type = new SimpleStringProperty();
    public SimpleStringProperty  Code = new SimpleStringProperty();
    public SimpleStringProperty  TrendSignal = new SimpleStringProperty();
    public SimpleStringProperty  ReferPrice = new SimpleStringProperty();
    public SimpleStringProperty  BoughtPrice = new SimpleStringProperty();
    public SimpleStringProperty  Rate = new SimpleStringProperty();
    public SimpleStringProperty  UpcutPrice = new SimpleStringProperty();
    public SimpleStringProperty  DRate = new SimpleStringProperty();
    public SimpleStringProperty  DowncutPrice = new SimpleStringProperty();
    public SimpleStringProperty  Style = new SimpleStringProperty();
    public SimpleStringProperty  Remark = new SimpleStringProperty();


    public SurfData(String Type, String Code, String TrendSignal, String ReferPrice, String BoughtPrice, String Rate, String UpcutPrice,
                    String DRate, String DowncutPrice, String Style, String Remark) {
            setType(Type);
            setCode(Code);
            setTrendSignal(TrendSignal);
            setReferPrice(ReferPrice);
            setBoughtPrice(BoughtPrice);
            setRate(Rate);
            setUpcutPrice(UpcutPrice);
            setDRate(DRate);
            setDowncutPrice(DowncutPrice);
            setStyle(Style);
            setRemark(Remark);

    }

    public  SurfData(){
        this("","","","","","","","","","","");
    }

    public String getType() {
        return Type.get();
    }

    public SimpleStringProperty typeProperty() {
        return Type;
    }

    public void setType(String type) {
        this.Type.set(type);
    }

    public String getCode() {
        return Code.get();
    }

    public SimpleStringProperty codeProperty() {
        return Code;
    }

    public void setCode(String code) {
        this.Code.set(code);
    }

    public String getTrendSignal() {
        return TrendSignal.get();
    }

    public SimpleStringProperty trendSignalProperty() {
        return TrendSignal;
    }

    public void setTrendSignal(String trendSignal) {
        this.TrendSignal.set(trendSignal);
    }

    public String getReferPrice() {
        return ReferPrice.get();
    }

    public SimpleStringProperty referPriceProperty() {
        return ReferPrice;
    }

    public void setReferPrice(String referPrice) {
        this.ReferPrice.set(referPrice);
    }

    public String getBoughtPrice() {
        return BoughtPrice.get();
    }

    public SimpleStringProperty boughtPriceProperty() {
        return BoughtPrice;
    }

    public void setBoughtPrice(String boughtPrice) {
        this.BoughtPrice.set(boughtPrice);
    }

    public String getRate() {
        return Rate.get();
    }

    public SimpleStringProperty rateProperty() {
        return Rate;
    }

    public void setRate(String rate) {
        this.Rate.set(rate);
    }

    public String getUpcutPrice() {
        return UpcutPrice.get();
    }

    public SimpleStringProperty upcutPriceProperty() {
        return UpcutPrice;
    }

    public void setUpcutPrice(String upcutPrice) {
        this.UpcutPrice.set(upcutPrice);
    }

    public String getDRate() {
        return DRate.get();
    }

    public SimpleStringProperty DRateProperty() {
        return DRate;
    }

    public void setDRate(String DRate) {
        this.DRate.set(DRate);
    }

    public String getDowncutPrice() {
        return DowncutPrice.get();
    }

    public SimpleStringProperty downcutPriceProperty() {
        return DowncutPrice;
    }

    public void setDowncutPrice(String downcutPrice) {
        this.DowncutPrice.set(downcutPrice);
    }

    public String getStyle() {
        return Style.get();
    }

    public SimpleStringProperty styleProperty() {
        return Style;
    }

    public void setStyle(String style) {
        this.Style.set(style);
    }

    public String getRemark() {
        return Remark.get();
    }

    public SimpleStringProperty remarkProperty() {
        return Remark;
    }

    public void setRemark(String remark) {
        this.Remark.set(remark);
    }
}
