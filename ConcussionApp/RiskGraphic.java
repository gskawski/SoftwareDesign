//Skawski_Glenn_SportConcussion Assessment System Project_Phase III_Submission
package com.company;

import javax.swing.*;
import java.awt.*;

public class RiskGraphic extends JFrame {
    private int riskNumber;
    private String firstName;
    private String lastName;

    public RiskGraphic(int riskNumber, String firstName, String lastName)
        {
            this.riskNumber=riskNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            //Set default close operation for JFrame
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //Set JFrame size
            setSize(400,400);
            //Make JFrame visible
            setVisible(true);

            setTitle(this.firstName + " " + this.lastName + "'s Risky Condition Indicator");
        }

        public void paint(Graphics g)
        {
            super.paint(g);
            //draw circle outline
            g.drawOval(100,100,200,200);

            if (this.riskNumber == 1) {
                g.setColor(Color.GREEN);
            }
            else if (this.riskNumber == 2) {
                g.setColor(Color.YELLOW);
            }
            else if (this.riskNumber == 3) {
                g.setColor(Color.RED);
            }
            //fill circle with RED
            g.fillOval(100,100,200,200);
        }
    }
