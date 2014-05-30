/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lw05.resource;

import java.util.ResourceBundle;

/**
 *
 * @author user
 */
public class Resource {

    private static ResourceBundle resource = ResourceBundle.getBundle("by.epam.lw05.resource.Property");

    public static String getValue(String key) {
        return resource.getString(key);
    }
}
