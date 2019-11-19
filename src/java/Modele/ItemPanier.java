
package Modele;

public class ItemPanier {
    
    private int ref;
    private int quantite;

    public ItemPanier(int ref, int quantite) {
        this.ref = ref;
        this.quantite = quantite;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "ItemPanier{" + "ref=" + ref + ", quantite=" + quantite + '}';
    }
    
    
}