//Skawski_Glenn_SportConcussion Assessment System Project_Phase III_Submission
package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AthleteApplication {

    Scanner scan = new Scanner(System.in);

    ArrayList<AthletesGames> athletesGames = new ArrayList<AthletesGames>();

    public void addAthleteEvaluation() {
        scan.nextLine();
        System.out.println("Enter Athlete's FirstName? (Needs to Match Previous Entries Exactly): ");
        String firstName = scan.next();

        System.out.println("Enter Athlete's LastName? (Needs to Match Previous Entries Exactly): ");
        String lastName = scan.next();

        LocalDateTime gameTime = LocalDateTime.now();

        System.out.println("Please enter your pain level                        (no pain (0) to severe (6)): ");
        int painLevel = scan.nextInt();

        System.out.println("Please enter your headache score                    (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int headache = scan.nextInt();

        System.out.println("Please enter your pressure in head score            (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int headPressure = scan.nextInt();

        System.out.println("Please enter your neck pain score                   (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int neckPain = scan.nextInt();

        System.out.println("Please enter your nausea or vomiting score          (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int nausea = scan.nextInt();

        System.out.println("Please enter your dizziness score                   (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int dizziness = scan.nextInt();

        System.out.println("Please enter your blurred vision score              (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int blurredVision = scan.nextInt();

        System.out.println("Please enter your balance problems score            (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int balance = scan.nextInt();

        System.out.println("Please enter your sensitivity to light score        (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int lightSensitivity = scan.nextInt();

        System.out.println("Please enter your sensitivity to noise score        (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int noiseSensitivity = scan.nextInt();

        System.out.println("Please enter your feeling slowed down score         (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int slowedDown = scan.nextInt();

        System.out.println("Please enter your feeling like \"in a fog\" score     (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int inFog = scan.nextInt();

        System.out.println("Please enter your \"don't feel right \" score         (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int feelRight = scan.nextInt();

        System.out.println("Please enter your difficulty concentrating score    (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int concentrate = scan.nextInt();

        System.out.println("Please enter your difficulty remembering score      (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int remember = scan.nextInt();

        System.out.println("Please enter your fatigue or low energy score       (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int fatigue = scan.nextInt();

        System.out.println("Please enter your confusion score                   (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int confusion = scan.nextInt();

        System.out.println("Please enter your drowsiness score                  (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int drowsiness = scan.nextInt();

        System.out.println("Please enter your trouble falling asleep score      (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int sleep = scan.nextInt();

        System.out.println("Please enter your more emotional score              (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int emotion = scan.nextInt();

        System.out.println("Please enter your irritability score                (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int irritability = scan.nextInt();

        System.out.println("Please enter your sadness score                     (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int sadness = scan.nextInt();

        System.out.println("Please enter your nervous or anxious score          (none (0), mild (1-2), moderate (3-4), & severe (5-6)): ");
        int nervous = scan.nextInt();

        GameEntry newGameEntry = GameEntry.createGameEntry(gameTime, painLevel, headache, headPressure, neckPain, nausea, dizziness, blurredVision, balance, lightSensitivity, noiseSensitivity,
                slowedDown, inFog, feelRight, concentrate, remember, fatigue, confusion, drowsiness, sleep, emotion, irritability, sadness, nervous);

        if (findAthlete(firstName, lastName) == null) {
            AthletesGames newAthletesGames = new AthletesGames(firstName, lastName);
            newAthletesGames.addGame(newGameEntry);
            athletesGames.add(newAthletesGames);
        } else {
            AthletesGames ag = findAthlete(firstName, lastName);
            ag.addGame(newGameEntry);
        }
    }

    private AthletesGames findAthlete(String firstName, String lastName) {//pass name to find in list
        for(AthletesGames checkedAthlete: this.athletesGames) {//for every entry save as checked song and compare
            if(checkedAthlete.getFirstName().equals(firstName) && checkedAthlete.getLastName().equals(lastName)) {
                return checkedAthlete;
            }
        }
        return null;
    }

    public void getAthletesGameSummaries () {

        scan.nextLine(); // clear the input stream
        System.out.println("Enter Athlete's FirstName? (Needs to Match Previous Entries Exactly): ");
        String firstName = scan.next();

        System.out.println("Enter Athlete's LastName? (Needs to Match Previous Entries Exactly): ");
        String lastName = scan.next();

        AthletesGames ag = findAthlete(firstName, lastName);

        if (ag == null) {
            System.out.println("Athlete Not In Application");
        } else {
            ag.displayAthletesGameSummaries(firstName, lastName);
        }
    }

    public void getRiskConditionIndicator() {
        scan.nextLine(); // clear the input stream
        System.out.println("Enter Athlete's FirstName? (Needs to Match Previous Entries Exactly): ");
        String firstName = scan.next();

        System.out.println("Enter Athlete's LastName? (Needs to Match Previous Entries Exactly): ");
        String lastName = scan.next();

        AthletesGames ag = findAthlete(firstName, lastName);

        if (ag == null) {
            System.out.println("Athlete Not In Application");
        }
        else if (ag.getRiskIndicator() == 4) {
            System.out.println("Risky Condition Indicator Not Available Since There is No Previous Game or Practice to Compare to" + "\n");
        } else {
            int riskNum = ag.getRiskIndicator();
            RiskGraphic riskCircle = new RiskGraphic(riskNum, firstName, lastName);
        }
    }

    public void printAthletes() {
        for(int i=0; i< athletesGames.size(); i++) {
            System.out.println((i + 1) + ". " + athletesGames.get(i).getFirstName() + " " + athletesGames.get(i).getLastName());
        }
    }
}
