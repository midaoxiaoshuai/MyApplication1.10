package com.example.myapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ExoAdapter(val exoList: List<Exo>) :
    RecyclerView.Adapter<ExoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val memberImage: ImageView = view.findViewById(R.id.memberImage)
        val memberName: TextView = view.findViewById(R.id.memberName)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.exo_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = exoList[position]
            Toast.makeText(parent.context, "you clicked view${fruit.name}",
            Toast.LENGTH_SHORT).show()
        }
        viewHolder.memberImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = exoList[position]
            Toast.makeText(parent.context, "you clicked image${fruit.name}",
            Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = exoList[position]
        holder.memberImage.setImageResource(fruit.imageId)
        holder.memberName.text = fruit.name
    }
    override fun getItemCount() = exoList.size
}