<%-- 
    Document   : afficheProduit
    Created on : 30 oct. 2019, 16:26:59
    Author     : GLZK2747
--%>

<%@page import="Modele.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    ArrayList<Produit> stock = new ArrayList<>();%>
   <% stock.add( new Produit( 14 , "BIC", 2, 20 )); 
    stock.add( new Produit( 20 , "CRAYON", 2, 20 ));
    stock.add( new Produit( 35 , "STYLO", 2, 20 ));
    stock.add( new Produit( 25 , "PILOT", 2, 15 ));
   
%>

             
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2> Liste des produits disponibles:</h2>
        <table>
            <thead>
                <tr>
                    
                    <th>Reference</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Quantite</th>
                    
                </tr>
                
            </thead>
            
            <tbody>
                <% for ( int i = 0; i< stock.size(); i++){%>
                
                <tr> 
                    <td><%=stock.get(i).getRef()%></td>
                    <td><%=stock.get(i).getNom()%></td>
                    <td><%=stock.get(i).getPrix()%></td>
                    <td><%=stock.get(i).getQuantite()%></td>
                </tr>
                
                <%}%>
            </tbody>
            
        </table>
        
        
        
    </body>
</html>
