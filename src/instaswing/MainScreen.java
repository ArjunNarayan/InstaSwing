/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.opencv.core.Core;
import org.opencv.core.Mat;


/**
 *
 * @author anuraag
 */
public class MainScreen extends javax.swing.JFrame {

   
    BufferedImage userImage;
    String userImagePath;
    String outputImagePath;
    BufferedImage output;
    BufferedImage backup;
    BufferedImage outputPreview;
    boolean imageEdited = false;
    boolean imageSaved = false;
    boolean imageFiltered = false;
    MainScreen mainscreen;
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        try{
            File image = new File("/home/anuraag/Documents/Projects/InstaSwing/bg.png");
            BufferedImage background = ImageIO.read(image);
            background = Utility.resize(background, 1200, 600);
            this.setContentPane(new ImagePanel(background));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if(!imageSaved){
                    if (JOptionPane.showConfirmDialog(mainscreen, 
                        "You have unsaved changes! Save them?", "Really Closing?", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        saveImage();
                            System.exit(0);
            
                    }
                    else
                        new File("savedImage.png").delete();
                }
            }
        });
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        steganographyButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        brightnessLabel = new javax.swing.JLabel();
        brightnessSlider = new javax.swing.JSlider();
        sharpnessSlider = new javax.swing.JSlider();
        shaprnessLabel = new javax.swing.JLabel();
        coontrastLabel = new javax.swing.JLabel();
        contrastSlider = new javax.swing.JSlider();
        sharpnessOKButton = new javax.swing.JButton();
        brightnessOKButton = new javax.swing.JButton();
        contrastOKButton = new javax.swing.JButton();
        gammaSlider = new javax.swing.JSlider();
        shaprnessLabel1 = new javax.swing.JLabel();
        gammaOKButton = new javax.swing.JButton();
        sketchButton = new javax.swing.JButton();
        grayscaleButton = new javax.swing.JButton();
        sepiaButton = new javax.swing.JButton();
        cartoonButton = new javax.swing.JButton();
        wierdnessButton = new javax.swing.JButton();
        invertedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Nimbus Sans L", 0, 14)); // NOI18N

        jToolBar1.setRollover(true);

        Border line = new LineBorder(Color.WHITE);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        openButton.setForeground(Color.BLACK);
        openButton.setBackground(Color.WHITE);
        openButton.setBorder(compound);
        openButton.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        openButton.setText("Open");
        openButton.setFocusable(false);
        openButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        openButton.setMaximumSize(new java.awt.Dimension(90, 35));
        openButton.setMinimumSize(new java.awt.Dimension(90, 35));
        openButton.setPreferredSize(new java.awt.Dimension(90, 35));
        openButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(openButton);

        saveButton.setForeground(Color.BLACK);
        saveButton.setBackground(Color.WHITE);
        saveButton.setBorder(compound);
        saveButton.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        saveButton.setText("Save");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        saveButton.setMaximumSize(new java.awt.Dimension(90, 35));
        saveButton.setMinimumSize(new java.awt.Dimension(90, 35));
        saveButton.setPreferredSize(new java.awt.Dimension(90, 35));
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton);

        steganographyButton.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        steganographyButton.setText("Steganography");
        steganographyButton.setFocusable(false);
        steganographyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        steganographyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        steganographyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                steganographyButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(steganographyButton);

        imageLabel.setBackground(new java.awt.Color(19, 143, 226));

        brightnessLabel.setFont(new java.awt.Font("URW Chancery L", 0, 20)); // NOI18N
        brightnessLabel.setText("Brightness");

        brightnessSlider.setMinimum(1);
        brightnessSlider.setValue(0);

        sharpnessSlider.setMaximum(16);
        sharpnessSlider.setPaintTicks(true);
        sharpnessSlider.setValue(0);

        shaprnessLabel.setFont(new java.awt.Font("URW Chancery L", 0, 20)); // NOI18N
        shaprnessLabel.setText("Sharpness");

        coontrastLabel.setFont(new java.awt.Font("URW Chancery L", 0, 20)); // NOI18N
        coontrastLabel.setText("Contrast");

        contrastSlider.setMaximum(50);
        contrastSlider.setMinimum(10);
        contrastSlider.setValue(0);

        sharpnessOKButton.setForeground(Color.BLACK);
        sharpnessOKButton.setBackground(Color.WHITE);
        sharpnessOKButton.setBorder(compound);
        sharpnessOKButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        sharpnessOKButton.setText("OK");
        sharpnessOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sharpnessOKButtonActionPerformed(evt);
            }
        });

        brightnessOKButton.setForeground(Color.BLACK);
        brightnessOKButton.setBackground(Color.WHITE);
        brightnessOKButton.setBorder(compound);
        brightnessOKButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        brightnessOKButton.setText("OK");
        brightnessOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brightnessOKButtonActionPerformed(evt);
            }
        });

        contrastOKButton.setForeground(Color.BLACK);
        contrastOKButton.setBackground(Color.WHITE);
        contrastOKButton.setBorder(compound);
        contrastOKButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        contrastOKButton.setText("OK");
        contrastOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrastOKButtonActionPerformed(evt);
            }
        });

        gammaSlider.setMaximum(10);
        gammaSlider.setValue(0);

        shaprnessLabel1.setFont(new java.awt.Font("URW Chancery L", 0, 20)); // NOI18N
        shaprnessLabel1.setText("Gamma");

        gammaOKButton.setForeground(Color.BLACK);
        gammaOKButton.setBackground(Color.WHITE);
        gammaOKButton.setBorder(compound);
        gammaOKButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        gammaOKButton.setText("OK");
        gammaOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gammaOKButtonActionPerformed(evt);
            }
        });

        sketchButton.setForeground(Color.BLACK);
        sketchButton.setBackground(Color.WHITE);
        sketchButton.setBorder(compound);
        sketchButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        sketchButton.setText("Sketch");
        sketchButton.setMaximumSize(new java.awt.Dimension(101, 31));
        sketchButton.setMinimumSize(new java.awt.Dimension(101, 31));
        sketchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sketchButtonActionPerformed(evt);
            }
        });

        grayscaleButton.setForeground(Color.BLACK);
        grayscaleButton.setBackground(Color.WHITE);
        grayscaleButton.setBorder(compound);
        grayscaleButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        grayscaleButton.setText("GrayScale");
        grayscaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grayscaleButtonActionPerformed(evt);
            }
        });

        sepiaButton.setForeground(Color.BLACK);
        sepiaButton.setBackground(Color.WHITE);
        sepiaButton.setBorder(compound);
        sepiaButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        sepiaButton.setText("Sepia");
        sepiaButton.setMaximumSize(new java.awt.Dimension(101, 31));
        sepiaButton.setMinimumSize(new java.awt.Dimension(101, 31));
        sepiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepiaButtonActionPerformed(evt);
            }
        });

        cartoonButton.setForeground(Color.BLACK);
        cartoonButton.setBackground(Color.WHITE);
        cartoonButton.setBorder(compound);
        cartoonButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        cartoonButton.setText("Cartoon");
        cartoonButton.setMaximumSize(new java.awt.Dimension(101, 31));
        cartoonButton.setMinimumSize(new java.awt.Dimension(101, 31));
        cartoonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartoonButtonActionPerformed(evt);
            }
        });

        cartoonButton.setForeground(Color.BLACK);
        cartoonButton.setBackground(Color.WHITE);
        cartoonButton.setBorder(compound);
        wierdnessButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        wierdnessButton.setText("Wierdness");
        wierdnessButton.setMaximumSize(new java.awt.Dimension(101, 31));
        wierdnessButton.setMinimumSize(new java.awt.Dimension(101, 31));
        wierdnessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wierdnessButtonActionPerformed(evt);
            }
        });

        grayscaleButton.setForeground(Color.BLACK);
        grayscaleButton.setBackground(Color.WHITE);
        grayscaleButton.setBorder(compound);
        invertedButton.setFont(new java.awt.Font("URW Chancery L", 0, 18)); // NOI18N
        invertedButton.setText("Inverted");
        invertedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invertedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(brightnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(brightnessOKButton))
                            .addComponent(shaprnessLabel1)
                            .addComponent(shaprnessLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(contrastSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contrastOKButton))
                            .addComponent(coontrastLabel)
                            .addComponent(brightnessLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(gammaSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gammaOKButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(sharpnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sharpnessOKButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(wierdnessButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cartoonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sepiaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sketchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(grayscaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(invertedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(brightnessLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brightnessSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brightnessOKButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coontrastLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contrastOKButton)
                            .addComponent(contrastSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(shaprnessLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sharpnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sharpnessOKButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shaprnessLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gammaSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gammaOKButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sketchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sepiaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grayscaleButton)
                            .addComponent(cartoonButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invertedButton)
                            .addComponent(wierdnessButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
      JFileChooser chooser = new JFileChooser();
      int rVal = chooser.showOpenDialog(this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
          try{
              File image = chooser.getSelectedFile();
              userImage = ImageIO.read(image);
              BufferedImage resizedImage = Utility.resize(userImage, 640, 480);
              ImageIcon imageIcon = new ImageIcon(resizedImage);
              imageLabel.setIcon(imageIcon);
              userImagePath = image.getAbsolutePath();
          }
          catch(IOException e){
              e.printStackTrace();
          }
          imageEdited = false;
        
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
          
      }
    }//GEN-LAST:event_openButtonActionPerformed

    private void brightnessOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brightnessOKButtonActionPerformed

        if(!imageEdited){
            output = Brightness.adjust(userImage, brightnessSlider.getValue());
            imageEdited = true;
        }
        else{
            output = Brightness.adjust(output, brightnessSlider.getValue());
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_brightnessOKButtonActionPerformed

    private void sharpnessOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sharpnessOKButtonActionPerformed
        
        if(!imageEdited){
            output = Sharpeness.adjust(userImage, sharpnessSlider.getValue());
            imageEdited = true;
        }
        else{

            output = Sharpeness.adjust(output, sharpnessSlider.getValue());
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_sharpnessOKButtonActionPerformed

    private void gammaOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gammaOKButtonActionPerformed
        
        if(!imageEdited){
            output = Gamma.adjust(userImage, gammaSlider.getValue());
            imageEdited = true;
        }
        else
            output = Gamma.adjust(output, gammaSlider.getValue());
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_gammaOKButtonActionPerformed

    private void contrastOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrastOKButtonActionPerformed
       
        if(!imageEdited){
            output = Contrast.adjust(userImage, contrastSlider.getValue());
            imageEdited = true;
        }
        else{
            output = Contrast.adjust(output, contrastSlider.getValue());
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_contrastOKButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
       JFileChooser chooser = new JFileChooser();
       int rVal = chooser.showSaveDialog(this);
       if(rVal == JFileChooser.APPROVE_OPTION )
        try{
            File outputImage = chooser.getSelectedFile();
            ImageIO.write(output, "png", outputImage);
            imageSaved = true;
       }
       catch(IOException e){
           e.printStackTrace();
       }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void sepiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepiaButtonActionPerformed
        
        if(!imageEdited || !imageFiltered){
            backup = userImage;
            output = Filters.sepia(userImage, 25);
            imageEdited = true;
            imageFiltered = true;
        }
        else if(!imageFiltered){
            backup = output;
            output = Filters.sepia(output, 25);
            imageFiltered = true;
        }
        else{
            output = Filters.sepia(backup, 25);
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
        
    }//GEN-LAST:event_sepiaButtonActionPerformed

    private void sketchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sketchButtonActionPerformed
        if(!imageEdited && !imageFiltered){
            backup = userImage;
            output = Filters.sketch(userImage);
            imageEdited = true;
            imageFiltered = true;
        }
        else if(!imageFiltered){
            backup = output;
            output = Filters.sketch(output);
            imageFiltered = true;
        }
        else{
            output = Filters.sketch(backup);
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
        
    }//GEN-LAST:event_sketchButtonActionPerformed

    private void cartoonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartoonButtonActionPerformed
        
        if(!imageEdited || !imageFiltered){
            backup = userImage;
            output = Filters.cartoon(userImage);
            imageEdited = true;
            imageFiltered = true;
        }
        else if(!imageFiltered){
            backup = output;
            output = Filters.cartoon(output);
            imageFiltered = true;
        }
        else{
            output = Filters.cartoon(backup);
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
        
    }//GEN-LAST:event_cartoonButtonActionPerformed

    private void grayscaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grayscaleButtonActionPerformed
        
        if(!imageEdited || !imageFiltered){
            backup = userImage;
            output = Filters.grayscale(userImage);
            imageEdited = true;
            imageFiltered = true;
        }
        else if(!imageFiltered){
            backup = output;
            output = Filters.grayscale(output);
            imageFiltered = true;
        }
        else{
            output = Filters.grayscale(backup);
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
        
    }//GEN-LAST:event_grayscaleButtonActionPerformed

    private void steganographyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_steganographyButtonActionPerformed
        
        
        this.hide();
        SteganographyUI steganographyui = new SteganographyUI();
        steganographyui.show();
    }//GEN-LAST:event_steganographyButtonActionPerformed

    private void wierdnessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wierdnessButtonActionPerformed
        
        if(!imageEdited || !imageFiltered){
            backup = userImage;
            output = Filters.wierdness(userImage);
            imageEdited = true;
            imageFiltered = true;
        }
        else if(!imageFiltered){
            backup = output;
            output = Filters.wierdness(output);
            imageFiltered = true;
        }
        else{
            output = Filters.wierdness(backup);
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_wierdnessButtonActionPerformed

    private void invertedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invertedButtonActionPerformed
       
        if(!imageEdited || !imageFiltered){
            backup = userImage;
            output = Filters.inverted(userImage);
            imageEdited = true;
            imageFiltered = true;
        }
        else if(!imageFiltered){
            backup = output;
            output = Filters.inverted(output);
            imageFiltered = true;
        }
        else{
            output = Filters.inverted(backup);
        }
        outputPreview = Utility.resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(outputPreview);
        imageLabel.setIcon(imageIcon);
        
    }//GEN-LAST:event_invertedButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
        
        
    }
    
    
    public void saveImage(){
        
            try{
                File outputImage = new File("savedImage.png");
                ImageIO.write(output, "png", outputImage);
            }
            catch (IOException e){
                e.printStackTrace();
            }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brightnessLabel;
    private javax.swing.JButton brightnessOKButton;
    private javax.swing.JSlider brightnessSlider;
    private javax.swing.JButton cartoonButton;
    private javax.swing.JButton contrastOKButton;
    private javax.swing.JSlider contrastSlider;
    private javax.swing.JLabel coontrastLabel;
    private javax.swing.JButton gammaOKButton;
    private javax.swing.JSlider gammaSlider;
    private javax.swing.JButton grayscaleButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton invertedButton;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton openButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton sepiaButton;
    private javax.swing.JLabel shaprnessLabel;
    private javax.swing.JLabel shaprnessLabel1;
    private javax.swing.JButton sharpnessOKButton;
    private javax.swing.JSlider sharpnessSlider;
    private javax.swing.JButton sketchButton;
    private javax.swing.JButton steganographyButton;
    private javax.swing.JButton wierdnessButton;
    // End of variables declaration//GEN-END:variables
}
