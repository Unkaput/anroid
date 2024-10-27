package com.example.anroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Пример данных
        val shoeList = listOf(
            Shoe("Nike Jordan", "$493.00", R.drawable.nike_jordan),
            Shoe("Nike Air Max", "$897.99", R.drawable.nike_air_max),
            Shoe("Nike Air Jordan", "$849.69", R.drawable.nike_air_jordan)
        )

        // Создание адаптера
        val adapter = ShoeAdapter(shoeList)
        recyclerView.adapter = adapter
    }
}

data class Shoe(val name: String, val price: String, val imageRes: Int)

class ShoeAdapter(private val shoeList: List<Shoe>) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shoeImage = itemView.findViewById<ImageView>(R.id.shoeImage)
        val shoeName = itemView.findViewById<TextView>(R.id.shoeName)
        val shoePrice = itemView.findViewById<TextView>(R.id.shoePrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shoe_item, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.shoeImage.setImageResource(shoe.imageRes)
        holder.shoeName.text = shoe.name
        holder.shoePrice.text = shoe.price
    }

    override fun getItemCount(): Int = shoeList.size
}
