package br.com.brunoccbertolini.contries.api

import br.com.brunoccbertolini.contries.models.Countries
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {

    @GET("europe?fields=name;capital;flag;population;region")
    suspend fun getEuropeCountries(): Response<Countries>

    @GET("africa?fields=name;capital;flag;population;region")
    suspend fun getAfricaCountries(): Response<Countries>

    @GET("americas?fields=name;capital;flag;population;region")
    suspend fun getAmericasCountries(): Response<Countries>
}