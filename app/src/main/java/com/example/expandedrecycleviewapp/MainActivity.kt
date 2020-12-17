package com.example.expandedrecycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList: ArrayList<Modal> = arrayListOf(
            Modal("val", "val val recyclerView = findViewById<RecyclerView>(R.id.expandedRV) val recyclerView = findViewById<RecyclerView>(R.id.expandedRV)"),
            Modal("val", "val val recyclerView = findViewById<RecyclerView>(R.id.expandedRV)"),
            Modal("val", "valval recyclerView = findViewById<RecyclerView>(R.id.expandedRV)")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.expandedRV)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = ModalRVAdapter(arrayList)
        }
    }
}