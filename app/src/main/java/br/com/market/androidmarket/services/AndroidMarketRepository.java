package br.com.market.androidmarket.services;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.UserAccount;
import br.com.market.androidmarket.services.responses.UserAccountResponse;

/**
 * Created by Douglas on 13/07/2016.
 */
public class AndroidMarketRepository {

    private static AndroidMarketRepository singleton;


    private AndroidMarketRepository() {

    }


    public static AndroidMarketRepository with() {
        if (singleton == null) {
            synchronized (AndroidMarketRepository.class) {
                if (singleton == null) {
                    singleton = new AndroidMarketRepository();
                }
            }
        }
        return singleton;
    }
    public void getUserAccount(Callback<UserAccountResponse> cb) {
        //Test
        cb.success(new UserAccountResponse(){{
            setUserAccount( new UserAccount("Douglas Seabra", "douglasseabra@gmail.com", R.drawable.profile));
        }});
    }


}
