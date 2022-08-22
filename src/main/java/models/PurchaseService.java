package models;
import Daos.PurchaseDaos;
import Daos.StoreDaos;

public class PurchaseService {
    private final PurchaseDaos purchasedaos;


    public PurchaseService(PurchaseDaos purchasedaos, StoreDaos storesDaos) {
        this.purchasedaos = purchasedaos;


    }
    public PurchaseService(PurchaseDaos purchasedaos) {
        this.purchasedaos = purchasedaos;
    }
    public PurchaseService(StoreDaos storesDaos, PurchaseDaos purchasedaos){
        this.purchasedaos = purchasedaos;
    }


}


