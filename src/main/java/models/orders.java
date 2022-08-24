package models;

public class orders {
    String Id;
    String username;
    String user_id;
    int total;
    int tree1;
    int tree2;
    int tree3;
    String thisstore;
    String storename;
    String ordernumber;
    public orders() {
    }

    public orders(String user_id, String storename) {
        this.user_id=user_id;
        this.storename=storename;
    }

    public String getStorename() {
        return storename;
    }

    public String getuser_id() {
        return user_id;
    }

    public void order1s(String user_id, String storename) {
    }

    public void order2s(String username,String user_id,String storename){
        this.ordernumber=ordernumber;
        this.user_id=user_id;
        this.storename=storename;
    }
    public orders(String ordernumber, String username, int total, int saptree1, int saptree2, int saptree3) {
    }

    public void setOrder(String Id, String username,String user_id, int total, int tree1, int tree2, int tree3,String thisstore){
        this.Id=Id;
        this.username=username;
        this.user_id=user_id;
        this.total=total;
        this.tree1=tree1;
        this.tree2=tree2;
        this.tree3=tree3;
        this.thisstore=thisstore;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getThisstore() {
        return thisstore;
    }

    public String getthisstore() {
        return thisstore;
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



