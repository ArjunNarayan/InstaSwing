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
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Range;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import static org.opencv.imgproc.Imgproc.rectangle;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author arjun
 */
public class FaceDetection {
    public static BufferedImage removeRedEye(BufferedImage image)
    {
        Mat imageMat = Utility.bufferedToMat(image);
        CascadeClassifier eyeDetector = new CascadeClassifier("eyeCascade.xml");
        MatOfRect eyeDetections = new MatOfRect();
        eyeDetector.detectMultiScale(imageMat, eyeDetections);
        for(Rect rect : eyeDetections.toArray())
        {
            for(int i = rect.y;i <= rect.y+rect.height;i++)
            {
                for(int j = rect.x;j <= rect.x+rect.width;j++)
                {
                    double[] pixel = imageMat.get(i, j);
                    double red = pixel[0];
                    double green = pixel[1];
                    double blue = pixel[2];
                    //System.out.println(red+" "+blue+" "+green);
                    double redIntensity = red/((blue+green)/2);
                    if(redIntensity > 1.7)
                    {
                        red = (green+blue)/2;
                        pixel[0] = red;
                        //pixel[1] = 0;
                        //pixel[2] = 0;
                    }
                    imageMat.put(i, j, pixel);
                    //System.out.println(red+" "+blue+" "+green);
                }
            }
        }
        return Utility.matToBuffered(imageMat);
    }
    public static void main(String[] args)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int beta  = 25;
        String imagePath = "/home/arjun/Pictures/Red2.jpg";
        BufferedImage image = Utility.readImage(imagePath);
        int x = image.getType();
        if(x==5)
        {
           // image = Utility.covertTo4Channel(image);
            x = image.getType();
            File outputfile = new File("/home/arjun/Pictures/conversion");
            try{
            
                ImageIO.write(image, "png", outputfile);
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            
        }
        System.out.println(x);
        BufferedImage output = removeRedEye(image);//sepia(image,beta);
        int y = output.getType();
        System.out.println(y);
        File outputfile = new File("/home/arjun/Pictures/faces");
        try{
            
            ImageIO.write(output, "png", outputfile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
