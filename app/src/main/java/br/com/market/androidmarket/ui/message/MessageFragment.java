package br.com.market.androidmarket.ui.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.market.androidmarket.R;
import br.com.market.androidmarket.models.Contact;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Douglas on 13/07/2016.
 */
public class MessageFragment extends Fragment{

    @Bind(R.id.rv_grid_message)
    RecyclerView mRecyclerView;

    private GridLayoutManager mGridLayoutManager;
    private MessageAdapter mMessageAdapter;
    private List<Contact> mListContacts;


    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadMessages();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setHasFixedSize(true);

        mGridLayoutManager = new GridLayoutManager(getActivity(), 4);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mMessageAdapter = new MessageAdapter(getContext(), mListContacts);

        mRecyclerView.setAdapter(mMessageAdapter);
    }


    private void loadMessages() {
//        FireRepository.with().getContacts(new Callback<MessageResponse>() {
//            @Override
//            public void success(MessageResponse messageResponse) {
//                mListContacts = messageResponse.getListContacts();
//            }
//
//            @Override
//            public void failure() {
//                //Implements error return
//            }
//        });
    }
}
