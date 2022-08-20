package models;

public class Stores {
private String ID;
private String name;
private int tree1;
private int tree2;
private int tree3;

    public void setStore(String ID,String name,int tree1,int tree2,int tree3) {
        this.ID = ID;
        this.name = name;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.tree3 = tree3;
    }



    public String getID() {
        return ID;
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
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", tree1=" + tree1 +
                ", tree2=" + tree2 +
                ", tree3=" + tree3 +
                '}';
    }
}
