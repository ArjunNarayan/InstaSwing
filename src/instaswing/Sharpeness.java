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
import org.opencv.core.Size;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author arjun
 */
public class Sharpeness {
    public static BufferedImage adjust(BufferedImage bi,int beta)
    {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Utility.bufferedToMat(bi);
        Mat destination = destination = new Mat(image.rows(),image.cols(),image.type());
	Imgproc.GaussianBlur(image, destination, new Size(0,0), beta);
	Core.addWeighted(image, 2, destination, -1, 0, destination);
        BufferedImage outputImage = Utility.matToBufferedSimple(destination);
        return outputImage;
    }
}