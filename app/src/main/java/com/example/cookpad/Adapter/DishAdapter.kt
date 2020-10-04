package com.example.cookpad.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cookpad.Dishes
import com.example.cookpad.Model.User
import com.example.cookpad.Model.dishes.ChooseDish
import com.example.cookpad.Model.dishes.FinalRecipe
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
        holder.id.text = response.meals?.get(position)?.idMeal
        Picasso.get().load(response.meals!!.get(position).strMealThumb).into(holder.imageView)
        holder.bindView(position)
    }

    override fun getItemCount(): Int {
        return response.meals!!.size
    }

    inner class CountryHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView
        var id: TextView

        init {
            imageView = itemView.findViewById(R.id.image_dish)
            textView = itemView.findViewById(R.id.text_dish)
            id = itemView.findViewById(R.id.random)
        }

        fun bindView(position: Int) {
            itemView.setOnClickListener {
                val intent: Intent = Intent(itemView.context, FinalRecipe::class.java)
                    .putExtra("id",id.text.toString())
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                ContextCompat.startActivity(itemView.context, intent, Bundle())
            }
        }


    }
}
