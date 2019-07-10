package com.gmail.name.domain.repositories

import com.gmail.name.domain.entity.Product
import com.gmail.name.domain.entity.ProductSearch
import io.reactivex.Completable
import io.reactivex.Observable

interface ProductRepository : BaseRepository {

    fun get() : Observable<List<Product>>

    fun getById(id: String) : Observable<Product>?

    fun search(search: ProductSearch) : Observable<List<Product>>

    fun order(product: Product) : Completable

}