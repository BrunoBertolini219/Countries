package br.com.brunoccbertolini.contries.ui.americas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brunoccbertolini.contries.models.Countries
import br.com.brunoccbertolini.contries.repository.CountryRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AmericasViewModel(private val repository: CountryRepository): ViewModel() {

    val myResponse: MutableLiveData<Response<Countries>> = MutableLiveData()

    fun getAmericaCountries(){
        viewModelScope.launch {
            val response = repository.getCountryAmerica()
            myResponse.value = response
        }

    }
}