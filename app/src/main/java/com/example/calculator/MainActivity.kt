package com.example.calculator


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.text.method.ScrollingMovementMethod
import android.util.TypedValue
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

import androidx.core.content.ContextCompat


import soup.neumorphism.NeumorphButton
import soup.neumorphism.NeumorphCardView

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {

 
    lateinit var add: NeumorphButton
    lateinit var c: NeumorphButton
    lateinit var mul: NeumorphButton
    lateinit var div: NeumorphButton
    lateinit var min: NeumorphButton
    lateinit var dot: NeumorphButton
    lateinit var equal: NeumorphButton
    lateinit var bracket: NeumorphButton
    lateinit var bracketwithmin: NeumorphButton
    lateinit var backspace: NeumorphCardView
    lateinit var b0: NeumorphButton
    lateinit var b1: NeumorphButton
    lateinit var b2: NeumorphButton
    lateinit var b3: NeumorphButton
    lateinit var b4: NeumorphButton
    lateinit var b5: NeumorphButton
    lateinit var b6: NeumorphButton
    lateinit var b7: NeumorphButton
    lateinit var b8: NeumorphButton
    lateinit var b9: NeumorphButton
    lateinit var inputtxt : TextView
    lateinit var resulttxt :TextView
    var check =0

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val w: Window = this.getWindow()

        if(resources.configuration.isNightModeActive){
                        setContentView(R.layout.activity_main_night)
            w.setStatusBarColor(ContextCompat.getColor(this,R.color.dback))

        }else{
            setContentView(R.layout.activity_main)
            w.setStatusBarColor(ContextCompat.getColor(this,R.color.status))

            w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        }






        supportActionBar?.hide()


        add = findViewById(R.id.add)
        min = findViewById(R.id.min)
        mul = findViewById(R.id.mul)
        dot = findViewById(R.id.dot)
        div  = findViewById(R.id.div)
        c  = findViewById(R.id.c)
        equal = findViewById(R.id.equal)
        backspace = findViewById(R.id.backspace)
        bracket = findViewById(R.id.bracket)
        bracketwithmin = findViewById(R.id.bracketwithmin)
        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4  = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8  = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        inputtxt = findViewById(R.id.inputtxt)
        resulttxt = findViewById(R.id.inputoutput)
        inputtxt.movementMethod = ScrollingMovementMethod()
        inputtxt.setActivated(true)
        inputtxt.setPressed(true)
        
    var text: String

    b0.setOnClickListener {
        text = inputtxt.text.toString()+"0"
        inputtxt.setText(text)
        result(text)

    }
        b1.setOnClickListener {
            text = inputtxt.text.toString()+"1"
            inputtxt.setText(text)
            result(text)

        }
        b2.setOnClickListener {
            text = inputtxt.text.toString()+"2"
            inputtxt.setText(text)
            result(text)

        }
        b3.setOnClickListener {
            text = inputtxt.text.toString()+"3"
            inputtxt.setText(text)
            result(text)

        }
        b4.setOnClickListener {
            text = inputtxt.text.toString()+"4"
            inputtxt.setText(text)
            result(text)

        }
        b5.setOnClickListener {
            text = inputtxt.text.toString()+"5"
            inputtxt.setText(text)
            result(text)

        }
        b6.setOnClickListener {
            text = inputtxt.text.toString()+"6"
            inputtxt.setText(text)
            result(text)

        }
        b7.setOnClickListener {
            text = inputtxt.text.toString()+"7"
            inputtxt.setText(text)
            result(text)

        }
        b8.setOnClickListener {
            text = inputtxt.text.toString()+"8"
            inputtxt.setText(text)
            result(text)

        }
        b9.setOnClickListener {
            text = inputtxt.text.toString()+"9"
            inputtxt.setText(text)
            result(text)

        }

        dot.setOnClickListener {
            text = inputtxt.text.toString()+"."
            inputtxt.setText(text)
            result(text)

        }
        c.setOnClickListener {
            resulttxt.setText(null)
            inputtxt.setText(null)
        }

        add.setOnClickListener {
            text = inputtxt.text.toString()+"+"
            inputtxt.setText(text)
            check = check+1

        }

        mul.setOnClickListener {
            text = inputtxt.text.toString()+"*"
            inputtxt.setText(text)
            check = check+1

        }

        div.setOnClickListener {
            text = inputtxt.text.toString()+"/"
            inputtxt.setText(text)
            check = check+1

        }

        min.setOnClickListener {
            text = inputtxt.text.toString()+"-"
            inputtxt.setText(text)
            check = check+1
        }
        bracket.setOnClickListener {
            text = inputtxt.text.toString()+"("
            inputtxt.setText(text)
            result(text)

        }
        bracket.setOnLongClickListener {
            text = inputtxt.text.toString()+")"
            inputtxt.setText(text)
            result(text)
            result(text)

            true
        }
        bracketwithmin.setOnClickListener {
            text = inputtxt.text.toString()+"(-"
            inputtxt.setText(text)
            result(text)
        }

        equal.setOnClickListener {
            text= resulttxt.text.toString()
            inputtxt.setText(text)
            resulttxt.setText(null)
        }

        backspace.setOnClickListener {
            var back:String
            if(inputtxt.text.length>0){
                val stringbuilder:StringBuilder = StringBuilder(inputtxt.text)
                val find = inputtxt.text.toString()
                val find2 = find.last()

                if(find2.equals('+')||find2.equals('*')||find2.equals('-')||find2.equals('/')){
                    check=check-1
                }
                stringbuilder.deleteCharAt(inputtxt.text.length-1)
                back=stringbuilder.toString()
                inputtxt.setText(back)
                result(back)
            }

        }


    }


private fun result(text:String){
    val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
    try{

        val r :Any=engine.eval(text)
        var main = r.toString()

        if(check==0){
            resulttxt.setText(null)
        }else{

            if(resulttxt.text.length>12||inputtxt.text.length>12){
                resulttxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50F)
                inputtxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30F)

            }
            resulttxt.setText(main)
        }


    }
    catch(e:Exception){
//        Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
    }

}





}

