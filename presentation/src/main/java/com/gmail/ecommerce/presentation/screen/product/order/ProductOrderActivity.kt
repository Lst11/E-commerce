package com.gmail.ecommerce.presentation.screen.product.order

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.ecommerce.R
import com.gmail.ecommerce.databinding.ActivityProductBinding
import com.gmail.ecommerce.presentation.base.BaseMvvmActivity

class ProductOrderActivity : BaseMvvmActivity<
        ProductOrderViewModel,
        ProductOrderRouter,
        ActivityProductBinding>() {

    override fun prodiveViewModel(): ProductOrderViewModel {
        return ViewModelProviders.of(this)
                .get(ProductOrderViewModel::class.java)
    }

    override fun provideRouter(): ProductOrderRouter{
        return ProductOrderRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_order

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}