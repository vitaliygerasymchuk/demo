package com.vh.demo.ui.abs

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class AbsBindingActivity<V : ViewBinding>(factory: (LayoutInflater) -> V) :
    AppCompatActivity() {

    protected val binding: V by lazy { factory(layoutInflater) }

    abstract fun onInitViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onInitViews()
    }
}