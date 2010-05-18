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

/**
 * Contract for all Info.plist elements.
 * <p>
 * This interface's sole purpose is to unify the property list writing process.
 * </p>
 * <p>
 * Since property list elements vary widly in structure, it is all but impossible
 * for us to offer generic Ant hooks. The {@link com.mucommander.commons.ant.macosx.NamedInfoElement}
 * class generalises the notion of element name, but values need to be set on a case by case basis.<br/>
 * While it is not enforced programatically, good practice requires such Ant hooks as are used to set
 * a value to be named, rather logically, <code>value</code>. Implementations of this interface
 * are thus expected to have a public <code>setValue</code> method used for Ant to, well, set
 * element's value.
 * </p>
 * @author Nicolas Rinaudo
 */
interface InfoElement {
    /**
     * Writes the content of this element to the specified XmlWriter.
     * @param     out            where to write the content of this element.
     */
    void write(XmlWriter out) throws SAXException;
}
