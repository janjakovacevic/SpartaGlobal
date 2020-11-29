# Rabbit Simulator

<img align="right" width="450" height="350" src="https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/24843973-5114-4226-987b-d5e6bd13ed77_200x200.png">

![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor) 
![memory_management](https://img.shields.io/badge/-Memory%20Management-orange?style=for-the-badge&logo=appveyor)
![agile](https://img.shields.io/badge/-Agile-blue?style=for-the-badge&logo=appveyor)
![scrum](https://img.shields.io/badge/-Scrum-red?style=for-the-badge&logo=appveyor)
![testing](https://img.shields.io/badge/-Testing-green?style=for-the-badge&logo=appveyor)


### **Table Of Contents**
  * [**Overview**](#overview)
  * [**Technology**](#technology)
  * [**Observations**](#observations)
  * [**Screenshots**](#screenshots)
      - [CLI Program](#cli-program)
      - [GUI Program](#gui-program)
  * [**Future Work**](#future-work)


## **Overview**
- A program that simulates how rabbits and foxes would behave in a real-life scenario: breeding and eating patterns
- The simulation starts with one rabbit couple and one fox couple
- User can choose to change default maturity and death age
  - If not, default values are as follows:
    - Rabbit maturity age: 3 months
    - Rabbit death age: 60 months (5 years)
    - Fox maturity age: 12 months
    - Fox death age: 60 months (5 years)
- Female rabbits have a 50% chance of giving birth each month after the maturity age has been reached
- Female rabbits can give birth to anywhere between 1-14 bunnies every time they get pregnant
- Female foxes always give birth to anywhere between 1-10 kits every 12 months
- Foxes hunt rabbits for prey
- First generation of foxes (the starting couple) doesn't hunt rabbits
- All other foxes hunt up to 20 rabbits each month

## **Technology**
- Scrum Framework within Agile
  - Followed Agile methodology to allow for easier implementation of changes in the requirements
- BigInteger
  - Made use of BigInteger to prevent the simulation from being limited by the integer limit
- JSON/Jackson
  - Made use of Jackson to write reports to an external `JSON` file allowing for further application of data
- OOP: Object Oriented Programming
  - Implements the 4 pillars of OOP (why are they important?)
- SOLID
  - Following SOLID principles for best practice that would allow for maintainable and extendable code

## **Observations**
- The biggest challanges that were faced during the development of this project were:
  - Memory Management
    - Initally, each animal was represented as an object 
    - Due to the large number of objects being created at each iteration (month), the simulation wasn't able to run for very long (<2 years)
    - To solve this problem, instead of creating a new object for each new animal being born, one object was created for each generation/age group, and a count variable was introduced to keep track of the number of animals of specific age
  - Integer limit
    - Depending on how long the simulation ran for, the Integer limit was sometimes getting exceeded and turning negative
    - To solve this problem, all integer values were substituted with BigInteger that allowed for exceptionally large values to be handled
  - Efficiency of the simulation
    - Once the number of animals of certain age got large enough, the program would take too long running due to the number of iterations that had to be performed
    - To solve this problem, a threshold value was set: every time it was reached, all randomized values would converge to a specific values and, by doing so, cut down on the number of iterations that need to be performed expediting the process


## **Screenshots**
- When the application is launched, user will first be asked for a choice on how they would like to run the application - in the Command Line Interface or in Graphical User Interface.

![cli-gui](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/cli-gui.png)

### **CLI Program**
- Should the user select option `1`, the following prompt would be displayed.

![cli_prompts](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/cli-prompts.png)

- Depending on the input provided by the user, up to 3 kinds of reports will be generated:
    - in the command line
    
        ![cli_report](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/cli-report.png)
        
    - in a `TXT` file
    
        ![txt_report](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/txt-report.png)
        
    - in a `JSON` file
        
        ![json_report](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/json-report.png)


### **GUI Program**
- Should the user select option `2`, they will be displayed with the following GUI. Notice that the default values are already entered, but the user is welcome to make any adjustments they choose to

![gui_prompt](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/gui-prompts.png)

- Depending on the input provided by the user, they will be provided with 2 kinds of reports - within GUI (shown in the image below) as well as in a `JSON` file inside resources foulder.
    
![gui_report](https://github.com/janjakovacevic/Rabbit-Population-Explosion/blob/dev/rabbit%20assets/gui-report.png)


## **Future Work**
Possible improvements for `Rabbit Simulator 2.0`
- Simulating hunting behavior more accurately
- Foxes die after a year if they don’t eat
- Add more animals
- Add more food sources (plants/grass)
- Display data in a more visually appealing manner
