package com.rahul.cryptocurrency.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.cryptocurrency.databinding.FragmentCoinListBinding
import com.rahul.cryptocurrency.domain.model.CoinResponseModel
import com.rahul.cryptocurrency.presentation.adapter.CoinListAdapter
import com.rahul.cryptocurrency.presentation.listeners.CoinClickListener
import com.rahul.cryptocurrency.presentation.viewmodel.CoinListViewModel
import com.rahul.cryptocurrency.presentation.viewstate.CoinListState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CoinListFragment : Fragment(), CoinClickListener {

    private val coinListAdapter = CoinListAdapter(this)

    private val coinListViewModel: CoinListViewModel by viewModels()

    private var _binding : FragmentCoinListBinding? = null
    val binding: FragmentCoinListBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.coinListRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coinListAdapter
        }
        lifecycleScope.launchWhenCreated {
            coinListViewModel.state.collect() {
                binding.coinListProgressBar.isVisible = it.isLoading
                if (it.error.isNotEmpty()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }
                else {
                    coinListAdapter.coinList = it.coinList as ArrayList<CoinResponseModel>
                    coinListAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onClick(coinResponseModel: CoinResponseModel) {
        var fragment = CoinDetailFragment.newInstance(coinResponseModel)
        childFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, fragment).commit()
    }
}