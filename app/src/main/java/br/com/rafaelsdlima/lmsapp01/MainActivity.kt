package br.com.rafaelsdlima.lmsapp01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imageView.setImageResource(R.drawable.androide) //encontra imagem por id
        mensagemInicial.text = "Bem vindo ao GAPARAWA"

//        botao_login.setOnClickListener {
//            val textoUsuario = campo_usuario.text.toString()
//            Toast.makeText (this,
//                "Clicou no botão: $textoUsuario",
//                Toast.LENGTH_SHORT
//            ).show()

//            var intent = Intent(this, TelaInicialActivity::class.java)

//            var param = Bundle()
//            param.putString("nome_usuario", textoUsuario)
//            param.putInt("numero", 10)
//            param.putIntegerArrayList("array_nros", arrayListOf(1,2,3,4))

//            intent.putExtras(param)

//            intent.putExtra("outro numero", 20)

//            startActivity(intent)

// segunda forma: delegar para método

        botao_login.setOnClickListener{onClickLogin() }
    }

    fun onClickLogin(){
            //val valorUsuario = campo_usuario.text.toString()
            //val valorSenha = campo_senha.text.toString()
            //Toast.makeText(this, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()

            var intent = Intent(this, TelaInicialActivity::class.java)
                if (campo_usuario.text.toString() == "aluno" && campo_senha.text.toString() == "impacta"){
                    intent.putExtra("result", getString(R.string.login_OK))
                }
                else
                    intent.putExtra("result", getString(R.string.login_ERR))

            var param = Bundle()
            param.putString("nome_usuario", "Rafael de Sales")
            param.putInt("numero", 10)
            intent.putExtras(param)

            startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        ///}
    ///}
}}}

