package br.com.market.androidmarket.ui.message;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.helpers.ColorHelper;
import br.com.market.androidmarket.models.User;

/**
 * Created by Douglas on 13/07/2016.
 */
public class MessageAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context mContext;
    private List<User> mlistContacts;

    public MessageAdapter(Context context, List<User> list) {
        mContext = context;
        mlistContacts = list;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User contact = mlistContacts.get(position);

        GradientDrawable bgShape = (GradientDrawable) holder.circleContact.getBackground();
        bgShape.setColor(mContext.getResources().getColor(android.R.color.white));

        if (contact.getPhoto() > 0) {
            holder.photo.setVisibility(View.VISIBLE);
            holder.letterContact.setVisibility(View.GONE);

            holder.photo.setImageResource(contact.getPhoto());
//            Picasso.with(mContext)
//                    .load(contact.getPhoto())
//                    .transform(new RoundedTransformation(80, 4))
//                    .resizeDimen(R.dimen.circle_image_size, R.dimen.circle_image_size)
//                    .centerCrop()
//                    .into(holder.photo);

        } else {
            holder.photo.setVisibility(View.GONE);
            holder.letterContact.setVisibility(View.VISIBLE);

            bgShape.setColor(mContext.getResources().getColor(ColorHelper.getRandomColor()));

            String firstLetter = contact.getName().substring(0, 1);
            holder.letterContact.setText(firstLetter);
        }

        holder.name.setText(contact.getName());
        holder.name.setGravity(Gravity.CENTER_HORIZONTAL);

        if (contact.isAlert()) {
            holder.alert.setVisibility(View.VISIBLE);
        } else {
            holder.alert.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mlistContacts.size();
    }
}
