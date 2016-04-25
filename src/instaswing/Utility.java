/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author arjun
 */
public class Utility {
    public static Mat bufferedToMat(BufferedImage image)
    {
        byte[] pixels = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        Mat imageMat = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC3);
        imageMat.put(0, 0, pixels);
        return imageMat;
    }
    public static BufferedImage fixChannels(BufferedImage image)
    {
        Mat imageMat = bufferedToMat(image);
        Mat fixedMat = new Mat(imageMat.height(),imageMat.width(),CvType.CV_8UC4);
        if(false)//imageMat.channels() == 4)
        {
            Imgproc.cvtColor(imageMat, fixedMat, Imgproc.COLOR_BGRA2BGR);
        }
        else
        {
            imageMat.copyTo(fixedMat);
        }
        return matToBuffered(fixedMat);
    }
    public static BufferedImage covertTo4Channel(BufferedImage image)
    {
        byte[] pixels = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        Mat imageMat = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC3);
        imageMat.put(0, 0, pixels);
        Imgproc.cvtColor(imageMat, imageMat, Imgproc.COLOR_BGR2BGRA);
        return Utility.matToBuffered(imageMat);
    }
    
    public static BufferedImage matToBuffered(Mat imageMat)
    {
        BufferedImage out;
        byte[] data = new byte[imageMat.cols()*imageMat.rows()*(int)imageMat.elemSize()];
        imageMat.get(0, 0,data);
        int type = BufferedImage.TYPE_3BYTE_BGR;
        if(imageMat.channels() == 1)
        {
            type = BufferedImage.TYPE_BYTE_GRAY;
        }
        else if(imageMat.channels() == 3)
        {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        else if(imageMat.channels() == 4)
        {
            type = BufferedImage.TYPE_4BYTE_ABGR;
        }
        out = new BufferedImage(imageMat.cols(),imageMat.rows(),type);
        out.getRaster().setDataElements(0,0,imageMat.cols(),imageMat.rows(),data);  
        return out;
    }
    
    public static BufferedImage matToBufferedSimple(Mat imageMat)
    {
        BufferedImage outputImage = new BufferedImage(imageMat.width(),imageMat.height(),BufferedImage.TYPE_4BYTE_ABGR);
        byte[] data = ((DataBufferByte) outputImage.getRaster().getDataBuffer()).getData();
        imageMat.get(0, 0,data);
        return outputImage;
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bufferedImage.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bufferedImage;
       
    }
    
    public static BufferedImage readImage(String imagePath)
    {
        Mat image = imread(imagePath);
        Imgproc.cvtColor(image, image,Imgproc.COLOR_RGB2BGR);
        return Utility.matToBuffered(image);
    }
    
}