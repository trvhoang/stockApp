package core;

import java.sql.Ref;

public class SurfData {
    public String Type;
    public String Code;
    public String TrendSignal;
    public String ReferPrice;
    public String BoughtPrice;
    public String Rate;
    public String UpcutPrice;
    public String DowncutPrice;
    public String Style;
    public String Remark;

    public SurfData(String text, String txtCodeText, String txtTrendSignalText, String txtReferPriceText, String txtBoughtPriceText, String txtUpcutPriceText, String txtDowncutPriceText, String txtStyleText, String txtRemarkText){

    }

    public void SurfData(String Type, String Code, String TrendSignal, String ReferPrice, String BoughtPrice, String Rate, String UpcutPrice, String DowncutPrice, String Style, String Remark){
        this.Type = Type;
        this.Code = Code;
        this.TrendSignal = TrendSignal;
        this.ReferPrice = ReferPrice;
        this.BoughtPrice = BoughtPrice;
        this.Rate = Rate;
        this.UpcutPrice = UpcutPrice;
        this.DowncutPrice = DowncutPrice;
        this.Style = Style;
        this. Remark = Remark;
    }

    public  void SurfData(){

    }


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getTrendSignal() {
        return TrendSignal;
    }

    public void setTrendSignal(String trendSignal) {
        TrendSignal = trendSignal;
    }

    public String getReferPrice() {
        return ReferPrice;
    }

    public void setReferPrice(String referPrice) {
        ReferPrice = referPrice;
    }

    public String getBoughtPrice() {
        return BoughtPrice;
    }

    public void setBoughtPrice(String boughtPrice) {
        BoughtPrice = boughtPrice;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getUpcutPrice() {
        return UpcutPrice;
    }

    public void setUpcutPrice(String upcutPrice) {
        UpcutPrice = upcutPrice;
    }

    public String getDowncutPrice() {
        return DowncutPrice;
    }

    public void setDowncutPrice(String downcutPrice) {
        DowncutPrice = downcutPrice;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
