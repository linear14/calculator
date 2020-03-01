package com.dongldh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number = ""     // 숫자 버튼 누르면 문자열에 계속 추가됨
    var input = 0       // 그 문자열을 숫자로 변환 (계산될 값)
    var resultNum = 0   // 결과 값 저장
    var sign = ""
    var count = 0       // cal버튼 누르지 않고 계속 연산하는 횟수 체크
    var isLastNumber: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 숫자 버튼 눌렀을 경우

        num1.setOnClickListener() {
            number += "1"
            updateInput()
        }

        num2.setOnClickListener() {
            number += "2"
            updateInput()
        }

        num3.setOnClickListener() {
            number += "3"
            updateInput()
        }

        num4.setOnClickListener() {
            number += "4"
            updateInput()
        }

        num5.setOnClickListener() {
            number += "5"
            updateInput()
        }

        num6.setOnClickListener() {
            number += "6"
            updateInput()
        }

        num7.setOnClickListener() {
            number += "7"
            updateInput()
        }

        num8.setOnClickListener() {
            number += "8"
            updateInput()
        }

        num9.setOnClickListener() {
            number += "9"
            updateInput()
        }

        num0.setOnClickListener() {
            if (!number.isBlank()) {
                number += "0"
                updateInput()
            }
        }


        // 연산 부호 버튼 눌렀을 경우

        plusButton.setOnClickListener() {
            if(isLastNumber) signCalculate()
            sign = "+"
            signLabel.text = "+"
        }

        minusButton.setOnClickListener() {
            if(isLastNumber) signCalculate()
            sign = "-"
            signLabel.text = "-"
        }

        mulButton.setOnClickListener() {
            if(isLastNumber) signCalculate()
            sign = "*"
            signLabel.text = "*"
        }

        divButton.setOnClickListener() {
            if(isLastNumber) signCalculate()
            sign = "/"
            signLabel.text = "/"
        }

        calButton.setOnClickListener() {
            if (!sign.isBlank()) {
                calculate()
                count = 0
                number = ""
                signLabel.text = ""
                inputLabel.text = "0"
                sign = ""
            }
        }


        // 초기화 버튼
        resetButton.setOnClickListener() {
            number = ""
            resultNum = 0
            input = 0
            sign = ""
            inputLabel.text = "0"
            resultLabel.text = "0"
            signLabel.text = sign
        }

        // 지우기 버튼
        delButton.setOnClickListener() {
            when {
                number.length == 1 -> {
                    number = ""
                    input = 0
                    inputLabel.text = "0"
                }

                !number.isBlank() -> {
                    number = number.substring(0, number.length - 1)
                    updateInput()
                }
            }
        }

        // 계산기 종료 버튼
        exitButton.setOnClickListener() {
            finish()
        }
    }

    fun updateInput() {
        input = number.toInt()
        inputLabel.text = number
        isLastNumber = true
    }

    fun calculate() {
        when (sign) {
            "+" -> {
                resultNum += input
            }
            "-" -> {
                resultNum -= input
            }
            "*" -> {
                resultNum *= input
            }
            "/" -> {
                resultNum /= input
            }
        }
        resultLabel.text = resultNum.toString()
    }

    fun signCalculate(){
        if(resultNum == 0) {
            resultNum = input
        } else {
            calculate()
        }
        count++
        number = ""
        isLastNumber = false
    }
}
