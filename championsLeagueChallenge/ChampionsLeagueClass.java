/**
 * 
 */
package championsLeagueChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class ChampionsLeagueClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// variable

		String team;
		int year = 1956;

		// File

		File file = new File("ECWinners-1 (1).txt");

		// Add winners to array list

		ArrayList<String> winners = new ArrayList<String>();

		readTeamNamesFromFile(file, winners);

		// Prints winners and year to console

		printYearsAndWinnersToConsole(year, winners);

		// All winners - no duplicates
		
		System.out.println();
		

		ArrayList<String> ClubsToWinCL = createArrayListOfAllWinnersNoDuplicates(winners);

		System.out.println(ClubsToWinCL.toString());

	}

	/**
	 * This method stores the winners of the CL without duplicates and returns them in an AL named ClubsToWinCL
	 * @param winners
	 * @return
	 */
	public static ArrayList<String> createArrayListOfAllWinnersNoDuplicates(ArrayList<String> winners) {
		ArrayList<String> ClubsToWinCL = new ArrayList<String>();
		
		System.out.println("Teams to win the Champions League : \n");

		for (String w : winners) {
			if (!ClubsToWinCL.contains(w)) {
				ClubsToWinCL.add(w);
			}
		}
		return ClubsToWinCL;
	}

	/**
	 * @param year
	 * @param winners
	 */
	public static void printYearsAndWinnersToConsole(int year, ArrayList<String> winners) {
		System.out.println("All winners by year : \n");
		if (winners.size() == 0) {
			System.out.println("Problem reading the file");
		} else {
			for (String w : winners) {
				System.out.println(year + " : " + w);
				year++;
			}
		}
	}

	/**
	 * This method reads the team names from file and stores them in winners
	 * ArrayList
	 * 
	 * @param file
	 * @param winners
	 */
	public static void readTeamNamesFromFile(File file, ArrayList<String> winners) {
		String team;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			team = br.readLine();

			while (team != null) {

				winners.add(team);

				team = br.readLine();

			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
