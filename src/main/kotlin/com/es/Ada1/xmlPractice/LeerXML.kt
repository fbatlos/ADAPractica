package com.es.Ada1.xmlPractice

import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory


//Parsear un xml a dom
fun main() {
//LEER
    //1º DocumentBuildFactory
    val dbf = DocumentBuilderFactory.newInstance()
    //2ºcon bdf , podemos crear un obj tipo documentbuillder
    val db = dbf.newDocumentBuilder()

    //3ºCon db ya podemos parsear nuestro documento ,file

    val ficheroXML = Path.of("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\resources\\prueba.xml")

    val documento = db.parse(ficheroXML.toFile())

    //Metodos vip de documet

    //1º obtener elemento root

    val root:Element = documento.documentElement

    //Clase Element
    //1º par "normalizar" el arbol

    root.normalize()

    //2º Obtener elementos por etiquetas

    val listaNodos:NodeList = root.getElementsByTagName("producto")

    //podemos iterrar sobre ella

    for(i in 0..<listaNodos.length){
        //para aceder a un item podemos usaar el index

        val nodo = listaNodos.item(i)

        if (nodo.nodeType == Node.ELEMENT_NODE){
            //casteamos a element
            val nodoElemento = nodo as Element

            //podemos buscar elementos

            val elementoNombre = nodoElemento.getElementsByTagName("nombre")

            val elementoPrecio = nodoElemento.getElementsByTagName("precio")

            //Cogemos el contenido

            val textContetNombre = elementoNombre.item(0).textContent

            val textContetPrecio = elementoPrecio.item(0).textContent

            println("${textContetNombre}\t,\t ${textContetPrecio} \n")

        }

    }




}