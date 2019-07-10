package com.gmail.ecommerce.presentation.utils

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.gmail.name.domain.entity.Product
import com.gmail.ecommerce.R
import com.gmail.ecommerce.presentation.utils.ProductRecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.item_product.view.*


class ProductRecyclerViewAdapter : RecyclerView.Adapter<ViewHolder>() {

    var listener: ClickListener? = null
    var items: List<Product> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) {
            with(itemView) {
                name.text = item.name
                price.text = item.price

                parentLayout.setOnClickListener {
                    listener?.onClick(item.id)
                }
                Log.e("aaa", "ProductRecyclerViewAdapter $item.toString()")

                val options = RequestOptions()
                        .circleCrop()
                        .error(R.mipmap.ic_launcher)

                Glide.with(itemView.context)
                        .load(item.imageUrl)
                        .listener(object : RequestListener<Drawable> {
                            override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                                return false
                            }

                            override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                                return false
                            }
                        })
                        .apply(options)
                        .into(image.image)
            }
        }
    }
}