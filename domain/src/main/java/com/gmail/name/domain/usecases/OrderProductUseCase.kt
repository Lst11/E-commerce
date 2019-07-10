package com.gmail.name.domain.usecases

import com.gmail.name.domain.entity.Product
import com.gmail.name.domain.executor.PostExecutorThread
import com.gmail.name.domain.repositories.ProductRepository
import io.reactivex.Completable

class OrderProductUseCase(private val productRepository: ProductRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {

    fun order(product: Product): Completable {
        return productRepository.order(product)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}