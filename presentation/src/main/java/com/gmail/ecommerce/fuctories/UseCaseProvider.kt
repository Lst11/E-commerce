package com.gmail.ecommerce.fuctories

import com.gmail.name.data.repositories.ProductRepositoryImpl
import com.gmail.name.domain.usecases.*
import com.gmail.ecommerce.executor.UIThread

object UseCaseProvider {

    val uiThread = UIThread()


    fun provideGetProductListUseCase(): GetProductsUseCase {

        val repository = ProductRepositoryImpl()

        val useCase = GetProductsUseCase(repository, uiThread)

        return useCase
    }

    fun provideOrderProductUseCase(): OrderProductUseCase {
        return OrderProductUseCase(ProductRepositoryImpl(), uiThread)
    }

    fun provideSearchProductUseCase(): SearchProductUseCase {
        return SearchProductUseCase(ProductRepositoryImpl(), uiThread)
    }

    fun provideGetProductUseCase(): GetProductUseCase {
        return GetProductUseCase(ProductRepositoryImpl(), uiThread)
    }
}