package pixLab.classes;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  /** Method to test KeepOnlyBlue */
  public static void testKeepOnlyBlue(){
	  Picture beach = new Picture("images/beach.jpg");
	    beach.explore();
	    beach.keepOnlyBlue();
	    beach.explore();
  }
  /** Method to test Negate */
  public static void testNegate(){
	  Picture beach = new Picture("images/beach.jpg");
	    beach.explore();
	    beach.negate();
	    beach.explore();
  }
  /** Method to test Grayscale */
  public static void testGrayscale(){
	  Picture beach = new Picture("images/beach.jpg");
	    beach.explore();
	    beach.grayScale();
	    beach.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("images/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("images/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  /** Method to test fixUnderwater */
  public static void testFixUnderwater(){
	Picture water = new Picture("images/water.jpg");
	Pixel[][] w = water.getPixels2D();
	for (int i = 0;i<w.length;i++){
		for(int j = 0;j<w[i].length;j++){
			w[i][j].setBlue(w[i][j].getBlue()-100);
			w[i][j].setGreen(w[i][j].getGreen()-100);
		}
	}
	water.explore();
  }
  /** Method to test testMirrorArms */
  public static void testMirrorArms(){
	  Picture swan = new Picture("images/snowman.jpg");
	    swan.mirrorArms();
	    swan.explore();
  }
  /** Method to test MirrorHorizonal */
  public static void testMirrorHorizontal(){
	  Picture swan = new Picture("images/swan.jpg");
	    swan.mirrorHorizontal();
	    swan.explore();
  }
  /** Method to test mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop(){
	  Picture swan = new Picture("images/swan.jpg");
	    swan.mirrorHorizontalBotToTop();
	    swan.explore();
  }
  /** Method to test testMirrorDiagonal */
  public static void testMirrorDiagonal(){
	  Picture swan = new Picture("images/swan.jpg");
	    swan.mirrorDiagonal();
	    swan.explore();
  }
  /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft() {
	  Picture swan = new Picture("images/swan.jpg");
	  swan.mirrorVerticalRightToLeft();
	  swan.explore();
  }
  /** Method to test MirrorGull */
  public static void testMirrorGull(){
	  Picture swan = new Picture("images/seagull.jpg");
	  swan.mirrorGull();
	  swan.explore();
  }
  /** Method to test Copy */
  public static void testCopy(){
	  Picture swan = new Picture("images/seagull.jpg");
	  Picture s1 = new Picture("images/robot.jpg");
	  swan.copy(s1,0,100,0,100);
	  swan.explore();
  }
  /** Method to test Collage */
  public static void testCollage1(){
	  Picture swan = new Picture("images/seagull.jpg");
	  swan.myCollage();
	  swan.explore();
  }
  
  
  
  
  
  
  
  // I talked with jake an robert about edge detection 
  
  
  
  
  
  
  
  /** Method to test edgeDetection2 */
public static void testEdgeDetection2(){
	 Picture swan = new Picture("images/swan.jpg");
	 swan.edgeDetection2(10);
	 swan.explore();
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testZeroBlue();
    testKeepOnlyBlue();
	testNegate();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    testGrayscale();
    testFixUnderwater();
    testMirrorVertical();
    testMirrorVerticalRightToLeft();
    testMirrorHorizontal();
	testMirrorHorizontalBotToTop();
    testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    testMirrorDiagonal();
    testCollage1();
    testCopy();
    testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}