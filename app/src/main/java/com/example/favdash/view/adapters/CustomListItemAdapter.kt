package com.example.favdash.view.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.favdash.databinding.ItemCustomListBinding

class CustomListItemAdapter (private val activity: Activity,
                             private val listItems: List<String>,
                             private val selection: String): RecyclerView.Adapter<CustomListItemAdapter.ViewHolder>(){

     //I create first this class, only after I implement the funs RecyclerView.Adapter ask
     class ViewHolder(view: ItemCustomListBinding): RecyclerView.ViewHolder(view.root) {
         val tvText = view.tvText
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //Using view binding
        val binding: ItemCustomListBinding = ItemCustomListBinding.inflate(
           LayoutInflater.from(activity),
           parent,
           false
       )
       return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvText.text = item
    }

    override fun getItemCount() = listItems.size
}