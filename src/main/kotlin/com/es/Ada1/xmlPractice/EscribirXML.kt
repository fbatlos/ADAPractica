package com.es.Ada1.xmlPractice

import org.w3c.dom.DOMImplementation
import org.w3c.dom.Element
import org.w3c.dom.Text
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    //Escribir

    //1º igual que leer

    val dbf = DocumentBuilderFactory.newInstance()

    val db = dbf.newDocumentBuilder()

    //(opcional) especificar opciones , Dom tiene los elementos para crear un document

    val imp:DOMImplementation = db.domImplementation

    //2º Procedemos acrear un document vacio(namespaceURI,qualifiedName(raiz) ,doctype)

    val document = imp.createDocument(null,"productos",null)

    //aquí ya tenemos creada la raiz , el root

    //3º solo tenemos que añdir los hijos al nodo root

    //a) creamos el element

    val producto1:Element = document.createElement("producto")

    val producto2:Element = document.createElement("producto")
    //unimos los nodos
    document.documentElement.appendChild(producto1)
    document.documentElement.appendChild(producto2)

    //b) Hijos de producto 1


    val nombreP1:Element = document.createElement("name")
    val precioP1:Element = document.createElement("precio")
    val nombreP2:Element = document.createElement("name")
    val precioP2:Element = document.createElement("precio")


    val textonombreP1:Text = document.createTextNode("Agua")
    val textoprecioP1:Text = document.createTextNode("1.50")

    val textonombre2 = document.createTextNode("Pan")
    val textoprecio2 = document.createTextNode("2.99")

    //unimos los textnodes con el elemto

    nombreP1.appendChild(textonombreP1)
    precioP1.appendChild(textoprecioP1)

    nombreP2.appendChild(textonombre2)
    precioP2.appendChild(textoprecio2)

    //unimos todo a producto

    producto1.appendChild(nombreP1)
    producto1.appendChild(precioP1)

    producto2.appendChild(nombreP2)
    producto2.appendChild(precioP2)

    //4º Procedemos a crear el xml
    //

    val source:Source = DOMSource(document)

    //Escribirlo : Streamresoul
    val result = StreamResult(Path.of("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\resources\\productosEjemplo.xml").toFile())

    //usamos el trnsform
    val tranformer:Transformer = TransformerFactory.newInstance().newTransformer()

    //Para identar un xml

    tranformer.setOutputProperty(OutputKeys.INDENT,"yes")

    //Lo ecribimos bien

    tranformer.transform(source,result)





}