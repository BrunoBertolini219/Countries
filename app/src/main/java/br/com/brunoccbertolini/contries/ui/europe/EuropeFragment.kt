package br.com.brunoccbertolini.contries.ui.europe

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunoccbertolini.contries.R
import br.com.brunoccbertolini.contries.adapters.CountriesAdapter
import br.com.brunoccbertolini.contries.repository.CountryRepository
import kotlinx.android.synthetic.main.fragment_europe.*

class EuropeFragment: Fragment(R.layout.fragment_europe) {

    private lateinit var viewModel: EuropeViewModel
    private lateinit var europeAdapter: CountriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle("Europe Countries")
        setupAdapter()
        val countryRepository = CountryRepository()
        val europeViewModelFactory = EuropeViewModelFactory(countryRepository)
        viewModel = ViewModelProvider(this, europeViewModelFactory).get(EuropeViewModel::class.java)
        viewModel.getEuropeCountry()
        viewModel.europeResponse.observe(viewLifecycleOwner, Observer {response ->
            europeAdapter.differ.submitList(response.body())
        })
    }

    private fun setupAdapter() {
        europeAdapter = CountriesAdapter()
        rvEurope.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = europeAdapter
        }
    }
}