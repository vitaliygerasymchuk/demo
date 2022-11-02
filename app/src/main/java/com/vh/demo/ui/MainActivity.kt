package com.vh.demo.ui

import androidx.lifecycle.lifecycleScope
import com.vh.demo.databinding.ActivityMainBinding
import com.vh.demo.ui.abs.AbsBindingActivity
import com.vh.libdemo.usecase.AuthUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AbsBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    @Inject
    lateinit var authUseCase: AuthUseCase

    override fun onInitViews() {
        lifecycleScope.launch {
            authUseCase.getSessionState()
        }
    }
}