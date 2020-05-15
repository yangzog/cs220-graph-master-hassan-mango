package graph.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.util.function.Consumer;

import graph.IGraph;
import graph.INode;
import graph.NodeVisitor;

/**
 * A basic representation of a graph that can perform BFS, DFS, Dijkstra,
 * and Prim-Jarnik's algorithm for a minimum spanning tree.
 * 
 * @author jspacco
 *
 */
public class Graph implements IGraph, graphproject {

    private Map<String, INode> newGraph;
    private Collection<INode> values;
    private Set<INode> newNeighbours;

    public Graph() {
        newGraph = new HashMap<String, INode>()
        ;
    }

    /**
     * Return the {@link Node} with the given name.
     * <p>
     * If no {@link Node} with the given name exists, create
     * a new node with the given name and return it. Subsequent
     * calls to this method with the same name should
     * then return the node just created.
     *
     * @param name
     * @return
     */
    public INode getOrCreateNode(String name) {

        if (newGraph.containsKey(name)) {
            return newGraph.get(name);
        } else {
            INode temp;
            temp = new Node(name);
            newGraph.put(name, temp);
            return newGraph.get(name);

            //Should I have kept this or not? throw new UnsupportedOperationException("Implement this method");
        }
    }

    /**
     * Return true if the graph contains a node with the given name,
     * and false otherwise.
     *
     * @param name
     * @return
     */
    public boolean containsNode(String name) {
        //throw new UnsupportedOperationException("Implement this method");
        return newGraph.containsKey(name);

    }

    /**
     * Return a collection of all of the nodes in the graph.
     *
     * @return
     */
    public Collection<INode> getAllNodes() {
        values = newGraph.values();
        return values;
        //throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Perform a breadth-first search on the graph, starting at the node
     * with the given name. The visit method of the {@link NodeVisitor} should
     * be called on each node the first time we visit the node.
     *
     * @param startNodeName
     * @param v
     */
    public void breadthFirstSearch(String startNodeName, NodeVisitor v) {
        Set<INode> destination = new HashSet<INode>();  //throw new UnsupportedOperationException("Implement this method")
        Queue<INode> toSearch = new Queue<INode>() {
            public boolean add(INode iNode) {
                return false;
            }

            @Override
            public boolean offer(INode iNode) {
                return false;
            }

            @Override
            public INode remove() {
                return null;
            }

            @Override
            public INode poll() {
                return null;
            }

            @Override
            public INode element() {
                return null;
            }

            @Override
            public INode peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<INode> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends INode> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        toSearch.add(getOrCreateNode(startNodeName));
        while (!toSearch.isEmpty()) {
            INode mango = toSearch.remove();
            if (destination.contains(mango)) {
                continue;
            }
            v.visit((mango));
            toSearch.add(mango);

            newNeighbours = (Set<INode>) mango.getNeighbors();
            Iterator<INode> iterator = newNeighbours.iterator();
            for (INode node : newNeighbours) {
                if (!destination.contains(mango)) {
                    toSearch.add(mango);
                }
            }
        }
        throw new UnsupportedOperationException("Implement this method");
    }

    /**
     * Perform a depth-first search on the graph, starting at the node
     * with the given name. The visit method of the {@link NodeVisitor} should
     * be called on each node the first time we visit the node.
     *
     * @param startNodeName
     * @param v
     */
    public void depthFirstSearch(String startNodeName, NodeVisitor v) {
        Set<INode> destination = new HashSet<INode>();  //throw new UnsupportedOperationException("Implement this method")
        Stack<INode> toSearch = new Stack<INode>();
        toSearch.add(getOrCreateNode(startNodeName));
        while (!toSearch.isEmpty()) {
            INode mango = toSearch.pop();
            if (destination.contains(mango)) {
                continue;
            }
            v.visit((mango));
            toSearch.add(mango);

            newNeighbours = (Set<INode>) mango.getNeighbors();
            for (INode node : newNeighbours) {
                if (!destination.contains(mango)) {
                    toSearch.push(mango);
                }
            }
        }

    }

    /**
     * Perform Dijkstra's algorithm for computing the cost of the shortest path
     * to every node in the graph starting at the node with the given name.
     * Return a mapping from every node in the graph to the total minimum cost of reaching
     * that node from the given start node.
     *
     * <b>Hint:</b> Creating a helper class called Path, which stores a destination
     * (String) and a cost (Integer), and making it implement Comparable, can be
     * helpful. Well, either than or repeated linear scans.
     *
     * @param //startName
     * @return
     */

    public FileSystem getFileSystem() {
        return null;
    }


    public boolean isAbsolute() {
        return false;
    }


    public Path getRoot() {
        return null;
    }


    public Path getFileName() {
        return null;
    }


    public Path getParent() {
        return null;
    }


    public int getNameCount() {
        return 0;
    }

    public Path getName(int index) {
        return null;
    }


    public Path subpath(int beginIndex, int endIndex) {
        return null;
    }


    public boolean startsWith(Path other) {
        return false;
    }


    public boolean startsWith(String other) {
        return false;
    }


    public boolean endsWith(Path other) {
        return false;
    }


    public boolean endsWith(String other) {
        return false;
    }


    public Path normalize() {
        return null;
    }


    public Path resolve(Path other) {
        return null;
    }


    public Path resolve(String other) {
        return null;
    }


    public Path resolveSibling(Path other) {
        return null;
    }


    public Path resolveSibling(String other) {
        return null;
    }


    public Path relativize(Path other) {
        return null;
    }


    public URI toUri() {
        return null;
    }


    public Path toAbsolutePath() {
        return null;
    }


    public Path toRealPath(LinkOption... options) throws IOException {
        return null;
    }

    public File toFile() {
        return null;
    }


    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return null;
    }

    public WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return null;
    }

    public Iterator<Path> iterator() {
        return null;
    }


    public void forEach(Consumer<? super Path> action) {

    }


    public Spliterator<Path> spliterator() {
        return null;
    }

    public int compareTo(Path other) {
        return 0;
    }


    public boolean equals(Object other) {
        return false;
    }


    public int hashCode() {
        return 0;
    }


    public Map<INode, Integer> dijkstra(String startName) {

        Map map = new HashMap<INode, Integer>();
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(startName);
        while (map.size() < newGraph.size()) {
            Path next = (Path) priorityQueue.poll();
            //retreiving the element
            Path nextone = next.getFileName();
            //getting and setting the element to a string so it can be represented.
            String toString = nextone.toString();

            INode node1 = getOrCreateNode(toString);
            if (map.containsKey(node1)) {
                continue;
            }
            int index = next.getNameCount();
            map.put(node1, index);

            newNeighbours = (Set<INode>) node1.getNeighbors();


            for (INode gelato : newNeighbours)
                priorityQueue.add(new jay(gelato.getName(), index + node1.getWeight(gelato)));

        }

                return map;

    }



    /**
     * Perform Prim-Jarnik's algorithm to compute a Minimum Spanning Tree (MST).
     * 
     * The MST is itself a graph containing the same nodes and a subset of the edges 
     * from the original graph.
     * 
     * @return
     */
    public IGraph primJarnik(){
        return null;
        //throw new UnsupportedOperationException();
    }
}