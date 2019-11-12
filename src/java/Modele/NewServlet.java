
package Modele;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            ArrayList<Produit> stock = new ArrayList<>();
           stock.add( new Produit( 14 , "Samsung Galaxy S10+", 1000, 20 )); 
           stock.add( new Produit( 20 , "Apple iPhone X", 899, 20 ));
           stock.add( new Produit( 35 , "Huawei P30 Pro", 649, 20 ));
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet page_servelet</title>");            
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1 align=center>Vente de film en ligne </h1>");
                    out.println("<h2 align=center>Liste des films disponibles : </h2>");
                    out.println("<table align=center>");              
                        out.println("<thead>"); 
                            out.println("<tr>");
                                out.println("<th>Référence</th>");
                                out.println("<th>Nom</th>");
                                out.println("<th>Prix</th>");
                                out.println("<th>Quantité</th>");
                            out.println("</tr>");
                        out.println("</thead>");                        
                        out.println("<tbody>"); 
                            for ( int i = 0; i< stock.size(); i++){
                            out.println("<tr>");         
                            out.println("<td>" + stock.get(i).getRef() + "</td>");  
                            out.println("<td>" + stock.get(i).getNom() + "</td>");  
                            out.println("<td>" + stock.get(i).getPrix() + "</td>");  
                            out.println("<td>" + stock.get(i).getQuantite() + "</td>");  
                            }
                        out.println("</tbody>"); 
                    out.println("</table>");
            
            
            
                 out.println("</body>");
            out.println("</html>");
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


