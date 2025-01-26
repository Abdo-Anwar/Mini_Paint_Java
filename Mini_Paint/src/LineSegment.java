import java.awt.*;
import java.util.HashMap;

public class LineSegment extends AbstractShape {
   
    
    public LineSegment(Point start, Point end) {
       this.position = start;
       
        properties.put("endX", (double) end.x);
        properties.put("endY", (double) end.y);
    }

    @Override
    public void draw(Graphics canvas) {
        int endX = properties.get("endX").intValue();
        int endY = properties.get("endY").intValue();
        if (color != null) {
            canvas.setColor(color);
            canvas.drawLine(position.x, position.y, endX, endY);
        }
    }
}
