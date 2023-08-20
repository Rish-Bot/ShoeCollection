package com.example.shoecollection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

private const val nikeShoe = "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/53bdca6c-d7ad-478e-8509-a1d81465471e/elevate-3-basketball-shoes-QT43Gj.png"

class ShoeCollectionAdapter(val context: Context, val shoeCollection: List<Shoe>) : RecyclerView.Adapter<ShoeCollectionAdapter.viewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.shoe_collection,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int = shoeCollection.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val s = shoeCollection[position]
        holder.bind(s)
    }


    inner class viewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        val shoeName = itemView.findViewById<TextView>(R.id.shoeNameId)
        val shoePrice = itemView.findViewById<TextView>(R.id.shoePriceId)
        val shoeImg = itemView.findViewById<ImageView>(R.id.shoeImageId)


       fun bind(s:Shoe){
           shoeName.text = s.shoeName
           shoePrice.text = "$ ${s.shoePrice}"
           Picasso.get().load(nikeShoe).into(shoeImg)


       }


    }
}
