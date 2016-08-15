package com.nblagonravova.polyglotchat.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nblagonravova.polyglotchat.R;
import com.nblagonravova.polyglotchat.model.User;

import java.util.List;

import static com.nblagonravova.polyglotchat.fragments.UserListFragment.Callbacks;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private static final String TAG = UserListAdapter.class.getSimpleName();

    private Context mContext;
    Callbacks mCallbacks;
    private List<User> mUserList;

    public UserListAdapter(Context context, Callbacks callbacks, List<User> userList) {
        mContext = context;
        mCallbacks = callbacks;
        mUserList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mUserList.get(position);
        holder.bindUser(user);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private User mUser;

        private TextView mFullNameTextView;
        private TextView mStatusTextView;
        private ImageView mPhotoImageView;
        private ImageView mNationalityFlagImageView;

        public UserViewHolder(View itemView) {
            super(itemView);

            mFullNameTextView = (TextView) itemView.findViewById(R.id.user_list_item_full_name);
            mStatusTextView = (TextView) itemView.findViewById(R.id.user_list_item_status);
            mPhotoImageView = (ImageView) itemView.findViewById(R.id.user_list_item_photo);
            mNationalityFlagImageView = (ImageView) itemView
                    .findViewById(R.id.chat_list_item_photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallbacks.onUserSelected(mUser);
                }
            });
        }

        public void bindUser(User user){
            mUser = user;

            mFullNameTextView.setText(user.getFullName());
            mStatusTextView.setText(user.getStatus());
        }
    }


}
