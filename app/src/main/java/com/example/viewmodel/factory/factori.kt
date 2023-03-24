package com.example.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.viewModel.provideData

class factori(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(provideData::class.java)){
            return super.create(modelClass)
        }
        throw IllegalArgumentException("Unknown viewmodel class")

    }
}