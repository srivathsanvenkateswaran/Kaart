package com.example.kaart.data.repository

import com.example.kaart.data.db.ShoppingDatabase
import com.example.kaart.data.db.ShoppingItemDao
import com.example.kaart.data.entity.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun updateOrInsert(item: ShoppingItem) = db.getShoppingItemDao().updateOrInsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingItemDao().delete(item)

    fun getAllItems() = db.getShoppingItemDao().getAllShoppingItems()

}