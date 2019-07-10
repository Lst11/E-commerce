package com.gmail.ecommerce.presentation.screen.product

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.gmail.ecommerce.R
import com.gmail.ecommerce.databinding.ActivityProductBinding
import com.gmail.ecommerce.presentation.base.BaseMvvmActivity

class ProductActivity : BaseMvvmActivity<
        ProductViewModel,
        ProductRouter,
        ActivityProductBinding>() {

    override fun prodiveViewModel(): ProductViewModel {
        return ViewModelProviders.of(this)
                .get(ProductViewModel::class.java)
    }

    override fun provideRouter(): ProductRouter {
        return ProductRouter(this)
    }

    override fun provideLayoutId(): Int = R.layout.activity_product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null) {
            router.goToProductList()
        }
    }
}