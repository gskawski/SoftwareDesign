//Skawski_Glenn_SportConcussion Assessment System Project_Phase III_Submission
package com.company;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class GameEntry {

    private LocalDateTime gameTime;
    private int painLevel;
    private int headache, headPressure, neckPain, nausea, dizziness, blurredVision, balance, lightSensitivity, noiseSensitivity, slowedDown, inFog,
            feelRight, concentrate, remember, fatigue, confusion, drowsiness, sleep, emotion, irritability, sadness, nervous;
    private int totalSymptoms;
    private int severity;

    public GameEntry(LocalDateTime gameTime, int painLevel, int headache, int headPressure, int neckPain, int nausea, int dizziness, int blurredVision,
                     int balance, int lightSensitivity, int noiseSensitivity, int slowedDown, int inFog, int feelRight, int concentrate, int remember, int fatigue,
                     int confusion, int drowsiness, int sleep, int emotion, int irritability, int sadness, int nervous) {
        this.gameTime = gameTime;
        this.painLevel = painLevel;
        this.headache = headache;
        this.headPressure = headPressure;
        this.neckPain = neckPain;
        this.nausea = nausea;
        this.dizziness = dizziness;
        this.blurredVision = blurredVision;
        this.balance = balance;
        this.lightSensitivity = lightSensitivity;
        this.noiseSensitivity = noiseSensitivity;
        this.slowedDown = slowedDown;
        this.inFog = inFog;
        this.feelRight = feelRight;
        this.concentrate = concentrate;
        this.remember = remember;
        this.fatigue = fatigue;
        this.confusion = confusion;
        this.drowsiness = drowsiness;
        this.sleep = sleep;
        this.emotion = emotion;
        this.irritability = irritability;
        this.sadness = sadness;
        this.nervous = nervous;
        int[] results = SymptomsEvalResult();
        this.totalSymptoms = results[0];
        this.severity = results[1];
    }

    public int getSeverity() {
        return severity;
    }

    public int getTotalSymptoms() {
        return totalSymptoms;
    }

    private int[] SymptomsEvalResult() {
        int[] symptomsArray = {headache, headPressure, neckPain, nausea, dizziness, blurredVision, balance, lightSensitivity, noiseSensitivity, slowedDown, inFog,
                feelRight, concentrate, remember, fatigue, confusion, drowsiness, sleep, emotion, irritability, sadness, nervous};
        int total = 0;
        int severity = 0;

        for (int i = 0; i < symptomsArray.length; i++) {
            if(symptomsArray[i] > 0) {
                total++;
                severity += symptomsArray[i];
            }
        }
        int[] results = {total, severity};
        return results;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return  "Date and Time of Game or Practice: " + dtf.format(gameTime) + "\n" +
                "Total Number of Symptoms: " + totalSymptoms + "\n" +
                "Severity of Symptoms: " + severity + "\n";
    }

    public static GameEntry createGameEntry(LocalDateTime gameTime, int painLevel, int headache, int headPressure, int neckPain, int nausea, int dizziness, int blurredVision,
                                            int balance, int lightSensitivity, int noiseSensitivity, int slowedDown, int inFog, int feelRight, int concentrate, int remember,
                                            int fatigue, int confusion, int drowsiness, int sleep, int emotion, int irritability, int sadness, int nervous) {

        return new GameEntry(gameTime, painLevel, headache, headPressure, neckPain, nausea, dizziness, blurredVision, balance, lightSensitivity, noiseSensitivity, slowedDown,
                inFog, feelRight, concentrate, remember, fatigue, confusion, drowsiness, sleep, emotion, irritability, sadness, nervous);
    }
}
