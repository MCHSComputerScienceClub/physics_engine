package engine.components;

import util.Vector2;

public class PositionComponent extends AbstractComponent {
    private Vector2 position;

    public PositionComponent(float x, float y) {
        super(ComponentType.POSITION_COMPONENT);
        position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }
}
