package br.com.market.androidmarket.models;

/**
 * Created by Douglas on 14/07/2016.
 */
public class Sale {
    private String id;
    private String description;
    private String date;
    private String value;
    private boolean alert;

    public Sale(String id, String description, String date, String value, boolean alert) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.value = value;
        this.alert = alert;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}
