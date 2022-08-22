package models;

public class Stores {
private String Id;
private String name;
private int tree1;
private int tree2;
private int tree3;
    public Stores(){}
    public Stores(String id, String name, int tree1, int tree2, int tree3) {
    }
    public void setstore(int tree1,int tree2,int tree3){
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.tree3 = tree3;
    }

    public void setStore(String Id,int tree1,int tree2,int tree3) {
        this.Id = Id;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.tree3 = tree3;
    }
    public void setStore(String ID,String name,int tree1,int tree2,int tree3) {
        this.Id = ID;
        this.name = name;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.tree3 = tree3;
    }


    public void setTree2(int tree2) {
        this.tree2 = tree2;
    }

    public void setTree1(int tree1) {
        this.tree1 = tree1;
    }

    public void setTree3(int tree3) {
        this.tree3 = tree3;
    }

    public String getID() {
        return Id;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "models.Stores{" +
                "ID='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", tree1=" + tree1 +
                ", tree2=" + tree2 +
                ", tree3=" + tree3 +
                '}';
    }
}
