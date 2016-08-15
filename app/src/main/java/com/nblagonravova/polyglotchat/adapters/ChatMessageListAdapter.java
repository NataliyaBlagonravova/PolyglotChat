package com.nblagonravova.polyglotchat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nblagonravova.polyglotchat.R;
import com.nblagonravova.polyglotchat.model.ChatMassage;

import java.util.List;

public class ChatMessageListAdapter extends
        RecyclerView.Adapter<ChatMessageListAdapter.ChatMessageViewHolder>{

    private static final String TAG = ChatMessageListAdapter.class.getSimpleName();

    private Context mContext;
    private List<ChatMassage> mChatMassages;

    public ChatMessageListAdapter(Context context, List<ChatMassage> chatMassages) {
        mContext = context;
        mChatMassages = chatMassages;
    }

    @Override
    public ChatMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        int layoutResourceId = -1;

        switch (viewType) {
            case ChatMassage.TYPE_MY_MESSAGE:
                layoutResourceId = R.layout.chat_list_item_my;
                break;
            case ChatMassage.TYPE_FOREIGN_MESSAGE:
                layoutResourceId = R.layout.chat_list_item_foreign;
                break;
        }

        View view = inflater.inflate(layoutResourceId, parent, false);

        return new ChatMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatMessageViewHolder holder, int position) {
        ChatMassage massage = mChatMassages.get(position);
        holder.bindChatMessage(massage);
    }

    @Override
    public int getItemCount() {
        return mChatMassages.size();
    }

    @Override
    public int getItemViewType(int position) {
        ChatMassage message = mChatMassages.get(position);
        return message.getType();
    }

    public class ChatMessageViewHolder extends RecyclerView.ViewHolder{

        private TextView mSenderTextView;
        private TextView mMessageTextView;
        private ImageView mSenderPhoto;

        public ChatMessageViewHolder(View itemView) {
            super(itemView);

            mSenderTextView = (TextView) itemView.findViewById(R.id.chat_list_item_sender);
            mMessageTextView = (TextView) itemView.findViewById(R.id.chat_list_item_message);
            mSenderPhoto = (ImageView) itemView.findViewById(R.id.chat_list_item_photo);
        }

        public void bindChatMessage(ChatMassage message){
            mSenderTextView.setText(message.getSender());
            mMessageTextView.setText(message.getText());
        }
    }
}
