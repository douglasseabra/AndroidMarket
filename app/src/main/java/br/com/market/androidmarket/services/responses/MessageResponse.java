package br.com.market.androidmarket.services.responses;

import java.util.List;

import br.com.market.androidmarket.models.User;
import br.com.market.androidmarket.models.UserAccount;

/**
 * Created by Douglas on 13/07/2016.
 */
public class MessageResponse {

    private List<User> listContacts;

    public List<User> getListContacts() {
        return listContacts;
    }

    public void setListContacts(List<User> listContacts) {
        this.listContacts = listContacts;
    }
}
