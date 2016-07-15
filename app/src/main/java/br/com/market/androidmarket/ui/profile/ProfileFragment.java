package br.com.market.androidmarket.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.Sale;
import br.com.market.androidmarket.services.AndroidMarketRepository;
import br.com.market.androidmarket.services.Callback;
import br.com.market.androidmarket.services.responses.SaleResponse;
import br.com.market.androidmarket.ui.sales.SalesAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Douglas on 14/07/2016.
 */
public class ProfileFragment extends Fragment {

    @Bind(R.id.rv_sales)
    RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLinearLayoutManager;
    private SalesAdapter mSalesAdapter;
    private List<Sale> mListSales;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        loadSales();
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

}


