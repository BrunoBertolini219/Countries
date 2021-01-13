package br.com.brunoccbertolini.contries.ui.americas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.brunoccbertolini.contries.repository.CountryRepository

class AmericasViewModelFactory(private val repository: CountryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AmericasViewModel(repository) as T
    }
}