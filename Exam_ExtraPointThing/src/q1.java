/**
 * q1 a,b,ci,cii
 * @author 18tsuetaki
 *
 */
public class q1 {
	public void addClimb(String peakName, int climbTime){
		climbList.add(new ClimbInfo(peakName,climbTime));
	}
	public void addClimbb(String peakName, int climbTime){
		for (int i = 0 ; i<climbList.length;i++){
			if (climbList.getName().compareTo(peakName)>=0 || i = climbList.length-1){
				climbList.add(new ClimbInfo(peakName,climbTime));
				break;
			}
		}
	}
	//i No
	//ii Yes
}
