import java.awt.*;
import java.util.HashMap;

public class Square extends AbstractShape {
    public Square(Point position, double side) {
        this.position = position;
        properties = new HashMap<>();
        properties.put("side", side);
    }

    @Override
    public void draw(Graphics canvas) {
        int side = properties.get("side").intValue();
        if (fillColor != null) {
            canvas.setColor(fillColor);
            canvas.fillRect(position.x, position.y, side, side);
        }
        if (color != null) {
            canvas.setColor(color);
            canvas.drawRect(position.x, position.y, side, side);
        }
    }
}
