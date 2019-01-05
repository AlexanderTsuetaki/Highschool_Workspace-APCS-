/**
 * q4 a,b
 * @author 18tsuetaki
 *
 */
public class q4 {
	private void FillBlock(String str){
		int c = 0;
		for (int i = 0; i<numRows,i++){
			for (int j = 0;j<numCols,j++){
				if (c<str.length()){
					letterBlock[i][j] = str.substring(c,c+1);
					c++;
				}
				else{
					letterBlock[i][j] = "A";
				}
			}
		}
	}
	public String encryptMessage(String message){
		int c = 0;
		String str = "";
		int l = 0;
		if (message.length()%(numCols*numRows)!=0){
			l = message.length() +(numCols*numRows)-message.length()%(numCols*numRows)
		}
		for(int i= 0 ; i<l;i++){
			message.substring(c*numCols*numRows,(i+1)*numCols*numRows).fillBlock();
			str = str+letterBlock.encryptBlock;
		}
		return str;
	}
}
