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
			//a parse() met�dus elemzi az xml f�jlt a dokument.
			doc.getDocumentElement().normalize();
			//A dokumentum normaliz�l�sa segt a helyes eredme�nyek el�r�seben
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//Megkell adni az el�r�si �t kifejez�s
			//EZT KELL V�LTOZTATNI
			
			//V�lassza ki az �sszes student element, amely a class gyermekei
			// String expression = "class/student";
			
			//V�lassza ki azt a student elemet, amely rendelkezik "id" attrib�tummal �s �rt�ke "01"
			//String expression ="class//student[@id=1]";
			
			//V�lassza ki a m�sodik student element, amely a class elem gyermeke.
			//String expression ="class//student[position()=2]";
			
			//V�lassza ki az utols� student elemet, amely a class elem gyermeke.
			String expression ="class/student[last()]";
			
			
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			
			for( int i=0; i < nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\nAktu�lis elem: "+ node.getNodeName());
				if(node.getNodeType()==Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					
					System.out.println("hallgat� ID: "+ element.getAttribute("id"));
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
