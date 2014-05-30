/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lw05.dao.mysql;

import by.epam.lw05.dao.GunDAO;
import by.epam.lw05.resource.Resource;
import by.epam.lw05.entity.Gun;
import java.util.ArrayList;
import java.util.List;
import by.epam.lw05.pool.Pool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class GunMySQL implements GunDAO {

    public final String SQL_HANDGUNS = "sql.guns";

    private static GunMySQL instance;

    private GunMySQL() {

    }

    public static GunMySQL getInstance() {
        if (null == instance) {
            instance = new GunMySQL();
        }
        return instance;
    }

    public List<Gun> getGuns() {
        List<Gun> guns = new ArrayList<Gun>();
        Pool.MyConnection connection = Pool.getConnection();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(Resource.getValue(SQL_HANDGUNS));
            while (resultSet.next()) {
                Gun gun = new Gun();

                gun.setModel(resultSet.getString(1));
                gun.setHandy(resultSet.getString(2));
                gun.setOrigin(resultSet.getString(3));
                gun.setSerial(resultSet.getString(4));
                gun.setDistance(resultSet.getInt(5));
                gun.setOptics(resultSet.getBoolean(6));
                guns.add(gun);
            }
        } catch (SQLException ex) {
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
            }
            connection.close();
        }
        return guns;
    }
}
