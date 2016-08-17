package hjg.rpcmina;
import java.awt.Color;
import java.io.Serializable;
import java.util.Date;
public class Apple implements Serializable{
    private Color color = Color.BLACK;
    private double weight = 1.1;
    private double dia = 2.33;
    
    private int num = 3;
    private String name = "aaapple";
    
    private Date pdate = new Date();
    
    public Date getPdate() {
        return pdate;
    }
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public double getDia() {
        return dia;
    }
    public void setDia(double dia) {
        this.dia = dia;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}