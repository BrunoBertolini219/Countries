package br.com.brunoccbertolini.contries.ui.africa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.brunoccbertolini.contries.repository.CountryRepository

class AfricaViewModelFactory(private val repository: CountryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AfricaViewModel(repository) as T
    }
}