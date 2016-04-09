/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author anuraag
 */
public class MainScreen extends javax.swing.JFrame {

    File userImage;
    String userImagePath;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
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
        helpButton = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Nimbus Sans L", 0, 14)); // NOI18N

        jToolBar1.setRollover(true);

        openButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
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

        saveButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        saveButton.setMaximumSize(new java.awt.Dimension(90, 35));
        saveButton.setMinimumSize(new java.awt.Dimension(90, 35));
        saveButton.setPreferredSize(new java.awt.Dimension(90, 35));
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(saveButton);

        helpButton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        helpButton.setText("Help");
        helpButton.setFocusable(false);
        helpButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpButton.setMargin(new java.awt.Insets(5, 14, 5, 14));
        helpButton.setMaximumSize(new java.awt.Dimension(90, 35));
        helpButton.setMinimumSize(new java.awt.Dimension(90, 35));
        helpButton.setPreferredSize(new java.awt.Dimension(90, 35));
        helpButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(helpButton);

        imageLabel.setBackground(new java.awt.Color(19, 143, 226));

        brightnessLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        brightnessLabel.setText("Brightness");

        sharpnessSlider.setMaximum(16);
        sharpnessSlider.setPaintTicks(true);
        sharpnessSlider.setValue(8);

        shaprnessLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        shaprnessLabel.setText("Sharpness");

        coontrastLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        coontrastLabel.setText("Contrast");

        contrastSlider.setMaximum(4);
        contrastSlider.setValue(2);

        sharpnessOKButton.setText("OK");
        sharpnessOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sharpnessOKButtonActionPerformed(evt);
            }
        });

        brightnessOKButton.setText("OK");
        brightnessOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brightnessOKButtonActionPerformed(evt);
            }
        });

        contrastOKButton.setText("OK");
        contrastOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrastOKButtonActionPerformed(evt);
            }
        });

        gammaSlider.setMaximum(10);
        gammaSlider.setValue(5);

        shaprnessLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        shaprnessLabel1.setText("Gamma");

        gammaOKButton.setText("OK");
        gammaOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gammaOKButtonActionPerformed(evt);
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
                                    .addComponent(sharpnessOKButton))))
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
                            .addComponent(gammaOKButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
      // Demonstrate "Open" dialog:
      int rVal = chooser.showOpenDialog(this);
      if (rVal == JFileChooser.APPROVE_OPTION) {
          try{
              userImage = chooser.getSelectedFile();
              BufferedImage image = ImageIO.read(userImage);
              BufferedImage resizedImage = resize(image, 640, 480);
              ImageIcon imageIcon = new ImageIcon(resizedImage);
              imageLabel.setIcon(imageIcon);
              userImagePath = userImage.getAbsolutePath();
          }
          catch(IOException e){
              e.printStackTrace();
          }
        
      }
      if (rVal == JFileChooser.CANCEL_OPTION) {
        
      }
    }//GEN-LAST:event_openButtonActionPerformed

    private void brightnessOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brightnessOKButtonActionPerformed

        BufferedImage output = Brightness.adjust(userImagePath, brightnessSlider.getValue());
        output = resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(output);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_brightnessOKButtonActionPerformed

    private void sharpnessOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sharpnessOKButtonActionPerformed
        
        BufferedImage output = Sharpeness.adjust(userImagePath, sharpnessSlider.getValue());
        output = resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(output);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_sharpnessOKButtonActionPerformed

    private void gammaOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gammaOKButtonActionPerformed
        
        BufferedImage output = Gamma.adjust(userImagePath, gammaSlider.getValue());
        output = resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(output);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_gammaOKButtonActionPerformed

    private void contrastOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrastOKButtonActionPerformed
       
        BufferedImage output = Contrast.adjust(userImagePath, contrastSlider.getValue());
        output = resize(output, 640, 480);
        ImageIcon imageIcon = new ImageIcon(output);
        imageLabel.setIcon(imageIcon);
    }//GEN-LAST:event_contrastOKButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bufferedImage.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, width, height, null);
    g2d.dispose();
    return bufferedImage;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brightnessLabel;
    private javax.swing.JButton brightnessOKButton;
    private javax.swing.JSlider brightnessSlider;
    private javax.swing.JButton contrastOKButton;
    private javax.swing.JSlider contrastSlider;
    private javax.swing.JLabel coontrastLabel;
    private javax.swing.JButton gammaOKButton;
    private javax.swing.JSlider gammaSlider;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton openButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel shaprnessLabel;
    private javax.swing.JLabel shaprnessLabel1;
    private javax.swing.JButton sharpnessOKButton;
    private javax.swing.JSlider sharpnessSlider;
    // End of variables declaration//GEN-END:variables
}
