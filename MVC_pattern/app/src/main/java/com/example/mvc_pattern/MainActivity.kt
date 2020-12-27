package com.example.mvc_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var viewByList: ImageButton
    lateinit var viewByGrid: ImageButton
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager
    lateinit var viewAdapter: ViewAdapter
    lateinit var editText: EditText
    lateinit var button: Button

    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewByList = findViewById(R.id.imagebutton_list)
        viewByGrid = findViewById(R.id.imagebutton_grid)
        recyclerView = findViewById(R.id.recyclerview)
        editText = findViewById(R.id.edittext)
        button = findViewById(R.id.button)

        model = Model()

        recyclerViewLayoutManager = LinearLayoutManager(this)
        viewAdapter = ViewAdapter()
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = recyclerViewLayoutManager
            adapter = viewAdapter
        }

        viewByList.setOnClickListener(this)
        viewByGrid.setOnClickListener(this)
        button.setOnClickListener(this)
    }

    private fun changeLinearLayoutManager() {
        if (!model.layoutMode) {
            model.changeLayoutMode()
            recyclerViewLayoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = recyclerViewLayoutManager
        }
    }

    private fun changeGridLayoutManager() {
        if (model.layoutMode) {
            model.changeLayoutMode()
            recyclerViewLayoutManager = GridLayoutManager(this, 2)
            recyclerView.layoutManager = recyclerViewLayoutManager
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imagebutton_list -> { changeLinearLayoutManager() }
            R.id.imagebutton_grid -> { changeGridLayoutManager() }
            R.id.button -> {
                model.content = editText.text.toString()
                editText.setText("")
                viewAdapter.addItem(model.content)
                viewAdapter.notifyDataSetChanged()
            }
        }
    }
}