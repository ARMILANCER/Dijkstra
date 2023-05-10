import java.util.*;

public class Node {
    private String label;
    private int weight = Integer.MAX_VALUE;
    private HashMap<Node, Integer> links;
    private Node prev = null;
    private List<Node> minPath = new LinkedList<>();

    public List<Node> getMinPath() {
        return minPath;
    }

    public void setMinPath(LinkedList<Node> path) {
        minPath = path;
    }

    public HashMap<Node, Integer> getLinks() {
        return links;
    }

    public Node(String label) {
        this.label = label;
        links = new HashMap<>();
    }

    public void link(Node nodo2, Integer weight) {
        links.put(nodo2, weight);
        nodo2.links.put(this, weight);
    }

    public int weightTo(Node n) {
        return weight + links.get(n);
    }

    public String getPath() {
        String weight = "";
        if (this.weight < Integer.MAX_VALUE)
            weight += this.weight;
        else
            weight = "inf";
        String out = "(" + label + "-" + weight + ")";
        if (prev != null)
            out = prev.getPath() + "-" + prev.links.get(this) + "->" + out;
        return out;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getLabel() {
        return label;
    }
}
