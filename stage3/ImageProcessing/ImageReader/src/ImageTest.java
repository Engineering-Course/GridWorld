import static org.junit.Assert.assertEquals;

import imagereader.*;


import java.awt.*;
import java.awt.image.*;

import javax.imageio.*;
import java.io.IOException;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;



public class ImageTest {

  	MyImageIO myimage = new MyImageIO();
    MyImageProcessor myprocessing = new MyImageProcessor();

  @Before
	public void setUp() throws Exception {
	}
  /**
   * Test the showChanlR method using 1.bmp.
   * Test width, height, and pixel.
   */
	@Test
	public void testRed() throws IOException {

	  FileInputStream imageFile2 = new FileInputStream("1_red_goal.bmp");

	  Image image1 = myimage.myRead("1.bmp");
	  Image goalRed1 = myimage.myRead("1_red_goal.bmp");

	  Image red1 = myprocessing.showChanelR(image1);

      assertEquals(red1.getWidth(null), goalRed1.getWidth(null));
      assertEquals(red1.getHeight(null), goalRed1.getHeight(null));

      myimage.myWrite(red1, "1_red.bmp");
  
      FileInputStream imageFile1 = new FileInputStream("1_red.bmp");

      imageFile1.skip(54);
      imageFile2.skip(54);

      int color = imageFile1.read();
      int goalColor = imageFile2.read();
      while (color != -1 && goalColor != -1) {
        assertEquals(color, goalColor);
      color = imageFile1.read();
      goalColor = imageFile2.read();
    }
    imageFile1.close();
    imageFile2.close();
  }

	  /**
	   * Test the showChanlG method using 1.bmp.
	   * Test width, height, and pixel.
	   */	
	
	@Test
	public void testGreen() throws IOException {

	  FileInputStream imageFile4 = new FileInputStream("1_green_goal.bmp");

	  Image image1 = myimage.myRead("1.bmp");
	  Image goalGreen1 = myimage.myRead("1_green_goal.bmp");

	  Image green1 = myprocessing.showChanelG(image1);

      assertEquals(green1.getWidth(null), goalGreen1.getWidth(null));
      assertEquals(green1.getHeight(null), goalGreen1.getHeight(null));

      myimage.myWrite(green1, "1_green.bmp");
  
      FileInputStream imageFile3 = new FileInputStream("1_green.bmp");

      imageFile3.skip(54);
      imageFile4.skip(54);

      int color = imageFile3.read();
      int goalColor = imageFile4.read();
      while (color != -1 && goalColor != -1) {
        assertEquals(color, goalColor);
      color = imageFile3.read();
      goalColor = imageFile4.read();
    }
    imageFile3.close();
    imageFile4.close();
  }
	  /**
	   * Test the showChanlB method using 2.bmp.
       * Test width, height, and pixel.	   
	   */	
	@Test
	public void testBlue() throws IOException {

	  FileInputStream imageFile6 = new FileInputStream("2_blue_goal.bmp");

	  Image image2 = myimage.myRead("2.bmp");
	  Image goalBlue2 = myimage.myRead("2_blue_goal.bmp");

	  Image blue2 = myprocessing.showChanelB(image2);

      assertEquals(blue2.getWidth(null), goalBlue2.getWidth(null));
      assertEquals(blue2.getHeight(null), goalBlue2.getHeight(null));

      myimage.myWrite(blue2, "2_blue.bmp");
  
      FileInputStream imageFile5 = new FileInputStream("2_blue.bmp");

      imageFile6.skip(54);
      imageFile5.skip(54);

      int color = imageFile5.read();
      int goalColor = imageFile6.read();
      while (color != -1 && goalColor != -1) {
        assertEquals(color, goalColor);
      color = imageFile5.read();
      goalColor = imageFile6.read();
    }
    imageFile5.close();
    imageFile6.close();
  }
	  /**
	   * Test the showGray method using 2.bmp.
	   * Test width, height, and pixel.
	   */	
	
	
	@Test
	public void testGray() throws IOException {

	  FileInputStream imageFile8 = new FileInputStream("2_gray_goal.bmp");

	  Image image2 = myimage.myRead("2.bmp");
	  Image goalGray2 = myimage.myRead("2_gray_goal.bmp");

	  Image gray2 = myprocessing.showGray(image2);

      assertEquals(gray2.getWidth(null), goalGray2.getWidth(null));
      assertEquals(gray2.getHeight(null), goalGray2.getHeight(null));

      myimage.myWrite(gray2, "2_gray.bmp");
  
      FileInputStream imageFile7 = new FileInputStream("2_gray.bmp");

      imageFile7.skip(54);
      imageFile8.skip(54);

      int color = imageFile7.read();
      int goalColor = imageFile8.read();
      while (color != -1 && goalColor != -1) {
        assertEquals(color, goalColor);
        color = imageFile7.read();
        goalColor = imageFile8.read();
    }
    imageFile7.close();
    imageFile8.close();
  }
	
	
}
