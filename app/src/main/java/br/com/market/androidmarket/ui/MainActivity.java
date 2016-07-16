package br.com.market.androidmarket.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import br.com.market.androidmarket.AndroidMarketApplication;
import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.UserAccount;
import br.com.market.androidmarket.services.AndroidMarketRepository;
import br.com.market.androidmarket.services.Callback;
import br.com.market.androidmarket.services.responses.UserAccountResponse;
import br.com.market.androidmarket.ui.message.MessageFragment;
import br.com.market.androidmarket.ui.profile.ProfileFragment;
import br.com.market.androidmarket.ui.sales.SalesFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

//    @Bind(R.id.nav_view)
//    NavigationView navigationView;

//    @Bind(R.id.drawer_layout)
//    DrawerLayout drawer;
    private TextView badge;
    private AccountHeader accountHeader;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

         badge = (TextView) toolbar.findViewById(R.id.tv_badge);

        loadUserAccount();

        initDrawer();

        navigate(1);
    }

    private void initDrawer() {

        UserAccount account = AndroidMarketApplication.getInstance().getUserAccountSession();

        IProfile profile = new ProfileDrawerItem()
                .withName(account.getName())
                .withEmail(account.getEmail())
                .withIcon(getResources().getDrawable(account.getPhoto()));

        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.profile_header)
                .withSelectionListEnabledForSingleProfile(false)
                .addProfiles(
                        profile
                )
                .build();

        TextView tvAccountName = (TextView) accountHeader.getView().findViewById(R.id.material_drawer_account_header_name);


        TextView tvAccountEmail = (TextView) accountHeader.getView().findViewById(R.id.material_drawer_account_header_email);
        if (Build.VERSION.SDK_INT < 23) {
            tvAccountEmail.setTextAppearance(this, R.style.ThemeDrawerHeader_Account_Email);
            tvAccountName.setTextAppearance(this, R.style.ThemeDrawerHeader_Account_Name);
        } else {
            tvAccountEmail.setTextAppearance(R.style.ThemeDrawerHeader_Account_Email);
            tvAccountName.setTextAppearance(R.style.ThemeDrawerHeader_Account_Name);
        }

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withDisplayBelowStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withHasStableIds(true)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        navigate(position);
                        return false;
                    }
                })
                .build();


        BadgeStyle badgeStyle = new BadgeStyle().withBadgeBackground(getResources().getDrawable(R.drawable.bg_badge)).withTextColor(Color.WHITE).withColorRes(R.color.orage_e7ad45);

        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_sales).withIcon(getResources().getDrawable(R.drawable.ico_minhas_vendas)));
        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_products).withIcon(getResources().getDrawable(R.drawable.ico_meus_produtos)));
        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_menbers).withIcon(getResources().getDrawable(R.drawable.ico_afiliados)).withIdentifier(1).withBadgeStyle(badgeStyle));
        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_messages).withIcon(getResources().getDrawable(R.drawable.ico_mensagens)).withIdentifier(2).withBadgeStyle(badgeStyle));
        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_notifications).withIcon(getResources().getDrawable(R.drawable.ico_notificacoes)).withIdentifier(3).withBadgeStyle(badgeStyle));
        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_account).withIcon(getResources().getDrawable(R.drawable.ico_minha_conta)));
        drawer.addItem(new PrimaryDrawerItem().withName(R.string.menu_about).withIcon(getResources().getDrawable(R.drawable.ico_sobre_o_app)));

        drawer.updateBadge(1, new StringHolder("121"));
        drawer.updateBadge(2, new StringHolder("+50"));
        drawer.updateBadge(3, new StringHolder("15"));

    }

    private void loadUserAccount() {

        AndroidMarketRepository.with().getUserAccount(new Callback<UserAccountResponse>() {
            @Override
            public void success(UserAccountResponse userResponse) {
                AndroidMarketApplication.getInstance().setUserAccountSession(userResponse.getUserAccount());
            }

            @Override
            public void failure() {
                //Implements error return
            }
        });
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen()){
            drawer.closeDrawer();
        }else {
            super.onBackPressed();
        }
    }



    private void navigate(int position) {
        setBadgeToolbar("");
        switch (position) {
            case 1:
                replaceFragment(SalesFragment.newInstance(), R.id.container_fragment, "my_sales_frag", false);
                changeTitleToolbar(R.string.fragment_sales);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                replaceFragment(MessageFragment.newInstance(), R.id.container_fragment, "message_frag", true);
                changeTitleToolbar(R.string.fragment_message);
                setBadgeToolbar("+15");
                break;
            case 5:
                break;
            case 6:
                replaceFragment(ProfileFragment.newInstance(), R.id.container_fragment, "my_profile_frag", true);
                changeTitleToolbar(R.string.fragment_profile);
                break;
            case 7:
                break;
        }
    }

    private void changeTitleToolbar(int title) {
        getSupportActionBar().setTitle(title);
    }

    private void setBadgeToolbar(String value) {
        if(!TextUtils.isEmpty(value)) {
            badge.setVisibility(View.VISIBLE);
            badge.setText(value);
    }else {
            badge.setVisibility(View.GONE);
        }


    }

}
