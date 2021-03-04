package com.example.kaart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
        @ColumnInfo(name = "item_name")
        val itemName: String,
        @ColumnInfo(name = "quantity")
        var quantity: Int
){
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null
}