
package com.example.bookinghotelonline.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AuthClass {

    @SerializedName("data")
    @Expose
    private AuthData data;

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData data) {
        this.data = data;
    }

}
