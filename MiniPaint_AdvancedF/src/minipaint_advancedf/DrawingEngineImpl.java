import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawingEngineImpl implements DrawingEngine {
    private List<Shape> shapes;
//    private List<List<Shape>> ListOfshapesList;
    public DrawingEngineImpl() {
        shapes = new ArrayList<>();
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void refresh(Graphics canvas) {
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
    }
}
