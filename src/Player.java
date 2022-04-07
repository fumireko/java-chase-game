import java.awt.*;

public class Player {

    public int x;
    public int y;
    public final int width;
    public final int height;
    public final Color c;
    private double xspeed, yspeed;
    public final Rectangle hitbox;
    public boolean left, right, up, down;

    public Player(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;

        width = (Constants.userScreenSize.width / 20);
        height = (Constants.userScreenSize.height / 15);
        hitbox = new Rectangle(x, y, width, height);
    }

    public void set(){
        if(left && right || !left && !right) xspeed *= 0.2;
        else if(left) xspeed--;
        else xspeed++;

        if(up && down || !up && !down) yspeed *= 0.2;
        else if(up) yspeed--;
        else yspeed++;

        x += xspeed;
        y += yspeed;

        hitbox.x = x;
        hitbox.y = y;
    }

    public void draw(Graphics2D gtd){
        gtd.setColor(c);
        gtd.fillRect(x, y, width, height);
    }
}
