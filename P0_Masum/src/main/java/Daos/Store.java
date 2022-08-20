package Daos;


public class Store {
    private String id;
    private String name;
    private String inventory;
    public Store(){

    }

    public Store(String id, String name, String inventory) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
}
