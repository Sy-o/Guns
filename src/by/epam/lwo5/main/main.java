/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lwo5.main;

import by.epam.lw05.dao.DAO;
import by.epam.lw05.dao.GunDAO;
import by.epam.lw05.dao.mysql.FactoryMySQL;
import by.epam.lw05.entity.Gun;
import by.epam.lw05.pool.Pool;
import by.epam.lw05.validator.Validator;
import by.epam.lw05.xml.ListToXml;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author user
 */
public class main {

    public static void ma(String[] args) {
        Pool.MyConnection conn = Pool.getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
//            st.executeUpdate("INSERT INTO `guns` (`model`,`distance`) VALUE ('проврка',12)");
            st.executeUpdate(new String(("INSERT INTO `guns` (`model`,`distance`) VALUE ('проврка',12)").getBytes(), "UTF8"));
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException e) {

        }
        ResultSet rs = null;
        try {
            rs = st.executeQuery("SELECT `model`,`distance` FROM `guns` where `distance`=12 LIMIT 1");
            rs.next();
            System.out.println(rs.getString(1));
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        DAO dao = FactoryMySQL.getInstance();
        GunDAO gunDAO = dao.getGunDAO();
        List<Gun> guns = gunDAO.getGuns();
        ListToXml converter = new ListToXml();
        converter.create(guns, "test.xml");
        Validator.validate();
    }
}
