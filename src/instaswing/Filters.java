/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import static instaswing.Utility.bufferedToMat;
import static instaswing.Utility.matToBuffered;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Core;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static org.opencv.core.Core.bitwise_and;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.cvtColor;
/**
 *
 * @author arjun
 */
public class Filters {
    public static BufferedImage sepia(BufferedImage image,int intensity)
    {
        Mat imageMat = bufferedToMat(image);
        int sepiaDepth = 20;
        int width = image.getWidth();
        int height = image.getHeight();
        Mat grayScaleMat = new Mat(imageMat.height(),imageMat.width(),CvType.CV_8UC4);
        Imgproc.cvtColor(imageMat, grayScaleMat, Imgproc.COLOR_BGRA2GRAY);
        Imgproc.cvtColor(grayScaleMat,grayScaleMat,Imgproc.COLOR_GRAY2BGRA);
        double[] test = grayScaleMat.get(0,0);
        System.out.println(test[0]+" "+test[1]+" "+test[2]);
        for(int i=0;i<grayScaleMat.rows();i++)
        {
            for(int j=0;j<grayScaleMat.cols();j++)
            {
                double[] data = grayScaleMat.get(i, j);
                double blue = data[0];
                double green = data[1];
                double red = data[2];
                red += 2*sepiaDepth;
                green += sepiaDepth;
                blue -= intensity;
                if(red>255)red=255;
                if(green>255)green=255;
                if(blue<0)blue=0;
                data[0] = red;
                data[1] = green;
                data[2] = blue;
                grayScaleMat.put(i, j, data);
            }
        }
        
        return (Utility.matToBuffered(grayScaleMat));
    }
    public static BufferedImage sketch(BufferedImage image)
    {
        Mat imageMat = Utility.bufferedToMat(image);
        Mat outputMat = new Mat(imageMat.rows(),imageMat.cols(),CvType.CV_8UC4);
        Mat negativeMat = new Mat(imageMat.rows(),imageMat.cols(),CvType.CV_8UC4,new Scalar(255,255,255));
        Imgproc.cvtColor(imageMat, imageMat, Imgproc.COLOR_BGRA2GRAY);
        Imgproc.cvtColor(imageMat, imageMat, Imgproc.COLOR_GRAY2BGRA);
        Core.subtract(negativeMat, imageMat, negativeMat);
        Imgproc.GaussianBlur(negativeMat, negativeMat, new Size(15,15),10);
        for(int i =0;i<imageMat.rows();i++)
        {
            for(int j=0;j<imageMat.cols();j++)
            {
                double[] mask = negativeMat.get(i, j);
                if(mask[0] == 255)
                {
                    outputMat.put(i,j,mask);
                }
                else
                {
                    double[] blend = imageMat.get(i, j);
                    double a = blend[0];
                    double b = blend[0];
                    double c = blend[0];
                    a = ((int)a << 8)/(255-mask[0]);
                    if(a>255)a=255;
                    b = ((int)b << 8)/(255-mask[0]);
                    if(b>255)b=255;
                    c = ((int)c << 8)/(255-mask[0]);
                    if(c>255)c=255;
                    blend[0] = a;
                    blend[1] = b;
                    blend[2] = c;
                    outputMat.put(i, j, blend);
                }
            } /*for(int i =0;i<imageMat.rows();i++)
        {
            for(int j=0;j<imageMat.cols();j++)
            {
                double[] mask = negativeMat.get(i, j);
                if(mask[0] == 255)
                {
                    outputMat.put(i,j,mask);
                }
                else
                {
                    double[] blend = imageMat.get(i, j);
                    double a = 255-blend[0];
                    double b = 255-blend[0];
                    double c = 255-blend[0];
                    a = ((int)a << 8)/(255-mask[0]);
                    b = ((int)b << 8)/(255-mask[0]);
                    c = ((int)c << 8)/(255-mask[0]);
                    blend[0] = a;
                    blend[1] = b;
                    blend[2] = c;
                    outputMat.put(i, j, blend);
                }
            }
        }*/
        }
        
        return Utility.matToBuffered(outputMat);
    }
    public static BufferedImage cartoon(BufferedImage image)
    {
        int num_bilateral = 7;
        int num_down = 2;
        Mat imageMat = Utility.bufferedToMat(image);
        Mat bilateralMat = new Mat(imageMat.height(),imageMat.width(),CvType.CV_8UC3);
        Mat edgeMat = Utility.bufferedToMat(image);
        Imgproc.cvtColor(imageMat, bilateralMat, Imgproc.COLOR_BGRA2BGR);
        
        for(int i=0;i<num_down;i++)
        {
            Imgproc.pyrDown(bilateralMat, bilateralMat);
        }
        for(int i=0;i<num_bilateral;i++)
        {
            System.out.println(bilateralMat.channels());
           Imgproc.bilateralFilter(bilateralMat, bilateralMat, 9, 9, 7);
        }
        for(int i=0;i<num_down;i++)
        {
            Imgproc.pyrUp(bilateralMat, bilateralMat);
        }
        Mat bilateralMat2 = new Mat(imageMat.height(),imageMat.width(),CvType.CV_8UC4);
        Imgproc.cvtColor(bilateralMat,bilateralMat2,Imgproc.COLOR_BGR2BGRA);
        Imgproc.cvtColor(edgeMat,edgeMat,Imgproc.COLOR_BGR2GRAY);
        Imgproc.adaptiveThreshold(edgeMat, edgeMat,255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 9, 2);
        Imgproc.cvtColor(edgeMat, edgeMat, Imgproc.COLOR_GRAY2BGRA);
        bitwise_and(bilateralMat2,edgeMat,imageMat);
        return Utility.matToBuffered(imageMat);
    }
    
    public static BufferedImage grayscale(BufferedImage image)
    {
        Mat imageMat = bufferedToMat(image);
        int sepiaDepth = 20;
        int width = image.getWidth();
        int height = image.getHeight();
        Mat grayScaleMat = new Mat(imageMat.height(),imageMat.width(),CvType.CV_8UC4);
        Imgproc.cvtColor(imageMat, grayScaleMat, Imgproc.COLOR_BGRA2GRAY);
        Imgproc.cvtColor(grayScaleMat,grayScaleMat,Imgproc.COLOR_GRAY2BGRA);
        return (Utility.matToBuffered(grayScaleMat));
    }
    
    
    //Only Testing Remove Later
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int beta  = 25;
        String imagePath = "/home/arjun/Pictures/castle.png";
        BufferedImage image = null;
        try{
            
            image = ImageIO.read(new File(imagePath));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        int x = image.getType();
        if(x==5)
        {
            image = Utility.covertTo4Channel(image);
            x = image.getType();
            
        }
        System.out.println(x);
        BufferedImage output = sketch(image);//sepia(image,beta);
        int y = output.getType();
        System.out.println(y);
        File outputfile = new File("/home/arjun/Pictures/sepia2");
        try{
            
            ImageIO.write(output, "png", outputfile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}