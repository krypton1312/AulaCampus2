package com.example.countries

data class Country(
    val name: Name,
    val capital: List<String>?,
    val region: String?,
    val population: Long?,
    val flags: Flags,
    val languages: Map<String, String>?,
    val cca2: String?
)

data class Name(val common: String?)
data class Flags(val png: String?, val svg: String?)

