package com.example.blagostroy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.math.ceil
import com.example.blagostroy.databinding.FragmentCalcBinding

class CalcFragment : Fragment() {
    lateinit var bindingCalc: FragmentCalcBinding
    private val nameList = mutableListOf<String>()
    private val countList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingCalc = FragmentCalcBinding.inflate(inflater)
        return bindingCalc.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickCalc()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CalcFragment()
    }

    fun onClickCalc(){
        bindingCalc.buttonCalculate.setOnClickListener {
            val countM2Text = bindingCalc.editTextM2.text.toString()
            val sizeObjectText = bindingCalc.editTextSize.text.toString()

            val countM2 = countM2Text.toDoubleOrNull()
            val sizeObject = sizeObjectText.toDoubleOrNull()

            if (countM2 != null && sizeObject != null) {
                val result = ceil(sizeObject / countM2).toInt()
                bindingCalc.tvResult.text = "Количество пачек - ${result.toString()}"
            } else {
                bindingCalc.tvResult.text = "Ошибка ввода"
            }
        }
    }
}