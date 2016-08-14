package com.nblagonravova.polyglotchat.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.nblagonravova.polyglotchat.fragments.UserListFragment;

public class UserListActivity extends BaseActivity{

    @Override
    protected Fragment createFragment() {
        return UserListFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, UserListActivity.class);
        return intent;
    }
}
