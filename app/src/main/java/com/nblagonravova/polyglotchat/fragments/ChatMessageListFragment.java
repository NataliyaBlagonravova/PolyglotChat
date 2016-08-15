package com.nblagonravova.polyglotchat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.nblagonravova.polyglotchat.R;
import com.nblagonravova.polyglotchat.adapters.ChatMessageListAdapter;
import com.nblagonravova.polyglotchat.model.ChatMassage;

import java.util.ArrayList;
import java.util.List;

public class ChatMessageListFragment extends Fragment{

    private final static String TAG = ChatMessageListFragment.class.getSimpleName();

    private RecyclerView mChatMessageRecyclerView;
    private Button mSendButton;
    private EditText mMessageInput;

    ChatMessageListAdapter mAdapter;

    List<ChatMassage> mMessageList = new ArrayList<>();

    public static ChatMessageListFragment newInstance(){
        return new ChatMessageListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_message_list_fragment, container, false);

        mChatMessageRecyclerView = (RecyclerView) view
                .findViewById(R.id.chat_message_list_fragment_recycler_view);
        mChatMessageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ChatMassage[] massages = {
                new ChatMassage("Екатерина Попова", "Привет. Как дела?",
                        ChatMassage.TYPE_MY_MESSAGE),
                new ChatMassage("Иван Иванов", "Привет. Все отлично! У тебя как?",
                        ChatMassage.TYPE_FOREIGN_MESSAGE),
        };

        for (ChatMassage massage: massages){
            mMessageList.add(massage);
        }

        mAdapter = new ChatMessageListAdapter(getActivity(), mMessageList);

        mChatMessageRecyclerView.setAdapter(mAdapter);

        mMessageInput = (EditText) view.findViewById(R.id.chat_message_list_fragment_input);
        mSendButton  = (Button) view.findViewById(R.id.chat_message_list_fragment_button_send);

        mMessageInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0){
                    mSendButton.setEnabled(true);
                }else {
                    mSendButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatMassage message = new ChatMassage("Екатерина Попова",
                        mMessageInput.getText().toString() ,
                        ChatMassage.TYPE_MY_MESSAGE);
                mMessageList.add(message);

                mAdapter.notifyItemInserted(mMessageList.size() - 1);
                mChatMessageRecyclerView.scrollToPosition(mMessageList.size() - 1);

                mMessageInput.setText("");
            }
        });

        return view;
    }
}
