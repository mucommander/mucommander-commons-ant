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

package com.mucommander.commons.ant.jnlp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nicolas Rinaudo
 */
public class ResourcesElement {
    private       String                 os;
    private       String                 arch;
    private       String                 locale;
    private final List<J2seElement>      j2ses;
    private final List<JarElement>       jars;
    private final List<NativeLibElement> nativeLibs;
    private final List<ExtensionElement> extensions;
    private final List<PropertyElement>  properties;
    private final List<PackageElement>   packages;

    public ResourcesElement() {
        j2ses      = new ArrayList<J2seElement>();
        jars       = new ArrayList<JarElement>();
        nativeLibs = new ArrayList<NativeLibElement>();
        extensions = new ArrayList<ExtensionElement>();
        properties = new ArrayList<PropertyElement>();
        packages   = new ArrayList<PackageElement>();
    }

    public String getOs() {
        return os;
    }

    public String getArch() {
        return arch;
    }

    public String getLocale() {
        return locale;
    }

    public Iterator<J2seElement> j2ses() {
        return j2ses.iterator();
    }

    public Iterator<JarElement> jars() {
        return jars.iterator();
    }

    public Iterator<NativeLibElement> nativeLibs() {
        return nativeLibs.iterator();
    }

    public Iterator<ExtensionElement> extensions() {
        return extensions.iterator();
    }

    public Iterator<PropertyElement> properties() {
        return properties.iterator();
    }

    public Iterator<PackageElement> packages() {
        return packages.iterator();
    }

    public void setOs(String s) {
        os = s;
    }

    public void setArch(String s) {
        arch = s;
    }

    public void setLocale(String s) {
        locale = s;
    }

    public J2seElement createJ2se() {
        J2seElement buffer;

        buffer = new J2seElement();
        j2ses.add(buffer);

        return buffer;
    }

    public JarElement createJar() {
        JarElement buffer;

        buffer = new JarElement();
        jars.add(buffer);

        return buffer;
    }

    public NativeLibElement createNativeLib() {
        NativeLibElement buffer;

        buffer = new NativeLibElement();
        nativeLibs.add(buffer);

        return buffer;
    }

    public ExtensionElement createExtension() {
        ExtensionElement buffer;

        buffer = new ExtensionElement();
        extensions.add(buffer);

        return buffer;
    }

    public PropertyElement createProperty() {
        PropertyElement buffer;

        buffer = new PropertyElement();
        properties.add(buffer);

        return buffer;
    }

    public PackageElement createPackage() {
        PackageElement buffer;

        buffer = new PackageElement();
        packages.add(buffer);

        return buffer;
    }
}
