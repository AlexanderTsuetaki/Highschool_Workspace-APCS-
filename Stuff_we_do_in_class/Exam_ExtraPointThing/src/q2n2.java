/**
 * q2n2 a,b
 * @author 18tsuetaki
 *
 */
public class q2n2 {
	public TokenPass(int playerCount){
		board = int[playerCount];
		for (int i= 0;i<playerCount;i++){
			board[i] = (int)(Math.random()*11);
		}
	}
	public void distributeCurrentPlayerTokens(){
		int temp = board[currentPlayer];
		board[currentPlayer] = 0;
		for(int i = 1;i<=board[currentPlayer];i++){
			board[(currentPlayer+i)%board.length()] +=1;
		}
	}
}
