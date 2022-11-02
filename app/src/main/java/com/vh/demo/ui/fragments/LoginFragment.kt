package com.vh.demo.ui.fragments

import android.os.Bundle
import android.view.View
import com.vh.demo.databinding.FragmentLoginBinding
import com.vh.demo.ui.abs.AbsBindingFragment

class LoginFragment : AbsBindingFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}