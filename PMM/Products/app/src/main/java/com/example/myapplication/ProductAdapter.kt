package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class ProductsAdapter(
    private var items: List<ProductResponse> = emptyList()
) : RecyclerView.Adapter<ProductsAdapter.ProductVH>() {

    fun submitList(newItems: List<ProductResponse>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductVH(view)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ProductVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        private val tvStock: TextView = itemView.findViewById(R.id.tvStock)
        private val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        private val chipDestination: Chip = itemView.findViewById(R.id.chipDestination)

        private val df = DecimalFormat("0.00", DecimalFormatSymbols(Locale.GERMANY))

        fun bind(p: ProductResponse) {
            tvName.text = p.name
            val priceText = when (val price = p.price) {
                is Number -> df.format(price.toDouble())
                else -> p.price.toString()
            }
            tvPrice.text = "€ $priceText"

            tvStock.text = "Stock: ${p.stock}"
            tvCategory.text = "Category: ${p.categoryId}"

            chipDestination.text = p.destination
            if (p.stock <= 2) {
                tvStock.text = "Low stock: ${p.stock}"
                tvStock.setTypeface(tvStock.typeface, android.graphics.Typeface.BOLD)
            } else {
                tvStock.setTypeface(tvStock.typeface, android.graphics.Typeface.NORMAL)
            }
        }
    }

}
