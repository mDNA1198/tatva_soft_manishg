package com.manish.tatvasoft.user_list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manish.tatvasoft.models.UserListModel
import com.manish.tatvasoft.models.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListViewModel constructor(private  val userListRepository: UserListRepository) : ViewModel(){

    private val TAG = UserListViewModel::class.java.name

    var userListModel = MutableLiveData<UserListModel>()
    var userList = MutableLiveData<ArrayList<Users>>()

    private var offset = 0

    fun getUserList(){

        userListRepository.getUserList(offset, 10).enqueue(object : Callback<UserListModel> {
            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
                userListModel.postValue(response.body())
                offset += 10
            }

            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                Log.e(TAG, "${t.message} ${t.localizedMessage}")
                t.printStackTrace()
            }
        })

    }


}