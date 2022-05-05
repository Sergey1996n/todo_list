package com.example.todo_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        var list: MutableList<Item> = IntArray(5) { it }.map {
            Item("Заголовок ${it + 1}", "Описание ${it + 1}", true)
        }.toMutableList()
    }

//    var list: MutableList<Item> = IntArray(5) { it }.map {
//        Item("Заголовок ${it + 1}", "Описание ${it + 1}", true)
//    }.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}