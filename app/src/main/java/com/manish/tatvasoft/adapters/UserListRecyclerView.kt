package com.manish.tatvasoft.adapters

import android.content.Context
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
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserListRecyclerView.UserListViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int = userDataList.size

    inner class UserListViewHolder(val binding: SingleRowForUserDataBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(position: Int){

            Glide.with(context).asBitmap().load(userDataList[position].image).into(binding.userDPIV)
            binding.userName.text = userDataList[position].name


            if(userDataList[position].items.size > 0 && userDataList[position].items.size == 1){

            }else{

            }

            if(userDataList[position].items.size / 2 == 0){
                binding.oddImageView.visibility = View.GONE
            }else{
                binding.oddImageView.visibility = View.VISIBLE
                Glide.with(context).asBitmap().load(userDataList[position].items[0]).into(binding.userDPIV)
            }

            //binding.evenImagesRV.layoutManager = GridLayoutManager(context, GridLayoutManager.HORIZONTAL, 2, false)

            //val gridAdapter: UserItemImagesGridView = UserItemImagesGridView(, context)

        }

    }

}