package com.emanuel.loginandroidbasico

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emanuel.loginandroidbasico.model.Usuario

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var et_correo: EditText? = null
    private var et_contrasena: EditText? = null
    private var bt_iniciar_sesion: Button? = null
    private var listaUsuario: ArrayList<Usuario>? = null
    private var objUsuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        ini()
    }

    fun ini() {
        et_correo = findViewById<View>(R.id.et_correo) as EditText
        et_contrasena = findViewById<View>(R.id.et_contrasena) as EditText
        bt_iniciar_sesion = findViewById<View>(R.id.bt_iniciar_sesion) as Button
        bt_iniciar_sesion!!.setOnClickListener(this)
    }

    private fun llenarUsuarios() {
        listaUsuario = ArrayList()
        listaUsuario!!.add(Usuario("Jose", "Gomez", "josegomez70@gmail.com", "123456"))
        listaUsuario!!.add(Usuario("Eduardo", "Davalos", "BaboDavalosC@santa.org", "123456"))
        listaUsuario!!.add(Usuario("Mary", "Juana", "MaryjuanaLazy@cbd.com", "654321"))
        listaUsuario!!.add(Usuario("Emanuel", "Gonzalez", "eGonzalezF@hotmail.com", "653821"))
    }

    private fun agregarUsuario(){

    }

    private fun iniciarSesion() {
        llenarUsuarios()
        val correo = et_correo!!.text.toString()
        val contrasena = et_contrasena!!.text.toString()
        var usuarioEncotrado = false
        for (i in listaUsuario!!.indices) {
            if (correo == listaUsuario!![i].correo && contrasena == listaUsuario!![i].contraseña) {
                Toast.makeText(this, "Bienvenido " + listaUsuario!![i].nombre, Toast.LENGTH_SHORT)
                    .show()
                usuarioEncotrado = true
                val inicio = Intent(this@MainActivity, InicioActivity::class.java)
                objUsuario = listaUsuario!![i]
                inicio.putExtra("Usuario", objUsuario)
                startActivity(inicio)
            } else if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Los campos estan llenos", Toast.LENGTH_SHORT).show()
            }
        }
        if (!usuarioEncotrado) {
            Toast.makeText(
                this,
                "Correo o contraseña incorrectos, intentelo de nuevo",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.bt_iniciar_sesion) {
            iniciarSesion()
        }
    }
}