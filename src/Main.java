import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String [] args){
        Graph graph = new Graph();
        Node genesi = new Node("sender");


        Node a= new Node("A");
        Node b= new Node("B");
        Node c= new Node("C");
        Node d= new Node("D");
        Node e= new Node("E");
        Node destruction= new Node("recipient");

        genesi.link(a,2);
        genesi.link(d,8);
        a.link(b,6);
        a.link(c,2);
        b.link(destruction,5);
        c.link(d,3);
        c.link(e,9);
        d.link(e,3);
        e.link(destruction,1);

        graph.addHop(genesi);
        graph.addHop(a);
        graph.addHop(b);
        graph.addHop(c);
        graph.addHop(d);
        graph.addHop(e);
        graph.addHop(destruction);
        graph.shortestPath(genesi);

        System.out.println("dim:"+graph.getGraph().size());
        graph.getGraph().forEach((node)->{
            System.out.println("Name: "+node.getLabel()+" Weight: "+node.getWeight()+" Path"+node.getPath());
        });

    }
}
