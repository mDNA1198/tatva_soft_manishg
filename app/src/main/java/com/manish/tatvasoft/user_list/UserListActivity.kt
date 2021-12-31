package com.manish.tatvasoft.user_list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.manish.tatvasoft.adapters.UserListRecyclerView
import com.manish.tatvasoft.databinding.UserListActivityBinding
import com.manish.tatvasoft.retrofit_networking.RetrofitInstance

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: UserListActivityBinding

    private val userListService = RetrofitInstance.userListService
    private lateinit var userViewModel: UserListViewModel

    private lateinit var adapter: UserListRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initObservers()
        fetchData()
    }

    fun initUI(){

        userViewModel = ViewModelProvider(this, UserListViewModelFactory(UserListRepository(userListService)))[UserListViewModel::class.java]
        binding.mainRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = UserListRecyclerView(this)
        binding.mainRV.adapter = adapter

    }

    fun initObservers(){

        userViewModel.userListModel.observe(this,{
            Log.e("dataReceived", Gson().toJson(it))
            adapter.setUserDataList(it.data.users)
        })

    }

    fun fetchData(){
        userViewModel.getUserList()
    }


}