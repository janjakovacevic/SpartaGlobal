package com.sparta.janja.views;

import com.sparta.janja.logger.LoggerClass;
import com.sparta.janja.manager.ArrayGenerator;
import com.sparta.janja.manager.SortingResultManager;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author janjakovacevic on 17/10/2020.
 * @project SortManagerProject
 */

public class SortManagerGUI extends JFrame {

    private JPanel panel;
    private JTextArea generatedArrayText;
    private JTextArea sortResultText;
    private JTextField messageBoxText;
    private JTextField algorithmSelectionText;
    private JTextField algorithmUsedNameText;
    private JTextField arrayLengthTextField;
    private JButton bubbleSortButton;
    private JButton mergeSortButton;
    private JButton binarySortAscendingButton;
    private JButton binarySortDescendingButton;
    private JButton compareAllSortsButton;
    private JButton randomizeArrayButton;
    private JSpinner arrayLengthInput;
    private JTextField timeText;
    private JTextField arrayLengthMaxText;
    private JLabel generatedArrayTitleText;
    private JLabel sortResultTitleText;
    private JTextField algorithmUsedText;
    private JButton quickSortButton;
    private JTextField welcomeMessage;
    private JButton resetTextFieldsButton;
    private JTextField spaceFiller;

    private static final Color DARK_GREEN = new Color(0,153,0);

    public SortManagerGUI(String s) {
        super(s);
    }

    public void start(){
        try {
            LoggerClass.logTrace("GUI: Starting");
            setUpJFrame();
            styleFields();
            buttonActionHandlers();
            pack();
        } catch(NegativeArraySizeException | NullPointerException e){
            LoggerClass.logError(e.getMessage());
        } catch(Exception e){
            LoggerClass.logError(e.getMessage() + " caused by " + e.getCause());
        }
    }

    private void setUpJFrame() {
        LoggerClass.logTrace("GUI: frame setup");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1080, 720);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    private void styleFields() {
        LoggerClass.logTrace("GUI: styling fields");
        welcomeMessage.setBorder(null);
        algorithmSelectionText.setBorder(null);
        arrayLengthTextField.setBorder(null);
        arrayLengthMaxText.setBorder(null);
        algorithmUsedText.setBorder(null);
        messageBoxText.setBorder(null);
        spaceFiller.setBorder(null);

        // allowing a range of values -million to +million, then providing user with a feedback
        arrayLengthInput.setModel(new SpinnerNumberModel(1, -1_000_000, 1_000_000, 1));
    }

    private void buttonActionHandlers() throws NegativeArraySizeException, NullPointerException{
        LoggerClass.logTrace("GUI: activating button action listeners");
        bubbleSortButton.addActionListener(a -> callSorter(1));
        mergeSortButton.addActionListener(a -> callSorter(2));
        binarySortAscendingButton.addActionListener(a -> callSorter(3));
        binarySortDescendingButton.addActionListener(a -> callSorter(4));
        quickSortButton.addActionListener(a -> callSorter(5));
        compareAllSortsButton.addActionListener(a -> compareAllSorters());
        randomizeArrayButton.addActionListener(a -> {
            try {
                int inputLength = Integer.parseInt(arrayLengthInput.getValue().toString());
                if(!isArrayLengthInputInvalid(inputLength)) {
                    ArrayGenerator.generatingRandomArray(inputLength);
                    resetAllTextFields();
                    messageBoxText.setForeground(DARK_GREEN);
                    messageBoxText.setText("ARRAY HAS BEEN RE-RANDOMIZED");
                }
            } catch(NegativeArraySizeException nase){
                LoggerClass.logError("Negative array length: " + nase.getMessage());
            } catch(NullPointerException npe){
                LoggerClass.logError("Null Pointer: " + npe.getMessage());
            } catch(NumberFormatException nfe){
                LoggerClass.logError("Number format: " + nfe.getMessage());
            }
        });
        resetTextFieldsButton.addActionListener(a -> {
            resetAllTextFields();
            arrayLengthInput.setValue(Integer.valueOf(1));
        });
    }

    private void resetAllTextFields(){
        messageBoxText.setText("");
        timeText.setText("TIME TAKEN: ");
        sortResultText.setText("");
        generatedArrayText.setText("");
        algorithmUsedNameText.setText("");
    }

