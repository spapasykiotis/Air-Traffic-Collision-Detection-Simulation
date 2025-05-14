
# Airplane Collision Simulation

This project simulates the movement of airplanes in 3D space and detects potential collisions based on the proximity of airplanes along the X and Y axes. The simulation generates random airplane coordinates, moves them over multiple time steps, and analyzes their relative positions to calculate collision warnings. The results are logged and provide insights into the proximity of airplanes and the time performance of the simulation.

---

## Project Structure

The project consists of the following files:

- **CoordinateAxis.java**: An enum defining the three coordinate axes (X, Y, Z) and a method to get the value of a specific coordinate for an airplane.
- **airplane.java**: Defines the airplane class with coordinates (X, Y, Z) and a unique ID. It also includes methods to set and get the airplane’s coordinates.
- **factorial.java**: A helper class with a recursive method for calculating the factorial of a number. This is not directly used in the main simulation but can be used for future enhancements.
- **project_main.java**: The main class that runs the simulation, generates airplanes, detects proximity warnings, and logs the results for each time step.
- **simulation.java**: A class that stores the results of each simulation step, including warning counts, elapsed time, and the spatial arrangement of airplanes.
- **sortbyX.java** and **sortbyY.java**: Comparators for sorting airplanes based on their X and Y coordinates. Sorting is used to analyze airplane proximity more efficiently.

---

## How the Project Works

### 1. **Airplane Class (`airplane.java`)**

Each airplane has three coordinates (X, Y, Z) and a unique ID. The simulation generates random positions for each airplane and assigns them an ID. The airplane's position can be updated over the course of the simulation.

### 2. **Coordinate Axis Enum (`CoordinateAxis.java`)**

The `CoordinateAxis` enum defines three constants for the X, Y, and Z axes. The `getValue` method is used to get the coordinate value of an airplane along a specified axis.

### 3. **Main Simulation Logic (`project_main.java`)**

The main simulation logic is handled by the `project_main` class. The simulation works as follows:

- **Initialization**: A set number of airplanes (`N`) is generated with random positions in 3D space. The positions of the airplanes are then used in the simulation.
  
- **Movement**: At each simulation step (`T` steps in total), the airplanes are moved randomly along each axis. The Z-axis (altitude) is adjusted by a smaller range to simulate changes in the height of airplanes.
  
- **Proximity Detection**: The airplanes are checked for proximity along the X and Y axes. If two airplanes are too close to each other, a warning is triggered. The distance between airplanes is compared with a specified proximity limit (`limit_x` for X and `limit_y` for Y).
  
- **Warning Calculation**: The number of warnings is calculated based on the number of airplanes that are too close to each other. The more airplanes in proximity, the higher the warning score. The warnings are stored and logged for each step.

- **Statistics**: For each step, the program calculates the total number of warnings for the X and Y axes, the overall warnings, and the time taken to perform the calculations. These results are logged and stored in the `simulation` objects.

### 4. **Results**

At the end of the simulation, the program outputs:

- **Total Simulation Time**: The total time taken for the simulation to run across all steps.
- **Total Warnings**: The total number of warnings triggered during the simulation.
- **Average Calculation Time per Step**: The average time taken for each step of the simulation.

The output for each step includes the number of warnings for both the X and Y axes, as well as the total warnings and the time elapsed for that step.

---

## Example Output

The output from the simulation looks like this:

```
Step 0 X limit warnings: 25.0
Step 0 Y limit warnings: 15.0
Step 0 total warnings: 40.0
Step 0 time elapsed for calculation: 120 ms

...

Total simulation time: 1500 ms
Total simulation warnings: 450.0
Average calculation time per step: 120 ms
```

---

## Classes and Methods

### **airplane.java**
- **Attributes**: `x`, `y`, `z`, `ID`
- **Constructors**: Initializes airplanes with random coordinates or predefined coordinates.
- **Methods**: Setters and getters for the coordinates and ID.

### **CoordinateAxis.java**
- **Methods**:
  - `getValue(airplane plane)`: Returns the value of the specified coordinate for an airplane.

### **factorial.java**
- **Methods**:
  - `cfactorial(int n)`: Recursively calculates the factorial of a number.

### **project_main.java**
- **Methods**:
  - `analyzeCoordinate(airplane[] plane, int N, int limit, Comparator<airplane> comparator, String coordinateName)`: Analyzes the airplanes' positions for potential collisions based on the specified coordinate (X or Y).
  - `getCoordinateValue(airplane plane, String coordinate)`: Returns the coordinate value (X or Y) for a given airplane.

### **simulation.java**
- **Attributes**: `xwarning`, `ywarning`, `airplanes_space`, `allwarnings`, `timeElapsed`
- **Methods**: Setters and getters for each attribute.

### **sortbyX.java and sortbyY.java**
- **Methods**: 
  - `compare(airplane a, airplane b)`: Compares two airplanes based on their X or Y coordinates.

---

## Future Improvements

- **Advanced Collision Detection**: Extend the collision detection to consider the Z-axis (altitude) and potential 3D collisions.
- **Visualization**: Implement a graphical representation of the airplanes' positions and their proximity to each other.
- **More Complex Behavior**: Model more realistic airplane movements, such as changing velocities or planned flight paths.
- **Performance Optimization**: Enhance the algorithm to handle larger datasets and more efficient sorting or clustering techniques.

---

## How to Run

1. Clone the repository to your local machine.
2. Compile all the `.java` files.
3. Run the `project_main.java` file to start the simulation.

The simulation will generate a set number of airplanes, move them over several discrete time steps, and output the collision warnings and timing statistics.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
