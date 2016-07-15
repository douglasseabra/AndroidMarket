package br.com.market.androidmarket.ui;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.market.androidmarket.AndroidMarketApplication;
import br.com.market.androidmarket.R;
import br.com.market.androidmarket.services.AndroidMarketRepository;
import br.com.market.androidmarket.services.Callback;
import br.com.market.androidmarket.services.responses.UserAccountResponse;
import br.com.market.androidmarket.ui.message.MessageFragment;
import br.com.market.androidmarket.ui.profile.ProfileFragment;
import br.com.market.androidmarket.ui.sales.SalesFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.nav_view)
    NavigationView navigationView;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        loadUserAccount();

        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    private void loadUserAccount(){

        AndroidMarketRepository.with().getUserAccount(new Callback<UserAccountResponse>() {
            @Override
            public void success(UserAccountResponse userResponse) {
                AndroidMarketApplication.getInstance().setUserAccountSession(userResponse.getUserAccount());


                View header = navigationView.getHeaderView(0);
                TextView txtName = (TextView) header.findViewById(R.id.userName);
                txtName.setText(userResponse.getUserAccount().getName());

                TextView txtEmail = (TextView) header.findViewById(R.id.userEmail);
                txtEmail.setText(userResponse.getUserAccount().getEmail());

                CircleImageView imgPhoto = (CircleImageView) header.findViewById(R.id.userPhoto);
                imgPhoto.setImageResource(userResponse.getUserAccount().getPhoto());

            }

            @Override
            public void failure() {
                //Implements error return
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            replaceFragment(MessageFragment.newInstance(), R.id.container_fragment, "message_fragment", false);
            changeTitleToolbar(R.string.fragment_message);
        } else if (id == R.id.nav_gallery) {
            replaceFragment(SalesFragment.newInstance(), R.id.container_fragment, "message_fragment", false);
            changeTitleToolbar(R.string.fragment_sales);
        } else if (id == R.id.nav_slideshow) {
            replaceFragment(ProfileFragment.newInstance(), R.id.container_fragment, "message_fragment", false);
            changeTitleToolbar(R.string.fragment_profile);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeTitleToolbar(int title){
        getSupportActionBar().setTitle(title);
    }
}
