/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instaswing;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author arjun
 */
public class Steganography {
    
    
    Steganography()
    {
        
    }
    
    public static boolean encode(String path,String steganpath,String message)
    {
        BufferedImage image = null;
        try
        {
            BufferedImage orig = getImage(path);
            image = userSpace(orig);
            image = addText(image,message);
            File output = new File(steganpath);
            ImageIO.write(image, "png", output);
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static String decode(String path)
    {
        byte[] decode;
        try
        {
            BufferedImage image = userSpace(getImage(path));
            decode = decodeText(getByteData(image));
            return (new String(decode));
        }catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
    
    private static byte[] getByteData(BufferedImage image)
    {
        WritableRaster imageRaster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte)imageRaster.getDataBuffer();
        return buffer.getData();
    }
    private static BufferedImage addText(BufferedImage image,String text)
    {
        byte[] img = getByteData(image);
        byte[] msg = text.getBytes();
        byte[] len = bitConversion(msg.length);
        try{
            encodeText(img,len,0);
            encodeText(img,msg,32);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return image;
        
    }
    private static BufferedImage getImage(String path)
    {
        BufferedImage orig = null;
        File file = new File(path);
        try
        {
            orig = ImageIO.read(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return orig;
    }
    
    
    //This method is for all images to be completely new and created.This makes sure there are no errors
    private static BufferedImage userSpace(BufferedImage image)
    {
        BufferedImage x = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = x.createGraphics();
        graphics.drawRenderedImage(image, null);
        graphics.dispose();
        return x;
    }
    
    //Convert to bytes
    
    private static byte[] bitConversion(int i)
    {
        byte byte3 = (byte)((i & 0xFF000000) >>> 24);
        byte byte2 = (byte)((i & 0x00FF0000) >>> 16);
        byte byte1 = (byte)((i & 0x0000FF00) >>> 8);
        byte byte0 = (byte)(i & 0x000000FF);
        return (new byte[]{byte3,byte2,byte1,byte0});
    }
     
    private static byte[] encodeText(byte[] image,byte[] addition,int offset)
    {
        if((addition.length + offset) > image.length)
        {
            System.out.println("Image too small");
            return null;
        }
        for(int i=0; i < addition.length;i++)
        {
            int add = addition[i];
            for(int bit = 7;bit>=0;--bit,++offset)
            {
                int b = (add >>> bit) & 1;
                image[offset] = (byte)((image[offset]&0xFE) | b);
            }
        }
        return image;
    }
    private static byte[] decodeText(byte[] image)
    {
        int length = 0;
        int offset = 32;
        for(int i=0;i<32;i++)
        {
            length = (length << 1) | (image[i] & 1);
        }
        byte[] result = new byte[length];
        for(int b = 0; b < result.length;b++)
        {
            for(int i = 0;i < 8; i++,offset++)
            {
                result[b] = (byte)((result[b] << 1) | (image[offset] & 1));
            }
        }
        
        return result;
    }
    
    public static void main(String args[])
    {
        String path = "/home/arjun/Pictures/Lenna.png";
        String outputPath = "/home/arjun/Pictures/out.png";
        String message = "WEED";
        if(encode(path,outputPath,message))
        {
            System.out.println("Great Success!");
        }
        else
        {
            System.out.println("Great Failure!");
        }
        String messageDecoded = decode(outputPath);
        System.out.println(messageDecoded);
    }
    
}
