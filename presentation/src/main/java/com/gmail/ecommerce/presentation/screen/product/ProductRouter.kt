package com.gmail.ecommerce.presentation.screen.product

import android.content.Intent
import android.view.View
import com.gmail.ecommerce.R
import com.gmail.ecommerce.presentation.base.BaseRouter
import com.gmail.ecommerce.presentation.screen.product.details.ProductDetailsFragment
import com.gmail.ecommerce.presentation.screen.product.list.ProductListFragment
import android.support.v4.content.ContextCompat.startActivity
import com.gmail.ecommerce.presentation.screen.product.order.ProductOrderActivity


class ProductRouter(activity: ProductActivity)
    : BaseRouter<ProductActivity>(activity) {

    fun goToProductList() {
        replaceFragment(
                activity.supportFragmentManager,
                ProductListFragment.getInstance(),
                R.id.container, false)
    }

    fun goToProductDetails(id: String) {

        val containerDetails = activity.findViewById<View>(R.id.containerDetails)

        if (containerDetails == null) {
            replaceFragment(
                    activity.supportFragmentManager,
                    ProductDetailsFragment.getInstance(id),
                    R.id.container, true)
        } else {
            replaceFragment(
                    activity.supportFragmentManager,
                    ProductDetailsFragment.getInstance(id),
                    R.id.containerDetails, false)
        }
    }

    fun startOrder(id: String) {
        val intent = Intent(activity, ProductOrderActivity::class.java)
        intent.putExtra("id",id)
        startActivity(activity.baseContext, intent, null)
    }
}