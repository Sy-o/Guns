/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lw05.validator;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/**
 *
 * @author user
 */
public class Validator {

    public static void validate() {

        String filename = "test.xml";
        DOMParser parser = new DOMParser();
        try {
            // установка способов проверки с использованием XSD
            parser.setFeature(
                    "http://xml.org/sax/features/validation", true);
            parser.setFeature(
                    "http://apache.org/xml/features/validation/schema", true);
            parser.parse(filename);
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
            System.out.print("идентификатор не распознан");
        } catch (SAXNotSupportedException e) {
            e.printStackTrace();
            System.out.print("неподдерживаемая операция");
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.print("глобальная SAX ошибка ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("ошибка I/O потока");
        }
        System.out.print("Проверка " + filename + " завершена");

    }
}
