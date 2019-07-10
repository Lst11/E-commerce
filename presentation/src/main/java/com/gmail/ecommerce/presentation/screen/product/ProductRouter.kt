package com.gmail.ecommerce.presentation.screen.product

import android.view.View
import com.gmail.ecommerce.R
import com.gmail.ecommerce.presentation.base.BaseRouter
import com.gmail.ecommerce.presentation.screen.product.details.ProductDetailsFragment
import com.gmail.ecommerce.presentation.screen.product.list.ProductListFragment

class ProductRouter(activity: ProductActivity)
    : BaseRouter<ProductActivity>(activity) {

    fun goToProductList(){
        replaceFragment(
                activity.supportFragmentManager,
                ProductListFragment.getInstance(),
                R.id.container, false)
    }

    fun goToProductDetails(id: String) {

        val containerDetails = activity.findViewById<View>(R.id.containerDetails)

        if(containerDetails == null) {
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
}