package com.nblagonravova.polyglotchat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nblagonravova.polyglotchat.R;
import com.nblagonravova.polyglotchat.adapters.ChatMessageListAdapter;
import com.nblagonravova.polyglotchat.model.ChatMassage;

import java.util.Arrays;
import java.util.List;

public class ChatMessageListFragment extends Fragment{

    private final static String TAG = ChatMessageListFragment.class.getSimpleName();

    private RecyclerView mChatMessageRecyclerView;

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
                new ChatMassage("Екатерина Попова", "Привет. Как дела?",
                        ChatMassage.TYPE_MY_MESSAGE),
                new ChatMassage("Иван Иванов", "Привет. Все отлично! У тебя как?",
                        ChatMassage.TYPE_FOREIGN_MESSAGE),
                new ChatMassage("Екатерина Попова", "Привет. Как дела?",
                        ChatMassage.TYPE_MY_MESSAGE),
                new ChatMassage("Иван Иванов", "Привет. Все отлично! У тебя как?",
                        ChatMassage.TYPE_FOREIGN_MESSAGE),
                new ChatMassage("Екатерина Попова", "Привет. Как дела?",
                        ChatMassage.TYPE_MY_MESSAGE),
                new ChatMassage("Иван Иванов", "Привет. Все отлично! У тебя как?",
                        ChatMassage.TYPE_FOREIGN_MESSAGE)
        };

        List<ChatMassage> massageList = Arrays.asList(massages);

        mChatMessageRecyclerView.setAdapter(new ChatMessageListAdapter(getActivity(), massageList));
        return view;
    }
}
