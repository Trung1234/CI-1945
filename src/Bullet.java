import java.awt.*;

/**
 * Created by My PC on 12/04/2017.
 */
public class Bullet {
    private int x;
    private int y;
    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x+ 24;
        this.y = y-13;
        this.image = image;
    }

     public int getX() {
        return x;
    }

       public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public void draw(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,null);
    }
    public void update(){
        this.y-=15;
    }
}
