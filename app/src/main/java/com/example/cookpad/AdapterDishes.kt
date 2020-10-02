package com.example.cookpad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterDishes {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.particular_dishes,parent,false)
        return ViewHolder(view)
    }

    fun getItemCount(): Int {
        return 14
    }

    fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }



}