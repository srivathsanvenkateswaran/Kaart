package com.example.kaart.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kaart.data.entity.ShoppingItem

@Dao
interface ShoppingItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrInsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items ORDER BY id")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>
}