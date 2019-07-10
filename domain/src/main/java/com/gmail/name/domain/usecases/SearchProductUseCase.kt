package com.gmail.name.domain.usecases

import com.gmail.name.domain.entity.Product
import com.gmail.name.domain.entity.ProductSearch
import com.gmail.name.domain.executor.PostExecutorThread
import com.gmail.name.domain.repositories.ProductRepository
import io.reactivex.Observable

class SearchProductUseCase(private val productRepository: ProductRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {

    fun search(searchProduct: ProductSearch): Observable<List<Product>> {
        return productRepository.search(searchProduct)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}