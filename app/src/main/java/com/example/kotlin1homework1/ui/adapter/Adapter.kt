package com.example.kotlin1homework1.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1homework1.databinding.ListItemBinding
import com.example.kotlin1homework1.model.Model
import com.example.kotlin1homework1.ui.fragments.ItemClick

class Adapter :
    ListAdapter<Model, Adapter.ViewHolder>(DiffUtilCallBack) {

    lateinit var itemClick: ItemClick
    fun onClick(itemClick: ItemClick) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: Model) {
            binding.tvName.text = model.name
            itemView.setOnClickListener {
                itemClick.onClick(model)
            }
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.name === newItem.name
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem === newItem
        }
    }
}

