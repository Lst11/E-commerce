package com.gmail.name.domain.entity

data class Product(val id: String,
                   val name: String,
                   val description: String,
                   val price: String,
                   val imageUrl: String) : DomainEntity