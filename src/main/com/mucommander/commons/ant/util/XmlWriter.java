/*
 * This file is part of muCommander, http://www.mucommander.com
 * Copyright (C) 2002-2010 Maxence Bernard
 *
 * muCommander is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * muCommander is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mucommander.commons.ant.util;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * @author Nicolas Rinaudo
 */
public class XmlWriter implements ContentHandler {
    private final ContentHandler out;
    private final AttributesImpl emptyAttributes = new AttributesImpl();

    public XmlWriter(OutputStream out) {
        this.out = createHandler(out, null);
    }

    public XmlWriter(OutputStream out, String docType) {
        this.out = createHandler(out, docType);
    }

    private static ContentHandler createHandler(OutputStream out, String doctType) {
        SAXTransformerFactory factory;
        TransformerHandler    transformer;
        Charset               charset;

        charset = Charset.forName("UTF-8");

        // Initialises the transformer factory.
        factory = (SAXTransformerFactory)SAXTransformerFactory.newInstance();

        try {factory.setAttribute("indent-number", 4);}
        catch(IllegalArgumentException e) {
            // indent-number isn't supported, guess we won't have indentation.
        }

        // Creates a new transformer.
        try {transformer = factory.newTransformerHandler();}
        catch(TransformerConfigurationException e) {throw new IllegalStateException(e);}

        // Enables indentation.
        transformer.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");

        // Sets the encoding parameter if necessary.
        transformer.getTransformer().setOutputProperty(OutputKeys.ENCODING, charset.name());

        if(doctType  == null)
            // Sets the standalone property.
            transformer.getTransformer().setOutputProperty(OutputKeys.STANDALONE, "yes");
        else
            transformer.getTransformer().setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctType);



        // Plugs the transformer into the specified stream.
        transformer.setResult(new StreamResult(new OutputStreamWriter(out, charset)));

        return transformer;
    }

    public void setDocumentLocator(Locator locator) {
        out.setDocumentLocator(locator);
    }

    public void startDocument() throws SAXException {
        out.startDocument();
    }

    public void endDocument() throws SAXException {
        out.endDocument();
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        out.startPrefixMapping(prefix, uri);
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        out.endPrefixMapping(prefix);
    }

    public void startElement(String name, Attributes attrs) throws SAXException {
        startElement("", name, name, attrs);
    }

    public void startElement(String name) throws SAXException {
        startElement(name, emptyAttributes);
    }

    public void endElement(String name) throws SAXException {
        endElement("", name, name);
    }

    public void addElement(String name, Attributes attrs) throws SAXException {
        startElement(name, attrs);
        endElement(name);
    }

    public void addElement(String name) throws SAXException {
        addElement(name, emptyAttributes);
    }

    public Attributes addAttribute(Attributes attrs, String uri, String localName, String qName, String type, String value) {
        AttributesImpl impl;

        if(attrs instanceof AttributesImpl)
            impl = (AttributesImpl)attrs;
        else
            impl = new AttributesImpl(attrs);
        impl.addAttribute(uri, localName, qName, type, value);

        return impl;
    }

    public Attributes addAttribute(Attributes attrs, String name, String value) {
        return addAttribute(attrs, "", name, name, "string", value);
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        out.startElement(uri, localName, qName, atts);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        out.endElement(uri, localName, qName);
    }

    public void characters(String characters) throws SAXException {
        char[] data;

        data = characters.toCharArray();
        characters(data, 0, data.length);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        out.characters(ch, start, length);
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        out.ignorableWhitespace(ch, start, length);
    }

    public void processingInstruction(String target, String data) throws SAXException {
        out.processingInstruction(target, data);
    }

    public void skippedEntity(String name) throws SAXException {
        out.skippedEntity(name);
    }
}
