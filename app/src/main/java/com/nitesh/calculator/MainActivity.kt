package com.nitesh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOne.setOnClickListener { appendonExpression(string = "1",canClear = true) }
        tvTwo.setOnClickListener { appendonExpression(string = "2",canClear = true) }
        tvThree.setOnClickListener { appendonExpression(string = "3",canClear = true) }
        tvFour.setOnClickListener { appendonExpression(string = "4",canClear = true) }
        tvFive.setOnClickListener { appendonExpression(string = "5",canClear = true) }
        tvSix.setOnClickListener { appendonExpression(string = "6",canClear = true) }
        tvSeven.setOnClickListener { appendonExpression(string = "7",canClear = true) }
        tvEight.setOnClickListener { appendonExpression(string = "8",canClear = true) }
        tvNine.setOnClickListener { appendonExpression(string = "9",canClear = true) }
        tvZero.setOnClickListener { appendonExpression(string = "0",canClear = true) }
        tvDot.setOnClickListener { appendonExpression(string = ".",canClear = true) }

        tvPlus.setOnClickListener { appendonExpression(string = "+",canClear = false) }
        tvMinus.setOnClickListener { appendonExpression(string = "-",canClear = false) }
        tvMul.setOnClickListener { appendonExpression(string = "*",canClear = false) }
        tvDivide.setOnClickListener { appendonExpression(string = "/",canClear = false) }
        tvOpen.setOnClickListener { appendonExpression(string = "(",canClear = false) }
        tvClose.setOnClickListener { appendonExpression(string = ")",canClear = false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }

            tvEquals.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                    val result = expression.evaluate()
                    val longresult = result.toLong()
                    if (result == longresult.toDouble())
                        tvResult.text = longresult.toString()
                    else
                        tvResult.text = result.toString()


                }catch (e:Exception){
                    Log.d("Exception","message : " + e.message )

                }
            }
    }

    fun appendonExpression( string: String, canClear :Boolean ) {

        if(canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}
