package com.manish.tatvasoft.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manish.tatvasoft.databinding.SingleRowForUserDataBinding
import com.manish.tatvasoft.models.Users

class UserListRecyclerView constructor(val context: Context) : RecyclerView.Adapter<UserListRecyclerView.UserListViewHolder>(){

    private var userDataList: ArrayList<Users> = arrayListOf()

    fun setUserDataList(list: ArrayList<Users>){
        userDataList.addAll(list)
        notifyItemRangeInserted((userDataList.size + 1), list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListRecyclerView.UserListViewHolder {
        val binding: SingleRowForUserDataBinding = SingleRowForUserDataBinding.inflate(LayoutInflater.from(context), parent, false)
        return UserListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListRecyclerView.UserListViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int = userDataList.size

    inner class UserListViewHolder(val binding: SingleRowForUserDataBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(position: Int){

            Glide.with(context).asBitmap().load(userDataList[position].image).into(binding.userDPIV)
            binding.userName.text = userDataList[position].name


            if(userDataList[position].items.size > 0){
                if(userDataList[position].items.size == 1){
                    binding.evenImagesRV.visibility = View.GONE
                    binding.oddImageView.visibility = View.VISIBLE
                    Glide.with(context).asBitmap().load(userDataList[position].items[0]).into(binding.userDPIV)
                }else if(userDataList[position].items.size % 2 == 0){
                    binding.evenImagesRV.visibility = View.VISIBLE
                    binding.oddImageView.visibility = View.GONE

                    binding.evenImagesRV.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                    val gridAdapter = UserItemImagesGridView(userDataList[position].items, context)
                    binding.evenImagesRV.adapter = gridAdapter
                }else{
                    binding.evenImagesRV.visibility = View.VISIBLE
                    binding.oddImageView.visibility = View.VISIBLE
                    Glide.with(context).asBitmap().load(userDataList[position].items[0]).into(binding.oddImageView)
                    userDataList[position].items.removeAt(0)
                    binding.evenImagesRV.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                    val gridAdapter = UserItemImagesGridView(userDataList[position].items, context)
                    binding.evenImagesRV.adapter = gridAdapter
                }
            }

        }

    }

}