package br.com.brunoccbertolini.contries.repository

import br.com.brunoccbertolini.contries.api.RetrofitInstance
import br.com.brunoccbertolini.contries.models.Countries
import retrofit2.Response

class CountryRepository() {

    suspend fun getCountryAmerica() : Response<Countries> {
        return RetrofitInstance.api.getAmericasCountries()
    }

    suspend fun getCountryAfrica(): Response<Countries>{
        return RetrofitInstance.api.getAfricaCountries()
    }

    suspend fun getCountryEurope(): Response<Countries>{
        return RetrofitInstance.api.getEuropeCountries()
    }

}