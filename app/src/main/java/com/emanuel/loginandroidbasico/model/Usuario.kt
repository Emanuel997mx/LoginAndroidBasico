package com.emanuel.loginandroidbasico.model

import java.io.Serializable

class Usuario : Serializable {
    var nombre: String? = null
    var apellido: String? = null
    var correo: String? = null
    var contraseña: String? = null

    constructor() {}
    constructor(nombre: String?, apellido: String?, correo: String?, contraseña: String?) {
        this.nombre = nombre
        this.apellido = apellido
        this.correo = correo
        this.contraseña = contraseña
    }
}