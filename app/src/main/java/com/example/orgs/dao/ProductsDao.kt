package com.example.orgs.dao

import com.example.orgs.ui.model.Product

class ProductsDao {

    fun addProduct(product: Product) {
        productsList.add(product)
    }

    fun getAllProducts(): List<Product> {
        return productsList.toList()
    }

    companion object {
        private val productsList = mutableListOf<Product>()
    }

}