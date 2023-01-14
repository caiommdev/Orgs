package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.ui.recyclerview.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListProductsActivity : AppCompatActivity(R.layout.activity_list_products) {

        private val dao = ProductsDao()

        private val adapter = ProductListAdapter(
            contex = this, products = dao.getAllProducts()
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAllProducts())
    }

    private fun configRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.list_products_recycler_view)
        recyclerView.adapter = adapter
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.list_products_floating_action_button)
        fab.setOnClickListener {
            setOnProductsForm()
        }
    }

    private fun setOnProductsForm() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

}