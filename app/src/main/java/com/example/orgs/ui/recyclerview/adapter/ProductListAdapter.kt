package com.example.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.ui.model.Product

class ProductListAdapter(
    products: List<Product>,
    private val contex: Context
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            val name = itemView.findViewById<TextView>(R.id.product_item_name)
            name.text = product.name
            val description = itemView.findViewById<TextView>(R.id.produtc_item_description)
            description.text = product.description
            val value = itemView.findViewById<TextView>(R.id.product_item_value)
            value.text = product.value.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contex)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view=view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun update(allProducts: List<Product>) {
        this.products.clear()
        this.products.addAll(allProducts)
        notifyDataSetChanged()
    }

}
