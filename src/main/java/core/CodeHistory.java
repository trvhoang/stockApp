package core;

import javafx.beans.property.SimpleStringProperty;


public class CodeHistory {
    public SimpleStringProperty Date = new SimpleStringProperty();
    public SimpleStringProperty Price = new SimpleStringProperty();

    public CodeHistory(String date, String price){
        setDate(date);
        setPrice(price);
    }

    private CodeHistory(){ this("","");}

    private String getDate(){return Date.get();}

    private void setDate(String date){Date.set(date);}

    private String getPrice(){return Price.get();}

    private void setPrice(String price) {Price.set(price);}



}
