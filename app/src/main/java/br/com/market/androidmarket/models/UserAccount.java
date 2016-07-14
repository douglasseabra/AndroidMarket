package br.com.market.androidmarket.models;

/**
 * Created by Douglas on 13/07/2016.
 */
public class UserAccount {

    private String name;
    private String email;
    private int photo;

    public UserAccount(String name, String email, int photo) {
        this.name = name;
        this.email = email;
        this.photo = photo;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
