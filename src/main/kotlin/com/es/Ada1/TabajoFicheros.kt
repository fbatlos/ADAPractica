package com.es.Ada1

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import kotlin.io.path.exists


//.io
fun main() {

    val separador = System.getProperty("file.separator") //o file.separator

    val userdir = System.getProperty("user.dir")

    val userhome = System.getProperty("user.home")

    val osname = System.getProperty("os.name")

    val file = File("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\kotlin\\carpetaPrueba\\papapa.txt")

    if (file.exists()) {

        if (file.isDirectory){

            File("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\kotlin\\carpetaPrueba","papapa.txt")

        }else {
            //escritura de archivos
            /*
            file.writeText("Papas\n")
            for (i in 1..10) {
                file.appendText("papas2\n")
            }
            */

            file.bufferedWriter()


            //lee de forma mas lenta
            //println(file.readText())
            //lectura rapida

            //hay que crear un flujo de lectura

            println(file.bufferedReader())


        }
    }
/*
MOVER EL ARCHIVO    

    val path1 = Path.of("src")
    val rutra = path1.resolve("main").resolve("resources").resolve("prueba.txt")

    if (rutra.exists()){
        val destino = path1.resolve("main").resolve("kotlin").resolve("carpetaPrueba").resolve("POLIM.text")
        println(destino)

        //cuendo existe las dos rutas se copiará

        Files.copy(rutra,destino, StandardCopyOption.REPLACE_EXISTING)
        println("switch")
    }
*/


}