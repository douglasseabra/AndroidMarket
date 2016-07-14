package br.com.market.androidmarket.services.responses;

import br.com.market.androidmarket.models.UserAccount;

/**
 * Created by Douglas on 13/07/2016.
 */
public class UserAccountResponse {

    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
