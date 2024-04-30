package com.example.studykotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //ссылаемся на объекты из дизайна
        //val label = findViewById<TextView>(R.id.main_lable)
        val listView = findViewById<ListView>(R.id.listView)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)

        //формируем пустой список (базовая настройка для listView)
        val array: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        listView.adapter = adapter

        //обработчик списка, удаляем элементы списка
        listView.setOnItemClickListener { parent, view, position, id ->
            val text = listView.getItemAtPosition(position).toString()
            adapter.remove(text)

            Toast.makeText(this, "Мы удалили $text", Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener{
            val text = userData.text.toString().trim()

            if(text != "")
                adapter.insert(text, 0)

            /*if(text == "toast")
                Toast.makeText(this,"User Enter Toast", Toast.LENGTH_SHORT).show()
            else
                label.text = text*/
        }


    }
}