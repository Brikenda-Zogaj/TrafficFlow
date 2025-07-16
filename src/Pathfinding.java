import java.util.*;

public class Pathfinding {
    static double calculateHeuristic(String node, String goal, Map<String, int[]> coordinates) {
        int[] currentCoords = coordinates.get(node);
        int[] goalCoords = coordinates.get(goal);
        return Math.sqrt(Math.pow(goalCoords[0] - currentCoords[0], 2) + Math.pow(goalCoords[1] - currentCoords[1], 2));
    }

//    Ky bllok i kodit zbaton algoritmin e kërkimit të rrugës më të shkurtër duke përdorur qasjen e Dijkstra ose A*.
//    Kombinimi i gScore dhe fScore ndihmon në optimizimin e kërkimit, ndërsa heuristika (nëse ekziston) përshpejton procesin.
//    Me inicializimin e e gscore qe eshte nje harte apo map qe po i ruan koston me te ulet per me arrit qdo nyje nga nyja fillestare
//    Me fscore ruan koson totale per vlerat e parashikuar per me arrit ne nyjet e destinacionit,cameFrom është një hartë që ruan rrugën
//    më të mirë për të arritur çdo nyje.openSet është një PriorityQueue që ruan nyjet që do të eksplorohen.
//    Krahason vlerat numerike të fScore dhe i radhit në mënyrë që vlerat më të vogla të jenë të parat.

    public static Map<String, Object> findShortestPath(Graph graph, String start, String end, Map<String, Double> heuristics) {
        Map<String, Double> gScore = new HashMap<>();
        Map<String, Double> fScore = new HashMap<>();
        Map<String, String> cameFrom = new HashMap<>();
        PriorityQueue<String> openSet = new PriorityQueue<>(Comparator.comparingDouble(fScore::get));
//        List<String> visitedNodes = new ArrayList<>();


        for (String node : graph.getNodes()) {
            gScore.put(node, Double.MAX_VALUE);
            fScore.put(node, Double.MAX_VALUE);
        }

        gScore.put(start, 0.0);
        fScore.put(start, heuristics != null ? heuristics.getOrDefault(start, 0.0) : 0.0);
        openSet.add(start);


        while (!openSet.isEmpty()) {
            String current = openSet.poll();
//            visitedNodes.add(current);

            if (current.equals(end)) {
                return reconstructPath(cameFrom, end, gScore.get(end)/*,visitedNodes*/);
            }

            for (Map.Entry<String, Double> neighbor : graph.getNeighbors(current).entrySet()) {
                String neighborNode = neighbor.getKey();
                double tentativeGScore = gScore.get(current) + neighbor.getValue();

                if (tentativeGScore < gScore.get(neighborNode)) {
                    cameFrom.put(neighborNode, current);
                    gScore.put(neighborNode, tentativeGScore);

                    double heuristic = heuristics != null ? heuristics.getOrDefault(neighborNode, 0.0) : 0.0;
                    fScore.put(neighborNode, tentativeGScore + heuristic);

                    if (!openSet.contains(neighborNode)) {
                        openSet.add(neighborNode);
                    }
                }
            }
        }

        return null;
    }

//    Funksioni reconstructPath rindërton rrugën më të shkurtër duke përdorur informacionin e ruajtur
//    në hartën cameFrom. Fillon nga nyja fundore dhe ndjek rrugën pas, duke shtuar nyjet në listë në rendin e duhur.
//    Më pas, kthen një hartë që përmban rrugën (nyjet) dhe koston totale të saj

    private static Map<String, Object> reconstructPath(Map<String, String> cameFrom, String end, double totalCost /*,List<String> visitedNodes */) {
        List<String> path = new LinkedList<>();
        String current = end;

        while (current != null) {
            path.add(0, current);
            current = cameFrom.get(current);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("path", path);
//        result.put("cost", totalCost);
////        result.put("visited", visitedNodes);
        return result;
    }
}
