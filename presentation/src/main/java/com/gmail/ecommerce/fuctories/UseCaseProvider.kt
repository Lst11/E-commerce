package com.gmail.ecommerce.fuctories

import com.gmail.name.data.repositories.ProductRepositoryImpl
import com.gmail.name.domain.usecases.*
import com.gmail.ecommerce.executor.UIThread

object UseCaseProvider {

    val uiThread = UIThread()


    fun provideGetProductListUseCase(): GetProductsUseCase {

        //Берем репозиторий из data слоя (репозиторий имплементирует интерфейс который
        // находится в domain слое)
        val repository = ProductRepositoryImpl()

        // создаем useCase и передаем в коструктор созданный репозиторий(который
        // находится в data слое, но domain не знает что репозиторий из data слоя)

        val useCase = GetProductsUseCase(repository, uiThread)

        return useCase
    }


    fun provideDeleteProductUseCase(): DeleteProductUseCase {
        return DeleteProductUseCase(ProductRepositoryImpl(), uiThread)
    }

    fun provideUpdateProductUseCase(): UpdateProductUseCase {
        return UpdateProductUseCase(ProductRepositoryImpl(), uiThread)
    }

    fun provideSearchProductUseCase(): SearchProductUseCase {
        return SearchProductUseCase(ProductRepositoryImpl(), uiThread)
    }

    fun provideGetProductUseCase(): GetProductUseCase {
        return GetProductUseCase(ProductRepositoryImpl(), uiThread)
    }
}