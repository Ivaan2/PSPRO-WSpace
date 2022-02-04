package Unidad3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejericico08 {
    /*
    Observa el resultado de la invocación de este servicio:
    https://api.tutiempo.net/xml/?lan=es&apid=zwDX4azaz4X4Xqs&lid=3768
    Programa una clase Java que pinte los datos de cada hora por pantalla.
     */
    static String lang = "es";
    static String apid = "zwDX4azaz4X4Xqs";
    static String lid = "3768";
    static String link = "https://api.tutiempo.net/xml/" + "?lan" + lang + "&apid" + apid + "&lid" + lid + "";

    public static void main(String[] args) {
        URL url = null;
        URLConnection urlCon = null;
        try {
            url = new URL(link);
            urlCon  = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        leerXML(urlCon);
    }

    private static void leerXML(URLConnection urlCon) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(urlCon.getInputStream());
            document.getDocumentElement().normalize();
            Node raiz = document.getDocumentElement();

            for(int i=1; i<24; i++) {
                NodeList horas = ((Element)raiz).getElementsByTagName("hour"+i);
                Node nodoHorai = horas.item(0);
                String fecha = ((Element)nodoHorai).getElementsByTagName("date").item(0).getTextContent();
                String hora = ((Element)nodoHorai).getElementsByTagName("hour_data").item(0).getTextContent();
                String temperatura = ((Element)nodoHorai).getElementsByTagName("temperature").item(0).getTextContent();
                System.out.println(fecha + " --> " + hora + ": " + temperatura + "ºC");
            }
        } catch ( IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
