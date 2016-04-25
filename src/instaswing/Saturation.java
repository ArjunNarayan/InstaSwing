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

/**
 *
 * @author arjun
 */
public class Saturation {
    public static BufferedImage redSaturation(BufferedImage image,int amount)
    {
        Mat imageMat = Utility.bufferedToMat(image);
        for(int i=0;i<imageMat.rows();i++)
        {
            for(int j=0;j<imageMat.cols();j++)
            {
                double[] data = imageMat.get(i,j);
//                for(double debu : data)
//                    System.out.println(debu);
                double red = data[0];
                red = red + amount;
                data[0]= red;
                if(data[0]>255)data[0]=255;
                imageMat.put(i, j, data);
            }
        }
        return Utility.matToBuffered(imageMat);
    }
    public static BufferedImage greenSaturation(BufferedImage image,int amount)
    {
        Mat imageMat = Utility.bufferedToMat(image);
        for(int i=0;i<imageMat.rows();i++)
        {
            for(int j=0;j<imageMat.cols();j++)
            {
                double[] data = imageMat.get(i,j);
                data[1] += amount+data[1];
                if(data[1]>255)data[1]=255;
                imageMat.put(i, j, data);
            }
        }
        return Utility.matToBuffered(imageMat);
    }
    public static BufferedImage blueSaturation(BufferedImage image,int amount)
    {
        Mat imageMat = Utility.bufferedToMat(image);
        for(int i=0;i<imageMat.rows();i++)
        {
            for(int j=0;j<imageMat.cols();j++)
            {
                double[] data = imageMat.get(i,j);
                data[2] += amount+data[2];
                if(data[2]>255)data[2]=255;
                imageMat.put(i, j, data);
            }
        }
        return Utility.matToBuffered(imageMat);
    }
    public static BufferedImage allSaturation(BufferedImage image,int amount)
    {
     Mat imageMat = Utility.bufferedToMat(image);
        for(int i=0;i<imageMat.rows();i++)
        {
            for(int j=0;j<imageMat.cols();j++)
            {
                double[] data = imageMat.get(i,j);
                data[2] += amount+data[2];
                data[1] += amount+data[1];
                data[0] += amount+data[0];
                if(data[2]>255)data[2]=255;
                if(data[1]>255)data[1]=255;
                if(data[0]>255)data[0]=255;
                imageMat.put(i, j, data);
            }
        }
        return Utility.matToBuffered(imageMat);   
    }
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int beta  = 75;
        String imagePath = "/home/arjun/Pictures/Lenna.png";
        BufferedImage image = Utility.readImage(imagePath);
        int x = image.getType();
        System.out.println(x);
        BufferedImage outputred = redSaturation(image,beta);
        BufferedImage outputblue = blueSaturation(image,beta);
        BufferedImage outputgreen = greenSaturation(image,beta);
        BufferedImage outputAll = allSaturation(image,beta);
        File outputfilered = new File("/home/arjun/Pictures/satRed");
        File outputfileblue = new File("/home/arjun/Pictures/satBlue");
        File outputfilegreen = new File("/home/arjun/Pictures/satGreen");
        File outputfileall = new File("/home/arjun/Pictures/satAll2");
        try{
            
            ImageIO.write(outputred, "png", outputfilered);
            ImageIO.write(outputblue, "png", outputfileblue);
            ImageIO.write(outputgreen, "png", outputfilegreen);
            ImageIO.write(outputAll,"png",outputfileall);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
