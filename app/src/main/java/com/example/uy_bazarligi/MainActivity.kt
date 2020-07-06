package com.example.uy_bazarligi
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import com.example.jerglikOnim.data.EmptyDatabase
import com.example.jerglikOnim.data.dao.EmptyDao
import com.example.jerglikOnim.data.model.Product
import com.example.uy_bazarligi.customDialog.CustomDialog
import com.example.uy_bazarligi.customDialog.CustomDialogForChange
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter(this)
    private lateinit var dao: EmptyDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val plus: FloatingActionButton = findViewById(R.id.plus)
        recyclerView.adapter = adapter
        plus.setOnClickListener {
            val dialog = CustomDialog(this, this)
            dialog.show()
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_gallery -> {
                    return@setNavigationItemSelectedListener true
                }
                R.id.nav_slideshow -> {
                    return@setNavigationItemSelectedListener true
                }
                else -> return@setNavigationItemSelectedListener false
            }
        }
        dao = EmptyDatabase.getInstance(this).dao()
    }

    // bazag'a daniy qosiw
    fun addProduct(product: Product) {
        dao.insertProduct(product)
        adapter.models = dao.getAllProducts()
    }

    // Bazadag'i daniydi ozgertiw
    fun changeProduct(id: Int){
        dao.getProductById(id)
        adapter.models = dao.getAllProducts()
    }

    // Bazadag'i daniydi ochiriw
    fun deleteProduct(product: Product) {
        dao.deleteProduct(product)
        adapter.models = dao.getAllProducts()
    }

    //
    fun updateProduct(product: Product){
    dao.updateDataInsert(product)
    adapter.models = dao.getAllProducts()
    }




        //item options menu
        fun itemOpMn(view: View, product: Product,id: Int) {
            val optionsMenu = PopupMenu(this, view)
            val menuInflater = optionsMenu.menuInflater
            menuInflater.inflate(R.menu.menu_item_options, optionsMenu.menu)
            optionsMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.itemChange -> {
                        val dialog = CustomDialogForChange(this, this)
                        dialog.show()
                    }
                    R.id.itemDelete -> {
                        val button = AlertDialog.Builder(this)
                        button.setTitle("ITIBAR QARATIN!!")
                            .setMessage("Siz haqiyqattanda o'shirwdi qaleysizbe? ")
                            .setPositiveButton("Awa") { _, _ ->
                                deleteProduct(product)
                                Toast.makeText(this, "o'shirldi", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        button.setNegativeButton("YAQ") { _, _ ->
                            Toast.makeText(this, "o'zgersiz", Toast.LENGTH_SHORT).show()
                        }
                        button.show()
                    }
                }
                return@setOnMenuItemClickListener true
            }
            optionsMenu.show()
        }


        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            //  Inflate the menu; this adds items to the action bar if it is present.
            //  menuInflater.inflate(R.menu.main, menu)
            return true
        }
    }