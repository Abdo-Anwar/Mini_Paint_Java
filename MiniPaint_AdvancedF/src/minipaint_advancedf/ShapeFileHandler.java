import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class ShapeFileHandler {
    public static void writeShapesToFile(List<Shape> shapes, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Shape shape : shapes) {
                StringBuilder line = new StringBuilder();
                
                 if (shape.getName() != null) {
                     System.out.println(shape.getName());
                line.append(shape.getName()).append(",");
                }
//                if (shape instanceof Circle) {
//                    line.append("Circle,");
//                } else if (shape instanceof Rectangle) {
//                    line.append("Rectangle,");
//                } else if (shape instanceof Square) {
//                    line.append("Square,");
//                } else if (shape instanceof LineSegment) {
//                    line.append("LineSegment,");
//                }

                
                Point position = shape.getPosition();
                line.append(position.x).append(",").append(position.y).append(",");

               
                Map<String, Double> properties = shape.getProperties();
                for (Map.Entry<String, Double> entry : properties.entrySet()) {
                    line.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
                }

                
                Color color = shape.getColor();
                Color fillColor = shape.getFillColor();
                if (color != null) {
                    line.append("color=").append(color.getRGB()).append(",");
                }
                if (fillColor != null) {
                    line.append("fillColor=").append(fillColor.getRGB()).append(",");
                }

                
                writer.write(line.substring(0, line.length() - 1));
                writer.newLine();
            }
        }
    }
    
    public static List<Shape> readShapesFromFile(String fileName,ShapeDrawer drawer) throws IOException {
    List<Shape> shapes = new ArrayList<>();
   
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            
            
            String shapeName = parts[0];
            
            
            Point position = new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

            
            Map<String, Double> properties = new HashMap<>();
            Color color = null, fillColor = null;

            
            for (int i = 3; i < parts.length; i++) {
                String[] keyValue = parts[i].split("=");
                switch (keyValue[0]) {
                    case "color":
                        color = new Color(Integer.parseInt(keyValue[1]));
                        break;
                    case "fillColor":
                        fillColor = new Color(Integer.parseInt(keyValue[1]));
                        break;
                    case "endX":
                        properties.put("endX", Double.parseDouble(keyValue[1]));
                        break;
                    case "endY":
                        properties.put("endY", Double.parseDouble(keyValue[1]));
                        break;
                    default:
                        properties.put(keyValue[0], Double.parseDouble(keyValue[1]));
                        break;
                }
            }

            
            Shape shape = null;
            String shapeType = shapeName.replaceAll("\\d", "");
            switch (shapeType) {
                case "Line":
                    
                    if (properties.containsKey("endX") && properties.containsKey("endY")) {
                        Point endPoint = new Point(properties.get("endX").intValue(), properties.get("endY").intValue());
                        shape = new LineSegment(position, endPoint); // Pass both points
                    }
                    drawer.increseCount("Line");
                    break;
                case "Circle":
                    shape = new Circle(position, properties.get("radius"));
                    drawer.increseCount("Circle");
                    break;
                case "Rectangle":
                    shape = new Rectangle(position, properties.get("width"), properties.get("height"));
                    drawer.increseCount("Rectangle");
                    break;
                case "Square":
                    shape = new Square(position, properties.get("side"));
                    drawer.increseCount("Square");
                    break;
            }

           
            if (shape != null) {
                shape.setName(shapeName); 
                shape.setProperties(properties);
                shape.setColor(color);
                shape.setFillColor(fillColor);
                shapes.add(shape);
                drawer.addShapeToList(shape.getName());
            }
        }
    }
    return shapes;
}
    // public static void main(String args[]) {
         
//       DrawingEngineImpl engine = new DrawingEngineImpl();
//       engine.addShape(new Circle(new Point(100, 150), 50));
//       engine.addShape(new Rectangle(new Point(200, 300), 100, 50));
//       engine.addShape(new Square(new Point(50, 75), 40));
//       engine.addShape(new LineSegment(new Point(10, 20), new Point(30, 40)));
//
//       try {
//           ShapeFileHandler.writeShapesToFile(engine.getShapes(), "shapes.txt");
//           System.out.println("Shapes written to file.");
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
//         try {
//            List<Shape> shapes = ShapeFileHandler.readShapesFromFile("shapes.txt");
//           
//            System.out.println("Shapes loaded from file.");
//        } catch (IOException e) {
//            e.printStackTrace();
//}
//       
//       
       
      
  //   }
    
    
}
