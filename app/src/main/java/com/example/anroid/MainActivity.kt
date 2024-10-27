package com.example.anroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

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


