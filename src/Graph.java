import java.util.*;
public class Graph {
    private Set<Node> graph = new HashSet<>();

    public Set<Node> getGraph() {
        return graph;
    }
    // new node to the graph
    public void addHop(Node hop){
        graph.add(hop);
    }

    // Dijkstra
    public void shortestPath(Node genesis){
        genesis.setWeight(0);
        Set<Node> settledNodes = new HashSet<>();
        PriorityQueue<Node> unsettledNodes = new PriorityQueue<>(2, (a, b) -> a.getWeight() - b.getWeight());
        unsettledNodes.add(genesis);
        while (!unsettledNodes.isEmpty()){
            Node current = distance(unsettledNodes);
            unsettledNodes.remove(current);
            settledNodes.add(current);
            current.getLinks().forEach((node,weight)->{
                if(!settledNodes.contains(node)){
                    minPath(node,weight,current);
                    unsettledNodes.add(node);
                }
            });
        }
    }

    private Node distance(PriorityQueue<Node> unsettledNodes){
        Node minimumWeight = null;
        int weight = Integer.MAX_VALUE;
        for (Node b: unsettledNodes) {
            if(b.getWeight()<weight){
                minimumWeight = b;
                weight = b.getWeight();
            }
        }
        return minimumWeight;
    }

    private void minPath(Node nextHop,int weight,Node current){
        int sum = current.getWeight()+weight;
        if(sum < nextHop.getWeight());{
            nextHop.setWeight(sum);
            LinkedList<Node> path = new LinkedList<>(current.getMinPath());
            path.add(current);
            nextHop.setMinPath(path);
        }
    }
}
