/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lw05.xml;

import by.epam.lw05.entity.Gun;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author user
 */
public class ListToXml {

    public static void create(List<Gun> guns, String path) {
        Document doc = listToDocument(guns);
        documentToXML(doc, path);
    }

    private static Document listToDocument(List<Gun> guns) {
        Element root = new Element("arsenal", "tns", "http://www.example.com/Tarifes");        
        root.addNamespaceDeclaration(Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
        Attribute attr = new Attribute("schemaLocation", "http://www.example.com/Tarifes myschema.xsd", Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
        root.setAttribute(attr);
        for (Gun gun : guns) {
            Element combatUnit = new Element("combatunit");

            combatUnit.setAttribute("serial", String.valueOf(gun.getSerial()));

            Element model = new Element("model");
            model.setText(gun.getModel());
            combatUnit.addContent(model);

            Element handy = new Element("handy");
            handy.setText(gun.getHandy());
            combatUnit.addContent(handy);

            Element origin = new Element("origin");
            origin.setText(String.valueOf(gun.getOrigin()));
            combatUnit.addContent(origin);

            Element ttx = new Element("ttx");

            Element distance = new Element("distance");
            distance.setText(String.valueOf(gun.getDistance()));
            ttx.addContent(distance);

            Element optics = new Element("optics");
            optics.setText(String.valueOf(gun.isOptics()));
            ttx.addContent(optics);
            combatUnit.addContent(ttx);

            root.addContent(combatUnit);
        }
        return new Document(root);
    }

    private static void documentToXML(Document doc, String path) {

        Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");
        XMLOutputter outputter = new XMLOutputter(format);
        try {
            outputter.output(doc, new FileOutputStream(path));
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

}
