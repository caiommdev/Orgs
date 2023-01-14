package com.example.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.R
import com.example.orgs.dao.ProductsDao
import com.example.orgs.ui.model.Product
import java.math.BigDecimal

class ProductFormActivity :
    AppCompatActivity(R.layout.activity_product_form) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configSaveButton()
    }

    private fun configSaveButton () {
        val dao = ProductsDao()
        val saveButton = findViewById<Button>(R.id.product_form_button)
        saveButton.setOnClickListener {

            val product = createProduct()
            dao.addProduct(product)
            finish()
        }
    }

    private fun createProduct() : Product {
        val formName = findViewById<EditText>(R.id.product_form_name)
        val productName = formName.text.toString()

        val formDescriptor = findViewById<EditText>(R.id.product_form_description)
        val productDescriptor = formDescriptor.text.toString()

        val formValue = findViewById<EditText>(R.id.product_form_value)
        val valueInText = formValue.text.toString()
        val productValue = if (valueInText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valueInText)
        }

        return Product(name = productName, description = productDescriptor, value = productValue)
    }
}