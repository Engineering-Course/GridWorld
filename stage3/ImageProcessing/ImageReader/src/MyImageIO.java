/*
 * @authro Gong Ke
 */


import imagereader.*;

import java.io.*;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;

/**
 * MyImageIO class implements IImageIO.
 * It implements myRead and myWrite method.
 */

public class MyImageIO implements IImageIO
{
	private static final int INI_NUM = 0xff;
  /**
   * This method read bmp image file as binary streams.
   * It uses of bit operation method.
   * @param filepath the image file path.
   * @return the image it read.
   * @throws IOException
   */
  public Image myRead(String filePath) throws IOException
  {
    try {
      FileInputStream file = new FileInputStream(filePath);
      int bmpLen = 54;
      byte bmpIm[] = new byte[bmpLen];
      file.read(bmpIm, 0, bmpLen);
    /**
     * get the width of bmp
     */
      int bmpWidth = ((int)bmpIm[21] & INI_NUM) << 24;
      bmpWidth = bmpWidth | (((int)bmpIm[20] & INI_NUM) << 16);
      bmpWidth = bmpWidth | (((int)bmpIm[19] & INI_NUM) << 8);
      bmpWidth = bmpWidth | ((int)bmpIm[18] & INI_NUM);
    /**
     * get the height of bmp
     */
      int bmpHeight = ((int)bmpIm[25] & INI_NUM) << 24;
      bmpHeight = bmpHeight | (((int)bmpIm[24] & INI_NUM) << 16);
      bmpHeight = bmpHeight | (((int)bmpIm[23] & INI_NUM) << 8);
      bmpHeight = bmpHeight | ((int)bmpIm[22] & INI_NUM);
    /**
     * get the size of bmp
     */
      int bmpSize = ((int)bmpIm[37] & INI_NUM) << 24;
      bmpSize = bmpSize | (((int)bmpIm[36] & INI_NUM) << 16);
      bmpSize = bmpSize | (((int)bmpIm[35] & INI_NUM) << 8);
      bmpSize = bmpSize | ((int)bmpIm[34] & INI_NUM);
    /**
     * get the blank of each row.
     */
      int bmpAdd = (bmpSize / bmpHeight) - bmpWidth * 3;
      if (bmpAdd == 4)
      {
        bmpAdd = 0;
      }
    /**
     * create the color lattice.
     */
      int bmpData[] = new int[bmpWidth*bmpHeight];
      byte bmpColor[] = new byte[bmpSize];

      file.read(bmpColor, 0, bmpSize);

      int index = 0;
      int data;
      for (int h = bmpHeight - 1; h >= 0; h--) {
        for (int w = 0; w < bmpWidth; w++)
        {
        	data = INI_NUM << 24;
        	data = data | (((int)bmpColor[index+2] & INI_NUM) << 16);
        	data = data | (((int)bmpColor[index+1] & INI_NUM) << 8);
        	data = data | ((int)bmpColor[index] & INI_NUM);
    		bmpData[h * bmpWidth + w] = data;
            index += 3;
      	}
    	  index += bmpAdd;
      }
      Image image = Toolkit.getDefaultToolkit().createImage(
         new MemoryImageSource(bmpWidth,bmpHeight, bmpData, 0, bmpWidth));

	    file.close();
      return image;

    } catch (FileNotFoundException e) {
      return (Image)null;
    }
  }
  /**
   * The method can write the image to the file.
   * It uses the method in Image class.
   * @param image the image being written.
   * @param filePath the path of image file.
   * @return the image written.
   */
  public Image myWrite(Image image, String filePath)
  {
	  File fileImage = new File(filePath);
	  BufferedImage buffImage = new BufferedImage(image.getWidth(null),
			  image.getHeight(null), BufferedImage.TYPE_INT_RGB);
	  Graphics2D graphImage = buffImage.createGraphics();
	  graphImage.drawImage(image, 0, 0, null);
	  graphImage.dispose();
	  try {
	  	ImageIO.write(buffImage, "bmp", fileImage);
	  } catch (IOException e) {
		  return (Image)null;
	  }
	  return image;
  }
}
