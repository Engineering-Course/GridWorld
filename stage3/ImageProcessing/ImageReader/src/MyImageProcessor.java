/*
 * @author Gong Ke
 */

import imagereader.IImageProcessor;

import java.awt.*;
import java.awt.image.*;

/**
 * MyImageProcessor class implements IImageProcessor.
 * It implements showChanelR, showChanelG, showChanelB, showGray,
 * four methods.
 */
public class MyImageProcessor implements IImageProcessor
{

    /**
     * Firstly, write the Fileter class extends RGBImageFilter,
     * to difine and get the color channel.
     */
    class RedFilter extends RGBImageFilter
    {
        public int filterRGB(int x, int y, int rgb)
        {
            return (rgb & 0xffff0000);
        }
    }

    class GreenFilter extends RGBImageFilter
    {
        public int filterRGB(int x, int y, int rgb)
        {
            return (rgb & 0xff00ff00);
        }
    }

    class BlueFilter extends RGBImageFilter
    {
        public int filterRGB(int x, int y, int rgb)
        {
            return (rgb & 0xff0000ff);
        }
    }
    /**
     * the formula for changing color image to grayscale image.
     * I = 0.299 * R + 0.587 * G + 0.144 * B;
     * three color channel uses the factor to get grayscale image.
     */

    class GrayFilter extends RGBImageFilter
    {
        public int filterRGB(int x, int y, int rgb)
        {
            int factor = (int)(((rgb & 0x00ff0000) >> 16) * 0.299 +
            		           ((rgb & 0x0000ff00) >> 8) * 0.587 +
            		           (rgb & 0x000000ff) * 0.114);
            int gray = (factor << 16) + (factor << 8) + factor;
            return ((rgb & 0xff000000) + gray);
        }
    }
    /**
     * showing images with color channel.
     */

	public Image showChanelR(Image sourceImage)
	{
    RedFilter red = new RedFilter();
    Image image = Toolkit.getDefaultToolkit().createImage(
        		      new FilteredImageSource(sourceImage.getSource(), red));
    return image;
	}
	public Image showChanelG(Image sourceImage)
	{
    GreenFilter green = new GreenFilter();
    Image image = Toolkit.getDefaultToolkit().createImage(
        		      new FilteredImageSource(sourceImage.getSource(), green));
    return image;
	}
	public Image showChanelB(Image sourceImage)
	{
    BlueFilter blue = new BlueFilter();
    Image image = Toolkit.getDefaultToolkit().createImage(
        		      new FilteredImageSource(sourceImage.getSource(), blue));
    return image;
	}
	public Image showGray(Image sourceImage)
	{
    GrayFilter gray = new GrayFilter();
    Image image = Toolkit.getDefaultToolkit().createImage(
                      new FilteredImageSource(sourceImage.getSource(), gray));
    return image;
	}



}
