package br.com.market.androidmarket.ui.message;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import br.com.market.androidmarket.models.Contact;

/**
 * Created by Douglas on 13/07/2016.
 */
public class MessageAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context mContext;
    private List<Contact> mlistContacts;

    public MessageAdapter(Context context, List<Contact> list) {
        mContext = context;
        mlistContacts = list;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
