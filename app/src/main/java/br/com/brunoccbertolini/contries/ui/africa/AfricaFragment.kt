package br.com.brunoccbertolini.contries.ui.africa

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunoccbertolini.contries.R
import br.com.brunoccbertolini.contries.adapters.CountriesAdapter
import br.com.brunoccbertolini.contries.repository.CountryRepository
import kotlinx.android.synthetic.main.fragment_africa.*

class AfricaFragment: Fragment(R.layout.fragment_africa) {

    private lateinit var viewModel: AfricaViewModel
    private lateinit var countryAdapter: CountriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle("Africa Countries")
        setupAdapter()
        val countryRepository = CountryRepository()
        val africaViewModelFactory = AfricaViewModelFactory(countryRepository)
        viewModel = ViewModelProvider(this, africaViewModelFactory).get(AfricaViewModel::class.java)
        viewModel.getAfricaCountries()
        viewModel.africaResponse.observe( viewLifecycleOwner, Observer {response ->
            response.let {
                countryAdapter.differ.submitList(response.body())
            }
        })

    }



   private fun setupAdapter(){
       countryAdapter = CountriesAdapter()
       rvAfrica.apply {
           layoutManager = LinearLayoutManager(activity)
           setHasFixedSize(true)
           adapter = countryAdapter
       }
   }
}