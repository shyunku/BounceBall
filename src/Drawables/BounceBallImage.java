package Drawables;

import Managers.ImageManager;
import ObjectUtil.CollideShape;
import ObjectUtil.Drawable;

public class BounceBallImage extends Drawable {
    public BounceBallImage() {
        super(true);
        setImage(ImageManager.BOUNCE_BALL_IMAGE);
        activatePhysics(false);
        activateCollidable(CollideShape.CIRCLE);
        setPos(970, 600);
    }
}
