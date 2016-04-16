/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import static org.opencv.imgcodecs.Imgcodecs.imencode;
import static org.opencv.imgcodecs.Imgcodecs.imencode;


/**
 *
 * @author anuraag
 */
public class Utility {
    public static Mat bufferedToMat(BufferedImage image)
    {
        byte[] pixels = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        Mat imageMat = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC4);
        imageMat.put(0, 0, pixels);
        return imageMat;
    }
    
    public static BufferedImage matToBuffered(Mat imageMat)
    {
        BufferedImage outputImage = new BufferedImage(imageMat.width(),imageMat.height(),BufferedImage.TYPE_4BYTE_ABGR);
        byte[] data = ((DataBufferByte) outputImage.getRaster().getDataBuffer()).getData();
        imageMat.get(0, 0,data);
        return outputImage;
    }
    
}
