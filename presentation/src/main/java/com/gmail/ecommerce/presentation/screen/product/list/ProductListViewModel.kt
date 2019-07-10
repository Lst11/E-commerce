package com.gmail.ecommerce.presentation.screen.product.list

import android.databinding.ObservableBoolean
import android.util.Log
import com.gmail.name.domain.entity.ProductSearch
import com.gmail.ecommerce.fuctories.UseCaseProvider
import com.gmail.ecommerce.presentation.base.BaseViewModel
import com.gmail.ecommerce.presentation.screen.product.ProductRouter
import com.gmail.ecommerce.presentation.utils.ClickListener
import com.gmail.ecommerce.presentation.utils.ProductRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ProductListViewModel : BaseViewModel<ProductRouter>() {

    val isProgressEnabled = ObservableBoolean(false)

    private val studentListUseCase = UseCaseProvider.provideGetProductListUseCase()

    private val searchStudentsUseCase = UseCaseProvider.provideSearchProductUseCase()


    private val listener = object : ClickListener {
        override fun onClick(id: String) {
            router?.goToProductDetails(id)
        }
    }

    val adapter: ProductRecyclerViewAdapter = ProductRecyclerViewAdapter()

    init {
        adapter.listener = listener
        isProgressEnabled.set(true)
        val disposable = studentListUseCase.get()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            Log.e("aaa", "ProductListViewModel size of the LIST is: " + it.size)
                            adapter.items = it
                            adapter.notifyDataSetChanged()
                            isProgressEnabled.set(false)
                        },
                        onError =
                        {
                            Log.e("aaa", "ProductListViewModel doOnError delete: $it")
                            isProgressEnabled.set(false)
                            router?.showError(it)
                        }
                )
        addToDisposable(disposable)
    }

    fun search(search: String) {

        if (isProgressEnabled.get()) return

        val studentSearch = ProductSearch(search)
        val disposable = searchStudentsUseCase.search(studentSearch)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {
                            adapter.items = it
                            adapter?.notifyDataSetChanged()
                        },
                        onError = {
                            router?.showError(it)
                        }
                )
        addToDisposable(disposable)
    }

    fun onClickAdd() {
        router?.goToProductDetails("")
    }
}