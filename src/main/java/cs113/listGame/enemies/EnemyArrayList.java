package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import cs113.listGame.gamecore.GameObject;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class EnemyArrayList extends EnemyObject {
    ArrayList<Behavior> behaviors = new ArrayList<>();
    Random random = new Random();
    public EnemyArrayList(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(random.nextDouble(500), random.nextDouble(400));
        int time = random.nextInt(1000);

        for(int i = 0; i <= 5; i++) {
            //behaviors.add(new Waiting(this, 3000));
            behaviors.add(new MoveToPoint(this, time, dest));
        }
    }

    @Override
    public Behavior getNextBehavior() {
        Behavior behavior;
        int index;
        if(behaviors.isEmpty())
        {
            seedBehaviors();
        }
        index = random.nextInt(behaviors.size());
        behavior = behaviors.get(index);
        behaviors.remove(index);
        return behavior;
    }
}