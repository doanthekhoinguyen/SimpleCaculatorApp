package com.KN.caculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.KN.caculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClear.setOnClickListener {
            binding.input.text=""
            binding.output.text=""
        }
        binding.btnBracketLeft.setOnClickListener {
            binding.input.text = addtoInputText("(")
        }
        binding.btnBracketRight.setOnClickListener {
            binding.input.text = addtoInputText(")")
        }
        binding.btn0.setOnClickListener {
            binding.input.text = addtoInputText("1")
        }
        binding.btn1.setOnClickListener {
            binding.input.text = addtoInputText("1")
        }
        binding.btn2.setOnClickListener {
            binding.input.text = addtoInputText("2")
        }
        binding.btn3.setOnClickListener {
            binding.input.text = addtoInputText("3")
        }
        binding.btn4.setOnClickListener {
            binding.input.text = addtoInputText("4")
        }
        binding.btn5.setOnClickListener {
            binding.input.text = addtoInputText("5")
        }
        binding.btn6.setOnClickListener {
            binding.input.text = addtoInputText("6")
        }
        binding.btn7.setOnClickListener {
            binding.input.text = addtoInputText("7")
        }
        binding.btn8.setOnClickListener {
            binding.input.text = addtoInputText("8")
        }
        binding.btn9.setOnClickListener {
            binding.input.text = addtoInputText("9")
        }
        binding.btnDot.setOnClickListener {
            binding.input.text = addtoInputText(".")
        }
        binding.btnDiv.setOnClickListener {
            binding.input.text = addtoInputText("÷")
        }
        binding.btnSub.setOnClickListener {
            binding.input.text = addtoInputText("-")
        }
        binding.btnAdd.setOnClickListener {
            binding.input.text = addtoInputText("+")
        }
        binding.btnEqual.setOnClickListener {
            showResult()
        }
        binding.btnMultiply.setOnClickListener {
            binding.input.text = addtoInputText("×")
        }

    }
    private fun addtoInputText(buttonValue:String):String{
        return "${binding.input.text}$buttonValue"
    }
    private fun getInputExpression(): String {
        var expression = binding.input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }
    private fun showResult(){
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // hien thi loi
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.Red))
            } else {
                // hien thi ket qua
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.Green))
            }
        }
        catch (e: Exception) {
            //
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.Red))
        }
    }
}