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

package com.mucommander.commons.ant.macosx;

import com.mucommander.commons.ant.util.XmlWriter;
import org.xml.sax.SAXException;

public class DataValue implements InfoElement {
    private static final String DATA_ELEMENT = "data";

    private final StringBuilder data;

    public DataValue() {data = new StringBuilder();}

    public void addText(String txt) {data.append(txt);}

    public void write(XmlWriter out) throws SAXException {
        out.startElement(DATA_ELEMENT);
        out.characters(data.toString());
        out.endElement(DATA_ELEMENT);
    }
}
