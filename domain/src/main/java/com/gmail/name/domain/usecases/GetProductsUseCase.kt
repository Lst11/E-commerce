package com.gmail.name.domain.usecases

import com.gmail.name.domain.entity.Product
import com.gmail.name.domain.executor.PostExecutorThread
import com.gmail.name.domain.repositories.ProductRepository
import io.reactivex.Observable

class GetProductsUseCase constructor(private val productRepository: ProductRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {

    fun get(): Observable<List<Product>> {
        return productRepository.get()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
