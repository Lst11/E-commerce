package com.gmail.ecommerce.presentation.screen.product.order


import android.databinding.ObservableField
import com.gmail.ecommerce.presentation.base.BaseViewModel

class ProductOrderViewModel() : BaseViewModel<ProductOrderRouter>() {

    var name = ObservableField<String>("")
    var email = ObservableField<String>("")
    var phone = ObservableField<String>("")

    fun onClickSave() {
//        val product = com.gmail.name.domain.entity.Product(id, name.get() ?: "", price.get()
//                ?: "", imageUrl.get() ?: "")
//        Log.e("aaa", "Changing data is: $product")
//        useCases.provideOrderProductUseCase().order(product)
//                ?.subscribeBy(
//                        onError = { Log.e("aaa", "ProductDetailsViewModel onClickSave onError: $it") },
//                        onComplete = {
//                            Log.e("aaa", "ProductDetailsViewModel onClickSave onComplete")
//                            Handler().postDelayed({}, 120)
//                            router?.goToProductList()
//                        })
    }
}