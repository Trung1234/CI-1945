import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by My PC on 12/04/2017.
 */
public class Player {
    private int xPlane;
    private int yPlane;
    private Image image;
    private int dx;
    private int dy;
    private boolean enableShoot = true;
    ArrayList<PlaneEnemy> planeEnemies;
    ArrayList<Bullet> bullets;
    private int coolDownTime;

    public Player(int xPlane, int yPlane, Image image) {
        this.xPlane = xPlane;
        this.yPlane = yPlane;
        this.image = image;
        this.dx=0;
        this.dy=0;
        this.enableShoot = true;
        bullets = new ArrayList<>();
        planeEnemies = new ArrayList<>();
        PlaneEnemy planeEnemy;
        PlaneEnemy planeEnemy1 = new PlaneEnemy(160 , 0, Utils.loadImage("res/enemy_plane_yellow_2.png"));
        planeEnemies.add(planeEnemy1);
        PlaneEnemy planeEnemy2 = new PlaneEnemy(160 , 40, Utils.loadImage("res/enemy_plane_yellow_2.png"));
        planeEnemies.add(planeEnemy2);
        PlaneEnemy planeEnemy3 = new PlaneEnemy(160 , 80, Utils.loadImage("res/enemy_plane_yellow_2.png"));
        planeEnemies.add(planeEnemy3);
        PlaneEnemy planeEnemy4 = new PlaneEnemy(100 , 40, Utils.loadImage("res/enemy_plane_yellow_3.png"));
        planeEnemies.add(planeEnemy4);
        PlaneEnemy planeEnemy6 = new PlaneEnemy(100 , 0, Utils.loadImage("res/enemy_plane_yellow_3.png"));
        planeEnemies.add(planeEnemy6);
    }



    public void move(boolean  isUpPressed,boolean isDownPressed,
                     boolean isRightPressed,boolean isLeftPressed
                      ,  boolean isSpacePressed){
        dx=0;
        dy=0;
        if (isRightPressed) {
            dx += 10;
        }
        if (isLeftPressed) {
            dx -= 10;
        }
        if (isUpPressed) {
            dy -= 10;
        }
        if (isDownPressed) {
            dy += 10;
        }
        if (isSpacePressed&&enableShoot) {
                Bullet bullet = null;
                bullet = new Bullet(xPlane , yPlane, Utils.loadImage("res/bullet.png"));
                bullets.add(bullet);

                enableShoot = false;
                coolDownTime = 50;

        }
    }


    public void draw(Graphics graphics){
        graphics.drawImage(this.image,this.xPlane,this.yPlane,50,50,null);
        for (Bullet bullet : bullets) {
            bullet.draw(graphics);
        }
        for (PlaneEnemy planeEnemy : planeEnemies){
            planeEnemy.draw(graphics);
        }
    }
    public void update(){
        this.xPlane += dx;
        this.yPlane += dy;
        for (Bullet bullet : bullets) {
            bullet.update();
        }
        for (PlaneEnemy planeEnemy : planeEnemies){
            planeEnemy.update();;
        }
        if(!enableShoot){
            // cooling down
            System.out.println(coolDownTime);
            coolDownTime --;
            if (coolDownTime <= 0){
                enableShoot = true;
            }
        }
        for (Bullet bullet : bullets) {
            bullet.update();
        }
        for (PlaneEnemy planeEnemy : planeEnemies){
            planeEnemy.update();
        }
    }
}
