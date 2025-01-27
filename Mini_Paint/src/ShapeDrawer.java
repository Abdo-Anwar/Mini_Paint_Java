import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class ShapeDrawer extends javax.swing.JFrame {

   private Shape currentShape;
   private DrawingEngineImpl drawingEngine;
   private List<List<Shape>> ListOfshapesList;
   
    private int CurrentState=0;
    private int LastEdit;
    private int circleCount = 0;
    private int squareCount = 0;
    private int rectangleCount = 0;
    private int lineCount = 0;
    
    public void increseCount(String type){
       switch(type) {
        case "Line":  
            lineCount++; 
            break;
        case "Circle":
            circleCount++;
            break;
        case "Rectangle":
            rectangleCount++;
        case "Square":
            squareCount++;
            break;
        }
    }
    public ShapeDrawer() {
        initComponents();
        setLocationRelativeTo(null); 
        drawingEngine = new DrawingEngineImpl();
    }
     public void setShape(Shape shape) {
        //this.currentShape = shape;
        drawingEngine.addShape(shape);  
//        ListOfshapesList[CurrentState]=drawingEngine.getShapes();
//        ListOfshapesList.set(CurrentState, drawingEngine.getShapes());
        drawPanel.repaint();  
    }
     public void addShapeToList(String shapeName) {
       
        ShapeListCobmoBox.addItem(shapeName);
    }
     private void createCircle() {
        try {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter x position:", "100"));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter y position:", "100"));
            double radius = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter radius:", "50"));
            int panelWidth = drawPanel.getWidth();
            int panelHeight = drawPanel.getHeight();
            if (x - radius < 0 || x + radius > panelWidth || y - radius < 0 || y + radius > panelHeight) {
            JOptionPane.showMessageDialog(this, "Shape exceeds panel boundaries. Please enter valid values.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
            
            Point position = new Point(x, y);
            Circle circle = new Circle(position, radius);
            circle.setColor(Color.BLACK);
            circle.setFillColor(Color.RED);
            this.currentShape = circle;
           
            
            circleCount++;
            String shapeName = "Circle" + String.format("%02d", circleCount);
            circle.setName(shapeName);
            
            ShapeListCobmoBox.addItem(circle.getName());
            setShape(circle);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for position and radius.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     private void createRectangle() {
        try {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter x position:", "100"));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter y position:", "100"));
            double width = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter width:", "100"));
            double height = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter height:", "50"));
            int panelWidth = drawPanel.getWidth();
            int panelHeight = drawPanel.getHeight();
            if (x < 0 || y < 0 || x + width > panelWidth || y + height > panelHeight) {
            JOptionPane.showMessageDialog(this, "Rectangle exceeds panel boundaries.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

            
            
            Point position = new Point(x, y);
            Rectangle rectangle = new Rectangle(position, width, height);
            rectangle.setColor(Color.BLACK);
            rectangle.setFillColor(Color.BLUE);
            this.currentShape = rectangle;
            rectangleCount++;
            String shapeName = "Rectangle" + String.format("%02d", rectangleCount);
            rectangle.setName(shapeName);
            ShapeListCobmoBox.addItem(rectangle.getName());
            
            setShape(rectangle);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for position, width, and height.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createSquare() {
        try {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter x position:", "100"));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter y position:", "100"));
            double side = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter side length:", "50"));
            int panelWidth = drawPanel.getWidth();
            int panelHeight = drawPanel.getHeight();
            if (x < 0 || y < 0 || x + side > panelWidth || y + side > panelHeight) {
            JOptionPane.showMessageDialog(this, "Square exceeds panel boundaries.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
            
            Point position = new Point(x, y);
            Square square = new Square(position, side);
            square.setColor(Color.BLACK);
            square.setFillColor(Color.GREEN);
            this.currentShape = square;
             squareCount++;
            String shapeName = "Square" + String.format("%02d", squareCount);
            square.setName(shapeName);
            ShapeListCobmoBox.addItem(square.getName());
            
            setShape(square);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for position and side length.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createLine() {
        try {
            int x1 = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter x1 position:", "50"));
            int y1 = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter y1 position:", "50"));
            int x2 = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter x2 position:", "150"));
            int y2 = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter y2 position:", "150"));

            int panelWidth = drawPanel.getWidth();
            int panelHeight = drawPanel.getHeight();
            if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || x1 > panelWidth || y1 > panelHeight || x2 > panelWidth || y2 > panelHeight) {
            JOptionPane.showMessageDialog(this, "Line exceeds panel boundaries.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            Point start = new Point(x1, y1);
            Point end = new Point(x2, y2);
            LineSegment line = new LineSegment(start, end);
            line.setColor(Color.BLACK);
            this.currentShape = line;
            lineCount++;
            String shapeName = "Line" + String.format("%02d", lineCount);
            line.setName(shapeName);
            ShapeListCobmoBox.addItem(line.getName());
            setShape(line);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for line positions.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawingEngine.refresh(g);
            }
        }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawPanel = new DrawingPanel();
        circleButton = new javax.swing.JButton();
        squareButton = new javax.swing.JButton();
        rectangleButton = new javax.swing.JButton();
        lineButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ShapeListCobmoBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        colorizqButton = new javax.swing.JButton();
        PositionChangeButton = new javax.swing.JButton();
        UndoButton = new javax.swing.JButton();
        RedoButton = new javax.swing.JButton();
        LoadButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        ResizeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini Paint");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        drawPanel.setBackground(new java.awt.Color(255, 255, 255));
        drawPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        circleButton.setBackground(new java.awt.Color(102, 255, 204));
        circleButton.setText("Circle");
        circleButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        circleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleButtonActionPerformed(evt);
            }
        });

        squareButton.setBackground(new java.awt.Color(102, 255, 204));
        squareButton.setText("Square");
        squareButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        squareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareButtonActionPerformed(evt);
            }
        });

        rectangleButton.setBackground(new java.awt.Color(102, 255, 204));
        rectangleButton.setText("Rectangle");
        rectangleButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });

        lineButton.setBackground(new java.awt.Color(102, 255, 204));
        lineButton.setText("Line Segment");
        lineButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Shapes");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        ShapeListCobmoBox.setToolTipText("Choose Shape");
        ShapeListCobmoBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ShapeListCobmoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShapeListCobmoBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Select Shape");

        DeleteButton.setBackground(new java.awt.Color(0, 255, 204));
        DeleteButton.setText("Delete");
        DeleteButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        colorizqButton.setBackground(new java.awt.Color(51, 255, 204));
        colorizqButton.setText("Colorize");
        colorizqButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorizqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizqButtonActionPerformed(evt);
            }
        });

        PositionChangeButton.setBackground(new java.awt.Color(51, 255, 204));
        PositionChangeButton.setText("Change Position");
        PositionChangeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PositionChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionChangeButtonActionPerformed(evt);
            }
        });

        UndoButton.setBackground(new java.awt.Color(153, 255, 255));
        UndoButton.setText("Undo");
        UndoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });

        RedoButton.setBackground(new java.awt.Color(153, 255, 255));
        RedoButton.setText("Redo");
        RedoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RedoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoButtonActionPerformed(evt);
            }
        });

        LoadButton.setBackground(new java.awt.Color(153, 255, 255));
        LoadButton.setText("Load");
        LoadButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        SaveButton.setBackground(new java.awt.Color(153, 255, 255));
        SaveButton.setText("Save");
        SaveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        ResizeButton.setBackground(new java.awt.Color(51, 255, 204));
        ResizeButton.setText("Resize");
        ResizeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResizeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShapeListCobmoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UndoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoadButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RedoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorizqButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PositionChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(circleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(squareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rectangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(circleButton)
                    .addComponent(squareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rectangleButton)
                    .addComponent(lineButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RedoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShapeListCobmoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colorizqButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PositionChangeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResizeButton)
                .addGap(44, 44, 44))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void circleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleButtonActionPerformed
        createCircle();
        drawPanel.repaint();
    }//GEN-LAST:event_circleButtonActionPerformed

    private void squareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareButtonActionPerformed
       createSquare();
       drawPanel.repaint();
       
    }//GEN-LAST:event_squareButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        createRectangle();
        drawPanel.repaint();
    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        createLine();
        drawPanel.repaint();
    }//GEN-LAST:event_lineButtonActionPerformed

    private void ShapeListCobmoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShapeListCobmoBoxActionPerformed
        
    }//GEN-LAST:event_ShapeListCobmoBoxActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedIndex = ShapeListCobmoBox.getSelectedIndex();
    
    if (selectedIndex >= 0) {
        String selectedShapeName = (String) ShapeListCobmoBox.getSelectedItem();
         Shape selectedShape = drawingEngine.getShapes().get(selectedIndex); 
        
        drawingEngine.removeShape(selectedShape); 
        ShapeListCobmoBox.removeItemAt(selectedIndex);  
        
        JOptionPane.showMessageDialog(this, selectedShapeName + " has been deleted.");
        
        drawPanel.repaint();  
    } else {
        JOptionPane.showMessageDialog(this, "Please select a shape to delete.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void colorizqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizqButtonActionPerformed
        int selectedIndex = ShapeListCobmoBox.getSelectedIndex();

    if (selectedIndex >= 0) {
       
        Shape selectedShape = drawingEngine.getShapes().get(selectedIndex);

        
        Color newColor = JColorChooser.showDialog(this, "Choose a Color", selectedShape.getColor());

        if (newColor != null) {
            
            selectedShape.setFillColor(newColor);
            selectedShape.setColor(newColor);
            JOptionPane.showMessageDialog(this, "Shape color has been updated.");

            
            drawPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "No color selected.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
          JOptionPane.showMessageDialog(this, "Please select a shape to colorize.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_colorizqButtonActionPerformed

    private void PositionChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionChangeButtonActionPerformed
         int selectedIndex = ShapeListCobmoBox.getSelectedIndex();

    if (selectedIndex >= 0) {
        // Retrieve the selected shape based on index
        Shape selectedShape = drawingEngine.getShapes().get(selectedIndex);

        try {
            // Prompt user to enter new x and y coordinates
            String xInput = JOptionPane.showInputDialog(this, "Enter new X position:");
            String yInput = JOptionPane.showInputDialog(this, "Enter new Y position:");

            if (xInput != null && yInput != null) {
                int newX = Integer.parseInt(xInput);
                int newY = Integer.parseInt(yInput);

                // Set the new position for the shape
                selectedShape.setPosition(new Point(newX, newY));

                JOptionPane.showMessageDialog(this, "Shape position has been updated.");

                // Repaint the panel to reflect position change
                drawPanel.repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Position change canceled.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a shape to reposition.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_PositionChangeButtonActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
        JOptionPane.showMessageDialog(this,"Coming sooon!");
    }//GEN-LAST:event_UndoButtonActionPerformed

    private void RedoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoButtonActionPerformed
      JOptionPane.showMessageDialog(this,"Coming sooon!");
    }//GEN-LAST:event_RedoButtonActionPerformed

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
     while (!drawingEngine.getShapes().isEmpty()) {
        Shape shapeToDelete = drawingEngine.getShapes().get(0); 
        drawingEngine.removeShape(shapeToDelete);
        ShapeListCobmoBox.removeItemAt(0); 
    }
   
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Load Shapes File");
    int userSelection = fileChooser.showOpenDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToLoad = fileChooser.getSelectedFile();
        String fileName = fileToLoad.getAbsolutePath();  // Corrected from fileToSave to fileToLoad

        try {
            // Assuming ShapeFileHandler.readShapesFromFile returns a List<Shape>
            List<Shape> loadedShapes = ShapeFileHandler.readShapesFromFile(fileName,this);
            
            // Add each shape individually to the drawing engine
            for (Shape shape : loadedShapes) {
                drawingEngine.addShape(shape); // Add each shape one by one
            }
            
            // Update the shapes in your engine
            drawPanel.repaint(); // Refresh the canvas
            
            JOptionPane.showMessageDialog(this, "Shapes loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save Shapes File");
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        
        String fileName = fileToSave.getAbsolutePath();

        
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }
        try {
           
            ShapeFileHandler.writeShapesToFile( drawingEngine.getShapes(),fileName);
            JOptionPane.showMessageDialog(this, "Shapes saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ResizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResizeButtonActionPerformed
int selectedIndex = ShapeListCobmoBox.getSelectedIndex();

    if (selectedIndex >= 0) {
        
        Shape selectedShape = drawingEngine.getShapes().get(selectedIndex);

        try {
            if (selectedShape instanceof Circle) {
                
                String newRadiusInput = JOptionPane.showInputDialog(this, "Enter new radius:");
                if (newRadiusInput != null) {
                    double newRadius = Double.parseDouble(newRadiusInput);

                    selectedShape.getProperties().put("radius", newRadius);
                }
                
                
            } else if (selectedShape instanceof Rectangle) {
                
                String newWidthInput = JOptionPane.showInputDialog(this, "Enter new width:");
                String newHeightInput = JOptionPane.showInputDialog(this, "Enter new height:");

                if (newWidthInput != null && newHeightInput != null) {
                    double newWidth = Double.parseDouble(newWidthInput);
                    double newHeight = Double.parseDouble(newHeightInput);

                    selectedShape.getProperties().put("width", newWidth);
                    selectedShape.getProperties().put("height", newHeight);
                }
            } else if (selectedShape instanceof Square) {
                // Prompt for new side length
                String newSideInput = JOptionPane.showInputDialog(this, "Enter new side length:");
                if (newSideInput != null) {
                    double newSide = Double.parseDouble(newSideInput);

                    // Update the side property
                    selectedShape.getProperties().put("side", newSide);
                }
            } else if (selectedShape instanceof LineSegment) {
                // Prompt for new x2 and y2
                String newX2Input = JOptionPane.showInputDialog(this, "Enter new x2:");
                String newY2Input = JOptionPane.showInputDialog(this, "Enter new y2:");

                if (newX2Input != null && newY2Input != null) {
                    double newX2 = Double.parseDouble(newX2Input);
                    double newY2 = Double.parseDouble(newY2Input);

                    // Update the endpoint properties
                    selectedShape.getProperties().put("endX", newX2);
                    selectedShape.getProperties().put("endY", newY2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Resize operation not supported for this shape.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            
            JOptionPane.showMessageDialog(this, "Shape resized successfully.");
            drawPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a shape to resize.", "Error", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_ResizeButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShapeDrawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShapeDrawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShapeDrawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShapeDrawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShapeDrawer().setVisible(true);
            }
            
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton PositionChangeButton;
    private javax.swing.JButton RedoButton;
    private javax.swing.JButton ResizeButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox<String> ShapeListCobmoBox;
    private javax.swing.JButton UndoButton;
    private javax.swing.JButton circleButton;
    private javax.swing.JButton colorizqButton;
    private javax.swing.JPanel drawPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lineButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton squareButton;
    // End of variables declaration//GEN-END:variables
}
