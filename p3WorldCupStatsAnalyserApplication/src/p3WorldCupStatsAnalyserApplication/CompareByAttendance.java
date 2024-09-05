/**
 * 
 */
package p3WorldCupStatsAnalyserApplication;

import java.util.Comparator;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class CompareByAttendance implements Comparator<Match>{

	@Override
	public int compare(Match o1, Match o2) {
		// TODO Auto-generated method stub
		return o1.getAttendance() - o2.getAttendance();
	}
	

}
