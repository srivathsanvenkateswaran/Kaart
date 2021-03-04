package com.example.kaart.ui.ShoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kaart.R
import com.example.kaart.data.db.ShoppingDatabase
import com.example.kaart.data.entity.ShoppingItem
import com.example.kaart.data.other.ShoppingItemAdapter
import com.example.kaart.data.repository.ShoppingRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        rvShoppingRecyclerView.layoutManager = LinearLayoutManager(this)
        rvShoppingRecyclerView.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDIalog(this,
                    object : AddDialogListener {
                        override fun onAddButtonClicked(item: ShoppingItem) {
                            viewModel.updateOrInsert(item)
                        }
                    }).show()
        }
    }
}