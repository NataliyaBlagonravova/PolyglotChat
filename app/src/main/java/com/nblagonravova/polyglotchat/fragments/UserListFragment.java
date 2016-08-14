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
import com.nblagonravova.polyglotchat.adapters.UserListAdapter;
import com.nblagonravova.polyglotchat.model.User;

import java.util.Arrays;
import java.util.List;

public class UserListFragment extends Fragment {

    private static final String TAG = UserListFragment.class.getSimpleName();

    private RecyclerView mUserRecyclerView;

    public static UserListFragment newInstance(){
        return new UserListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_list_fragment, container, false);

        mUserRecyclerView = (RecyclerView) view.findViewById(R.id.user_list_fragment_recycler_view);
        mUserRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        User[] users = {
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться"),
                new User("Иван Иванов", "Готов общаться")
        };

        List<User> userList = Arrays.asList(users);
        mUserRecyclerView.setAdapter(new UserListAdapter(getActivity(), userList));
        return view;
    }
}
