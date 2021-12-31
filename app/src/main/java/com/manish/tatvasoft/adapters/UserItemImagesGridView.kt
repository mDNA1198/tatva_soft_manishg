package com.manish.tatvasoft.adapters

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginEnd
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manish.tatvasoft.databinding.SingleRowForUserItemImagesBinding

class UserItemImagesGridView constructor(val imageList: ArrayList<String>, val context: Context) : RecyclerView.Adapter<UserItemImagesGridView.UserItemsImagesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemImagesGridView.UserItemsImagesViewHolder {
        val binding: SingleRowForUserItemImagesBinding = SingleRowForUserItemImagesBinding.inflate(LayoutInflater.from(context), parent, false)
        return UserItemsImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserItemImagesGridView.UserItemsImagesViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int = imageList.size

    inner class UserItemsImagesViewHolder(val binding: SingleRowForUserItemImagesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(position: Int){
            var linearLayout = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            if(position == 0){
                linearLayout.marginEnd = 10
            }else if(position % 2 == 0) {
                linearLayout.marginEnd = 10
            }else{
                linearLayout.marginStart = 10
            }

            binding.evenImageView.layoutParams = linearLayout
            Glide.with(context).asBitmap().load(imageList[position]).into(binding.evenImageView)

        }

    }
}