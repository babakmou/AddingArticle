/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.babak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.babak.modele.Article;

/**
 *
 * @author babak
 */
public class ArticleDAO {
    
    public static int ajouterArticle(Article article){
        Connection con = null;
        PreparedStatement stm = null;
        int resultat = 0;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://192.168.2.56:3306/A15", "root", "root");
            
            stm = con.prepareStatement("insert into article(id, titre, texte) values (?,?,?)");
            stm.setString(1, article.getId());
            stm.setString(2, article.getTitre());
            stm.setString(3, article.getTexte());
//                        stm.setString(1, "2");
//            stm.setString(2, "first article");
//            stm.setString(3, "text of 1st article");
            resultat = stm.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return resultat;
    }
    
}
