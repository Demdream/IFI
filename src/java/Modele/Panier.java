
package Modele;
import java.util.ArrayList;

public class Panier {
    
     ArrayList<ItemPanier> items ;
     

    public Panier() {
        items = new ArrayList<>();
        
    }

    public ArrayList<ItemPanier> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPanier> items) {
        this.items = items;
    }
    
    public void ajouterAuPanier(int ref){
        
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
    
    
     
    
}
