import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    public void parseJsonFile(String file) throws Exception
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            String countryName;
            Object obj = jsonParser.parse(reader);
            JSONArray happyList = (JSONArray) obj;
            int count = happyList.size();
            System.out.println("Entries: " +  count);
            for(int i = 1; i < count; i++)
            {
                JSONObject jsonObject = (JSONObject) happyList.get(i);
                System.out.println(i + " " + jsonObject);

                if (jsonObject.get(i) == "Country")
                {
                    i++;
                    countryName = (String) happyList.get(i);
                    i--;

                    System.out.println(countryName + " " + i + ": " + jsonObject);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * normalize wordt ook aangeraden
     * setFeature is apparatnly recommended to avoid attacks like XML External Entities
     * @param filePath
     * @throws Exception
     */
    public void parseXmlFile(String filePath) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            //parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filePath));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            if(doc.hasChildNodes())
            {
                printNote(doc.getChildNodes());
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNote(NodeList nodeList)
    {
        for (int count = 0; count < nodeList.getLength(); count++)
        {
            Node tempNode = nodeList.item(count);
            if(tempNode.getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println("\nNode Name =" + tempNode.getNodeName() + "[Open]");
                System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {
                    //get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    for (int i = 0; i < nodeMap.getLength(); i++)
                    {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }
                if(tempNode.hasChildNodes()) {
                    printNote(tempNode.getChildNodes());
                }
                System.out.println("Node Name = " + tempNode.getNodeName() + " [CLOSE]");
            }
        }
    }
}
