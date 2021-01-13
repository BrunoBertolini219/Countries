package br.com.brunoccbertolini.contries.ui.europe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.brunoccbertolini.contries.repository.CountryRepository

class EuropeViewModelFactory(
    private val repository: CountryRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EuropeViewModel(repository) as T
    }
}