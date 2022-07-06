package com.emanuel.loginandroidbasico

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.emanuel.loginandroidbasico.model.Usuario

class InicioActivity : AppCompatActivity() {
    private var tv_nombre: TextView? = null
    private var tv_nombre_completo: TextView? = null
    private var tv_correo: TextView? = null
    private var objUsuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        ini()
        cargarDatos()
    }

    fun ini() {
        tv_nombre = findViewById<View>(R.id.tv_nombre) as TextView
        tv_nombre_completo = findViewById<View>(R.id.tv_nombre_completo) as TextView
        tv_correo = findViewById<View>(R.id.tv_correo) as TextView
    }

    fun cargarDatos() {
        objUsuario = intent.getSerializableExtra("Usuario") as Usuario?
        tv_nombre!!.text = objUsuario!!.nombre
        tv_nombre_completo!!.text = objUsuario!!.nombre + " " + objUsuario!!.apellido
        tv_correo!!.text = objUsuario!!.correo
    }
}