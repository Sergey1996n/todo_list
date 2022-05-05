package com.example.todo_list.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_list.Item
import com.example.todo_list.MainActivity
import com.example.todo_list.R
import com.example.todo_list.databinding.ActivityMainBinding
import com.example.todo_list.easy.EasyAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    /** Получаем наши аргументы, которые отправляет FirstFragmentNavigation */
    private val argument: MainFragmentArgs by navArgs()

    private lateinit var easyAdapter: EasyAdapter
    private lateinit var addItem: Button
    private lateinit var recyclerView: RecyclerView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (argument.title != "По умолчанию") {
            val item = Item(argument.title, argument.description, false)
            MainActivity.list.add(0, item)
        }
        easyAdapter = EasyAdapter()
        recyclerView = view.findViewById(R.id.main_recycler)
        addItem = view.findViewById(R.id.Add)

        initView()
    }

    /** Устанавливаем клики и текст */
    private fun initView() {
        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            this.adapter = easyAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        Log.d("Проверка аргументов", argument.title)

        easyAdapter.setItems(MainActivity.list)

        addItem.setOnClickListener {
            /** Возвращаемся к предыдущему стеку  */
            findNavController().navigate(R.id.action_mainFragment_to_AddItemActivity)
        }

//        argumentTxt.text = argument.name
    }


}

