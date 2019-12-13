
package Modele;
import java.util.ArrayList;

public class Panier {
    
     ArrayList<ItemPanier> items ; 
     
    public Panier() {
        items = new ArrayList<>();  
        
    }
  
   //  il cherche dans le panier l'itemPanier qui a la référence = à la référence passée
    // en paramètre. Quand il le trouve, il le retourne sinon il retourne null
    
    public ItemPanier trouverItemPanier(int ref){
        
        for(int i = 0; i < this.getItems().size(); i++){ 
            ItemPanier item= this.getItems().get(i);
            if (item.getRef() == ref){             
                return item;
            }
        }
        
      return null;  
    } 
    
  
     
    //cette methode est pour vérifier la disponibilité d'un produit avant de l'ajouter au panier
    //si la quantité du produit est supérieur de 0 et sa référence ne se trouve pas dans le panier c'est OK
    // sinon il vérifie que la quantité disponible moins la quantité voulue est supérieur à 0
    
    
    public boolean verifierDisponibiliteProduit (int ref , Stock stock){
         
         Produit prod = stock.trouverProduit(ref);
         ItemPanier item = this.trouverItemPanier(ref);
         if (prod.getQuantite()> 0 && item == null){
             return true ;
            
         }
         else if ( item != null && (prod.getQuantite() - item.getQuantite()) > 0 ) {
             return true;
         }
         else {
             return false;
         }
     
     }
            
      public void ajouterAuPanier(int ref){
          
        // Une boucle pour parcourir le tableau initial si la référence du produit 
        // existe dans le panier , il va incrémenter la quantité
        // et modifier le itempanier avec la nouvelle quantité comptée 
        // si la référence n'existe pas il va créeer un nouveau itempanier
        // avec la bonne référence et quantité 1
        
        Boolean existe = false;
        for(int i = 0; i < this.getItems().size(); i++){ 
            ItemPanier item = this.getItems().get(i);
            if (item.getRef() == ref){
                existe = true;
                item.setQuantite(item.getQuantite() + 1);
                this.getItems().set(i, item);
            }
        }
              
        if (!existe) {
            this.getItems().add(new ItemPanier(ref, 1));
        }
        
    }
    // pour afficher sur la page le item panier cad la référence du produit et sa quantite selon le nb de fois 
    // que l'utilisateur a cliqué sur ajouter panier
    @Override
    public String toString() {
        
        String result = ""; 
        
        if (this.getItems().size() > 0) {
            result += "Le Panier contient: ";
        }
        
        for(ItemPanier item : this.getItems()) {
            result += item.toString() + "\n;";
        }
        
        return result;
    }
    
    
       public ArrayList<ItemPanier> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPanier> items) {
        this.items = items;
    } 
    
}
