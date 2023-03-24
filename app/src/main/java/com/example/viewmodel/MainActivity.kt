package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isNotEmpty
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding
import com.example.viewmodel.factory.factori
import com.example.viewmodel.viewModel.provideData

class MainActivity : AppCompatActivity() {

    lateinit var dataBind : ActivityMainBinding
    lateinit var view_model : provideData
    lateinit var factori : factori

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBind = DataBindingUtil.setContentView(this,R.layout.activity_main)
        factori = factori()
        view_model = ViewModelProvider(this, factori)[provideData::class.java]

        dataBind.lifecycleOwner= this

        dataBind.btn.setOnClickListener{
            if (dataBind.number.isNotEmpty())
            {
                val sum = view_model.data.toInt()+(dataBind.number.editText!!.text.toString()).toInt()
                dataBind.sum.text=sum.toString()

            }
        }
    }
}