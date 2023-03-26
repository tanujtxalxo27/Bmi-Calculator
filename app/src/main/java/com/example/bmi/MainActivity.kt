package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            if ( !editWeight.text.toString().equals("") && !editWeight.text.toString().equals("")
                            && !editHeightIn.text.toString().equals("") ) {
                        val wt = (editWeight.text.toString().toDouble())
                        val htFeet = (editHeightFt.text.toString()).toDouble()
                        val htInch = (editHeightIn.text.toString()).toDouble()

                        val totalInch = htFeet*12 + htInch
                        val totalCM = totalInch *2.54

                        val totalM = totalCM/100

                        val bmi = wt/(totalM*totalM)

                        txtTitle.text="Your BMI"
                        txtResult.text="${bmi.toInt()}"


                when {
                    bmi>25 -> {
                        Toast.makeText( this@MainActivity,R.string.strOverWt, Toast.LENGTH_LONG).show();

                        txtMsg.text=resources.getString(R.string.strOverWt)
                        llMain.setBackgroundColor(resources.getColor(R.color.Green))

                    }
                    bmi<18 -> {
                        Toast.makeText( this@MainActivity,R.string.strUnderWt, Toast.LENGTH_LONG).show();

                        txtMsg.text=resources.getString(R.string.strUnderWt)
                        llMain.setBackgroundColor(resources.getColor(R.color.Yellow))

                    }
                    else -> {
                        Toast.makeText(this@MainActivity,R.string.strHealthy,Toast.LENGTH_LONG).show()
                        txtMsg.text=resources.getString(R.string.strHealthy)
                        llMain.setBackgroundColor(resources.getColor(R.color.teal_200))
                    }
                }
            }else {
                        Toast.makeText(this@MainActivity,"Please fill up to all the requriment",Toast.LENGTH_LONG).show();
                    }
                }
            }
        }



