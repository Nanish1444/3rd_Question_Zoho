import java.util.*;

public class Manager {
    public static void main(String[] args) {
        // Input edges
        String[] edges = {"A->A", "B->C", "A->B", "C->D", "D->E","E->F","N->F","A->N","B->B"};
        
        // Step 1: Build the adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> allNodes = new HashSet<>();
        for (String edge : edges) {
            String[] nodes = edge.split("->");
            String from = nodes[0];
            String to = nodes[1];
            
            allNodes.add(from); // Track all nodes
            allNodes.add(to);
            
            if (from.equals(to)) {
                // Include self-references in the graph but do not add any neighbors
                graph.putIfAbsent(from, new ArrayList<>());
            } else {
                graph.putIfAbsent(from, new ArrayList<>());
                graph.get(from).add(to);
            }
        }
        
        // Step 2: Compute reachable nodes for each node
        Map<String, Set<String>> reachableMap = new HashMap<>();
        for (String node : allNodes) {
            Set<String> visited = new HashSet<>();
            dfs(node, graph, visited);
            reachableMap.put(node, visited);
        }
        
        // Step 3: Print the result
        for (String node : reachableMap.keySet()) {
            System.out.print(node + "->{");
            List<String> sortedReachable = new ArrayList<>(reachableMap.get(node));
            sortedReachable.remove(node);
            Collections.sort(sortedReachable);
            System.out.println(String.join(",", sortedReachable) + "}");
        }
    }

    // Helper function to perform DFS
    private static void dfs(String node, Map<String, List<String>> graph, Set<String> visited) {
        if (visited.contains(node)) return; // Avoid cycles
        visited.add(node);
        
        // Traverse neighbors
        if (graph.containsKey(node)) {
            for (String neighbor : graph.get(node)) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
