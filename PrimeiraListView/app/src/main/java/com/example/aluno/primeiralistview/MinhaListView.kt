package com.example.aluno.primeiralistview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView



class MinhaListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minha_list_view)
       // setSupportActionBar(toolbar)




        val arrayDeLinhas = ArrayList<String>()
        arrayDeLinhas.add("Linha 1")
        arrayDeLinhas.add("Linha 2")
        arrayDeLinhas.add("Linha 3")
        arrayDeLinhas.add("Linha 4")
        val listView = findViewById<ListView>(R.id.primeiralistview)

        listView.adapter = ArrayAdapter(
                  this,
        android.R.layout.simple_list_item_1,
        arrayDeLinhas)
    }
}
