package jp.techacademy.yoshihisa.wada.calcapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import java.text.DecimalFormat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val format1 = DecimalFormat("0.######")
        val val1 = intent.getDoubleExtra("VALUE1", 0.0)

        textView.text = format1.format(val1).toString()

    }
}