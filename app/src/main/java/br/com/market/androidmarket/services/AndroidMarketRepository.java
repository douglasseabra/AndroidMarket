
package br.com.market.androidmarket.services;

import java.util.ArrayList;
import java.util.List;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.Sale;
import br.com.market.androidmarket.models.User;
import br.com.market.androidmarket.models.UserAccount;
import br.com.market.androidmarket.services.responses.MessageResponse;
import br.com.market.androidmarket.services.responses.SaleResponse;
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


    public void getContacts(Callback<MessageResponse> cb) {
        //Test
        final List<User> list = new ArrayList<>();
        list.add(new User("Douglas Seabra", R.drawable.profile, true));
        list.add(new User("Isabella Nunes", false));
        list.add(new User("Priscila Pedrosa", true));
        list.add(new User("Rúbia Pedrosa", false));
        list.add(new User("Ângela Maria", false));
        list.add(new User("Rene Seabra", true));
        list.add(new User("Fátima Silva", false));
        list.add(new User("Izauro Nunes", false));
        list.add(new User("Douglas Seabra", R.drawable.profile, true));
        list.add(new User("Isabella Nunes", false));
        list.add(new User("Priscila Pedrosa", true));
        list.add(new User("Rúbia Pedrosa", false));
        list.add(new User("Ângela Maria", false));
        list.add(new User("Rene Seabra", true));
        list.add(new User("Fátima Silva", false));
        list.add(new User("Izauro Nunes", false));
        list.add(new User("Douglas Seabra", R.drawable.profile, true));
        list.add(new User("Isabella Nunes", false));
        list.add(new User("Priscila Pedrosa", true));
        list.add(new User("Rúbia Pedrosa", false));
        list.add(new User("Ângela Maria", false));
        list.add(new User("Rene Seabra", true));
        list.add(new User("Fátima Silva", false));
        list.add(new User("Izauro Nunes", false));

        cb.success(new MessageResponse(){{
            setListContacts(list);
        }});

    }

    public void getSales(Callback<SaleResponse> cb){
        //Test
        final List<Sale> list = new ArrayList<>();

        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", true));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", true));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", true));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));
        list.add(new Sale("id 30294080", "Como decorar uma festa infantil maravilhosa", "11/01/2016", "R$1.035,00", false));

        cb.success(new SaleResponse(){{
            setListSales(list);
        }});

    }


}
