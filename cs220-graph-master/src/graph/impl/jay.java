package graph.impl;
//class for Dijkstra's part in Graph.
import java.nio.file.Path;

public class jay implements Comparable<Path> {
    private String lilG;
    private int ash;

    public jay(String lilG, int ash){
        this.lilG = lilG;
        this.ash = ash;
    }

    public int compareTo(Path o){
        return this.ash-o.getNameCount();
    }
    public String toString(){
        return this.lilG+"with cost "+this.ash;
    }

    public String getDest(){
        return lilG;
    }

    public Integer cost() {
        return ash;
    }
}
