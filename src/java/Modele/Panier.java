
package Modele;
import java.util.ArrayList;

public class Panier {
    
     ArrayList<ItemPanier> items ; 
     
    public Panier() {
        items = new ArrayList<>();  
        
    }
  
   //  il trouve l'item panier si il existe 
   // correspondant à la référence passée en paramètre sinon il retourne null
    
    public ItemPanier trouverItemPanier(int ref){
        
        for(int i = 0; i < this.getItems().size(); i++){ 
            ItemPanier item= this.getItems().get(i);
            if (item.getRef() == ref){             
                return item;
            }
        }
        
      return null;  
    } 
    
     // si le panier est vide , il regarde 
    // si le produit du stock correspandant à la référence passée en paramètre est disponible 
    // sinon il vérifier que la nouvelle quantité voulue est au moins égale 
    //à la quantité disoinible 
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
        // et modifier le itempanier avec la nouvelle quantité compté 
        // si la référence n'existe pas il va me créeer un nouveau itempanier
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
