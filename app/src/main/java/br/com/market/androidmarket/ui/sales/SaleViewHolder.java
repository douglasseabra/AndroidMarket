package br.com.market.androidmarket.ui.sales;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.market.androidmarket.R;

/**
 * Created by Douglas on 14/07/2016.
 */
public class SaleViewHolder  extends RecyclerView.ViewHolder {

    public RelativeLayout container;
    public TextView description;
    public TextView info;
    public ImageView alert;
    public TextView value;

    public SaleViewHolder(View itemView) {
        super(itemView);

        container = (RelativeLayout) itemView.findViewById(R.id.container_sales);
        description = (TextView) itemView.findViewById(R.id.tv_sale_description);
        info = (TextView) itemView.findViewById(R.id.tv_sale_info);
        alert = (ImageView) itemView.findViewById(R.id.iv_sale_alert);
        value = (TextView) itemView.findViewById(R.id.tv_sale_value);
    }

}
