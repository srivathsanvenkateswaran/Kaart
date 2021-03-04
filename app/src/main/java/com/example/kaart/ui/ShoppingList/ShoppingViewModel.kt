package com.example.kaart.ui.ShoppingList

import androidx.lifecycle.ViewModel
import com.example.kaart.data.entity.ShoppingItem
import com.example.kaart.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class ShoppingViewModel(private val repository: ShoppingRepository): ViewModel() {

    fun updateOrInsert(item: ShoppingItem){
        CoroutineScope(Dispatchers.IO).launch {
            repository.updateOrInsert(item)
        }
    }

    fun delte(item: ShoppingItem){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(item)
        }
    }

    fun getAllShoppingItems() = repository.getAllItems()
}