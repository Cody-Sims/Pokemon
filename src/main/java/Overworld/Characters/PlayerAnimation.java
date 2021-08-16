package Overworld.Characters;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PlayerAnimation extends Component {
    private int speed;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalkRight,animWalkLeft, animWalkUp, animWalkDown;

    public PlayerAnimation(){
        animIdle = new AnimationChannel(FXGL.image("dawn.png"), 12, 18, 26, Duration.seconds(1), 0, 0);
        animWalkRight = new AnimationChannel(FXGL.image("dawn.png"), 12, 18, 26, Duration.seconds(1), 2, 4);
        animWalkLeft = new AnimationChannel(FXGL.image("dawn.png"), 12, 18, 26, Duration.seconds(1), 8, 10);
        animWalkUp = new AnimationChannel(FXGL.image("dawn.png"), 12, 18, 26, Duration.seconds(1), 5, 7);
        animWalkDown = new AnimationChannel(FXGL.image("dawn.png"), 12, 18, 26, Duration.seconds(1), 0, 1);

        texture = new AnimatedTexture(animIdle);
    }

    @Override
    public void onAdded() {
        //entity.getTransformComponent().setScaleOrigin(new Point2D(26, 40));
        entity.getTransformComponent().setScaleX(3);
        entity.getTransformComponent().setScaleY(3);
        entity.getViewComponent().addChild(texture);
    }

    @Override
    public void onUpdate(double tpf) {
        if (speed != 0) {
            speed = (int) (speed * 0.9);
            if (FXGLMath.abs(speed) < 1) {
                speed = 0;
                texture.loopAnimationChannel(animIdle);
            }
        }
    }

    public void moveRight() {
        speed = 2;
        entity.translateX(speed);
        if(texture.getAnimationChannel() != animWalkRight){
            texture.loopAnimationChannel(animWalkRight);
        }

    }

    public void moveLeft() {
        speed = 2;
        entity.translateX(-speed);
        if(texture.getAnimationChannel() != animWalkLeft){
            texture.loopAnimationChannel(animWalkLeft);
        }
    }

    public void moveDown() {
        speed = 2;
        entity.translateY(speed);
        if(texture.getAnimationChannel() != animWalkDown){
            texture.loopAnimationChannel(animWalkDown);
        }
    }

    public void moveUp() {
        speed = 2;
        entity.translateY(-speed);
        if(texture.getAnimationChannel() != animWalkUp){
            texture.loopAnimationChannel(animWalkUp);
        }
    }
}

