package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  /** Method to set the everything but blue to 0 */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  /** Method to mirror the stuff on the right of a picture to the left of the picture */
  public void mirrorVerticalRightToLeft(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++){ 
		  for (int col = 0; col < width / 2; col++){ 
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width-1-col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	       
	} 
  }
  /** Method to mirror the stuff on the top of a picture to the bottom of the picture */
  public void mirrorHorizontal(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel bottomPixel = null;
	  Pixel topPixel = null;
	  int width = pixels[0].length;
	  for (int col = 0; col < width; col++){ 
		  for (int row = 0; row < pixels[0].length/2; row++){ 
			  bottomPixel = pixels[pixels.length-row-1][col];
			  topPixel = pixels[row][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  /** Method to mirror the stuff on the bottom of a picture to the top of the picture */
  public void mirrorHorizontalBotToTop(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel bottomPixel = null;
	  Pixel topPixel = null;
	  int width = pixels[0].length;
	  for (int col = 0; col < width; col++){ 
		  for (int row = 0; row < pixels[0].length/2; row++){ 
			  bottomPixel = pixels[pixels.length-row-1][col];
			  topPixel = pixels[row][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }
  /** Method to mirror the stuff across a diagonal */
  public void mirrorDiagonal(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel pix1 = null;
	  Pixel pix2 = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++){
	      for (int col = 0; col < pixels[0].length; col++){
	        if (col < pixels.length){
	            pix1 = pixels[row][col];
	            pix2 = pixels[col][row];
	            pix1.setColor(pix2.getColor());
	        }
	      }
	       
	  }
  }
  //Got from internet https://pastebin.com/pDFrReka
  /** Method to mirror the points on a picture to a spicific area*/
  public void mirrorArms(){
	  {
      int mirrorPoint = 193;
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      Pixel[][]pixels = this.getPixels2D();
      for(int row = 158; row<mirrorPoint; row++)
      {
          for(int col=0; col<170; col++)
          {
             topPixel = pixels[row][col];
             bottomPixel = pixels[mirrorPoint-row+mirrorPoint][col];
             bottomPixel.setColor(topPixel.getColor());
          }
      }
     int mirrorPoint1=193;
     Pixel topPixel1 = null;
     Pixel botPixel1 =null;
     
     for(int row1=181; row1<mirrorPoint1;row1++){
         for(int col1=240; col1<295;col1++){
             topPixel1 = pixels[row1][col1];
             botPixel1=pixels[mirrorPoint1-row1+mirrorPoint1][col1];
             botPixel1.setColor(topPixel1.getColor());
         }
     }
  }
  }
  /** Method to mirror a part of a picture so it looks like there are two seagulls */
  public void mirrorGull(){
	  {
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width-40 / 2 ; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width-1-col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
	  }
  }
  /** Method to mirror a part of a picture to fix a temple */
  public void mirrorTemple()
  { int mirrorPoint = 276;
    Pixel leftPixel = null;
    int count= 0;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    // loop through the rows
    for (int row = 27; row < 97; row++)
    { // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
    	  count++;
        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                         [mirrorPoint - col -1];
        rightPixel.setColor(leftPixel.getColor());
 
      }

    }System.out.println(count);
    }
  /** Method to make every color 255 values less powerful */
  public void negate(){
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(pixelObj.getRed()-255);
	        pixelObj.setGreen(pixelObj.getGreen()-255);
	        pixelObj.setBlue(pixelObj.getBlue()-255);
	      }
	    }
  }
  /** Method to make a picture grayscale */
  public void grayScale(){
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3);
	        pixelObj.setGreen((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3);
	        pixelObj.setBlue((pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3);
	      }
	    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
 
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  /** Method to copy a picture a a particular area */
  public void copy(Picture fromPic,int startRow,int endRow, int startCol,int endCol)
{
Pixel fromPixel = null;
Pixel toPixel = null;
Pixel[][] toPixels = this.getPixels2D();
Pixel[][] fromPixels = fromPic.getPixels2D();
for (int fromRow = 0, toRow = startRow;  fromRow < fromPixels.length && toRow < endRow; fromRow++, toRow++)
{
for (int fromCol = 0, toCol = startCol; 
    fromCol < fromPixels[0].length &&
    toCol < endCol;  
    fromCol++, toCol++)
{
 fromPixel = fromPixels[fromRow][fromCol];
 toPixel = toPixels[toRow][toCol];
 toPixel.setColor(fromPixel.getColor());
}
}   
}
  /** Method to make a collage */
  public void myCollage(){
	  Picture swan = new Picture("images/seagull.jpg");
	  Picture s1 = new Picture("images/robot.jpg");
	  Picture s2 = new Picture("images/flower1.jpg");
	  Picture s3 = new Picture("images/flower2.jpg");
	  this.copy(s1,0,100,0,100);
	  this.copy(s2,100,200,100,200);
	  this.copy(s3,200,300,200,300);
	  this.copy(s1,300,400,300,400);
	  this.mirrorDiagonal();
	  this.grayScale();
	  this.zeroBlue();
  }
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  /** Method to print out a picture only showing the edges of the items depicted */
  public void edgeDetection2(int edgeDist)
  { Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel upPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color downColor = null;
    for (int row = 0; row < pixels.length; row++){ 
    	for (int col = 0; col < pixels[0].length-1; col++){
			leftPixel = pixels[row][col];
			rightPixel = pixels[row][col+1];
			rightColor = rightPixel.getColor();
			if (row<pixels.length-1){
			    upPixel = pixels[row][col];
			    downPixel =pixels[row+1][col];
			    downColor = downPixel.getColor();
			}
			if (leftPixel.colorDistance(rightColor)> edgeDist || upPixel.colorDistance(downColor)> edgeDist)
			  leftPixel.setColor(Color.BLACK);
			else
			  leftPixel.setColor(Color.WHITE);
    	}
    }
}
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
