package com.example.tanyongrui.basicmovie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.tanyongrui.basicmovie.R.id.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBoxSuitable.setOnClickListener {
            if (checkBoxSuitable.isChecked == true) {
                //tvMyTextDisplay.text = "CheckBox has been checked@@@"
                checkBoxViolence.setVisibility(View.VISIBLE)
                checkBoxLanguageUsed.setVisibility(View.VISIBLE)
            } else {
                //tvMyTextDisplay.text = "CheckBox has unchecked!!!!"
                checkBoxViolence.setVisibility(View.GONE)
                checkBoxLanguageUsed.setVisibility(View.GONE)
                checkBoxViolence.isChecked = false
                checkBoxLanguageUsed.isChecked = false
            }
        }

        /*radioGroupLanguage.setOnCheckedChangeListener { group, checkedId ->
            //val radio:RadioButton = findViewById(checkedId)
            //radio.setError(null) //this only removes error if clicked radio btn 4, since error is on btn4
            rbtnButton4.setError(null)
        } */
        radioGroupLanguage.setOnCheckedChangeListener() { radioGroup: RadioGroup, i: Int ->
            rbtnButton4.setError(null) //remove error that was set once clicked on any other radio
        }

    }

    fun checkBoxViolenceValiation(): String {
        var checkboxViolenceText = ""
        //var checkYes = checkBoxViolence.isChecked()
        if (checkBoxViolence.isChecked()) {
            checkboxViolenceText = "\n " + checkBoxViolence.text.toString()
        }
        Log.d("checkyestag","checkyes value log print is " + checkboxViolenceText)
        println("hello this printlnss is working!!! ")
        //System.out.printf("hello this system println ")
        return checkboxViolenceText
    }
    fun checkBoxLanguageValidation() : String {
        var checkBoxLanguageText = ""
        if (checkBoxLanguageUsed.isChecked()) {
            checkBoxLanguageText = "\n " + checkBoxLanguageUsed.text.toString()
        }
        return checkBoxLanguageText
    }

    fun checkSuitableValidation() : String {
        var checkSuitableToast = ""
        var suitableIsChecked = false;
        // practical assignment logic wrong, if not suitable for all audience,
        // means toast should display suitable for all ages = false instead..
        if (!checkBoxSuitable.isChecked()) {
            suitableIsChecked = true;
        }
        if (!suitableIsChecked) {
            if (!checkBoxViolence.isChecked && !checkBoxLanguageUsed.isChecked) {
                checkSuitableToast = "Suitable for all ages = " + suitableIsChecked
            }
            else {
                checkSuitableToast = "Suitable for all ages = " + suitableIsChecked + "\n Reason:"
            }
        }
        else{
            checkSuitableToast = "Suitable for all ages = " + suitableIsChecked
        }

        return checkSuitableToast
    }
    fun getRadioButtonText() : String {
        var radioButtonText = ""
        var radioButtonId: Int = radioGroupLanguage.checkedRadioButtonId
        Log.e("radio button id " , radioButtonId.toString())
        val radio:RadioButton = findViewById(radioButtonId)
        radioButtonText = radio.text.toString()

        return radioButtonText
    }
    
    fun btnValidate(v: View) {
        var statusOfValidation = validationDone() //validate all fields empty/no
        System.out.println("validation done fail/pass " + statusOfValidation)
        if (statusOfValidation) {
            var checkBoxVio = checkBoxViolenceValiation()
            var checkBoxLanguage = checkBoxLanguageValidation()
            var checkSuitableToast = checkSuitableValidation()
            var radioButtonText = getRadioButtonText()

            Toast.makeText(
                    this," Title = " + nameOfMovie.text +
                        "\n Overview = " + description.text +
                        "\n Release date = " + releaseDate.text +
                        "\n Language = " + radioButtonText +
                        "\n " + checkSuitableToast +
                        checkBoxVio + checkBoxLanguage, Toast.LENGTH_LONG
            ).show()
        }

    } // end of btnvalidate method

    private fun validationDone(): Boolean {
        var statusOfValidation = true;
        val list = mutableListOf(nameOfMovie,description, releaseDate)
        Log.d("validating list", " list is " + list)
        Log.d("length of list", "length/size = " + list.size)
        for (i in 0..list.size-1) {
            System.out.println("list i val " + i + " value = " + list[i])
            System.out.println("text values in list : " + list[i].text)
            if (list[i].text.toString() == "") {
                System.out.println("list[i] is empty !!! " + list[i].text)
                statusOfValidation = false
                list[i].setError("Field empty")
            }
        }
        if (radioGroupLanguage.checkedRadioButtonId == -1) {
            statusOfValidation = false
            rbtnButton4.setError("radio empty")
        }
        return statusOfValidation
    }

}
