/**
 * q4n2 a,b
 * @author 18tsuetaki
 *
 */
public class q4n2 {
	public int countWhitePixels(){
		int c = 0;
		for (int i = 0;i<pixelValues.length();i++){
			for (int j = 0; j<pixelValues[i].length();j++)
				if (pixelValues[i][j] == 255 ){
					c++;
				}
		}
		return c;
	}
	public void processImage(){
		for (int i = 0;i<pixelValues.length()+2;i++){
			for (int j = 0; j<pixelValues[i].length()-2;i++){
				pixelValues[i][j] -= pixelValues[i+2][j+2];
				if (pixelValues[i][j]< BLACK){
					pixelValues[i][j] = BLACK;
				}
			}
		}
	}
}
