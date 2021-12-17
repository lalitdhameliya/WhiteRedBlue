package com.application.whiteredblue.task2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.whiteredblue.R
import com.application.whiteredblue.task2.model.Data
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(private val list: List<Data>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() = with(itemView) {
            Glide
                .with(context)
                .load(list[adapterPosition].avatar)
                .centerCrop()
                .circleCrop()
                .into(itemUserImage)

            itemTvUserName.text =
                list[adapterPosition].firstName + " " + list[adapterPosition].lastName
            itemTvUserEmail.text = list[adapterPosition].email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = list.size
}