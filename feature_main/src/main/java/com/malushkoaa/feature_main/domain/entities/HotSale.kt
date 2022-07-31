package com.malushkoaa.feature_main.domain.entities

data class HotSale(
    val id: Int? = null,
    val isBuy: Boolean? = null,
    val isNew: Boolean? = null,
    val picture: String? = null,
    val subtitle: String? = null,
    val title: String? = null
)