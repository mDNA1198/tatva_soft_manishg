package com.manish.tatvasoft.user_list

import com.manish.tatvasoft.models.UserListModel
import com.manish.tatvasoft.utils.AppConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserListService {

    @GET(AppConstants.GET_USERS)
    fun getUserList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ) : Call<UserListModel>

}