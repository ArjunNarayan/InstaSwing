/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.imread;

/**
 *
 * @author arjun
 */
public class Brightness {
    public static BufferedImage adjust(String ImagePath,int beta)
    {
        Mat image = imread(ImagePath);
        Mat new_image = Mat.zeros(image.size(), image.type());
        image.convertTo(new_image, -1, 1, beta);
        int width = new_image.width();
        int height = new_image.height();
        System.out.println(image.width());
        System.out.println(image.height());
        BufferedImage outputImage = new BufferedImage(new_image.width(),new_image.height(),BufferedImage.TYPE_3BYTE_BGR);
        byte[] data = ((DataBufferByte) outputImage.getRaster().getDataBuffer()).getData();
        new_image.get(0, 0,data);
        return outputImage;
    }
    //Only for testing will be removed later
    public static void main(String args[])
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int beta  = 55;
        BufferedImage output = adjust("/home/arjun/Pictures/Lenna.png",beta);
        File outputfile = new File("image2.png");
        try{
            ImageIO.write(output, "png", outputfile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}