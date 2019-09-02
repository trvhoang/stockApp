package core;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.text.Text;


public class CodeHistory {

    public SimpleStringProperty Date = new SimpleStringProperty();
    public SimpleStringProperty Price = new SimpleStringProperty();
    public Text Change = new Text();

    public CodeHistory(String date, String price, Text change) {
        setDate(date);
        setPrice(price);
        setChange(change);
    }

    public String getDate() {
        return Date.get();
    }

    public SimpleStringProperty dateProperty() {
        return Date;
    }

    public void setDate(String date) {
        this.Date.set(date);
    }

    public String getPrice() {
        return Price.get();
    }

    public SimpleStringProperty priceProperty() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price.set(price);
    }

    public Text getChange() {
        return Change;
    }

    public void setChange(Text change) {
        Change = change;
    }
}
