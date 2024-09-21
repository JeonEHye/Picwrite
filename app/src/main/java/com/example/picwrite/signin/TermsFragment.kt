package com.example.picwrite.signin

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.picwrite.R
import com.example.picwrite.databinding.FragmentTermsBinding

class TermsFragment : Fragment() {
    private val binding by lazy { FragmentTermsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivIconArrowBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        binding.tvButtonAgree.setOnClickListener{
            parentFragmentManager.commit {
                replace(R.id.main, SignInFragment.newInstance(true))
            }
        }

    }
}