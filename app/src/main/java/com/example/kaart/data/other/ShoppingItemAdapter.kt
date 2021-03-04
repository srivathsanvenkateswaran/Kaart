package com.example.kaart.data.other

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kaart.R
import com.example.kaart.data.entity.ShoppingItem
import com.example.kaart.ui.ShoppingList.ShoppingViewModel
import org.w3c.dom.Text

class ShoppingItemAdapter(
        var items: List<ShoppingItem>,
        private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val amount = itemView.findViewById<TextView>(R.id.tvAmount)
        val delImage = itemView.findViewById<ImageView>(R.id.ivDelete)
        val plusImage = itemView.findViewById<ImageView>(R.id.ivPlus)
        val minusImage = itemView.findViewById<ImageView>(R.id.ivMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent,false)
        val viewHolder = ShoppingViewHolder(view)
        // To add a listener
        viewHolder.delImage.setOnClickListener{
            viewModel.delte(items[viewHolder.adapterPosition])
        }
        viewHolder.minusImage.setOnClickListener {
            if(items[viewHolder.adapterPosition].quantity > 0){
                items[viewHolder.adapterPosition].quantity--
                viewModel.updateOrInsert(items[viewHolder.adapterPosition])
            }
        }
        viewHolder.plusImage.setOnClickListener {
            items[viewHolder.adapterPosition].quantity++
            viewModel.updateOrInsert(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.amount.text = "${currentShoppingItem.quantity}"
        holder.name.text = currentShoppingItem.itemName
    }

    override fun getItemCount(): Int {
        return items.size
    }

}