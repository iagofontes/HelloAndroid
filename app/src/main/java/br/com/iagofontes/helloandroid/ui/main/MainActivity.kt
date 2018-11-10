package br.com.iagofontes.helloandroid.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.iagofontes.helloandroid.R
import br.com.iagofontes.helloandroid.model.Pedido
import br.com.iagofontes.helloandroid.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel::class.java)

        val nome = intent.getStringExtra("nome")
        val telefone = intent.getStringExtra("telefone")

        mainViewModel.nomeCliente = intent.getStringExtra("nome")
        mainViewModel.telefoneCliente = intent.getStringExtra("telefone")

        tvNome.text = getString(R.string.saudacao, mainViewModel.nomeCliente, mainViewModel.telefoneCliente)

        cbAtum.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.atumSelecionado = isChecked
        }

        cbBacon.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.baconSelecionado = isChecked
        }

        cbCalabresa.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.calabresaSelecionado = isChecked
        }

        cbMussarela.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.mussarelaSelecionado = isChecked
        }

        cbAtum.isChecked = mainViewModel.atumSelecionado
        cbBacon.isChecked = mainViewModel.baconSelecionado
        cbCalabresa.isChecked = mainViewModel.calabresaSelecionado
        cbMussarela.isChecked = mainViewModel.mussarelaSelecionado

        btnCalcular.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("pedido", gerarPedido())
            startActivity(intent)
        }

    }

    private fun gerarPedido(): Pedido {
        return Pedido(
                mainViewModel.nomeCliente,
                mainViewModel.telefoneCliente
        )
    }

}
