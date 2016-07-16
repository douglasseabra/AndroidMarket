package br.com.market.androidmarket.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.Sale;
import br.com.market.androidmarket.models.User;
import br.com.market.androidmarket.services.AndroidMarketRepository;
import br.com.market.androidmarket.services.Callback;
import br.com.market.androidmarket.services.responses.MessageResponse;
import br.com.market.androidmarket.services.responses.SaleResponse;
import br.com.market.androidmarket.ui.message.MessageAdapter;
import br.com.market.androidmarket.ui.sales.SalesAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Douglas on 14/07/2016.
 */
public class ProfileFragment extends Fragment {

    @Bind(R.id.rv_sales)
    RecyclerView mRecyclerView;

    @Bind(R.id.rv_grid_message)
    RecyclerView messageRecyclerView;

    @Bind(R.id.tv_badge)
    TextView tvMessageBadge;

    private RecyclerView.LayoutManager mLinearLayoutManager;
    private SalesAdapter mSalesAdapter;

    private MessageAdapter mMessageAdapter;
    private List<Sale> mListSales;
    private List<User> mListContacts;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadSales();
        loadMessages();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);;
        ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setFocusable(false);

        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mSalesAdapter = new SalesAdapter(getContext(), mListSales);

        mRecyclerView.setAdapter(mSalesAdapter);

        LinearLayoutManager messageLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        messageRecyclerView.setLayoutManager(messageLayoutManager);
        mMessageAdapter = new MessageAdapter(getContext(), mListContacts);
        messageRecyclerView.setAdapter(mMessageAdapter);

        int messageCount = mListContacts.size();

        if(messageCount>4){
            tvMessageBadge.setText("+" + (messageCount -4));
        }else{
            tvMessageBadge.setVisibility(View.INVISIBLE);
        }

    }

    private void loadSales(){
        AndroidMarketRepository.with().getSales(new Callback<SaleResponse>() {
            @Override
            public void success(SaleResponse saleResponse) {
                mListSales = saleResponse.getListSales();
            }

            @Override
            public void failure() {
                //Implements error return
            }
        });
    }

    private void loadMessages() {
        AndroidMarketRepository.with().getContacts(new Callback<MessageResponse>() {
            @Override
            public void success(MessageResponse messageResponse) {
                mListContacts = messageResponse.getListContacts();

            }

            @Override
            public void failure() {
                //Implements error return
            }
        });
    }

}


