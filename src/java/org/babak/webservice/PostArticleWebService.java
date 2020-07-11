 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.babak.webservice;

import java.util.UUID;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.babak.dao.ArticleDAO;
import org.babak.modele.Article;

/**
 *
 * @author babak
 */
@WebService(serviceName = "PostArticleService")
public class PostArticleWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "ajouterArticle")
    public int ajouterArticle(@WebParam(name = "article") Article article) {
        article.setId(UUID.randomUUID().toString());
        int resultat = ArticleDAO.ajouterArticle(article);
        return resultat;
    }
}
