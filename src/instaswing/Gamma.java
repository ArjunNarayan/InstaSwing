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
import java.lang.Math;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.imread;

/**
 *
 * @author arjun
 */
public class Gamma {
    static BufferedImage adjust(String imagePath,double gamma)
    {
        double invGamma = 1.0/gamma;
        BufferedImage image = null;
        try{
            BufferedImage imageIO;
            image = ImageIO.read(new File(imagePath));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage gammaCorrected = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        for(int i = 0;i < height;i++)
        {
            for(int j = 0; j < width;j++)
            {
                Color c = new Color(image.getRGB(j, i));
               // int alpha = c.getAlpha();
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                r = (int) (255 * (Math.pow((double)r/(double)255,invGamma)));
                g = (int) (255 * (Math.pow((double)g/(double)255,invGamma)));
                b = (int) (255 * (Math.pow((double)b/(double)255,invGamma)));
                
                Color newColor = new Color(r,g,b);
                gammaCorrected.setRGB(j, i, newColor.getRGB());
                
            }
        }
        return gammaCorrected;
    }
    public static void main(String args[])
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        double gamma  = 2.5;
        BufferedImage output = adjust("/home/arjun/Pictures/dsc_0278.jpg",gamma);
        File outputfile = new File("image3.png");
        try{
            ImageIO.write(output, "png", outputfile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
