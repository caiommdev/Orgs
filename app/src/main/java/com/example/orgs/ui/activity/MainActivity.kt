package com.example.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.orgs.R
import com.example.orgs.ui.model.Product
import com.example.orgs.ui.recyclerview.adapter.ProductListAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ProductListAdapter(
            contex = this, products = listOf(
                Product(
                    name = "Teste Name1",
                    description = "teste description1",
                    value = BigDecimal("9.99")
                ),
                Product(
                    name = "Teste Name2",
                    description = "teste description2",
                    value = BigDecimal("19.99")
                ),
                Product(
                    name = "Teste Name3",
                    description = "teste description3",
                    value = BigDecimal("29.99")
                )
            )
        )

        //recyclerView.layoutManager = LinearLayoutManager(this)

    }
}