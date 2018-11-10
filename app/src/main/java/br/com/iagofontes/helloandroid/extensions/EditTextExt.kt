package br.com.iagofontes.helloandroid.extensions

import android.widget.EditText

fun EditText.value() = this.text.toString()