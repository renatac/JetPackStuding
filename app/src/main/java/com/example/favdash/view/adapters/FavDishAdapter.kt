package com.example.favdash.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.favdash.databinding.ItemDishLayoutBinding
import com.example.favdash.model.entities.FavDish

class FavDishAdapter(private val fragment: Fragment): RecyclerView.Adapter<FavDishAdapter.ViewHolder>() {

    private var dishes: List<FavDish> = listOf()

    //1
    class ViewHolder(view: ItemDishLayoutBinding): RecyclerView.ViewHolder(view.root) {
        //Holds the image and the TextView that will add each item to
        val ivDishImage = view.ivDishImage
        val tvTitle =  view.tvDishTitle
    }

    //4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDishLayoutBinding = ItemDishLayoutBinding.inflate(
            LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    //3
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        Glide.with(fragment)
            .load(dish.image)
            .into(holder.ivDishImage)
        //This holder take the element of ViewHolder class
        holder.tvTitle.text = dish.title
    }

    //2
    override fun getItemCount(): Int {
        return dishes.size
    }

    //Using this function to fill the dishes list
    fun setDishesList(list: List<FavDish>) {
        dishes = list
        notifyDataSetChanged()
    }
}