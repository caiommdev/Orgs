package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.orgs.R
import com.example.orgs.ui.model.Product
import java.math.BigDecimal

class ProductFormActivity :
    AppCompatActivity(R.layout.activity_product_form) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saveButton = findViewById<Button>(R.id.formButton)
        saveButton.setOnClickListener {
            val formName = findViewById<EditText>(R.id.formName)
            val productName = formName.text.toString()

            val formDescriptor = findViewById<EditText>(R.id.formDescription)
            val productDescriptor = formDescriptor.text.toString()

            val formValue = findViewById<EditText>(R.id.formValue)
            val valueInText = formValue.text.toString()
            val productValue = if (valueInText.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valueInText)
            }


            val product =
                Product(name = productName, description = productDescriptor, value = productValue)

            Log.i("ProductFormActivity", "onCreate: $product")
        }
    }
}