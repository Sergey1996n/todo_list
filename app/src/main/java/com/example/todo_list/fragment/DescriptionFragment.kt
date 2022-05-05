package com.example.todo_list.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todo_list.Item
import com.example.todo_list.R

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    /** Получаем наши аргументы, которые отправляет FirstFragmentNavigation */
//    companion object {
//        val argument = ""
//    }
    private val argument: DescriptionFragmentArgs by navArgs()


    private lateinit var addButton: Button
    private lateinit var argumentTitle: TextView
    private lateinit var argumentDescription: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Инициализируем наши вьюшки */
        addButton = view.findViewById(R.id.button)
        argumentTitle = view.findViewById(R.id.textView10)
        argumentDescription = view.findViewById(R.id.textView11)

        initView()
    }

    /** Устанавливаем клики и текст */
    private fun initView() {
        addButton.setOnClickListener {
            /** Возвращаемся к предыдущему стеку  */
            findNavController().popBackStack()
        }

        argumentTitle.text = argument.title
        argumentDescription.text = argument.description
    }
}
