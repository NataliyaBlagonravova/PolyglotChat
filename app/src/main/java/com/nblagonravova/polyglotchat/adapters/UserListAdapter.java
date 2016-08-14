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

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private static final String TAG = UserListAdapter.class.getSimpleName();

    Context mContext;
    List<User> mUserList;

    public UserListAdapter(Context context, List<User> userList) {
        mContext = context;
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

        TextView mFullNameTextView;
        TextView mStatusTextView;
        ImageView mPhotoImageView;
        ImageView mNationalityFlagImageView;

        public UserViewHolder(View itemView) {
            super(itemView);

            mFullNameTextView = (TextView) itemView.findViewById(R.id.user_list_item_full_name);
            mStatusTextView = (TextView) itemView.findViewById(R.id.user_list_item_status);
            mPhotoImageView = (ImageView) itemView.findViewById(R.id.user_list_item_photo);
            mNationalityFlagImageView = (ImageView) itemView
                    .findViewById(R.id.user_list_item_nationality_flag);
        }

        public void bindUser(User user){
            mFullNameTextView.setText(user.getFullName());
            mStatusTextView.setText(user.getStatus());
        }
    }
}
