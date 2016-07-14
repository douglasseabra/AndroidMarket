package br.com.market.androidmarket.models;

/**
 * Created by Douglas on 13/07/2016.
 */
public class Contact {

    private String name;
    private int photo;
    private boolean alert;

    public Contact(String name, int photo, boolean alert) {
        this.name = name;
        this.photo = photo;
        this.alert = alert;
    }

    public Contact(String name, boolean alert) {
        this.name = name;
        this.alert = alert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}

