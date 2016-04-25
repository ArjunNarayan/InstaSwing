/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author arjun
 */
public class Test {
    public static BufferedImage readImage(String imagePath)
    {
        Mat image = imread(imagePath);
        Imgproc.cvtColor(image, image,Imgproc.COLOR_RGB2BGR);
        return Utility.matToBuffered(image);
    }
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int beta  = 25;
        String imagePath = "/home/arjun/Pictures/airplane.png";
        BufferedImage image = readImage(imagePath);
         File outputfile = new File("/home/arjun/Pictures/test");
        try{
            
            ImageIO.write(image, "png", outputfile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
