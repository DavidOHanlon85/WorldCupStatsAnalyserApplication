package p3WorldCupStatsAnalyserApplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMatch {

	// Input data

	int validYearLow, validYearHigh;
	int invalidYearLow;

	String validHostLow, validHostMid, validHostHigh;
	String invalidHostLow, invalidHostHigh;

	String validStageLow, validStageMid, validStageHigh;
	String invalidStageLow, invalidStageHigh;

	String validStadiumLow, validStadiumMid, validStadiumHigh;
	String invalidStadiumLow, invalidStadiumHigh;

	String validCityLow, validCityMid, validCityHigh;
	String invalidCityLow, invalidCityHigh;

	int validAttendanceLow, validAttendanceMid, validAttendanceHigh;
	int invalidAttendanceLow, invalidAttendanceHigh;

	String validNameLow, validNameMid, validNameHigh;
	String invalidNameLow, invalidNameHigh;

	int validGoalsLow, validGoalsMid, validGoalsHigh;
	int invalidGoalsLow, invalidGoalsHigh;

	WinCondition ET, HWP, AWP;

	String validInitials;
	String invalidInitialsLow, invalidInitialsHigh;

	Match m;

	@BeforeEach
	void setUp() throws Exception {

		validYearLow = 1930;
		validYearHigh = 2000;
		invalidYearLow = 1929;

		validHostLow = "x";
		validHostMid = "x".repeat(15);
		validHostHigh = "x".repeat(30);
		invalidHostLow = "";
		invalidHostHigh = "x".repeat(31);

		validStageLow = "x";
		validStageMid = "x".repeat(25);
		validStageHigh = "x".repeat(50);
		invalidStageLow = "";
		invalidStageHigh = "x".repeat(51);

		validStadiumLow = "x";
		validStadiumMid = "x".repeat(40);
		validStadiumHigh = "x".repeat(80);
		invalidStadiumLow = "";
		invalidStadiumHigh = "x".repeat(81);

		validCityLow = "x";
		validCityMid = "x".repeat(20);
		validCityHigh = "x".repeat(40);
		invalidCityLow = "";
		invalidCityHigh = "x".repeat(41);

		validAttendanceLow = 0;
		validAttendanceMid = 100000;
		validAttendanceHigh = 200000;
		invalidAttendanceLow = -1;
		invalidAttendanceHigh = 200001;

		validNameLow = "x";
		validNameMid = "x".repeat(18);
		validNameHigh = "x".repeat(35);
		invalidNameLow = "";
		invalidNameHigh = "x".repeat(36);

		validGoalsLow = 0;
		validGoalsMid = 7;
		validGoalsHigh = 15;
		invalidGoalsLow = -1;
		invalidGoalsHigh = 16;

		ET = WinCondition.ET;
		HWP = WinCondition.HWP;
		AWP = WinCondition.AWP;

		validInitials = "IRE";
		invalidInitialsLow = "IR";
		invalidInitialsHigh = "IREL";

		m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
				validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
				validGoalsHigh, validInitials, validInitials);

	}

	@Test
	void testMatchDefaultConstructor() {
		assertNotNull(m);
	}

	@Test
	void testMatchConstructorValid() {
		assertEquals(validYearHigh, m.getYear());
		assertEquals(validHostHigh, m.getHost());
		assertEquals(validStageHigh, m.getStage());
		assertEquals(validStadiumHigh, m.getStadium());
		assertEquals(validCityHigh, m.getCity());
		assertEquals(validAttendanceHigh, m.getAttendance());
		assertEquals(validNameHigh, m.getHomeTeamName());
		assertEquals(validGoalsHigh, m.getHomeTeamGoals());
		assertEquals(validGoalsHigh, m.getAwayTeamGoals());
		assertEquals(validNameHigh, m.getAwayTeamName());
		assertEquals(ET, m.getWinconditions());
		assertEquals(validGoalsHigh, m.getHalfTimeHomeGoals());
		assertEquals(validGoalsHigh, m.getHalfTimeAwayGoals());
		assertEquals(validInitials, m.getHomeTeamInitials());
		assertEquals(validInitials, m.getAwayTeamInitials());
	}

	@Test
	void testMatchConstructorInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(invalidYearLow, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID YEAR", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, invalidHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID HOST", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, invalidHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID HOST", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostLow, invalidStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID STAGE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, invalidStageLow, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID STAGE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, invalidStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID STADIUM", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, invalidStadiumLow, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID STADIUM", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, invalidCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID CITY", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, invalidCityLow,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID CITY", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					invalidAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID ATTENDANCE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					invalidAttendanceLow, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID ATTENDANCE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, invalidNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HOME TEAM NAME INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, invalidNameLow, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HOME TEAM NAME INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, invalidGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HOME TEAM GOALS INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, invalidGoalsLow, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HOME TEAM GOALS INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, invalidNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("AWAY TEAM NAME INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, invalidNameLow, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("AWAY TEAM NAME INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, invalidGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("AWAY TEAM GOALS INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, invalidGoalsLow, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("AWAY TEAM GOALS INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, null, validGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("INVALID WIN CONDITIONS", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, invalidGoalsHigh,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HT HOME GOALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, invalidGoalsLow,
					validGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HT HOME GOALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					invalidGoalsHigh, validInitials, validInitials);
		});

		assertEquals("HT AWAY GOALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					invalidGoalsLow, validInitials, validInitials);
		});

		assertEquals("HT AWAY GOALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, invalidInitialsLow, validInitials);
			});

		assertEquals("HOME TEAM INITIALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, invalidInitialsHigh, validInitials);
			});

		assertEquals("HOME TEAM INITIALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, invalidInitialsLow);
			});

		assertEquals("AWAY TEAM INITIALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m = new Match(validYearHigh, validHostHigh, validStageHigh, validStadiumHigh, validCityHigh,
					validAttendanceHigh, validNameHigh, validGoalsHigh, validGoalsHigh, validNameHigh, ET, validGoalsHigh,
					validGoalsHigh, validInitials, invalidInitialsHigh);
			});

		assertEquals("AWAY TEAM INITIALS INVALID", exp.getMessage());	
	}

	@Test
	void testGetYear() {
		m.setYear(validYearLow);
		assertEquals(validYearLow, m.getYear());
		
		m.setYear(validYearHigh);
		assertEquals(validYearHigh, m.getYear());
	}

	@Test
	void testSetYear() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setYear(invalidYearLow);
		});

		assertEquals("INVALID YEAR", exp.getMessage());
	}

	@Test
	void testGetHost() {
		m.setHost(validHostLow);
		assertEquals(validHostLow, m.getHost());
		
		m.setHost(validHostMid);
		assertEquals(validHostMid, m.getHost());
		
		m.setHost(validHostHigh);
		assertEquals(validHostHigh, m.getHost());
		
	}

	@Test
	void testSetHost() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHost(invalidHostLow);
		});

		assertEquals("INVALID HOST", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHost(invalidHostHigh);
		});

		assertEquals("INVALID HOST", exp.getMessage());
	}

	@Test
	void testGetStage() {
		m.setStage(validStageLow);
		assertEquals(validStageLow, m.getStage());
		
		m.setStage(validStageMid);
		assertEquals(validStageMid, m.getStage());
		
		m.setStage(validStageHigh);
		assertEquals(validStageHigh, m.getStage());
		
	}

	@Test
	void testSetStage() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setStage(invalidStageLow);
		});

		assertEquals("INVALID STAGE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setStage(invalidStageHigh);
		});

		assertEquals("INVALID STAGE", exp.getMessage());
	}

	@Test
	void testGetStadium() {
		m.setStadium(validStadiumLow);
		assertEquals(validStadiumLow, m.getStadium());
		
		m.setStadium(validStadiumMid);
		assertEquals(validStadiumMid, m.getStadium());
		
		m.setStadium(validStadiumHigh);
		assertEquals(validStadiumHigh, m.getStadium());
		
	}

	@Test
	void testSetStadium() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setStadium(invalidStadiumLow);
		});

		assertEquals("INVALID STADIUM", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setStadium(invalidStadiumHigh);
		});
	}

	@Test
	void testGetCity() {
		m.setCity(validCityLow);
		assertEquals(validCityLow, m.getCity());
		
		m.setCity(validCityMid);
		assertEquals(validCityMid, m.getCity());
		
		m.setCity(validCityHigh);
		assertEquals(validCityHigh, m.getCity());
		
	}

	@Test
	void testSetCity() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setCity(invalidCityLow);
		});

		assertEquals("INVALID CITY", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setCity(invalidCityHigh);
		});

		assertEquals("INVALID CITY", exp.getMessage());
	}

	@Test
	void testGetAttendance() {
		m.setAttendance(validAttendanceLow);
		assertEquals(validAttendanceLow, m.getAttendance());
		
		m.setAttendance(validAttendanceMid);
		assertEquals(validAttendanceMid, m.getAttendance());
		
		m.setAttendance(validAttendanceHigh);
		assertEquals(validAttendanceHigh, m.getAttendance());
		
	}

	@Test
	void testSetAttendance() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAttendance(invalidAttendanceLow);
		});

		assertEquals("INVALID ATTENDANCE", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAttendance(invalidAttendanceHigh);
		});

		assertEquals("INVALID ATTENDANCE", exp.getMessage());
	}

	@Test
	void testGetHomeTeamName() {
		m.setHomeTeamName(validNameLow);
		assertEquals(validNameLow, m.getHomeTeamName());
		
		m.setHomeTeamName(validNameMid);
		assertEquals(validNameMid, m.getHomeTeamName());
		
		m.setHomeTeamName(validNameHigh);
		assertEquals(validNameHigh, m.getHomeTeamName());
		
	}

	@Test
	void testSetHomeTeamName() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHomeTeamName(invalidNameLow);
		});

		assertEquals("HOME TEAM NAME INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHomeTeamName(invalidNameHigh);
		});

		assertEquals("HOME TEAM NAME INVALID", exp.getMessage());
	}

	@Test
	void testGetHomeTeamGoals() {
		m.setHomeTeamGoals(validGoalsLow);
		assertEquals(validGoalsLow, m.getHomeTeamGoals());
		
		m.setHomeTeamGoals(validGoalsMid);
		assertEquals(validGoalsMid, m.getHomeTeamGoals());
		
		m.setHomeTeamGoals(validGoalsHigh);
		assertEquals(validGoalsHigh, m.getHomeTeamGoals());
		
	}

	@Test
	void testSetHomeTeamGoals() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHomeTeamGoals(invalidGoalsLow);
		});

		assertEquals("HOME TEAM GOALS INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHomeTeamGoals(invalidGoalsHigh);
		});

		assertEquals("HOME TEAM GOALS INVALID", exp.getMessage());
	}

	@Test
	void testGetAwayTeamGoals() {
		m.setAwayTeamGoals(validGoalsLow);
		assertEquals(validGoalsLow, m.getAwayTeamGoals());
		
		m.setAwayTeamGoals(validGoalsMid);
		assertEquals(validGoalsMid, m.getAwayTeamGoals());
		
		m.setAwayTeamGoals(validGoalsHigh);
		assertEquals(validGoalsHigh, m.getAwayTeamGoals());
		
	}

	@Test
	void testSetAwayTeamGoals() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAwayTeamGoals(invalidGoalsLow);
		});

		assertEquals("AWAY TEAM GOALS INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAwayTeamGoals(invalidGoalsHigh);
		});

		assertEquals("AWAY TEAM GOALS INVALID", exp.getMessage());
	}

	@Test
	void testGetAwayTeamName() {
		m.setAwayTeamName(validNameLow);
		assertEquals(validNameLow, m.getAwayTeamName());
		
		m.setAwayTeamName(validNameMid);
		assertEquals(validNameMid, m.getAwayTeamName());
		
		m.setAwayTeamName(validNameHigh);
		assertEquals(validNameHigh, m.getAwayTeamName());
		
	}

	@Test
	void testSetAwayTeamName() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAwayTeamName(invalidNameLow);
		});

		assertEquals("AWAY TEAM NAME INVALID", exp.getMessage());

		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAwayTeamName(invalidNameHigh);
		});

		assertEquals("AWAY TEAM NAME INVALID", exp.getMessage());
	}

	@Test
	void testGetWinconditions() {
		m.setWinconditions(ET);
		assertEquals(ET, m.getWinconditions());
		
		m.setWinconditions(AWP);
		assertEquals(AWP, m.getWinconditions());
		
		m.setWinconditions(HWP);
		assertEquals(HWP, m.getWinconditions());

	}

	@Test
	void testSetWinconditions() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setWinconditions(null);
		});

		assertEquals("INVALID WIN CONDITIONS", exp.getMessage());
	}

	@Test
	void testGetHalfTimeHomeGoals() {
		m.setHalfTimeHomeGoals(validGoalsLow);
		assertEquals(validGoalsLow, m.getHalfTimeHomeGoals());
		
		m.setHalfTimeHomeGoals(validGoalsMid);
		assertEquals(validGoalsMid, m.getHalfTimeHomeGoals());
		
		m.setHalfTimeHomeGoals(validGoalsHigh);
		assertEquals(validGoalsHigh, m.getHalfTimeHomeGoals());
		
	}

	@Test
	void testSetHalfTimeHomeGoals() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHalfTimeHomeGoals(invalidGoalsLow);
		});

		assertEquals("HT HOME GOALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHalfTimeHomeGoals(invalidGoalsHigh);
		});

		assertEquals("HT HOME GOALS INVALID", exp.getMessage());
	}

	@Test
	void testGetHalfTimeAwayGoals() {
		m.setHalfTimeAwayGoals(validGoalsLow);
		assertEquals(validGoalsLow, m.getHalfTimeAwayGoals());
		
		m.setHalfTimeAwayGoals(validGoalsMid);
		assertEquals(validGoalsMid, m.getHalfTimeAwayGoals());
		
		m.setHalfTimeAwayGoals(validGoalsHigh);
		assertEquals(validGoalsHigh, m.getHalfTimeAwayGoals());
		
	}

	@Test
	void testSetHalfTimeAwayGoals() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHalfTimeAwayGoals(invalidGoalsLow);
		});

		assertEquals("HT AWAY GOALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHalfTimeAwayGoals(invalidGoalsHigh);
		});

		assertEquals("HT AWAY GOALS INVALID", exp.getMessage());
	}

	@Test
	void testGetHomeTeamInitials() {
		m.setHomeTeamInitials(validInitials);
		assertEquals(validInitials, m.getHomeTeamInitials());
	}

	@Test
	void testSetHomeTeamInitials() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHomeTeamInitials(invalidInitialsLow);
			});

		assertEquals("HOME TEAM INITIALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setHomeTeamInitials(invalidInitialsHigh);
			});

		assertEquals("HOME TEAM INITIALS INVALID", exp.getMessage());
	}

	@Test
	void testGetAwayTeamInitials() {
		m.setAwayTeamInitials(validInitials);
		assertEquals(validInitials, m.getAwayTeamInitials());
	}

	@Test
	void testSetAwayTeamInitials() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAwayTeamInitials(invalidCityLow);
			});

		assertEquals("AWAY TEAM INITIALS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			m.setAwayTeamInitials(invalidCityHigh);
			});

		assertEquals("AWAY TEAM INITIALS INVALID", exp.getMessage());
	}

}
