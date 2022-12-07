package com.rahul.cryptocurrency.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rahul.cryptocurrency.R
import com.rahul.cryptocurrency.databinding.FragmentCoinDetailBinding
import com.rahul.cryptocurrency.domain.model.CoinDetailResponse
import com.rahul.cryptocurrency.domain.model.CoinResponseModel
import com.rahul.cryptocurrency.presentation.viewmodel.CoinDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CoinDetailFragment : Fragment() {

    companion object {
        fun newInstance(coinResponseModel: CoinResponseModel) : CoinDetailFragment{
            val fragment = CoinDetailFragment()
            fragment.arguments = Bundle().apply {
                putParcelable("coinResponseModel", coinResponseModel)
            }
            return fragment
        }
    }

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
        arguments?.getParcelable<CoinResponseModel>("coinResponseModel") ?.let { coinResponseModel ->
            coinDetailViewModel.getCoinDetail(coinResponseModel.id)
            binding.coinDetail?.coinId = coinResponseModel.id
        }

        lifecycleScope.launchWhenCreated {
            coinDetailViewModel.state.collect() {
                binding.coinDetailProgressBar.isVisible = it.isLoading

                if (it.error.isNotEmpty()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_LONG).show()
                } else if (it.coinDetail != null){
                    binding.rank.text = it.coinDetail?.rank.toString() + ". "
                    binding.name.text = it.coinDetail?.name + " "
                    binding.symbol.text = "(" + it.coinDetail?.symbol + ")"
                    if (binding.coinDetail?.isActive == true) {
                        binding.active.text = "inactive"
                    } else {
                        binding.active.text = "active"
                    }
                    binding.description.text = it.coinDetail?.description
                }
            }
        }
    }
}