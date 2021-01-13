package br.com.brunoccbertolini.contries.ui.americas

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunoccbertolini.contries.R
import br.com.brunoccbertolini.contries.adapters.CountriesAdapter
import br.com.brunoccbertolini.contries.repository.CountryRepository
import kotlinx.android.synthetic.main.fragment_americas.*

class AmericasFragment: Fragment(R.layout.fragment_americas) {

    private lateinit var viewModel: AmericasViewModel
    private lateinit var countryAdapter: CountriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle("America Countries")
        setupCountryAdapter()
        val repository = CountryRepository()
        val americasViewModelFactory = AmericasViewModelFactory(repository)
        viewModel = ViewModelProvider(this, americasViewModelFactory).get(AmericasViewModel::class.java)
        viewModel.getAmericaCountries()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->

            response.let {
                countryAdapter.differ.submitList(it.body())
            }

        })




    }

    private fun setupCountryAdapter(){
        countryAdapter = CountriesAdapter()
        rvSouthAmerica.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = countryAdapter
        }
    }
}