/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lw05.dao.mysql;

import by.epam.lw05.dao.DAO;
import by.epam.lw05.dao.GunDAO;

/**
 *
 * @author user
 */
public class FactoryMySQL implements DAO {

    private static FactoryMySQL instance;
    
    private FactoryMySQL() {

    }
    
    public static FactoryMySQL getInstance(){
        if(null == instance)
        {
            instance = new FactoryMySQL();
        }
        return instance;
    }

    public GunDAO getGunDAO() {
        return GunMySQL.getInstance();
    }
}
