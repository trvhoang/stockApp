package core;

import javafx.beans.property.SimpleStringProperty;


public class CodeHistory {

    public SimpleStringProperty Date = new SimpleStringProperty();
    public SimpleStringProperty Price = new SimpleStringProperty();

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

    public CodeHistory(String Date, String Price){
        setDate(Date);
        setPrice(Price);
    }

}
