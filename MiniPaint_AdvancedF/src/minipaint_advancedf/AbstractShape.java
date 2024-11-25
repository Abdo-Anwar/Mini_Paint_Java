import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public abstract class AbstractShape implements Shape {
    protected Map<String, Double> properties = new HashMap<>();
    protected Color color;
    protected Color fillColor;
    protected Point position;
    
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    // Abstract method to be implemented by subclasses
    @Override
    public abstract void draw(Graphics canvas);
}
