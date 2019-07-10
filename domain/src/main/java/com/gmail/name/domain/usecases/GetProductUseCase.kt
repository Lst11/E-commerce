package com.gmail.name.domain.usecases

import com.gmail.name.domain.entity.Product
import com.gmail.name.domain.executor.PostExecutorThread
import com.gmail.name.domain.repositories.ProductRepository
import io.reactivex.Observable

class GetProductUseCase(private val productRepository: ProductRepository, postExecutorThread: PostExecutorThread) : BaseUseCase(postExecutorThread) {

    fun getById(id: String): Observable<Product>? {
        return productRepository.getById(id)
                ?.observeOn(postExecutorThread)
                ?.subscribeOn(workExecutorThread)
    }
}
