import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
public class ShapeDrawer extends javax.swing.JFrame {

   private Shape currentShape;
   private DrawingEngineImpl drawingEngine;
   
    private int circleCount = 0;
    private int squareCount = 0;
    private int rectangleCount = 0;
    private int lineCount = 0;
    
    public ShapeDrawer() {
        initComponents();
        setLocationRelativeTo(null); 
        drawingEngine = new DrawingEngineImpl();
    }
     public void setShape(Shape shape) {
        //this.currentShape = shape;
        drawingEngine.addShape(shape);  
        drawPanel.repaint();  
    }
    
     private void createCircle() {
        try {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter x position:", "100"));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter y position:", "100"));
            double radius = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter radius:", "50"));

            Point position = new Point(x, y);
            Circle circle = new Circle(position, radius);
            circle.setColor(Color.BLACK);
            circle.setFillColor(Color.RED);
            this.currentShape = circle;
           
            
            circleCount++;
            String shapeName = "Circle" + String.format("%02d", circleCount);
            
            
            ShapeListCobmoBox.addItem(shapeName);
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

            Point position = new Point(x, y);
            Rectangle rectangle = new Rectangle(position, width, height);
            rectangle.setColor(Color.BLACK);
            rectangle.setFillColor(Color.BLUE);
            this.currentShape = rectangle;
            rectangleCount++;
            String shapeName = "Rectangle" + String.format("%02d", rectangleCount);
            ShapeListCobmoBox.addItem(shapeName);
            
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

            Point position = new Point(x, y);
            Square square = new Square(position, side);
            square.setColor(Color.BLACK);
            square.setFillColor(Color.GREEN);
            this.currentShape = square;
             squareCount++;
            String shapeName = "Square" + String.format("%02d", squareCount);
            ShapeListCobmoBox.addItem(shapeName);
            
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

            Point start = new Point(x1, y1);
            Point end = new Point(x2, y2);
            LineSegment line = new LineSegment(start, end);
            line.setColor(Color.BLACK);
            this.currentShape = line;
            lineCount++;
            String shapeName = "Line" + String.format("%02d", lineCount);
            ShapeListCobmoBox.addItem(shapeName);
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
        colorizqButton1 = new javax.swing.JButton();
        colorizqButton2 = new javax.swing.JButton();
        colorizqButton3 = new javax.swing.JButton();
        colorizqButton4 = new javax.swing.JButton();
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
            .addGap(0, 595, Short.MAX_VALUE)
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

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Shapes");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        ShapeListCobmoBox.setToolTipText("Choose Shape");
        ShapeListCobmoBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ShapeListCobmoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShapeListCobmoBoxActionPerformed(evt);
            }
        });

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

        colorizqButton1.setBackground(new java.awt.Color(153, 255, 255));
        colorizqButton1.setText("Undo");
        colorizqButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorizqButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizqButton1ActionPerformed(evt);
            }
        });

        colorizqButton2.setBackground(new java.awt.Color(153, 255, 255));
        colorizqButton2.setText("Redo");
        colorizqButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorizqButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizqButton2ActionPerformed(evt);
            }
        });

        colorizqButton3.setBackground(new java.awt.Color(153, 255, 255));
        colorizqButton3.setText("Load");
        colorizqButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorizqButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizqButton3ActionPerformed(evt);
            }
        });

        colorizqButton4.setBackground(new java.awt.Color(153, 255, 255));
        colorizqButton4.setText("Save");
        colorizqButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        colorizqButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorizqButton4ActionPerformed(evt);
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
                    .addComponent(ShapeListCobmoBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(colorizqButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorizqButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorizqButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorizqButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colorizqButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PositionChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ResizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(colorizqButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorizqButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorizqButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorizqButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
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

    private void colorizqButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizqButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorizqButton1ActionPerformed

    private void colorizqButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizqButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorizqButton2ActionPerformed

    private void colorizqButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizqButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorizqButton3ActionPerformed

    private void colorizqButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorizqButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorizqButton4ActionPerformed

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
                
                String newSideInput = JOptionPane.showInputDialog(this, "Enter new side length:");
                if (newSideInput != null) {
                    double newSide = Double.parseDouble(newSideInput);
                    selectedShape.getProperties().put("side", newSide);
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
    private javax.swing.JButton PositionChangeButton;
    private javax.swing.JButton ResizeButton;
    private javax.swing.JComboBox<String> ShapeListCobmoBox;
    private javax.swing.JButton circleButton;
    private javax.swing.JButton colorizqButton;
    private javax.swing.JButton colorizqButton1;
    private javax.swing.JButton colorizqButton2;
    private javax.swing.JButton colorizqButton3;
    private javax.swing.JButton colorizqButton4;
    private javax.swing.JPanel drawPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lineButton;
    private javax.swing.JButton rectangleButton;
    private javax.swing.JButton squareButton;
    // End of variables declaration//GEN-END:variables
}
