package com.nblagonravova.polyglotchat.model;

public class ChatMassage {

    public static final int TYPE_MY_MESSAGE = 0;
    public static final int TYPE_FOREIGN_MESSAGE = 1;

    private String mSender;
    private String mText;
//  private Date mDate;
    private int mType;

    public ChatMassage(String sender, String text, int type) {
        mSender = sender;
        mText = text;
        mType = type;
    }

    public String getSender() {
        return mSender;
    }

    public void setSender(String sender) {
        mSender = sender;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

//  public Date getDate() {
//      return mDate;
//    }
//
//  public void setDate(Date date) {
//      mDate = date;
//  }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }
}
