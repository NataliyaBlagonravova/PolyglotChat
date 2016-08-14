package com.nblagonravova.polyglotchat.model;


public class User {
    private String mFullName;
    private String mStatus;
    private String mPhotoUrl;
    private String mNationalityFlagUrl;

    public User(String fullName, String status) {
        mFullName = fullName;
        mStatus = status;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        mPhotoUrl = photoUrl;
    }

    public String getNationalityFlagUrl() {
        return mNationalityFlagUrl;
    }

    public void setNationalityFlagUrl(String nationalityFlagUrl) {
        mNationalityFlagUrl = nationalityFlagUrl;
    }
}
