package com.example.cookpad.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookpad.Adapter.CategoryAdapter.CountryHolder
import com.example.cookpad.Model.User
import com.example.cookpad.R
import com.squareup.picasso.Picasso

class CategoryAdapter(var context: Context, var response: User) : RecyclerView.Adapter<CountryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view =
            layoutInflater.inflate(R.layout.particular_category, parent, false)
        return CountryHolder(view)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.textView.text = response.categories?.get(position)?.strCategory
        Picasso.get().load(response.categories!!.get(position).strCategoryThumb).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return response.categories!!.size //14
    }

    inner class CountryHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textview)
        }
    }

}