    private void enableAllButtons(boolean able) {
        binarySortAscendingButton.setEnabled(able);
        bubbleSortButton.setEnabled(able);
        binarySortDescendingButton.setEnabled(able);
        mergeSortButton.setEnabled(able);
        quickSortButton.setEnabled(able);
        compareAllSortsButton.setEnabled(able);
        randomizeArrayButton.setEnabled(able);
    }

    private boolean isArrayLengthInputInvalid(int inputLength) throws NegativeArraySizeException{
        if (inputLength < 0) {
            messageBoxText.setForeground(Color.RED);
            messageBoxText.setText("ARRAY CANNOT BE OF NEGATIVE LENGTH");
            return true;
        }
        if (inputLength == 0) {
            messageBoxText.setForeground(Color.RED);
            messageBoxText.setText("ARRAY CANNOT BE EMPTY");
            return true;
        }
        if (inputLength > 1000){
            messageBoxText.setForeground(Color.RED);
            messageBoxText.setText("ARRAY LENGTH GREATER THAN 1000 IS NOT ALLOWED");
            return true;
        }
        else {
            messageBoxText.setForeground(DARK_GREEN);
            return false;
        }
    }

    private void callSorter(int sorterChoice) {

        LoggerClass.logTrace("calling a sorter");

        int inputLength = Integer.parseInt(arrayLengthInput.getValue().toString());
        SortingResultManager sortResults;

        if (isArrayLengthInputInvalid(inputLength)) return;

        messageBoxText.setText("SORTER IS RUNNING...");
        enableAllButtons(false);
        sortResults = SortingResultManager.runAlgorithm(sorterChoice, ArrayGenerator.generatingRandomArray(inputLength));
        enableAllButtons(true);

        showSortResults(sortResults);
    }

    private void showSortResults(SortingResultManager sortingResultManager) {

        LoggerClass.logTrace("displaying sort results");

        messageBoxText.setText("SORTER HAS FINISHED RUNNING!");
        algorithmUsedNameText.setText(sortingResultManager.getAlgorithmName());
        generatedArrayText.setText(Arrays.toString(sortingResultManager.getOriginalArray()));
        sortResultText.setText(Arrays.toString(sortingResultManager.getSortedArray()));
        timeText.setText("TIME TAKEN: " + sortingResultManager.getSortTime() + " milliseconds");
    }

    private void compareAllSorters() {

        LoggerClass.logTrace("calling all sorters");

        int inputLength = Integer.parseInt(arrayLengthInput.getValue().toString());
        List<SortingResultManager> algorithmTimesList;
        int[] unsortedArray, array;

        if (isArrayLengthInputInvalid(inputLength)) return;

        unsortedArray = ArrayGenerator.generatingRandomArray(inputLength);
        array = Arrays.copyOf(unsortedArray, inputLength);

        messageBoxText.setText("RUNNING ALL SORTERS...");
        enableAllButtons(false);
        algorithmTimesList = SortingResultManager.runAllAlgorithms(array);
        enableAllButtons(true);

        algorithmTimesList.sort((algorithm1, algorithm2) -> (int) (1_000_000.0 * (algorithm1.getSortTime() - algorithm2.getSortTime())));

        showComparisonResults(unsortedArray, algorithmTimesList);
    }

    private void showComparisonResults(int[] array, List<SortingResultManager> algorithmTimesList) {

        LoggerClass.logTrace("displaying all sort results");

        messageBoxText.setText("ALL SORTERS HAVE FINISHED RUNNING!");
        algorithmUsedNameText.setText("ALL ALGORITHMS");
        generatedArrayText.setText(Arrays.toString(array));

        StringBuilder result = new StringBuilder(("\n Sorting Algorithms' Times over " + array.length + " elements\n"));
        result.append("-----------------------------------------------\n\n");

        int ranking = 1;
        for (SortingResultManager algorithmSortTime : algorithmTimesList) {
            result.append(String.format(" %d. %s : %.5f milliseconds\n", ranking, algorithmSortTime.getAlgorithmName(), algorithmSortTime.getSortTime()));
            ranking++;
        }
        sortResultText.setText(result.toString());
        timeText.setText(" Fastest sorter over " + (array.length) + " elements is " + algorithmTimesList.get(0).getAlgorithmName()
                + " with " + String.format("%.5f", algorithmTimesList.get(0).getSortTime()) + "ms.");
    }

}
