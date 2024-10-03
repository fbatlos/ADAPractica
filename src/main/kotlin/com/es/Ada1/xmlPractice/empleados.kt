package com.es.Ada1.xmlPractice

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
   val file = Path.of("src").resolve("main/resources/empleados.xml").toFile()
   val empleados = empleados()
   empleados.mostrar(file)
}

class empleados (){
    fun mostrar(ficheroXML:File) {
        val dbf = DocumentBuilderFactory.newInstance()

        val db = dbf.newDocumentBuilder()

        val documet = db.parse(ficheroXML)

        val root:Element= documet.documentElement
        root.normalize()

        val listaNodos = root.getElementsByTagName("empleado")

        for (i in 0..<listaNodos.length){
            val nodo = listaNodos.item(i)

            if (nodo.nodeType != Node.ELEMENT_NODE){

            }else{
                val nodoElemento = nodo as Element

                val elementoID = nodoElemento.getElementsByTagName("id")
                val elementoApellido = nodoElemento.getElementsByTagName("apellido")
                val elementoDepartamento = nodoElemento.getElementsByTagName("dep")
                val elementosalario = nodoElemento.getElementsByTagName("salario")

            }
        }



    }
}
