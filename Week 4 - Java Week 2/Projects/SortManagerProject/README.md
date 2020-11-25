

<img align="right" width="250" height="250" src="https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/sort%20manager%20-%20logo.png">


# **Sort Manager**
![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor) 
![algs_badge](https://img.shields.io/badge/-Sorting%20Algorithms-blue?style=for-the-badge&logo=appveyor)
![gui](https://img.shields.io/badge/-GUI-red?style=for-the-badge&logo=appveyor)
![oop](https://img.shields.io/badge/-OOP-brightgreen?style=for-the-badge&logo=appveyor)
![solid](https://img.shields.io/badge/-SOLID-orange?style=for-the-badge&logo=appveyor)

### **Table Of Contents**
  * [**Overview**](#overview)
  * [**Technology**](#technology)
  * [**Screenshots**](#screenshots)
      - [CLI Program](#cli-program)
      - [GUI Program](#gui-program)
  * [**Future Work**](#future-work)

## **Overview**
- Program that sorts an unsorted array based on user input
- User can select any of the 5 algorithms
  - Bubble Sort
  - Merge Sort
  - Binary Sort (ascending order)
  - Binary Sort (descending order)
  - Quick Sort
- User can select the desired length of an array
- An array is randomly generated
- The program can be run in 2 ways:
  - through the Command Line Interface (CLI)
  - through a Graphical User Interface (GUI)

## **Technology**
- Algorithms
  - Five different sorting algorithms has been implemented
- Exceptions
  - Both from java.lang and custom built ones
- Interfaces
  - Two interfaces are used: Sorter and BinaryTree
- SOLID Principles
  - The project aims to follow SOLID principles
- OOP: Object Oriented Programming
  - the 4 pillars: Abstraction, Inheritance, Encapsulation, Polymorphism
- Nested Classes
  - The Node class nested inside the Binary Tree class

## **Screenshots**

### **CLI Program**

Every time the CLI program is run, the following menu will be displayed in the command line allowing the user to select their preference:

![CLI - initial prompt](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/CLI%20-%20initial%20prompt.png)

As seen in the picture above, there are 5 algorithms to choose from:
- `Bubble Sort`
- `Merge Sort`
- `Binary Sort (ascending order)`
- `Binary Sort (descending order)`
- `Quick Sort`

The user is asked to enter the corresponding number for the option they opt for.
Sorting algorithms are included in options from 1 to 5.
The user is also given an option 6 - to compare the sorting times of all the algorithms.
Finally, to quit the program, user should choose option 7.

After choosing one of the options from 1 to 6, that is - a sorting algorithm
or a comparison of all of them, the program would prompt the user to input
the length of the random array you would like to sort.
Please note there is a size limit on the input array and it is capped at 1,000.

![CLI - array prompt](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/CLI%20-%20array%20prompt.png)

If a sorting algorithm was chosen, upon setting the desired array length, the
program will then sort the array using the specified algorithm. Note that the
default sorting order is ascending, unless specified otherwise.
You will be shown the following:

- `the entire unsorted random array`
- `the sorting algorithm that was used to sort the array`
- `the entire sorted array`
- `the time taken to sort the array`

![CLI - sort output](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/CLI%20-%20sort%20output.png)

In case option 6 was chosen, that is - comparing all algorithms by their times,
the program will first display the array the sorting was done on, before
displaying a table listing the sorting times of each
algorithm. The table is sorted in ascending order of time taken, with the
fastest algorithm on the top and slowest algorithm at the bottom.
Below is an example of such an output.

![CLI - comparison output](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/CLI%20-%20comparison%20output.png)

Upon finishing this run, the program will return to the first menu, where
the user will be free to choose another algorithm or make another comparison.
The user is welcome to repeat this cycle as many times as they wish until they
choose to exit the program.

### **GUI Program**

When the user runs the GUI program, a GUI application will open up. It will look like
the the picture below:

![GUI - initial setup](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/GUI%20-%20initial%20setup.png)

The 5 sorting algorithms are listed down the left hand side of the GUI,
as well as the option to compare all algorithms and the field to set the length
of the array. The re-randomise array option is included and can be found in the
bottom just below the field for setting the array length. Option to reset all 
output fields can be found in the left corner or the GUI.
Please note again that the array length input is still limited to 1,000.

For the user to sort an array or compare the algorithms, they must first enter
the length of the array they wish to sort, then press the button corresponding
to your desired action.

If the user decides to use a sorting algorithm, the GUI will display the
following, illustrated by an image similar to the one below:

- `the sorting algorithm used`
- `the entire unsorted array`
- `the entire sorted array`
- `the amount of time taken to sort the array`


![GUI - sort output](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/GUI%20-%20sort%20output.png)

If the user decides to compare all of the algorithms instead, the GUI will
show

- `all sorting algorithms having been used`
- `the entire unsorted array`
- `the table of sorting times for each algorithm over the unsorted array, with the fastest time on top`
- `the fastest algorithm for that comparison and its recorded sort time`

![GUI - comparison output](https://github.com/janjakovacevic/SpartaGlobal/blob/master/Week%204%20-%20Java%20Week%202/Projects/SortManagerProject/program%20screenshots/GUI%20-%20comparison%20output.png)

User is welcome to re-randomize an array of the same length before re-running any of the algorithms. They are also free to reset all output field before deciding on their next course of action.

While an action is being performed, all buttons will be temporarily disabled. Once the action has been completed, the user can immediately pick another option.

The user can exit the program at any point by pressing the close [X] button in the top left corner of the screen.

## **Future Work**
Possible improvments for `Sort Manager 2.0`
 - Add more sorting algorithms
 - Make use of Java Fx instead of Java Swing
 - Make the app web-based
