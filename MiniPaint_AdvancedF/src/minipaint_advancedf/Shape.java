import java.awt.*;
import java.util.Map;

public interface Shape {
    void setPosition(Point position);
    Point getPosition();
    void setProperties(Map<String, Double> properties);
    Map<String, Double> getProperties();
    void setColor(Color color);
    Color getColor();
    void setFillColor(Color color);
    Color getFillColor();
    void draw(Graphics canvas);
    void setName(String name);
    String getName();
}
