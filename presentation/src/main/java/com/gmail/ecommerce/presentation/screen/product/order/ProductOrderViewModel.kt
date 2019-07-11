package com.gmail.ecommerce.presentation.screen.product.order


import android.databinding.ObservableField
import android.util.Log
import com.gmail.ecommerce.fuctories.UseCaseProvider
import com.gmail.ecommerce.presentation.base.BaseViewModel

class ProductOrderViewModel() : BaseViewModel<ProductOrderRouter>() {

    private val useCases = UseCaseProvider

    var name = ObservableField<String>("")
    var email = ObservableField<String>("")
    var phone = ObservableField<String>("")

    fun onClickSave() {
        var id = router?.idProductFromIntent()
        try {
            if (id?.isNotEmpty()!!) {
                var product = useCases.provideGetProductUseCase().getById(id)
                useCases.provideOrderProductUseCase().order(product!!.blockingSingle())
            }
        } catch (e: NumberFormatException) {
            Log.e("aaa", "ProductOrderViewModel exception")
        }
    }
}