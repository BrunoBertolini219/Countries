package br.com.brunoccbertolini.contries.ui.europe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunoccbertolini.contries.models.Countries
import br.com.brunoccbertolini.contries.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class EuropeViewModel(private val repository: CountryRepository): ViewModel() {

   val europeResponse: MutableLiveData<Response<Countries>> = MutableLiveData()

    fun getEuropeCountry(){
        viewModelScope.launch {
            val response = repository.getCountryEurope()
            europeResponse.value = response
        }
    }

}