import java.awt.*;
import java.util.HashMap;

public class Rectangle extends AbstractShape {
    public Rectangle(Point position, double width, double height) {
        this.position = position;
        properties = new HashMap<>();
        properties.put("width", width);
        properties.put("height", height);
    }

    @Override
    public void draw(Graphics canvas) {
        int width = properties.get("width").intValue();
        int height = properties.get("height").intValue();
        if (fillColor != null) {
            canvas.setColor(fillColor);
            canvas.fillRect(position.x, position.y, width, height);
        }
        if (color != null) {
            canvas.setColor(color);
            canvas.drawRect(position.x, position.y, width, height);
        }
    }
}
