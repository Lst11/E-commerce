package com.gmail.ecommerce.presentation.screen.product.details

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.os.Handler
import android.util.Log
import com.gmail.ecommerce.fuctories.UseCaseProvider
import com.gmail.ecommerce.presentation.base.BaseViewModel
import com.gmail.ecommerce.presentation.screen.product.ProductRouter
import io.reactivex.rxkotlin.subscribeBy


class ProductDetailsViewModel : BaseViewModel<ProductRouter>() {

    private val useCases = UseCaseProvider

    val isProgressEnabled = ObservableBoolean(false)

    private var productId: String? = null

    var id = ("")
    var name = ObservableField<String>("")
    var price = ObservableField<String>("")
    var imageUrl = ObservableField<String>("")

    fun setProductId(id: String) {

        if (productId != null) return

        productId = id

        val disposable = useCases.provideGetProductUseCase().getById(id)
                ?.subscribeBy(
                        onNext = {
                            Log.e("aaa", "Product is ${it.name} ${it.price}")
                            this.id = it.id
                            this.name.set(it.name)
                            this.price.set(it.price)
                            this.imageUrl.set(it.imageUrl)
                        },
                        onError = {
                            Log.e("aaa", "ProductDetailsViewModel error: $it")
                            isProgressEnabled.set(false)
                            router?.showError(it)
                        }
                )
        disposable?.let { addToDisposable(it) }
    }

    fun onClickSave() {
        val product = com.gmail.name.domain.entity.Product(id, name.get() ?: "", price.get()
                ?: "", imageUrl.get() ?: "")
        Log.e("aaa", "Changing data is: $product")
        useCases.provideUpdateProductUseCase().update(product)
                ?.subscribeBy(
                        onError = { Log.e("aaa", "ProductDetailsViewModel onClickSave onError: $it") },
                        onComplete = {
                            Log.e("aaa", "ProductDetailsViewModel onClickSave onComplete")
                            Handler().postDelayed({}, 120)
                            router?.goToProductList()
                        })
    }

    fun onClickDelete() {
        useCases.provideDeleteProductUseCase().delete(id)
                ?.subscribeBy(
                        onError = { Log.e("aaa", "ProductDetailsViewModel onClickDelete onError: $it") },
                        onComplete = {
                            Log.e("aaa", "ProductDetailsViewModel onClickDelete onComplete")
                            Handler().postDelayed({}, 120)
                            router?.goToProductList()
                        })
    }
}

