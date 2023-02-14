/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Article;
import entity.Author;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sesion.ArticleFacade;
import sesion.AuthorFacade;

/**
 *
 * @author user
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {
    
    "/newArticle",
    "/createArticle",
    "/newAuthor",
    "/createAuthor",
    "/listArticles",

})
public class ArticleServlet extends HttpServlet {
    @EJB private ArticleFacade articleFacade;
    @EJB private AuthorFacade authorFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/listArticle":
                request.setAttribute("listArticles", articleFacade.findAll());
                request.getRequestDispatcher("/listArticles.jsp").forward(request, response);
                break;
            case "/newArticle":
                request.setAttribute("listAuthors", authorFacade.findAll());
                request.getRequestDispatcher("/WEB-INF/newArticle.jsp").forward(request, response);
                break;
            case "/createArticle":
                String caption = request.getParameter("caption");
                String text = request.getParameter("text");
                String authorId = request.getParameter("authorId");
                Author author = authorFacade.find(Long.parseLong(authorId));
                Article article = new Article();
                article.setAuthor(author);
                article.setCaption(caption);
                article.setText(text);
                article.setDate(new GregorianCalendar().getTime());
                articleFacade.create(article);
                author.getArticles().add(article);
                authorFacade.edit(author);
                
                request.getRequestDispatcher("/listArticles").forward(request, response);
                break;
            case "/newAuthor":
                request.getRequestDispatcher("/WEB-INF/newAuthor.jsp").forward(request, response);
                break;
            case "/createAuthor":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                author = new Author();
                author.setFirstname(firstname);
                author.setLastname(lastname);
                authorFacade.create(author);
                request.getRequestDispatcher("/WEB-INF/newAuthor.jsp").forward(request, response);
                break;
            case "/article":
                String articleId = request.getParameter("articleId");
                article = articleFacade.find(Long.parseLong(articleId));
                request.setAttribute("article", article);
                request.getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);
                break;
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
