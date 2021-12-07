package hu.domparse.FOQH34;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomReadFOQH34 {public static void main(String argv[]) throws SAXException, IOException, ParserConfigurationException {
	File xmlFile = new File("XMLfoqh34.xml");
	
	//A documnetBulderFactory-ból megkaptjuk a documentBuildert
	//A documentbuilder tartalazza az aAPI-t a DOM-dokumentum ld�nyok xml dokumentumb�l val� besz
	//a parse() metódus elemzi az xml fájlt a dokument.
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = factory.newDocumentBuilder();
	Document doc =dBuilder.parse(xmlFile);
	doc.getDocumentElement().normalize();
	
	//A dokumentum normaliz�l�sa segt a helyes eredme�nyek el�r�seben
	 System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
	String[] tagNames= {"vasarlo" ,"termek", "vasarlas"};
	for(String tagName :tagNames) {
		NodeList nList = doc.getElementsByTagName(tagName);	
		
	
	for(int i=0; i<	nList.getLength();i++) {
		Node nNode = nList.item(i);
		System.out.println("\nCurrent Element: " + nNode.getNodeName());
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element elem =(Element) nNode;
			
			//Azonositő kiirása
			String id = elem.getAttribute("id");
			System.out.println("	ID: " +id);
			//Tulajdonságok kiirása
			
			String nodeContent="";
			NodeList childNodes =elem.getChildNodes();
			
			for(int j =0; j< childNodes.getLength();j++) {
				if(childNodes.item(j).getTextContent().trim() !="") {
					nodeContent =normalizeText(childNodes.item(j).getTextContent().trim());
					System.out.println("	"+childNodes.item(j).getNodeName()+": "+nodeContent);
				}
			}
			
			}
		System.out.println();
		}
			
			
				
			
	}
}
	private static String normalizeText(String text) {
		text=text.replaceAll("\\n", ", ");
		text=text.replaceAll("\\s+", " ");
		return text;
	}
}
