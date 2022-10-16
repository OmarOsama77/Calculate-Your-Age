package com.example.calculate

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
   private var tvselecteddatee : TextView ?=null
    private var tvageinmin : TextView ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvselecteddatee = findViewById(R.id.tvselecteddate)
        tvageinmin = findViewById(R.id.tvageinmin)








        val bdatepicker : Button = findViewById(R.id.firstbutton)
        bdatepicker.setOnClickListener {

            clickdatepicker()



        }


    }
fun clickdatepicker(){
     val mycalender = Calendar.getInstance()
     val year = mycalender.get(Calendar.YEAR)
     val month =mycalender.get(Calendar.MONTH)
     val day =mycalender.get(Calendar.DAY_OF_MONTH)
    DatePickerDialog(this ,
    DatePickerDialog.OnDateSetListener
      {View , selectedyear , selectedmonth , selectedday ->

        Toast.makeText(
            applicationContext,
            "year was $selectedyear,month was ${selectedmonth+1},day was $selectedday ", Toast.LENGTH_LONG).show()
          val selectedddate = "$selectedday/${selectedmonth+1}/$selectedyear"
          tvselecteddatee?.setText(selectedddate)
          val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
          val  theDate =sdf.parse(selectedddate)
          val selecteddateinminutes = theDate.time / 6000
          val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
          val currentdateinmin=currentDate.time/6000
          val diffrenceinmi= currentdateinmin - selecteddateinminutes
           tvageinmin?.text = diffrenceinmi.toString()
      }, year,
        month,
        day).show()


}



}