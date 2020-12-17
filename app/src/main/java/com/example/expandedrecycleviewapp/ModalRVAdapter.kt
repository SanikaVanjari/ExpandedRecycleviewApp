package com.example.expandedrecycleviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModalRVAdapter(private val arrayList: ArrayList<Modal>) :
    RecyclerView.Adapter<ModalRVAdapter.ModalViewHolder>() {

    private var expandedPosition = 0

    class ModalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textView)
        val description: TextView = itemView.findViewById(R.id.textView2)
        val arrow: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModalViewHolder {
        return ModalViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ModalViewHolder, position: Int) {
        val currentModal: Modal = arrayList[position]
        currentModal.apply {
            holder.title.text = title
            holder.description.text = description
        }
        val isExpanded = position == expandedPosition
        if (isExpanded) {
            holder.arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            holder.description.maxLines = Int.MAX_VALUE
        } else {
            holder.arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            holder.description.maxLines = 1
        }
        holder.itemView.isActivated = isExpanded
        holder.itemView.setOnClickListener {
            expandedPosition = if (isExpanded) -1 else position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int = arrayList.size
}