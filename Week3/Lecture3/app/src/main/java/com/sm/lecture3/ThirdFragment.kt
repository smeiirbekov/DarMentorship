package com.sm.lecture3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.sm.lecture3.DataRepo.live
import com.sm.lecture3.databinding.FragmentSecondBinding
import com.sm.lecture3.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {



    private var _binding: FragmentThirdBinding? = null
    private val binding: FragmentThirdBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        _binding?.lifecycleOwner = viewLifecycleOwner
        _binding?.data = DataRepo
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvTitle.postDelayed({
                                    live.postValue("New test")
        }, 2000)

        binding.tvTitle.postDelayed({
            live.postValue("testing again")
        }, 4000)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}