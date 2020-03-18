package com.example.inventorytracker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        goToAddProduct.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

//        Not needed at this time

//        val preferences = getSharedPreferences( "database", Context.MODE_PRIVATE )
//        val savedName = preferences.getString("savedProductName", "This value doesn't exist")
//        d("daniel", "saved message is: $savedName")
//
//        lastSavedProduct.text = savedName

//        lifecycleScope.launch(Dispatchers.Default) {
//            val message =
//                URL("https://finepointmobile.com/api/inventory/v1/message").readText()
//            d("will", "the message is: $message")
//            lastSavedProduct.text = message
//        }

//        val textView = findViewById<TextView>(R.id.text)

    // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://www.google.com"

    // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                d("will", "the message is:${response}")
//                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { d("will", "That didn't work!") })

    // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}
