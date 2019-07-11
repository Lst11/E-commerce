package com.gmail.ecommerce.presentation.screen.product.order


import com.gmail.ecommerce.presentation.base.BaseRouter

class ProductOrderRouter(activity: ProductOrderActivity)
    : BaseRouter<ProductOrderActivity>(activity) {

    fun idProductFromIntent(): String? {
        var id = activity.intent.getStringExtra("id")
        return id
    }
}