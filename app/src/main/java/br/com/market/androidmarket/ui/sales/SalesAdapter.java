package br.com.market.androidmarket.ui.sales;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.Sale;

/**
 * Created by Douglas on 14/07/2016.
 */
public class SalesAdapter extends RecyclerView.Adapter<SaleViewHolder> {

    private Context mContext;
    private List<Sale> mlistSales;

    public SalesAdapter(Context context, List<Sale> list) {
        mContext = context;
        mlistSales = list;
    }

    @Override
    public SaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sale, parent, false);
        return new SaleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SaleViewHolder holder, int position) {
        Sale sale = mlistSales.get(position);

        holder.description.setText(sale.getDescription());

        String info = String.format("id %s - %s", sale.getId(), sale.getDate());
        holder.info.setText(info);

        if (position % 2 == 0) {
            holder.container.setBackgroundResource(R.color.white_f4f4fe);
        } else {
            holder.container.setBackgroundResource(android.R.color.white);
        }

        if (sale.isAlert()) {
            holder.alert.setVisibility(View.VISIBLE);
        } else {
            holder.alert.setVisibility(View.GONE);
        }

        holder.value.setText(sale.getValue());
    }

    @Override
    public int getItemCount() {
        return mlistSales.size();
    }

}

