# Readme file for MarsRoverApp

### How to install
Clone the repository from [Github](https://github.com/adeyatz/melody-mars-rover-app.git) here

### How to run
Open the Project and open the MarsRoverApp.java file `src/main/java/org/melody/roverApp/MarsRoverApp.java`

Then either:
+ find the `public static void main (String[] args)` function in the editor and select _Run MarsRoverApp.main()_ from the 
adjacent green triangle to the left _or_
+ select the Run menu, then _Run MarsRoverApp.main()_ from there _or_
+ select _Shift_ and _f10_ to run

The `MarsRoverApp` can take a parameter which points to the file containing the Mars Rover instructions. You set this up in the
`Run - Edit Configurations` menu in the IDE
If no input is passed into the program as an argument then the following file is the default:
[MarsRoverInput.txt](src/main/resources/MarsRoverInput.txt)

To pass a parameter filename into the application, the full path from the project root is required, for example:
`src/main/resources/MarsRoverInput.txt`


### Key features

+ Ability to support multiple Rovers at the same time
+ Attempts to create a MarsRover which is intially outside of the plateau causes an exception
+ Checks are made prior to every move to ensure each rover is within the boundary of the plateau and each rover does not enter another rovers location
+ If a rover attempts to move outside the boundary or enter another rovers location then the move does not go ahead although a message
is printed onto the console. Subsequent Move instructions are then acted upon on their merit
+ The position of the rover and its heading are printed to the console at the completion of processing of a Move string




### Assumptions
+ It should be possible to create alternative shapes for the plateau
+ The plateau is fenced – so a rover can’t move outside of the boundary
+ If a rover attempts to move outside of the plateau the move is ignored and the next move instruction is acted upon
+ Multiple rovers are to be supported at the same time
+ Rovers cannot be in the same place at the same time
+ Rovers can be blocked from moving by Mars Objects
+ A Plateau must be in place before a Rover can be created
+ It should be possible to support other vehicle types beside the Mars Rover
+ Vehicles should be capable of housing instruments
+ Mars objects should be capable of having properties, e.g  can be collected

### Approach 
Create a flexible, scaleable solution by making use of abstract classes and interfaces to facilitate:
+ Alternative Plateau shapes e.g polygon, circle
+ Alternative coordinate system e.g lat long, or What Three Words
+ Alternative Direction e.g degrees or radians
+ Support a range of different vehicle types
+ Support a range of Mars object types
+ To be expandable

The approach utilized the following methods:
+ UML diagramming
+ Block diagrams
+ Flowcharts
+ OO principals in the design
+ TDD for the coding
+ Refactor, refactor, refactor
+ Review the feedback
+ Sleep deprivation!


### Project Structure
The project is structured over 3 folders:
+ the _rover_ folder contains all the main code for the Mars Rover application. A sub-folder, _API_ contains the
  Interface and Abstract classes from which the other classes are derived. The main entry point to the Mars rover sub-system is
  the `MarsMissionController.java` file
+ The _roverApp_ folder contains the runnable `MarsRoverApp` application
+ The _roverIO_ folder contains the IO sub-system to allow input from either a file or hard-coded in a Class

In addition, there are Unit tests for all the main classes in the associated Test folders


The entry point to the main code,`MarsMissionController.java` contains 3 main functions to control the Mars Rovber subsystem
which reflect the 3 types of string input to the MarsRover app

+ `createPlateau()`
+ `createMarsRover()`
+ `moveMarsRover()`

### Tests
The default test file contains the following test:  
`/# Example Test Case, from Mars Rover Brief 1.1.0`   
`5 5`  
`1 2 N`  
`LMLMLMLMM`   
`3 3 E`  
`MMRMMRMRRM`

To illustrate Rovers not colliding the following could be used (where rover one finishes in location (1,3))  
`/# Example Test Case, where rovers collide at position (1,3)`  
`5 5`  
`1 2 N`  
`LMLMLMLMM`   
`1 2 N`  
`MMRMMRMRRM`




### Future thoughts
In the UML diagram [here](docs/Melody Mars Rover UML v4.png) all the classes above the Red line have been implemented. However that does mean that conversely none of the classes below the red line have been.
In addition, the main Mars Rover functionality that is performed by the classes below the green line and have been unit tested. The classes above the green line are purely there to create an application that
can be run, and read input from a file, so are not particularly robust to rogue input and the like

Here are some thoughts about how we could expand the application:
+ Finish coding the classes that are missing!
+ Enable the MarsRover to be 'decorated' with a camera and / or robotic arm
+ Enable the MarsRover to collect objects and place in a basket
+ Implement the MarsRoverObject classes, so that other objects besides vehicles can be positioned in the grid
+ Refactor the test classes given more time
+ Provide a better UI component, maybe a graphical representation of the grid and what is located where 




