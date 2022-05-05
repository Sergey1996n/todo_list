package com.example.todo_list.easy

import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.Item
import com.example.todo_list.R
import com.example.todo_list.fragment.MainFragmentDirections

class EasyAdapter : RecyclerView.Adapter<EasyAdapter.EasyViewHolder>() {

    private val items: MutableList<Item> = mutableListOf()
    private lateinit var recyclerView: RecyclerView

    fun setItems(items: List<Item>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EasyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_string, parent, false)

        return EasyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EasyViewHolder, position: Int) {
        val checkBox = holder.itemView.findViewById<CheckBox>(R.id.checkBox)
        checkBox.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked)
                button.paintFlags = button.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            else
                button.paintFlags = button.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            items[position].achievement = isChecked

        }

        checkBox.text = items[position].title
        checkBox.isChecked = items[position].achievement

        val itemView = holder.itemView.findViewById<ConstraintLayout>(R.id.item_string)

        itemView.setOnClickListener {view ->
            Navigation.findNavController(view).navigate(
                MainFragmentDirections.actionMainFragmentToDescriptionFragment(items[position].title, items[position].description))
        }
    }

    override fun getItemCount(): Int = items.size

    class EasyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

