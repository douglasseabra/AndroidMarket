package br.com.market.androidmarket.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Douglas on 13/07/2016.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public void replaceFragment(Fragment fragment, int containerViewId, String label, boolean toBack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);

        if (toBack) {
            transaction.addToBackStack(label);
        }

        transaction.replace(containerViewId, fragment, label).commitAllowingStateLoss();
    }
}
