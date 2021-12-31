package com.manish.tatvasoft.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manish.tatvasoft.databinding.SingleRowForUserItemImagesBinding

class UserItemImagesGridView constructor(val imageList: ArrayList<String>, val context: Context) : RecyclerView.Adapter<UserItemImagesGridView.UserItemsImagesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemImagesGridView.UserItemsImagesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserItemImagesGridView.UserItemsImagesViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int = imageList.size

    inner class UserItemsImagesViewHolder(val binding: SingleRowForUserItemImagesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(position: Int){
            Glide.with(context).asBitmap().load(imageList[position]).into(binding.evenImageView)
        }

    }
}