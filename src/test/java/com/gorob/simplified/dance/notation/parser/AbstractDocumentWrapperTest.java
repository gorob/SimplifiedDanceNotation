package com.gorob.simplified.dance.notation.parser;

import com.gorob.simplified.dance.notation.AbstractTest;
import lombok.Getter;
import org.junit.Test;
import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@Getter
public class AbstractDocumentWrapperTest extends AbstractTest {
    private File testXML;
    private static final String NODE_NAME_ROOT = "rootNode";
    private static final String EXTENSION = "xml";

    public AbstractDocumentWrapper createUnderTest() throws IOException {
        testXML = copyToTemp("/test.xml");

        return new AbstractDocumentWrapper(testXML) {
            @Override
            protected String getMyExtension() {
                return EXTENSION;
            }

            @Override
            protected String getMyRootNodeName() {
                return NODE_NAME_ROOT;
            }
        };
    }

    @Test
    public void testCreate() throws IOException {
        AbstractDocumentWrapper documentWrapper = createUnderTest();
        assertEquals(getTestXML(), documentWrapper.getXmlFile());
        assertNotNull(documentWrapper.getDocument());
        assertEquals(EXTENSION, documentWrapper.getMyExtension());
        assertEquals(NODE_NAME_ROOT, documentWrapper.getMyRootNodeName());
        assertTrue(documentWrapper.isCorrectDocumentType());
    }

    @Test
    public void testGetRootNode() throws IOException {
        AbstractDocumentWrapper documentWrapper = createUnderTest();
        Node rootNode = documentWrapper.getRootNode();
        assertNotNull(rootNode);
        assertEquals(NODE_NAME_ROOT, rootNode.getNodeName());
    }

    @Test
    public void testGetNodesByName() throws IOException {
        AbstractDocumentWrapper documentWrapper = createUnderTest();
        assertTrue(documentWrapper.getNodesByName(documentWrapper.getRootNode(), "nodeNameNotExisting").isEmpty());

        List<Node> nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode1");
        assertEquals(2, nodes.size());
        assertEquals("childNode1", nodes.get(0).getNodeName());
        assertEquals("ChildNode1", nodes.get(1).getNodeName());

        nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "ChildNode1");
        assertEquals(2, nodes.size());
        assertEquals("childNode1", nodes.get(0).getNodeName());
        assertEquals("ChildNode1", nodes.get(1).getNodeName());

        nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "CHILDNODE1");
        assertEquals(2, nodes.size());
        assertEquals("childNode1", nodes.get(0).getNodeName());
        assertEquals("ChildNode1", nodes.get(1).getNodeName());

        nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode2");
        assertEquals(2, nodes.size());
        assertEquals("CHILDNODE2", nodes.get(0).getNodeName());
        assertEquals("childNode2", nodes.get(1).getNodeName());

        nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "CHILDNODE2");
        assertEquals(2, nodes.size());
        assertEquals("CHILDNODE2", nodes.get(0).getNodeName());
        assertEquals("childNode2", nodes.get(1).getNodeName());

        nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "ChildNode2");
        assertEquals(2, nodes.size());
        assertEquals("CHILDNODE2", nodes.get(0).getNodeName());
        assertEquals("childNode2", nodes.get(1).getNodeName());

        nodes = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "ChildNode11");
        assertEquals(1, nodes.size());
        assertEquals("childNode11", nodes.get(0).getNodeName());

        assertTrue(documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode12").isEmpty());
        assertTrue(documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode111").isEmpty());
        assertTrue(documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode21").isEmpty());
    }

    @Test
    public void testGetAttributeValue() throws IOException {
        AbstractDocumentWrapper documentWrapper = createUnderTest();

        assertNull(documentWrapper.getAttributeValue(null, "someName"));

        Node parentNode = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode1").get(0);
        assertNotNull(parentNode);
        assertEquals("aaa1", documentWrapper.getAttributeValue(parentNode, "attr1"));
        assertEquals("bbb1", documentWrapper.getAttributeValue(parentNode, "attr2"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr3"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr4"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr5"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr6"));

        parentNode = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode1").get(1);
        assertNotNull(parentNode);
        assertEquals("aaa3", documentWrapper.getAttributeValue(parentNode, "attr1"));
        assertEquals("bbb3", documentWrapper.getAttributeValue(parentNode, "attr2"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr3"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr4"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr5"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr6"));

        parentNode = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode2").get(0);
        assertNotNull(parentNode);
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr1"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr2"));
        assertEquals("aaa2", documentWrapper.getAttributeValue(parentNode, "attr3"));
        assertEquals("bbb2", documentWrapper.getAttributeValue(parentNode, "attr4"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr5"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr6"));

        parentNode = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode2").get(1);
        assertNotNull(parentNode);
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr1"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr2"));
        assertEquals("aaa4", documentWrapper.getAttributeValue(parentNode, "attr3"));
        assertEquals("bbb4", documentWrapper.getAttributeValue(parentNode, "attr4"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr5"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr6"));

        parentNode = documentWrapper.getNodesByName(documentWrapper.getRootNode(), "childNode11").get(0);
        assertNotNull(parentNode);
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr1"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr2"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr3"));
        assertNull(documentWrapper.getAttributeValue(parentNode, "attr4"));
        assertEquals("aaa5", documentWrapper.getAttributeValue(parentNode, "attr5"));
        assertEquals("bbb5", documentWrapper.getAttributeValue(parentNode, "attr6"));
    }
}