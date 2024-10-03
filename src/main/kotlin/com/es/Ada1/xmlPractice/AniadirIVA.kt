package com.es.Ada1.xmlPractice
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


fun main() {
    val iva = AniadirIVA()
    val info = iva.Leer(Path.of("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\resources\\productosEjemplo.xml"))
    iva.Escribir(info)
}



class AniadirIVA (){

    fun Leer(path: Path):Map<String,Double>{
        val dbf = DocumentBuilderFactory.newInstance()
        val db = dbf.newDocumentBuilder()

        val productos = mutableMapOf<String,Double>()

        val document = db.parse(path.toFile())

        val root = document.documentElement
        root.normalize()

        val listaNodos = root.getElementsByTagName("producto")

        for (i in 0..<listaNodos.length){
            val nodo = listaNodos.item(i)

            if (nodo.nodeType == Node.ELEMENT_NODE){
                //casteamos a element
                val nodoElemento = nodo as Element

                //podemos buscar elementos

                val elementoNombre = nodoElemento.getElementsByTagName("name")

                val elementoPrecio = nodoElemento.getElementsByTagName("precio")

                //Cogemos el contenido

                val textContetNombre = elementoNombre.item(0).textContent

                val textContetPrecio = elementoPrecio.item(0).textContent

                productos[textContetNombre] = textContetPrecio.replace(",",".").toDouble()

            }
        }

        return productos
    }

    fun Escribir(productos:Map<String,Double>){
        val dbf = DocumentBuilderFactory.newInstance()
        val db = dbf.newDocumentBuilder()

        val imp = db.domImplementation

        val document = imp.createDocument(null,"productos",null)


        productos.forEach{
            val producto = document.createElement("producto")
            document.documentElement.appendChild(producto)

            val nombre:Element = document.createElement("name")
            val precio:Element = document.createElement("precio")

            producto.appendChild(nombre)
            producto.appendChild(precio)

            val textnombre = document.createTextNode(it.key)

            val num = calIVA(it.value)

            val textprecio = document.createTextNode(num)

            nombre.appendChild(textnombre)

            precio.appendChild(textprecio)

        }
        val source: Source = DOMSource(document)
        val result = StreamResult(Path.of("C:\\Users\\UsuarioT\\IdeaProjects\\ADA\\ADATest\\src\\main\\resources\\productosEjemploIva.xml").toFile())
        val tranformer: Transformer = TransformerFactory.newInstance().newTransformer()
        tranformer.setOutputProperty(OutputKeys.INDENT,"yes")
        tranformer.transform(source,result)
    }

    private fun calIVA(precio:Double):String{

        var precioFinal = 0.0

        precioFinal+= (precio*0.21)+precio

        return precioFinal.toString()
    }

}