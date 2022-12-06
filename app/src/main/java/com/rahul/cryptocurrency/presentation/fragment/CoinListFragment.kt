package com.rahul.cryptocurrency.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rahul.cryptocurrency.databinding.FragmentCoinListBinding
import com.rahul.cryptocurrency.presentation.adapter.CoinListAdapter
import com.rahul.cryptocurrency.presentation.viewmodel.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinListFragment : Fragment() {

    private val coinListAdapter = CoinListAdapter()

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
        binding.coinListRecycler.apply {
            adapter = coinListAdapter
        }
        super.onViewCreated(view, savedInstanceState)
    }
}