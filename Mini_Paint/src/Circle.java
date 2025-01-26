import java.awt.*;
import java.util.HashMap;

public class Circle extends AbstractShape {
    public Circle(Point position, double radius) {
        this.position = position; 
        properties = new HashMap<>();
        properties.put("radius", radius); 
    }

    @Override
    public void draw(Graphics canvas) {
        int radius = properties.get("radius").intValue();
        if (fillColor != null) {
            canvas.setColor(fillColor);
            canvas.fillOval(position.x, position.y, radius * 2, radius * 2);
        }
        if (color != null) {
            canvas.setColor(color);
            canvas.drawOval(position.x, position.y, radius * 2, radius * 2);
        }
    }
}
