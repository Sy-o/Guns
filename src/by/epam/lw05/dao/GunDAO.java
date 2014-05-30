/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.lw05.dao;

import by.epam.lw05.entity.Gun;
import java.util.List;

/**
 *
 * @author user
 */
public interface GunDAO {
    public List<Gun> getGuns();
}
