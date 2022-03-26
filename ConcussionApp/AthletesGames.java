//Skawski_Glenn_SportConcussion Assessment System Project_Phase III_Submission
package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class AthletesGames {

    private String firstName;
    private String lastName;
    private ArrayList<GameEntry> gameEntries;
    private int riskIndicator;

    public AthletesGames(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gameEntries = new ArrayList<GameEntry>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRiskIndicator() {
        return riskIndicator;
    }

    public void addGame(GameEntry gameEntry) {
        this.gameEntries.add(0, gameEntry);

        if (gameEntries.size() == 6) {
            gameEntries.remove(5);
        }
    }

    public void displayAthletesGameSummaries(String firstName, String lastName) {
        ListIterator<GameEntry> listIterator = gameEntries.listIterator();
        this.riskIndicator = -1;
        while (listIterator.hasNext()) {
            for (int i = 0; i < gameEntries.size(); i++) {
                if (i < gameEntries.size() - 1) {
                    GameEntry gameEntryAfter = this.gameEntries.get(i);
                    GameEntry gameEntryBefore = this.gameEntries.get(i+1);
                    int severityDifference = gameEntryAfter.getSeverity() - gameEntryBefore.getSeverity();
                    int totalSymptomDifference = gameEntryAfter.getTotalSymptoms() - gameEntryBefore.getTotalSymptoms();
                    if (totalSymptomDifference < 3 && severityDifference < 10) {
                        System.out.println("\n" + firstName + " " + lastName + "\n" + listIterator.next().toString() +
                                            "Overall Rating: No Difference" + "\n");
                        if (i == 0) {
                            this.riskIndicator = 1;
                        }
                    }
                    if (totalSymptomDifference < 3 && severityDifference >= 10) {
                        System.out.println("\n" + firstName + " " + lastName + "\n" + listIterator.next().toString() +
                                "Overall Rating: Unsure" + "\n");
                        if (i == 0) {
                            this.riskIndicator = 2;
                        }
                    }
                    if (totalSymptomDifference >= 3 || severityDifference >= 15) {
                        System.out.println("\n" + firstName + " " + lastName + "\n" + listIterator.next().toString() +
                                "Overall Rating: Very Different" + "\n");
                        if (i == 0) {
                            this.riskIndicator = 3;
                        }
                    }
                } else {
                    System.out.println("\n" + firstName + " " + lastName + "\n" + listIterator.next().toString() +
                            "Overall Rating: Not Available Since There is No Previous Game or Practice to Compare to" + "\n");
                    if (i == 0) {
                        this.riskIndicator = 4;
                    }
                }
            }
        }
    }
}
