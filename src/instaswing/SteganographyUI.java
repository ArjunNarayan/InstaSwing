/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author anuraag
 */
public class SteganographyUI extends javax.swing.JFrame {

    /**
     * Creates new form Steganography
     */
    BufferedImage userImage;
    public SteganographyUI() {
//        try{
//            File image = new File("/home/anuraag/Documents/Projects/InstaSwing/bg.png");
//            BufferedImage background = ImageIO.read(image);
//            background = Utility.resize(background, 720, 360);
//            this.setContentPane(new ImagePanel(background));
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
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

        encodeButton = new javax.swing.JButton();
        decodeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(360, 360));

        Border line = new LineBorder(Color.WHITE);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        encodeButton.setForeground(Color.BLACK);
        encodeButton.setBackground(Color.WHITE);
        encodeButton.setBorder(compound);
        encodeButton.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        encodeButton.setText("Encode");
        encodeButton.setToolTipText("");
        encodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeButtonActionPerformed(evt);
            }
        });

        decodeButton.setForeground(Color.BLACK);
        decodeButton.setBackground(Color.WHITE);
        decodeButton.setBorder(compound);
        decodeButton.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        decodeButton.setText("Decode");
        decodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeButtonActionPerformed(evt);
            }
        });

        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.WHITE);
        backButton.setBorder(compound);
        backButton.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encodeButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(decodeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(encodeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decodeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encodeButtonActionPerformed
        
        String steganpath = null;
        String message = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose File to Encode");
        int rVal = chooser.showOpenDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            try{
                File image = chooser.getSelectedFile();
                userImage = ImageIO.read(image);
                message = JOptionPane.showInputDialog(null,
                "Enter Message",
                "Enter Message",
                JOptionPane.QUESTION_MESSAGE);
                
                chooser.setDialogTitle("Choose Location to Save");
                rVal = chooser.showSaveDialog(this);
                if(rVal == JFileChooser.APPROVE_OPTION ){  
            
                    File outputImage = chooser.getSelectedFile();
                    steganpath = outputImage.getAbsolutePath();
                    if(Steganography.encode(userImage, steganpath , message))
                        JOptionPane.showMessageDialog(this, "Encoded Successfully");
                    else
                        JOptionPane.showMessageDialog(this, "Encode Failed");
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            
        }
        
    }//GEN-LAST:event_encodeButtonActionPerformed

    private void decodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeButtonActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose File to Decode");
        int rVal = chooser.showOpenDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            try{
                File image = chooser.getSelectedFile();
                userImage = ImageIO.read(image);
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
        if (rVal == JFileChooser.CANCEL_OPTION) {

        }
        
        String message = Steganography.decode(userImage);
        if(message == null)
            JOptionPane.showMessageDialog(this, "Not an encoded image");
        else
            JOptionPane.showMessageDialog(this, message);
        
    }//GEN-LAST:event_decodeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
        this.hide();
        new MainScreen().show();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SteganographyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SteganographyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SteganographyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SteganographyUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SteganographyUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton decodeButton;
    private javax.swing.JButton encodeButton;
    // End of variables declaration//GEN-END:variables
}
