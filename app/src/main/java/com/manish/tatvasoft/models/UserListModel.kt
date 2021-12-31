package com.manish.tatvasoft.models

import com.google.gson.annotations.SerializedName

data class UserListModel(
    @SerializedName("status"  ) var status  : Boolean,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("data"    ) var data    : Data
)

data class Data(
    @SerializedName("users"    ) var users   : ArrayList<Users> = arrayListOf(),
    @SerializedName("has_more" ) var hasMore : Boolean
)

data class Users(
    @SerializedName("name"  ) var name  : String,
    @SerializedName("image" ) var image : String,
    @SerializedName("items" ) var items : ArrayList<String> = arrayListOf()

)