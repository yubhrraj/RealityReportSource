package com.example.myapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("user_data")
    @Expose
    private UserData_ userData;
    @SerializedName("other_data")
    @Expose
    private OtherData otherData;

    public UserData_ getUserData() {
        return userData;
    }

    public void setUserData(UserData_ userData) {
        this.userData = userData;
    }

    public OtherData getOtherData() {
        return otherData;
    }

    public void setOtherData(OtherData otherData) {
        this.otherData = otherData;
    }

}