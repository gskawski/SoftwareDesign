//Skawski_Glenn_SportConcussion Assessment System Project_Phase III_Submission
package com.company;

import java.util.Scanner;

public class Main {

    public static AthleteApplication athleteApplication = new AthleteApplication();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        do {
            displayMenu();
            int choice = scan.nextInt();
            switch(choice) {
                case 1:
                    athleteApplication.addAthleteEvaluation();
                    break;
                case 2:
                    athleteApplication.printAthletes();
                    break;
                case 3:
                    athleteApplication.getAthletesGameSummaries();
                    break;
                case 4:
                    athleteApplication.getRiskConditionIndicator();
                    break;
                case 5:
                    System.out.println("Exiting Application");
                    System.exit(0);
                    break;
            }
        } while(true);
    }

    static void displayMenu()
    {
        System.out.println("Welcome to Sport Concussion Assessment System");
        System.out.println("==================================");
        System.out.println("Please select one of the following options");
        System.out.println("\t  1. Enter Athlete's Health Symptoms following Game or Practice (Athlete will be added if not in system)");
        System.out.println("\t  2. Display List of Athlete Names in Application");
        System.out.println("\t  3. Retrieve Athlete's Symptom Summaries from Game(s) or Practice(s)");
        System.out.println("\t  4. Retrieve Athlete's \"Am I at Risk?\" Indicator");
        System.out.println("\t  5. Exit");

    }
}
