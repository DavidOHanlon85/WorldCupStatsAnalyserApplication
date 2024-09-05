/**
 * 
 */
package p3WorldCupStatsAnalyserApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class Stats {

	public static ArrayList<Match> matches = new ArrayList<Match>();

	public static void main(String[] args) {

		// Task 1

		matches = readFile();

		// Task 2

		// displayAllItemsInList(matches);

		// Task 3

//		totalAttendance(matches);
//		double avgAtt = averageAttendance(matches, totalAttendance(matches));
//		System.out.printf("Average Attendance = %.2f\n", avgAtt);

		// Task 4

//		int targetYear = 1998;
//		ArrayList<Match> resultsInTargetYear = resultsFilteredByYear(matches, targetYear);
//		System.out.println("All matches in WC France 1998");
//		displayIntro(resultsInTargetYear);
//		displayResults(resultsInTargetYear);

//		// Task 5
//
//		String targetTeam = "Spain";
//		ArrayList<Match> resultsForTargetTeam = filterByTargetTeam(matches, targetTeam);
//		System.out.println("Matches " + targetTeam + "have played in the WC");
//		displayResults(resultsForTargetTeam);
//
//		// Task 6
//
//		String targetStage = "Final";
//		ArrayList<Match> resultsForFinals = filterByStage(matches, targetStage);
//		System.out.println("Matches at " +targetStage + " stage");
//		System.out.println();
//		displayYearLocationAndResultOfGames(resultsForFinals);

		// Task 7

//		System.out.println("Total goals in all WCs: " + totalNumberOfGoals(matches));
//		double avg = averageGoals(totalNumberOfGoals(matches), matches);
//		System.out.printf("Average goals per game : %.2f", avg);

		// Task 8

//		System.out.println("Attendances");
//		Match smallestAttendance = Collections.min(matches, new CompareByAttendance());
//		System.out.println("Smallest Attendance " + smallestAttendance.getAttendance());
//		System.out.printf("%s %s %s %s %s vs %s\n", smallestAttendance.getHost(), smallestAttendance.getYear(),
//				smallestAttendance.getStadium(), smallestAttendance.getCity(), smallestAttendance.getHomeTeamInitials(),
//				smallestAttendance.getAwayTeamInitials());
//		
//		
//		Match la = Collections.max(matches, new CompareByAttendance());
//		System.out.println("Largest Attendance " + la.getAttendance());
//		System.out.printf("%s %s %s %s %s vs %s\n", la.getHost(), la.getYear(),
//				la.getStadium(), la.getCity(), la.getHomeTeamInitials(),
//				la.getAwayTeamInitials());

		// Task 9

//		ArrayList<Match> resultsForWinCondition = gamesThatWentToWinCondition(matches, WinCondition.ET);
//		System.out.println("ET games");
//		System.out.println();
//		displayForWinConditions(resultsForWinCondition);

		// Task 10

//		ArrayList<Match> resultsForWinCondition = gamesThatWentToWinCondition(matches, WinCondition.HWP, WinCondition.AWP);
//		System.out.println("Games that went to penalties");
//		displayResultsforWinConditions(resultsForWinCondition);

		// Task 11

		int totalWinners = totalWinnersThatLedAtHalfTime(matches);
		System.out.println(totalWinners);
		
		System.out.printf("Percentage of teams that led at half time and won: %.2f%%",
				(double) totalWinners / matches.size() * 100);

	}

	private static int totalWinnersThatLedAtHalfTime(ArrayList<Match> matches2) {

		int totalWinners = 0;

		for (Match m : matches2) {
			if (m.getHalfTimeHomeGoals() > m.getHalfTimeAwayGoals() && m.getHomeTeamGoals() > m.getAwayTeamGoals()
					|| m.getHalfTimeAwayGoals() > m.getHalfTimeHomeGoals()
							&& m.getAwayTeamGoals() > m.getHomeTeamGoals()) {
				totalWinners++;
			}
		}

		return totalWinners;

	}

	private static void displayResultsforWinConditions(ArrayList<Match> resultsForWinCondition)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (Match m : resultsForWinCondition) {
			m.displayForGamesThatWentToPenalties();
			System.out.println();
		}

	}

	/**
	 * This method filters by games that went to penalties
	 * 
	 * @param matches2
	 * @param HWP
	 * @param AWP
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static ArrayList<Match> gamesThatWentToWinCondition(ArrayList<Match> matches, WinCondition HWP,
			WinCondition AWP) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		ArrayList<Match> results = new ArrayList<Match>();

		for (Match m : matches) {
			if (m.getWinconditions() == WinCondition.HWP || m.getWinconditions() == WinCondition.AWP) {
				results.add(m);
			}
		}
		return results;

	}

	/**
	 * This method displays results for win conditions
	 * 
	 * @param resultsForWinCondition
	 */
	private static void displayForWinConditions(ArrayList<Match> resultsForWinCondition)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (Match m : resultsForWinCondition) {
			m.displayForWinConditions();
		}
	}

	/**
	 * This method filters by win conditions
	 * 
	 * @param matches
	 * @param ET
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Match> gamesThatWentToWinCondition(ArrayList<Match> matches, WinCondition ET)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		ArrayList<Match> results = new ArrayList<Match>();

		for (Match m : matches) {
			if (m.getWinconditions() == WinCondition.ET) {
				results.add(m);
			}
		}
		return results;

	}

	/**
	 * This method calculates the average goals in a list based on the total number
	 * of goals and list being provided
	 * 
	 * @param totalNumberOfGoals
	 * @param matches
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static double averageGoals(int totalNumberOfGoals, ArrayList<Match> matches)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		double avg = (double) totalNumberOfGoals(matches) / matches.size();

		return avg;

	}

	/**
	 * This method calculates the total number of goals
	 * 
	 * @param matches2
	 */
	public static int totalNumberOfGoals(ArrayList<Match> matches) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		int total = 0;

		for (Match m : matches) {
			total += (m.getHomeTeamGoals() + m.getAwayTeamGoals());
		}

		return total;
	}

	/**
	 * Introduces method with host and year of competition
	 * 
	 * @param resultsInTargetYear
	 */

	private static void displayIntro(ArrayList<Match> resultsInTargetYear) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (int i = 0; i < 1; i++) {
			Match m = resultsInTargetYear.get(i);
			m.displayWhereWorldCupWas();

		}

	}

	/**
	 * This method displats the year, location and results of all games in the list
	 * 
	 * @param matches
	 */
	private static void displayYearLocationAndResultOfGames(ArrayList<Match> matches) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (Match m : matches) {
			m.displayYearLocationAndResultOfGames();
		}

	}

	/**
	 * This method filter by target stage
	 * 
	 * @param matches
	 * @param targetStage
	 * @return
	 */
	public static ArrayList<Match> filterByStage(ArrayList<Match> matches, String targetStage)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		ArrayList<Match> results = new ArrayList<Match>();

		for (Match m : matches) {
			if (m.getStage().equalsIgnoreCase(targetStage)) {
				results.add(m);
			}
		}
		return results;
	}

	/**
	 * This method filters team based on targetteam - will show both home and away
	 * results
	 * 
	 * @param matches2
	 * @param targetTeam
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Match> filterByTargetTeam(ArrayList<Match> matches2, String targetTeam)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		ArrayList<Match> results = new ArrayList<Match>();

		for (Match m : matches) {
			if (m.getHomeTeamName().equalsIgnoreCase(targetTeam) || m.getAwayTeamName().equalsIgnoreCase(targetTeam)) {
				results.add(m);
			}
		}
		return results;

	}

	/**
	 * This method displays the results of games in the list
	 * 
	 * @param matches
	 */
	public static void displayResults(ArrayList<Match> matches) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (Match m : matches) {
			System.out.printf("%s %d : %s %d\n", m.getHomeTeamName(), m.getHomeTeamGoals(), m.getAwayTeamName(),
					m.getAwayTeamGoals());
		}

	}

	/**
	 * This method filters games by year
	 * 
	 * @param matches
	 * @param year
	 * @return
	 */
	private static ArrayList<Match> resultsFilteredByYear(ArrayList<Match> matches, int year)
			throws IllegalArgumentException {

		ArrayList<Match> results = new ArrayList<Match>();

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (Match m : matches) {
			if (m.getYear() == year) {
				results.add(m);
			}
		}

		return results;

	}

	/**
	 * This method calculates the average attendance
	 * 
	 * @param matches1
	 * @param totalAttendance
	 * @return
	 */
	public static double averageAttendance(ArrayList<Match> matches, int totalAttendance)
			throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		double avgAtt = 0.0;

		avgAtt = (double) totalAttendance / matches.size();

		return avgAtt;

	}

	/**
	 * This method calculates the total attendance in a list
	 * 
	 * @param matches
	 * @return
	 */
	public static int totalAttendance(ArrayList<Match> matches) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		int total = 0;

		for (Match m : matches) {
			total += m.getAttendance();
		}

		return total;

	}

	/**
	 * This method displays the toString for all items in a list
	 * 
	 * @param matches
	 */
	public static void displayAllItemsInList(ArrayList<Match> matches) throws IllegalArgumentException {

		if (matches == null || matches.isEmpty()) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		for (Match m : matches) {
			System.out.println(m.toString());
		}

	}

	/**
	 * This method reads the file and creates match objects for each game
	 * 
	 * @return
	 */
	public static ArrayList<Match> readFile() {

		File file = new File("WorldCupMatches.csv");
		int attemptedReads = 0;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine(); // remove header
			line = br.readLine(); // first line

			while (line != null) {
				attemptedReads++;

				try {
					String[] splitDetails = line.split(",");
					// create object
					Match m = createMatchObject(splitDetails);
					// add object
					matches.add(m);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				line = br.readLine(); // first next line
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Attempted Reads: " + attemptedReads);
		System.out.println("Actual Reads: " + matches.size());

		return matches;

	}

	/**
	 * This method creates a match object
	 * 
	 * @param splitDetails
	 * @return
	 */
	public static Match createMatchObject(String[] splitDetails) {
		Match m = new Match();

		m.setYear(Integer.parseInt(splitDetails[0]));
		m.setHost(splitDetails[1]);
		m.setStage(splitDetails[2]);
		m.setStadium(splitDetails[3]);
		m.setCity(splitDetails[4]);
		m.setAttendance(Integer.parseInt(splitDetails[5]));
		m.setHomeTeamName(splitDetails[6]);
		m.setHomeTeamGoals(Integer.parseInt(splitDetails[7]));
		m.setAwayTeamGoals(Integer.parseInt(splitDetails[8]));
		m.setAwayTeamName(splitDetails[9]);

		if (splitDetails[10].contains(" ")) {
			m.setWinconditions(WinCondition.NORMAL_TIME);
		} else {
			m.setWinconditions(WinCondition.valueOf(splitDetails[10].toUpperCase()));
		}

		m.setHalfTimeHomeGoals(Integer.parseInt(splitDetails[11]));
		m.setHalfTimeAwayGoals(Integer.parseInt(splitDetails[12]));

		m.setHomeTeamInitials(splitDetails[13]);
		m.setAwayTeamInitials(splitDetails[14]);
		return m;
	}

}
