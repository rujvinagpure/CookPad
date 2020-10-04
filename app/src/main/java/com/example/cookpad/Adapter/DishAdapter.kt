package com.example.cookpad.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookpad.Model.User
import com.example.cookpad.Model.dishes.ChooseDish
import com.example.cookpad.R
import com.squareup.picasso.Picasso


class DishAdapter(var context: Context, var response: ChooseDish) : RecyclerView.Adapter<DishAdapter.CountryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view =
                layoutInflater.inflate(R.layout.particular_dishes, parent, false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: DishAdapter.CountryHolder, position: Int) {
        holder.textView.text = response.meals?.get(position)?.strMeal
        Picasso.get().load(response.meals!!.get(position).strMealThumb).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return response.meals!!.size
    }

    inner class CountryHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView

        init {
            imageView = itemView.findViewById(R.id.image_dish)
            textView = itemView.findViewById(R.id.text_dish)
        }
    }



}