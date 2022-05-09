package service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParsingUtility {
    public static String getTagValue(String tagName, Element element){
        NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        if (node ==null)    return null;
        return node.getNodeValue();
    }
}
