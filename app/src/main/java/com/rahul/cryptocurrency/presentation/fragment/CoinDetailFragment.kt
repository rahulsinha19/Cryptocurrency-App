package com.rahul.cryptocurrency.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rahul.cryptocurrency.R
import com.rahul.cryptocurrency.databinding.FragmentCoinDetailBinding
import com.rahul.cryptocurrency.presentation.viewmodel.CoinDetailViewModel

class CoinDetailFragment : Fragment() {
    private var _binding: FragmentCoinDetailBinding? = null
    val binding: FragmentCoinDetailBinding
        get() = _binding!!

    private val coinDetailViewModel: CoinDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}