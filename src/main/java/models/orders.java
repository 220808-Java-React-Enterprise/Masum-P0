package models;

public class orders {
    String Id;
    String username;
    int total;
    int tree1;
    int tree2;
    int tree3;

    public orders() {
    }

    public orders(String ordernumber, String username, int total, int saptree1, int saptree2, int saptree3) {
    }

    public void setOrder(String Id, String username, int total, int tree1, int tree2, int tree3){
        this.Id=Id;
        this.username=username;
        this.total=total;
        this.tree1=tree1;
        this.tree2=tree2;
        this.tree3=tree3;
    }

    public String getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public int getTotal() {
        return total;
    }

    public int getTree1() {
        return tree1;
    }

    public int getTree2() {
        return tree2;
    }

    public int getTree3() {
        return tree3;
    }
}



