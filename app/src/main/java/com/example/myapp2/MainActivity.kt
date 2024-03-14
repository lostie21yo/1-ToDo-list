package com.example.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val userInput = findViewById<EditText>(R.id.userInput)
        val button: Button = findViewById(R.id.addButton)

        // список задач и адаптер к нему
        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, i, id ->
            val text = listView.getItemAtPosition(i).toString()
            adapter.remove(text)
            Toast.makeText(this, "Удалена задача: $text", Toast.LENGTH_LONG).show()
        }

        // обработчик нажатия на кнопку
        button.setOnClickListener{
            val text = userInput.text.toString().trim()
            if(text != "")
                adapter.insert(text, 0)
        }
    }
}