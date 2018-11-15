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
            }
        }

        /*radioGroupLanguage.setOnCheckedChangeListener { group, checkedId ->
            //val radio:RadioButton = findViewById(checkedId)
            //radio.setError(null) //this only removes error if clicked radio btn 4, since error is on btn4
            rbtnButton4.setError(null)
        } */
        radioGroupLanguage.setOnCheckedChangeListener() { radioGroup: RadioGroup, i: Int ->
            rbtnButton4.setError(null)
        }

    }

    fun checkYesOrNo(): String {
        var checkYes = ""
        //var checkYes = checkBoxViolence.isChecked()
        if (checkBoxViolence.isChecked()) {
            checkYes = "\n " + checkBoxViolence.text.toString()
        }
        else{
            checkYes == ""

        }
        Log.d("checkyestag","checkyes value log print is " + checkYes)
        println("hello this printlnss is working!!! ")
        //System.out.printf("hello this system println ")
        return checkYes
    }
    fun checkBoxValidation() : String {
        var checkBoxLanguage = ""
        if (checkBoxLanguageUsed.isChecked()) {
            checkBoxLanguage = "\n " + checkBoxLanguageUsed.text.toString()
        }
        else{
            checkBoxLanguage == ""
        }
        return checkBoxLanguage
    }

    fun checkSuitableValidation() : Boolean {
        var suitableIsChecked = true;
        if (!checkBoxSuitable.isChecked()) {
            suitableIsChecked = false;
        }
        return suitableIsChecked
    }
    fun getRadioButtonText() : String {
        var radioButtonText: String = ""
        var radioButtonId: Int = radioGroupLanguage.checkedRadioButtonId
        Log.e("radio button id " , radioButtonId.toString())
        val radio:RadioButton = findViewById(radioButtonId)
        radioButtonText = radio.text.toString()

        return radioButtonText
    }
    fun btnValidate(v: View) {
        var statusOfValidation = validationDone()
        System.out.println("validation done fail/pass " + statusOfValidation)
        if (statusOfValidation) {
            //var editTextNumber: Int = etNumBiggerThan25.text.toString().toInt()
            //var checkBoxVio:String = checkBoxViolence.text.toString()
            var checkBoxVio: String = checkYesOrNo()
            var checkBoxLanguage: String = checkBoxValidation()
            var checkSuitable: Boolean = checkSuitableValidation()
            var checkSuitableToast: String = ""
            var radioButtonText = getRadioButtonText()

            if (checkSuitable) {
                checkSuitableToast = "Suitable for all ages = " + checkSuitable + "\n Reason:"
            }
            else{
                checkSuitableToast = "Suitable for all ages = " + checkSuitable
            }
            Toast.makeText(
                    this," Title = " + etNumBiggerThan25.text +
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
        val list = mutableListOf(etNumBiggerThan25,description, releaseDate)
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
