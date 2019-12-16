package com.gorob.simplified.dance.notation.parser;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PROTECTED)
public abstract class AbstractDocumentWrapper {
    private Document document;
    private File xmlFile;

    public AbstractDocumentWrapper(File xmlFile){
        this.xmlFile = xmlFile;
        this.document = createDocument();
    }

    public boolean isCorrectDocumentType(){
        return FilenameUtils.getExtension(getXmlFile().getName()).equalsIgnoreCase(getMyExtension()) && getRootNode().getNodeName().equalsIgnoreCase(getMyRootNodeName());
    }

    protected abstract String getMyExtension();

    protected abstract String getMyRootNodeName();

    protected Node getRootNode(){
        return getDocument().getDocumentElement();
    }

    private Document createDocument(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(getXmlFile());
            document.getDocumentElement().normalize();
            return document;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new RuntimeException("Error on creating Document from SDN-File '" + getXmlFile().getAbsolutePath() + "'!", ex);
        }
    }

    protected List<Node> getNodesByName(Node parentNode, String nodeName){
        return getNodesByName(parentNode.getChildNodes(), nodeName);
    }

    private List<Node> getNodesByName(NodeList nodeList, String nodeName){
        List<Node> nodes = new ArrayList<>();

        for (int i=0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node.getNodeName().equalsIgnoreCase(nodeName)){
                nodes.add(nodeList.item(i));
            }
        }

        return nodes;
    }

    protected String getAttributeValue(Node parentNode, String attributeName){
        if (parentNode==null){ return null; }
        Node node = parentNode.getAttributes().getNamedItem(attributeName);
        return node==null ? null : node.getNodeValue();
    }
}
