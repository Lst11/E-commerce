package com.gmail.ecommerce.presentation.utilssurname

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.ecommerce.R

@BindingAdapter("visibility")
fun View.visibility(visibility: Boolean) {
    this.visibility = if(visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("app:src")
fun loadImage(view: ImageView, imageUrl: String) {
    val errorImageView : Drawable? = view.resources.getDrawable( R.mipmap.ic_launcher)
    val options = RequestOptions()
            .circleCrop()
            .error(errorImageView)

    Glide.with(view.context)
            .load(imageUrl)
            .apply(options)
            .into(view)
}