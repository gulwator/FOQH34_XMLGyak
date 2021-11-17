package xpathfoqh341110;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//{

public class xPathFOQH34 {
	public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc =dBuilder.parse("studentFOQH34.xml");
			//a parse() metódus elemzi az xml fájlt a dokument.
			doc.getDocumentElement().normalize();
			//A dokumentum normalizálása segt a helyes eredmeények eléréseben
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Megkell adni az elérési út kifejezés
			//EZT KELL VÁLTOZTATNI
			
			//Válassza ki az összes student element, amely a class gyermekei
			// String expression = "class/student";
			
			//Válassza ki azt a student elemet, amely rendelkezik "id" attribútummal és értéke "01"
			//String expression ="class//student[@id=1]";
			
			//Válassza ki a második student element, amely a class elem gyermeke.
			//String expression ="class//student[position()=2]";
			
			//Válassza ki az utolsó student elemet, amely a class elem gyermeke.
			String expression ="class/student[last()]";
			
			
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			
			for( int i=0; i < nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktuális elem: "+ node.getNodeName());
				if(node.getNodeType()==Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					
					System.out.println("hallgató ID: "+ element.getAttribute("id"));
					System.out.println("Keresztnev: "+ element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Vezeteknev: "+ element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Becenev: "+ element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kor: "+ element.getElementsByTagName("kor").item(0).getTextContent());
					
					
					
				}
				
				//Element element = (Element) node;
				
			}
			
			}catch(ParserConfigurationException e) {
				e.printStackTrace();
			}catch(SAXException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(XPathExpressionException e) {
				e.printStackTrace();
			}
				
			finally {
				
			}
		}
}
