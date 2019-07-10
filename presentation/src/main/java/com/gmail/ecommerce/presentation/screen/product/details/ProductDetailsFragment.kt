package com.gmail.ecommerce.presentation.screen.product.details

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.gmail.ecommerce.R
import com.gmail.ecommerce.databinding.FragmentProductDetailsBinding
import com.gmail.ecommerce.presentation.base.BaseMvvmFragment
import com.gmail.ecommerce.presentation.screen.product.ProductRouter

class ProductDetailsFragment : BaseMvvmFragment<ProductDetailsViewModel,
        ProductRouter, FragmentProductDetailsBinding>() {

    companion object {

        private const val ID_EXTRA = "ID_EXTRA"

        fun getInstance(id: String) : ProductDetailsFragment {
            val fragment = ProductDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return fragment
        }

        fun getInstance(): ProductDetailsFragment {
            return this.getInstance()
        }
    }

    override fun prodiveViewModel(): ProductDetailsViewModel {
        return ViewModelProviders.of(this)
                .get(ProductDetailsViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_product_details
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(ID_EXTRA)
        if(id != null) {
            viewModel.setProductId(id)
        } else {
            router?.goBack()
        }
    }
}