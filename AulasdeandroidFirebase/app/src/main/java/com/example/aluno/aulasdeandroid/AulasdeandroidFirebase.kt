package com.eteczl.aulasdeandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AulasdeandroidFirebase : AppCompatActivity() {

        lateinit var btnSignUp:Button
        lateinit var btnLogin:Button
    lateinit var lbEmailDoUsuarioLogado: TextView
    lateinit var fbAuth: FirebaseAuth
    lateinit var txtEmail: EditText
    lateinit var txtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aulasdeandroid_firebase)

        this.lbEmailDoUsuarioLogado = findViewById<TextView>(R.id.lbEmailDoUsuarioLogado);
        this.fbAuth = FirebaseAuth.getInstance()
        this.txtEmail = findViewById<EditText>(R.id.txtEmail);
        this.txtPasss = findViewById<EditText>(R.id.txtPassw);
        this.btnSignUp = findViewById<Button>(R.id.btnSingUp);
        this.btnLogin = findViewById<Button>(R.id.btnLogin);

        // [START on_start_check_user]

        public override fun onStart(){
            super.onStart()
            val currentUser = this.fbAuth.currentUser
            updateUI(currentUser)
        }

        private fun updateUI(User: FirebaseUser?){

            if (user!=null){
                this.lbEmailDoUsuarioLogado.text = user.email
            } else{
                this.lbEmailDoUsuarioLogado.text = "Nenhum user Logado"
            }

        }

            private fun signUp(){
                this.fbAuth.createUserWhithEmailAndPassword(this.txtEmail, this.txtPass)
                        .addOnCompleteListener(this) {task ->
                            if (task.isSuccessful){
                                log.d(TAG,"createUserWithEmail:success")
                                val user = auth.currentUser
                                updateUI(user)

                            }else{
                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                                updateUI(null)
                            }
                        }
            }


    }
}
