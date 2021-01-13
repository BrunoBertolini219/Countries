package br.com.brunoccbertolini.contries.ui.africa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunoccbertolini.contries.models.Countries
import br.com.brunoccbertolini.contries.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AfricaViewModel(private val repository: CountryRepository): ViewModel() {

    val africaResponse: MutableLiveData<Response<Countries>> = MutableLiveData()

    fun getAfricaCountries(){
        viewModelScope.launch {
            val response = repository.getCountryAfrica()
            africaResponse.value = response
        }
    }
}