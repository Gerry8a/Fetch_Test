package com.practicas.fetchtest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.practicas.fetchtest.R
import com.practicas.fetchtest.databinding.ItemLayoutBinding
import com.practicas.fetchtest.model.RandomObject

class ObjectAdapter(
    private val objectList: List<RandomObject>,
    private val onClickListener: (RandomObject) -> Unit
): RecyclerView.Adapter<ObjectAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectAdapter.ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObjectAdapter.ViewHolder, position: Int) {
        holder.bind(objectList[position], onClickListener)
    }

    override fun getItemCount(): Int = objectList.size

    class ViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(randomObject: RandomObject, onClickListener: (RandomObject) -> Unit){
            binding.tvId.text = randomObject.id.toString()
            binding.tvOrder.text = randomObject.listId.toString()
            binding.tvName.text = randomObject.name.toString()
        }
    }
}