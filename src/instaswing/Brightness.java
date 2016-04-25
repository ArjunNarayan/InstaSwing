/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import jdk.nashorn.internal.parser.TokenType;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.imread;

/**
 *
 * @author arjun
 */
public class Brightness {
    public static BufferedImage adjust(BufferedImage bi,int beta)
    {
        if(beta == 50)
            beta = 0;
        else if (beta < 50)
            beta = -(100/beta)*10;
        else
            beta = (beta/25)*10;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Utility.bufferedToMat(bi);
        Mat new_image = Mat.zeros(image.size(), image.type());
        image.convertTo(new_image, -1, 1, beta);
        int width = new_image.width();
        int height = new_image.height();
        System.out.println(image.width());
        System.out.println(image.height());
        BufferedImage outputImage = Utility.matToBufferedSimple(new_image);
        return outputImage;
    }
}