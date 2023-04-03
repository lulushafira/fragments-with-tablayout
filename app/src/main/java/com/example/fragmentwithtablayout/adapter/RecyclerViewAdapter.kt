package com.example.fragmentwithtablayout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentwithtablayout.databinding.ListItemBinding
import com.example.fragmentwithtablayout.model.News

class RecyclerViewAdapter(private val newsList: ArrayList<News>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        val image = binding.titleImage
        val heading = binding.tvHeading

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = newsList[position]

        holder.image.setImageResource(list.titleImage)
        holder.heading.text = list.heading
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}