import java.util.*;

public class Graph {
    private Set<Node> graph = new HashSet<>();

    public Set<Node> getGraph() {
        return graph;
    }

    public void addHop(Node hop){
        graph.add(hop);
    }
    public void shortestPath(Node genesis){
        genesis.setWeight(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(genesis);
        while (!unsettledNodes.isEmpty()){
            Node current = distance(unsettledNodes);
            System.out.println("prima di unsettle"+current.getLinks().size());
            unsettledNodes.remove(current);
            System.out.println(unsettledNodes);
            System.out.println("dopo di unsettle"+current.getLinks().size()+"curr"+current);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            current.getLinks().forEach((node,weight)->{
                if(!settledNodes.contains(node)){
                    minPath(node,current);
                    System.out.println("siii"+ node);
                    unsettledNodes.add(node);
                    System.out.println(" first if  "+unsettledNodes.size());
                }
            });
        }
    }

    private Node distance(Set<Node> unsettledNodes){
        Comparator<Node> comp = (a, b) -> a.getWeight() - b.getWeight();
        Node minimumWeight = new Node("temp");
        minimumWeight.setWeight(Integer.MAX_VALUE);
        //unsettledNodes.forEach((b)->{
        for (Node b: unsettledNodes) {
            if (comp.compare(b, minimumWeight) < 0) {
                minimumWeight = b;
                System.out.println("Distance");
            }
        }
        return minimumWeight;
    }

    private void minPath(Node nextHop,Node current){
        int sum = current.getWeight()+ nextHop.getWeight();
        if(sum < nextHop.getWeight());{
            System.out.println("in minPath");
            nextHop.setWeight(sum);
            LinkedList<Node> path = new LinkedList<>(current.getMinPath());
            path.add(current);
            nextHop.setMinPath(path);
        }
    }
}
