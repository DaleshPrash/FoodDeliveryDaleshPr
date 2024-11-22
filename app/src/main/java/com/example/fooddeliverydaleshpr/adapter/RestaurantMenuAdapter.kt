package com.example.fooddeliverydaleshpr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliverydaleshpr.databinding.FragmentRestaurantItemBinding
import com.example.fooddeliverydaleshpr.model.MenuItem

class RestaurantMenuAdapter(
    private var menuItems: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit
) : RecyclerView.Adapter<RestaurantMenuAdapter.MenuViewHolder>() {

    // Removed 'inner' keyword to make it a static nested class
    class MenuViewHolder(private val binding: FragmentRestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menuItem: MenuItem, onItemClick: (MenuItem) -> Unit) {
            binding.textViewMenuItemName.text = menuItem.name
            binding.textViewPrice.text =
                "Priced at $${String.format("%.2f", menuItem.price)}"
            binding.root.setOnClickListener { onItemClick(menuItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = FragmentRestaurantItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    // Pass 'onItemClick' to the 'bind' method
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuItems[position], onItemClick)
    }

    override fun getItemCount(): Int = menuItems.size

    fun updateData(newMenuItems: List<MenuItem>) {
        menuItems = newMenuItems
        notifyDataSetChanged()
    }
}
