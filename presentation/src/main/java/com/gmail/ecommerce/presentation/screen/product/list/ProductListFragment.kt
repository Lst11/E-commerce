package com.gmail.ecommerce.presentation.screen.product.list

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.gmail.ecommerce.R
import com.gmail.ecommerce.databinding.FragmentProductListBinding
import com.gmail.ecommerce.presentation.base.BaseMvvmFragment
import com.gmail.ecommerce.presentation.screen.product.ProductRouter
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit

class ProductListFragment : BaseMvvmFragment<ProductListViewModel,
        ProductRouter, FragmentProductListBinding>() {

    companion object {

        fun getInstance() : ProductListFragment {
            return ProductListFragment()
        }
    }

    override fun prodiveViewModel(): ProductListViewModel {
        return ViewModelProviders.of(this)
                .get(ProductListViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_product_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listRecyclerView.adapter = viewModel.adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.listRecyclerView.setHasFixedSize(true)

        RxTextView.textChanges(binding.searchEditText)
                .throttleFirst(500L, TimeUnit.MILLISECONDS)
                .subscribeBy {
                    Log.e("aaa","ProductListFragment: text to search is $it")
                    viewModel.search(it.toString())
                }
    }
}