package com.manish.tatvasoft.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class UserListViewModelFactory(private val userListRepository: UserListRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserListViewModel::class.java)){
            return UserListViewModel(this.userListRepository) as T
        }else {
            throw IllegalArgumentException("View model not found")
        }
    }

}