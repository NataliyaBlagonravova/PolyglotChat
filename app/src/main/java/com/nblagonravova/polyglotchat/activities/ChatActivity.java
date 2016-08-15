package com.nblagonravova.polyglotchat.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.nblagonravova.polyglotchat.fragments.ChatMessageListFragment;

public class ChatActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return ChatMessageListFragment.newInstance();
    }
}
