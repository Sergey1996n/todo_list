package com.example.todo_list

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.MenuItem
import androidx.core.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.databinding.ActivityMainBinding
import com.example.todo_list.list_view.ListViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var defaultItemAnimator: RecyclerView.ItemAnimator

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.bind(findViewById(R.id.main_root))
        //defaultItemAnimator = viewBinding.mainRecycler.itemAnimator!!

        configListVew()
        toListView()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun toListView() {
        viewBinding.mainRecycler.isVisible = false
        viewBinding.mainList.isVisible = true
    }

    private fun configListVew() {
        viewBinding.mainList.adapter = ListViewAdapter()
        val inflater = LayoutInflater.from(this)
//        val header = inflater.inflate(R.layout.item_search, viewBinding.mainList, false)
        val footer = inflater.inflate(R.layout.item_button_add, viewBinding.mainList, false)
//        viewBinding.mainList.addHeaderView(header)
        viewBinding.mainList.addFooterView(footer)
    }
}