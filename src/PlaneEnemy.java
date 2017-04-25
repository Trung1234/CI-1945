import java.awt.*;

/**
 * Created by My PC on 13/04/2017.
 */
public class PlaneEnemy {
    private int x;
    private int y;
    private Image image;

    public PlaneEnemy(int x, int y, Image image){
        this.x = x;
        this.y = y;
        this.image = image;
    }


    public void draw(Graphics graphics){
        graphics.drawImage(image,x,y,null);
    }
    int cd;
    public void update(){
        this.y ++;
        if(this.y > 100){
            this.x += 5;
        }
        if(this.y > 150){
            this.x -= 10;
        }
        if(this.y > 180){
            this.x += 5;
        }
    }
}
