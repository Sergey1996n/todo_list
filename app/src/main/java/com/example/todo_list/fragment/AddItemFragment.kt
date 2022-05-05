package com.example.todo_list.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todo_list.R

class AddItemFragment : Fragment(R.layout.add_item) {

    /** Получаем наши аргументы, которые отправляет FirstFragmentNavigation */
//    private val argument: AddItemFragmentArgs by navArgs()

    private lateinit var addButton: Button
    private lateinit var title: TextView
    private lateinit var description: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Инициализируем наши вьюшки */
        addButton = view.findViewById(R.id.button)
        title = view.findViewById(R.id.editTextTitle)
        description = view.findViewById(R.id.editTextTextMultiLine)

        initView()
    }

    /** Устанавливаем клики и текст */
    private fun initView() {
        addButton.setOnClickListener {
            findNavController().navigate(
            AddItemFragmentDirections.actionAddItemActivityToMainFragment(
                title.text.toString(), description.text.toString()
            ))
            /** Возвращаемся к предыдущему стеку  */
            findNavController().popBackStack(0, true)
        }

//        title.text = argument.name
    }
}