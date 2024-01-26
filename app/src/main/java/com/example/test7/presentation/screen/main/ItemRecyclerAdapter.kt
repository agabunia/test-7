package com.example.test7.presentation.screen.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test7.R
import com.example.test7.databinding.ItemLayoutBinding
import com.example.test7.presentation.screen.module.main.Item

class ItemRecyclerAdapter : ListAdapter<Item, ItemRecyclerAdapter.ItemViewHolder>(ItemDiffUtil()) {

    class ItemDiffUtil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return ItemViewHolder(ItemLayoutBinding.inflate(inflate, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    var onItemClick: ((Item) -> Unit)? = null

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            with(binding) {
                tvItemText.text = item.title
                binding.root.setOnClickListener {
                    if (item.isClicked) {
                        itemLayout.setBackgroundResource(R.drawable.item_shape_unclicked)
                    } else {
                        itemLayout.setBackgroundResource(R.drawable.item_shape_clicked)
                    }
                    item.isClicked = !item.isClicked
                }
            }
        }
    }
}