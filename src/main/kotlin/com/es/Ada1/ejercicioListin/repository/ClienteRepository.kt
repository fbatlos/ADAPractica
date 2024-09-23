package com.es.Ada1.ejercicioListin.repository

import com.es.Ada1.ejercicioListin.model.Cliente
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

class GestionTelefono() {

    private val destino =
        Path.of("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\kotlin\\com\\es\\Ada1\\ejercicioListin\\Telefono\\listin.txt")


    fun FindCliente(nombre: String) {


    }

    fun AddCliente(nombre: String, telefono: String): Cliente? {

        if (Files.notExists(destino)) {

            Files.createDirectories(destino.parent)

            Files.createFile(destino)

        }

        val br: BufferedReader = Files.newBufferedReader(destino)
        var existe = false

        br.use {
            it.forEachLine { line ->
                if (line.isNotBlank()) {
                    val nombreSpliteada = line.split(",")
                    if (nombreSpliteada[1].equals(telefono)) {
                        existe = true
                    }
                }
            }

            if (existe) {
                return null
            } else {

                //Sino existe debemos añadir el telefono al cliente
                val bw: BufferedWriter = Files.newBufferedWriter(destino,StandardOpenOption.APPEND)
                //escribimos el telefono y el nombre
                bw.use {
                    it.newLine()
                    it.append("${nombre},${telefono}")
                    /*
                val fileWrite = File(destino.toString())

                fileWrite.appendText("${nombre},${telefono}")
                */
                }

                return Cliente(nombre, telefono)
            }
        }

        fun RevokeCliente(telefonos: String): Boolean {
            return true
        }
    }
}