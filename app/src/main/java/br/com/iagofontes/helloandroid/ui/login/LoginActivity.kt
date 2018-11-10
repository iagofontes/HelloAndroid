package br.com.iagofontes.helloandroid.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.iagofontes.helloandroid.R
import br.com.iagofontes.helloandroid.extensions.value
import br.com.iagofontes.helloandroid.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnFazerPedido.setOnClickListener {
            fazerPedido()
        }

    }

    private fun fazerPedido() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("nome", this.inputNome.value())
        intent.putExtra("telefone", this.inputTelefone.value())
        startActivity(intent)
    }

}
