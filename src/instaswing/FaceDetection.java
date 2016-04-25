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
}