package com.geeks.mvvm15_1j.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geeks.mvvm15_1j.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}