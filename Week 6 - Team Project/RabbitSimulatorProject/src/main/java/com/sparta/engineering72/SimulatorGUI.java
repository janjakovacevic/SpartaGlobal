package com.sparta.engineering72;

import com.sparta.engineering72.animal.fox.Fox;
import com.sparta.engineering72.animal.rabbit.Rabbit;
import com.sparta.engineering72.log.Logger;
import com.sparta.engineering72.simulation.Simulator;
import com.sparta.engineering72.utility.ReportPacker;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class SimulatorGUI extends JFrame{
    private JPanel panel;
    private JLabel welcomeLabel;
    private JLabel rabbitSettingsLabel;
    private JSpinner rabbitMaturityAgeSpinner;
    private JSpinner rabbitDeathAgeSpinner;
    private JLabel foxSettingsLabel;
    private JSpinner foxDeathAgeSpinner;
    private JTextField totalRabbitsTextField;
    private JLabel rabbitsReportLabel;
    private JLabel populationReportLabel;
    private JTextField maleRabbitsTextField;
    private JTextField femaleRabbitsTextField;
    private JLabel foxesReportLabel;
    private JLabel allSettingsLabel;
    private JLabel simulationReportLabel;
    private JTextField totalFoxesTextField;
    private JTextField maleFoxesTextField;
    private JLabel timerSettingsLabel;
    private JSpinner yearsSpinner;
    private JSpinner monthsSpinner;
    private JLabel deathReportLabel;
    private JTextField oldAgeDeathRabbitsTextField;
    private JButton startSimulationButton;
    private JTextField preyDeathRabbitsTextField;
    private JLabel rabbitMaturityAgeLabel;
    private JLabel rabbitDeathAgeLabel;
    private JSpinner foxMaturityAgeSpinner;
    private JLabel foxMaturityAgeLabel;
    private JLabel foxDeathAgeLabel;
    private JLabel yearsLabel;
    private JLabel monthsLabel;
    private JTextField femaleFoxesTextField;
    private JLabel totalRabbitsLabel;
    private JLabel maleRabbitsLabel;
    private JLabel femaleRabbitsLabel;
    private JLabel totalFoxesLabel;
    private JLabel maleFoxesLabel;
    private JLabel femaleFoxesLabel;
    private JTextField deathFoxesTextField;
    private JLabel successMessageTextField;
    private JLabel oldAgeDeathRabbitsLabel;
    private JLabel preyDeathRabbitsLabel;
    private JLabel deathFoxesLabel;
    private JButton resetButton;


    private static final Color DARK_GREEN = new Color(0,153,0);

    public SimulatorGUI(String s){
        super(s);
        start();
    }

    public void start(){
        try {
            setUpJFrame();
            styleFields();
            buttonHandler();
            pack();
        } catch(Exception e){
            Logger.logError(e, e.getMessage());
        }
    }

    private void setUpJFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(720, 540);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void styleFields() {

        // allowing a range of values -million to +million, then providing user with a feedback
        rabbitMaturityAgeSpinner.setModel(new SpinnerNumberModel(3, 0, 1000, 1));
        rabbitDeathAgeSpinner.setModel(new SpinnerNumberModel(60, 0, 1000, 1));
        foxMaturityAgeSpinner.setModel(new SpinnerNumberModel(12, 0, 1000, 1));
        foxDeathAgeSpinner.setModel(new SpinnerNumberModel(60, 0, 1000, 1));
        yearsSpinner.setModel(new SpinnerNumberModel(0, 0, 9999, 1));
        monthsSpinner.setModel(new SpinnerNumberModel(0, 0, 11, 1));
    }

    private void buttonHandler(){
        startSimulationButton.addActionListener(e -> callSimulator());
    }

    private void enableButtons(boolean able){
        startSimulationButton.setEnabled(able);
    }

    private void callSimulator(){

        int years = Integer.parseInt(yearsSpinner.getValue().toString());
        int months = Integer.parseInt(monthsSpinner.getValue().toString());
        int totalMonths = years * 12 + months;

        int rabbitMaturityAge = Integer.parseInt(rabbitMaturityAgeSpinner.getValue().toString());
        Rabbit.setMaturityAge(rabbitMaturityAge);
        int rabbitDeathAge = Integer.parseInt(rabbitDeathAgeSpinner.getValue().toString());
        Rabbit.setDeathAge(rabbitDeathAge);
        int foxMaturityAge = Integer.parseInt(foxMaturityAgeSpinner.getValue().toString());
        Fox.setMaturityAge(foxMaturityAge);
        int foxDeathAge = Integer.parseInt(foxDeathAgeSpinner.getValue().toString());
        Fox.setDeathAge(foxDeathAge);

        enableButtons(false);
        ReportPacker reportPacker = Simulator.resetAllStaticValues(totalMonths, 1);
        enableButtons(true);

        showSimulatorResults(reportPacker);
    }

    private void showSimulatorResults(ReportPacker reportPacker){

        successMessageTextField.setForeground(DARK_GREEN);
        successMessageTextField.setText("THE SIMULATOR HAS FINISHED RUNNING!");

        DecimalFormat myFormatter = new DecimalFormat("###,###,###");

        totalRabbitsTextField.setText("" + myFormatter.format(reportPacker.getTotalRabbits()));
        maleRabbitsTextField.setText("" + myFormatter.format(reportPacker.getMaleRabbits()));
        femaleRabbitsTextField.setText("" + myFormatter.format(reportPacker.getFemaleRabbits()));
        totalFoxesTextField.setText("" + myFormatter.format(reportPacker.getTotalFoxes()));
        maleFoxesTextField.setText("" + myFormatter.format(reportPacker.getMaleFoxes()));
        femaleFoxesTextField.setText("" + myFormatter.format(reportPacker.getFemaleFoxes()));
        oldAgeDeathRabbitsTextField.setText("" + myFormatter.format(reportPacker.getRabbitAgeDeaths()));
        preyDeathRabbitsTextField.setText("" + myFormatter.format(reportPacker.getRabbitPreyDeaths()));
        deathFoxesTextField.setText("" + myFormatter.format(reportPacker.getFoxDeaths()));
    }

}
