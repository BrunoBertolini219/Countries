package br.com.brunoccbertolini.contries.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "countries")
data class CountriesItem(

    @PrimaryKey(autoGenerate = true)
    val capital: String,
    val flag: String,
    val name: String,
    val population: Int,
    val region: String
)