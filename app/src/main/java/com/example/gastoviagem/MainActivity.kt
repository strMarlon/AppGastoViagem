package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calcular) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomia.text.toString() != ""
                && binding.editAutonomia.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        // Toast notification
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPreco.text.toString().toFloat()
            val autonomy = binding.editAutonomia.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textValorTotal.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this,R.string.Validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }

}
