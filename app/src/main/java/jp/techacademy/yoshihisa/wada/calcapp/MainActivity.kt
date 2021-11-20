package jp.techacademy.yoshihisa.wada.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (editText1.text.isNullOrEmpty() || editText2.text.isNullOrEmpty()) {
            showAlertDialog()
        } else {
            when (v.id) {
                R.id.button1 -> showAdd()
                R.id.button2 -> showSubtract()
                R.id.button3 -> showMultiplication()
                R.id.button4 -> showDivision()
            }
        }
    }

    private fun showAdd() {
        val intent = Intent(this, SecondActivity::class.java)
        val val1 = editText1.text.toString().toDouble() + editText2.text.toString().toDouble()
        intent.putExtra("VALUE1", val1)
        startActivity(intent)

    }
    private fun showSubtract() {
        val intent = Intent(this, SecondActivity::class.java)
        val val1 = editText1.text.toString().toDouble() - editText2.text.toString().toDouble()
        intent.putExtra("VALUE1", val1)
        startActivity(intent)
    }
    private fun showMultiplication() {
        val intent = Intent(this, SecondActivity::class.java)
        val val1 = editText1.text.toString().toDouble() * editText2.text.toString().toDouble()
        intent.putExtra("VALUE1", val1)
        startActivity(intent)
    }
    private fun showDivision() {
        val intent = Intent(this, SecondActivity::class.java)
        if (editText1.text.toString().toDouble() > 0 && editText2.text.toString().toDouble() > 0 ) {
            val val1 = editText1.text.toString().toDouble() / editText2.text.toString().toDouble()
            intent.putExtra("VALUE1", val1)
        } else {
            intent.putExtra("VALUE1", 0)
        }
        startActivity(intent)
    }
    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("エラー")
        alertDialogBuilder.setMessage("数値を入力して下さい")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->

        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}