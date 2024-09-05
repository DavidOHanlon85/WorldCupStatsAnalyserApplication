package p3WorldCupStatsAnalyserApplication;

public class Match {

	private static final int MAX_TEAM_GOALS = 15;

	private static final int MAX_TEAM_NAME_LENGTH = 35;

	private static final int MAX_ATTENDANCE = 200000;

	private static final int ZERO = 0;

	private static final int MAX_CITY_LENGTH = 40;

	private static final int MAX_STADIUM_LENGTH = 80;

	private static final int MAX_STAGE_LENGTH = 50;

	private static final int MAX_HOST_LENGTH = 30;

	private static final int MIN_ACCEPTABLE_CHARACTERS = 1;
	// Instance variables

	private int year;
	private String host;
	private String stage;
	private String stadium;
	private String city;
	private int attendance;
	private String homeTeamName;
	private int homeTeamGoals;
	private int awayTeamGoals;
	private String awayTeamName;
	private WinCondition winconditions;
	private int halfTimeHomeGoals;
	private int halfTimeAwayGoals;
	private String homeTeamInitials;
	private String awayTeamInitials;

	// Constructors

	/**
	 * Default constructor
	 */
	Match() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param year
	 * @param host
	 * @param stage
	 * @param stadium
	 * @param city
	 * @param attendance
	 * @param homeTeamName
	 * @param homeTeamGoals
	 * @param awayTeamGoals
	 * @param awayTeamName
	 * @param winconditions
	 * @param halfTimeHomeGoals
	 * @param halfTimeAwayGoals
	 * @param homeTeamInitials
	 * @param awayTeamInitials
	 */
	public Match(int year, String host, String stage, String stadium, String city, int attendance, String homeTeamName,
			int homeTeamGoals, int awayTeamGoals, String awayTeamName, WinCondition winconditions,
			int halfTimeHomeGoals, int halfTimeAwayGoals, String homeTeamInitials, String awayTeamInitials) {
		this.setYear(year);
		this.setHost(host);
		this.setStage(stage);
		this.setStadium(stadium);
		this.setCity(city);
		this.setAttendance(attendance);
		this.setHomeTeamName(homeTeamName);
		this.setHomeTeamGoals(homeTeamGoals);
		this.setAwayTeamGoals(awayTeamGoals);
		this.setAwayTeamName(awayTeamName);
		this.setWinconditions(winconditions);
		this.setHalfTimeHomeGoals(halfTimeHomeGoals);
		this.setHalfTimeAwayGoals(halfTimeAwayGoals);
		this.setHomeTeamInitials(homeTeamInitials);
		this.setAwayTeamInitials(awayTeamInitials);
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 * @throws IllegalArgumentException
	 */
	public void setYear(int year) throws IllegalArgumentException {
		if (year >= 1930) {
			this.year = year;
		} else {
			throw new IllegalArgumentException("INVALID YEAR");
		}

	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * 
	 * @param host
	 * @throws IllegalArgumentException
	 */
	public void setHost(String host) throws IllegalArgumentException {
		if (host.length() >= MIN_ACCEPTABLE_CHARACTERS && host.length() <= MAX_HOST_LENGTH) {
			this.host = host;
		} else {
			throw new IllegalArgumentException("INVALID HOST");
		}

	}

	/**
	 * @return the stage
	 */
	public String getStage() {
		return stage;
	}

	/**
	 * 
	 * @param stage
	 * @throws IllegalArgumentException
	 */
	public void setStage(String stage) throws IllegalArgumentException {
		if (stage.length() >= MIN_ACCEPTABLE_CHARACTERS && stage.length() <= MAX_STAGE_LENGTH) {
			this.stage = stage;
		} else {
			throw new IllegalArgumentException("INVALID STAGE");
		}

	}

	/**
	 * @return the stadium
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * 
	 * @param stadium
	 * @throws IllegalArgumentException
	 */
	public void setStadium(String stadium) throws IllegalArgumentException {
		if (stadium.length() >= MIN_ACCEPTABLE_CHARACTERS && stadium.length() <= MAX_STADIUM_LENGTH) {
			this.stadium = stadium;
		} else {
			throw new IllegalArgumentException("INVALID STADIUM");
		}

	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 * @throws IllegalArgumentException
	 */
	public void setCity(String city) throws IllegalArgumentException {
		if (city.length() >= MIN_ACCEPTABLE_CHARACTERS && city.length() <= MAX_CITY_LENGTH) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("INVALID CITY");
		}
	}

	/**
	 * @return the attendance
	 */
	public int getAttendance() {
		return attendance;
	}

	/**
	 * 
	 * @param attendance
	 * @throws IllegalArgumentException
	 */
	public void setAttendance(int attendance) throws IllegalArgumentException {
		if (attendance >= ZERO && attendance <= MAX_ATTENDANCE) {
			this.attendance = attendance;
		} else {
			throw new IllegalArgumentException("INVALID ATTENDANCE");
		}

	}

	/**
	 * @return the homeTeamName
	 */
	public String getHomeTeamName() {
		return homeTeamName;
	}

	/**
	 * @param homeTeamName the homeTeamName to set
	 */
	public void setHomeTeamName(String homeTeamName) throws IllegalArgumentException {
		if (homeTeamName.length() >= MIN_ACCEPTABLE_CHARACTERS && homeTeamName.length() <= MAX_TEAM_NAME_LENGTH) {
			this.homeTeamName = homeTeamName;
		} else {
			throw new IllegalArgumentException("HOME TEAM NAME INVALID");
		}

	}

	/**
	 * @return the homeTeamGoals
	 */
	public int getHomeTeamGoals() {
		return homeTeamGoals;
	}

	/**
	 * @param homeTeamGoals the homeTeamGoals to set
	 */
	public void setHomeTeamGoals(int homeTeamGoals) throws IllegalArgumentException {
		if (homeTeamGoals >= 0 && homeTeamGoals <= MAX_TEAM_GOALS) {
			this.homeTeamGoals = homeTeamGoals;
		} else {
			throw new IllegalArgumentException("HOME TEAM GOALS INVALID");
		}

	}

	/**
	 * @return the awayTeamGoals
	 */
	public int getAwayTeamGoals() {
		return awayTeamGoals;
	}

	/**
	 * @param awayTeamGoals the awayTeamGoals to set
	 */
	public void setAwayTeamGoals(int awayTeamGoals) throws IllegalArgumentException {
		if (awayTeamGoals >= 0 && awayTeamGoals <= MAX_TEAM_GOALS) {
			this.awayTeamGoals = awayTeamGoals;
		} else {
			throw new IllegalArgumentException("AWAY TEAM GOALS INVALID");
		}
	}

	/**
	 * @return the awayTeamName
	 */
	public String getAwayTeamName() {
		return awayTeamName;
	}

	/**
	 * @param awayTeamName the awayTeamName to set
	 */
	public void setAwayTeamName(String awayTeamName) throws IllegalArgumentException {
		if (awayTeamName.length() >= MIN_ACCEPTABLE_CHARACTERS && awayTeamName.length() <= MAX_TEAM_NAME_LENGTH) {
			this.awayTeamName = awayTeamName;
		} else {
			throw new IllegalArgumentException("AWAY TEAM NAME INVALID");
		}
	}

	/**
	 * @return the winconditions
	 */
	public WinCondition getWinconditions() {
		return winconditions;
	}

	/**
	 * @param winconditions the winconditions to set
	 */
	public void setWinconditions(WinCondition winconditions) throws IllegalArgumentException {
		if (winconditions == null) {
			throw new IllegalArgumentException("INVALID WIN CONDITIONS");
		} else {
			this.winconditions = winconditions;
		}
		
	}

	/**
	 * @return the halfTimeHomeGoals
	 */
	public int getHalfTimeHomeGoals() {
		return halfTimeHomeGoals;
	}

	/**
	 * @param halfTimeHomeGoals the halfTimeHomeGoals to set
	 */
	public void setHalfTimeHomeGoals(int halfTimeHomeGoals) throws IllegalArgumentException {
		if (halfTimeHomeGoals >= 0 && halfTimeHomeGoals <= MAX_TEAM_GOALS) {
			this.halfTimeHomeGoals = halfTimeHomeGoals;
		} else {
			throw new IllegalArgumentException("HT HOME GOALS INVALID");
		}
	}

	/**
	 * @return the halfTimeAwayGoals
	 */
	public int getHalfTimeAwayGoals() {
		return halfTimeAwayGoals;
	}

	/**
	 * @param halfTimeAwayGoals the halfTimeAwayGoals to set
	 */
	public void setHalfTimeAwayGoals(int halfTimeAwayGoals) throws IllegalArgumentException {
		if (halfTimeAwayGoals >= 0 && halfTimeAwayGoals <= MAX_TEAM_GOALS) {
			this.halfTimeAwayGoals = halfTimeAwayGoals;
		} else {
			throw new IllegalArgumentException("HT AWAY GOALS INVALID");
		}
	}

	/**
	 * @return the homeTeamInitials
	 */
	public String getHomeTeamInitials() {
		return homeTeamInitials;
	}

	/**
	 * @param homeTeamInitials the homeTeamInitials to set
	 */
	public void setHomeTeamInitials(String homeTeamInitials) throws IllegalArgumentException {
		if (homeTeamInitials.length() == 3) {
			this.homeTeamInitials = homeTeamInitials;
		} else {
			throw new IllegalArgumentException("HOME TEAM INITIALS INVALID");
		}
		
	}

	/**
	 * @return the awayTeamInitials
	 */
	public String getAwayTeamInitials() {
		return awayTeamInitials;
	}

	/**
	 * @param awayTeamInitials the awayTeamInitials to set
	 */
	public void setAwayTeamInitials(String awayTeamInitials) throws IllegalArgumentException {
		if (awayTeamInitials.length() == 3) {
				this.awayTeamInitials = awayTeamInitials;
		} else {
			throw new IllegalArgumentException("AWAY TEAM INITIALS INVALID");
		}
	
	}
	
	// Methods

	@Override
	public String toString() {
		return "Match [year=" + year + ", host=" + host + ", stage=" + stage + ", stadium=" + stadium + ", city=" + city
				+ ", attendance=" + attendance + ", homeTeamName=" + homeTeamName + ", homeTeamGoals=" + homeTeamGoals
				+ ", awayTeamGoals=" + awayTeamGoals + ", awayTeamName=" + awayTeamName + ", winconditions="
				+ winconditions + ", halfTimeHomeGoals=" + halfTimeHomeGoals + ", halfTimeAwayGoals="
				+ halfTimeAwayGoals + ", homeTeamInitials=" + homeTeamInitials + ", awayTeamInitials="
				+ awayTeamInitials + "]";
	}
	
	public void displayYearLocationAndResultOfGames() {
		System.out.printf("%d, %s\n", getYear(), getHost());
		System.out.printf("%s %d : %s %d\n\n", getHomeTeamName(), getHomeTeamGoals(), getAwayTeamName(),
		getAwayTeamGoals());
	}
	
	public void displayWhereWorldCupWas() {
		
		System.out.printf("All matches in WC %s %d\n\n", getHost(), getYear());
	}
	
	public void displayForWinConditions() {
		System.out.printf("%d %s %s\n", getYear(), getHost(), getStage());
		System.out.printf("%s %d : %s %d\n\n", getHomeTeamName(), getHomeTeamGoals(), getAwayTeamName(),
				getAwayTeamGoals());
	}
	
	public void displayForGamesThatWentToPenalties() {
		System.out.printf("%d %s %s\n", getYear(), getHost(), getStage());
		System.out.printf("%s %d : %s %d\n", getHomeTeamInitials(), getHomeTeamGoals(), getAwayTeamInitials(), getAwayTeamGoals());
		
		if (getWinconditions() == WinCondition.HWP) {
			System.out.println("Winner: " + getHomeTeamInitials());
		} else {
			System.out.println("Winner: " + getAwayTeamGoals());
		}
	}
	

}
