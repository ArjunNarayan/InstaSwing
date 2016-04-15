/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.imread;

/**
 *
 * @author arjun
 */
public class Contrast {
    public static BufferedImage adjust(String ImagePath,double alpha)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = imread(ImagePath);
        Mat new_image = Mat.zeros(image.size(), image.type());
        image.convertTo(new_image, -1,alpha );
        int width = new_image.width();
        int height = new_image.height();
        System.out.println(image.width());
        System.out.println(image.height());
        BufferedImage outputImage = new BufferedImage(new_image.width(),new_image.height(),BufferedImage.TYPE_3BYTE_BGR);
        byte[] data = ((DataBufferByte) outputImage.getRaster().getDataBuffer()).getData();
        new_image.get(0, 0,data);
        return outputImage;
    }
}
