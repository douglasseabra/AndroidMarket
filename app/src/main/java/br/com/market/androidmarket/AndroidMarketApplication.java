package br.com.market.androidmarket;

import android.app.Application;

import br.com.market.androidmarket.models.UserAccount;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Douglas on 13/07/2016.
 */
public class AndroidMarketApplication extends Application {


    private static AndroidMarketApplication instance;

    private UserAccount userAccountSession;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSansRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public static AndroidMarketApplication getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Configure the application on AndroidManifest.xml");
        }
        return instance;
    }

    public void setUserAccountSession(UserAccount userAccount){
        userAccountSession = userAccount;
    }


    public UserAccount getUserAccountSession() {
        return userAccountSession;
    }
}


