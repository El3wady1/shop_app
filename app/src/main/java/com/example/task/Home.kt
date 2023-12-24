package com.example.task
import Product
import ProductAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

//nav_drawer
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class Home : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId", "ResourceType")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //nav_drawer
        drawerLayout = findViewById(R.id.my_drawer_layout)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.id.elawady, R.id.mm)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
//        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        recyclerView = findViewById(R.id.recycleid)
        recyclerView.layoutManager = LinearLayoutManager(this)
//GlobalScope: This is the scope in which the coroutine
        GlobalScope.launch(Dispatchers.Main) {
            val products = fetchData()
            recyclerView.adapter = ProductAdapter(products)
        }
    }

    // if i press or swip get items in menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else
            super.onOptionsItemSelected(item)
    }

    private suspend fun fetchData(): List<Product> = withContext(Dispatchers.IO) {
        val url = URL("https://fakestoreapi.com/products")
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String ?

        do {
            line = reader.readLine()
            if (line != null) {
                stringBuilder.append(line)
            }
        } while (line != null)

        reader.close()
        connection.disconnect()

        val json = stringBuilder.toString()
        val products = Gson().fromJson(json, Array<Product>::class.java)
        products.toList()


    }


}



