package br.com.market.androidmarket.ui.message;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.market.androidmarket.R;

/**
 * Created by Douglas on 13/07/2016.
 */
public class ContactViewHolder extends  RecyclerView.ViewHolder {

    public RelativeLayout circleContact;
    public TextView letterContact;
    public ImageView photo;
    public ImageView alert;
    public TextView name;

    public ContactViewHolder(View itemView) {
        super(itemView);

//        circleContact = (RelativeLayout) itemView.findViewById(R.id.container_circle_contact);
//        letterContact = (TextView) itemView.findViewById(R.id.tv_letter_contact);
//        photo = (ImageView) itemView.findViewById(R.id.iv_photo_contact);
//        alert = (ImageView) itemView.findViewById(R.id.iv_alert);
//        name = (TextView) itemView.findViewById(R.id.tv_name_contact);
    }
}
