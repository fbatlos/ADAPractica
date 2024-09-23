package com.es.Ada1

import java.io.BufferedReader
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path

fun main() {
    //buffers de lectura hay que crear un flujo

    val filePruebaBf = java.nio.file.Path.of("src\\main\\kotlin\\carpetaPrueba\\papapa.txt")

    val br:BufferedReader = Files.newBufferedReader(filePruebaBf)

    //ya hemos abierto el flujo de lectura , ahora podemos consumirlo

    br.forEachLine { line -> println(line) }

    //importante cerrar los flujos
    br.close()

    //.use se lo recorre aun con excepciones y 100% lo cierra
  /*  br.use { flujo -> flujo.forEachLine {
        println(it)
    } }*/

    val filePruebaBf2 = java.nio.file.Path.of("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\kotlin\\carpetaPrueba\\prueba2.txt")

    val bw = Files.newBufferedWriter(filePruebaBf2)

    bw.use { flujo ->
        flujo.write("Hola estoy aquí")
        flujo.newLine()
        flujo.write("hola 2")
        flujo.write("hola 2")
        flujo.write("hola 2")
        flujo.newLine()
        flujo.write("hola 223")
    }

}