package com.nblagonravova.polyglotchat.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.nblagonravova.polyglotchat.fragments.UserListFragment;
import com.nblagonravova.polyglotchat.model.User;

public class UserListActivity extends BaseActivity implements UserListFragment.Callbacks{

    @Override
    protected Fragment createFragment() {
        return UserListFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, UserListActivity.class);
        return intent;
    }

    @Override
    public void onUserSelected(User user) {
        Intent intent = ChatActivity.newIntent(this);
        startActivity(intent);
    }
}
