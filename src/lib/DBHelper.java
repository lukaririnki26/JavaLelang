/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fahmi
 */
public class DBHelper {
    private Connection connection;
    private Connection start(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/app_lelang","root","");
        } catch (Exception e) {
            System.out.println("gagal terhubung"+e);
        }
        return connection;
    }
    public Connection init(){
       Connection r = this.start();
       return r;
    }
}
// sql select petugas.username,petugas.password,petugas.level,masyarakat.username,masyarakat.password from petugas join masyarakat;


