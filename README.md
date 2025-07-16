# Traffic Flow Optimization in a City Grid

---

## **Project Description**
This project uses **Dijkstra** and **A\*** algorithms to optimize traffic flow in a city modeled as a network of nodes and roads with traffic delays. The project is designed to find the fastest route between two nodes, taking into account real-time data about traffic and possible blockages.

---

## **Key Features**
1. **Dijkstra's Algorithm**  
   - Used for static cases where traffic does not change during the analysis time.
2. **A\* Algorithm**  
   - Utilizes a heuristic (Euclidean distance) to predict and optimize routes in real time.
3. **Traffic Simulation**  
   - Adjusts edge weights in the graph to mimic dynamic changes in traffic every few seconds.
4. **Dynamic Output**  
   - Finds the fastest route and displays the costs and travel time, adapted to current traffic conditions.

---
## Technical Requirements
- Java Development Kit (JDK): Version 8 or higher.
- IDE: IntelliJ IDEA, Eclipse, or terminal with configured Java environment.
- Git: For cloning the repository and managing code.

---

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/Brikenda-Zogaj/TrafficFlow.git
   cd src
## Running the Program
1. Open the Main class and run the program.

2. Select a start node and an end node.

3. The program will execute both algorithms:

  - Dijkstra for static cases.

  - A* for dynamic cases, using the heuristic.

4. The traffic simulation automatically updates road weights every 20 seconds.

## Project Structure
1. `Graph`
   - Represents the graph as an adjacency list and contains functions for managing nodes and edges.
2. `Pathfinding`
   - Contains algorithms for shortest path finding and heuristic calculation.
3. `TrafficSimulator`
   - Simulates dynamic traffic changes in the graph.
4. `Main`
   - Entry point of the program that connects all parts and provides the user interface.

## Example Execution
**1. Intial Graph**
This graph contains nodes and edges with corresponding weights as follows:
```java
// Shton nyje në graf.
graph.addNode("A");
graph.addNode("B");
graph.addNode("C");
graph.addNode("D");
graph.addNode("E");
graph.addNode("F");

// Shton lidhje (edge) midis nyjeve me peshat përkatëse.
graph.addEdge("A", "B", 10);
graph.addEdge("B", "C", 15);
graph.addEdge("C", "D", 20);
graph.addEdge("D", "E", 25);
graph.addEdge("E", "F", 30);
graph.addEdge("A", "D", 40);
graph.addEdge("B", "E", 35);
```
#  **Initial Result without Traffic Update:**
<img width="526" height="336" alt="sc1" src="https://github.com/user-attachments/assets/9c4e9be0-c559-4594-8894-2ff5e3b62d62" />

# **Result after a Traffic Update:**
<img width="380" height="289" alt="sc2" src="https://github.com/user-attachments/assets/b6cdea0a-241a-4109-abeb-17f65da3a17e" />


