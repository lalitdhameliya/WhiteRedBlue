package com.application.whiteredblue.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.whiteredblue.R
import kotlinx.android.synthetic.main.item_red_blue.view.*

class RedBlueAdapter(private val list: List<RedBlueModel>) :
    RecyclerView.Adapter<RedBlueAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() = with(itemView) {
            val redBlueModel = list[adapterPosition]
            when (redBlueModel.currentMode) {
                0 -> itemRedBlueView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.white
                    )
                )
                1 -> itemRedBlueView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.red
                    )
                )
                2 -> itemRedBlueView.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.blue
                    )
                )
            }

            itemRedBlueView.setOnClickListener {
                if (redBlueModel.currentMode == 1) {
                    list[adapterPosition].currentMode = 2
                    val remList = list.filter { it.currentMode == 0 }
                    remList.random().currentMode = 1
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_red_blue, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = list.size
}