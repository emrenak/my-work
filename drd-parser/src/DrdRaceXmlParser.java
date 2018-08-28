

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class DrdRaceXmlParser {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        InputStream fileIS = DrdRaceXmlParser.class.getClassLoader().getResourceAsStream("drd_races.log");
//        FileInputStream fileIS = new FileInputStream("/home/aunlu/data/GIT/scc-mtn-enm/core/src/test/java/com/ericsson/enk/ne/drd_races.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(fileIS);
        xmlDocument.getDocumentElement().normalize();
        Map<Race, Integer> map = new HashMap<>();
        NodeList nodeList = xmlDocument.getElementsByTagName("Race");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Race r = processNode2(nodeList.item(i));
            if (r != null) {
                Integer count = map.get(r);
                if (count == null)
                    map.put(r, 1);
                else
                    map.put(r, ++count);
            }
        }

        int i = 1;
        for (Map.Entry<Race, Integer> raceIntegerEntry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            //i,racetype,target,count
            sb.append(i++).append(",").append(raceIntegerEntry.getKey().raceTargetType).append(",");
            sb.append(raceIntegerEntry.getKey().targetCombined).append(",").append(raceIntegerEntry.getValue());
            System.out.println(sb.toString());
        }
    }

    public static Race processNode2(Node node) {
        if (node.hasChildNodes()) {
            Element race = (Element) node;
            String raceTargetType = race.getElementsByTagName("raceTargetType").item(0).getTextContent();
            Element currentAccess = (Element) race.getElementsByTagName("currentAccess").item(0);
            Node targetInfo = currentAccess.getElementsByTagName("targetInfo").item(0);

            NodeList childs = targetInfo.getChildNodes();
            String owner = null, name = null;
            for (int n = childs.getLength() - 1; n >= 0; n--) {
                Node child = childs.item(n);
                short nodeType = child.getNodeType();
                if (nodeType == Node.ELEMENT_NODE) {
                    if (child.getNodeName().equals("entry")) {
                        Element eElement = (Element) child;
                        String key = eElement.getElementsByTagName("key").item(0).getTextContent();
                        if (key.equals("owner") || key.equals("type")) {
                            owner = eElement.getElementsByTagName("value").item(0).getTextContent();
                        } else if (key.equals("name") || key.equals("method")) {
                            name = eElement.getElementsByTagName("value").item(0).getTextContent();
                        }
                    }
                }
            }
            if (owner != null && name != null) {
                Race r = new Race();
                r.raceTargetType = raceTargetType;
                r.name = name;
                r.owner = owner;
                r.targetCombined = owner + ":" + name;
                return r;
            } else {
                processNode(targetInfo);
            }
        }
        return null;
    }

    public static void processNode(Node node) {
        NodeList childs = node.getChildNodes();
        for (int n = childs.getLength() - 1; n >= 0; n--) {
            Node child = childs.item(n);
            short nodeType = child.getNodeType();
            if (nodeType == Node.ELEMENT_NODE) {
                System.out.println("nodename:"+child.getNodeName()+". text:"+child.getTextContent());
                processNode(child);
            }
            else if (nodeType == Node.TEXT_NODE) {
                String trimmedNodeVal = child.getNodeValue().trim();
                if (trimmedNodeVal.length() == 0){
                    node.removeChild(child);
                }
                else {
                    child.setNodeValue(trimmedNodeVal);
//                    System.out.println(trimmedNodeVal);
                }
            } else if (nodeType == Node.COMMENT_NODE) {
                node.removeChild(child);
            }
        }
    }

    public static class Race {
        public String raceTargetType;
        public String targetCombined, owner, name;

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (!(obj instanceof Race))
                return false;
            Race other = (Race) obj;
            if (other.targetCombined != null && this.targetCombined != null && other.targetCombined.equals(this.targetCombined))
                return true;
            if (other.targetCombined == null && this.targetCombined == null)
                return true;
            return false;
        }

        @Override
        public int hashCode() {
            return targetCombined.hashCode();
        }

        @Override
        public String toString() {
            return targetCombined;
        }
    }
}
