package depthfirst;

/**
 *
 * @author niall o connor
 */
import java.util.*;
 
public class DepthFirst
{
    private final int vertices; // number of vertices
 
    // Represents the tree of nodes
    private final LinkedList<Integer> adj[];
 
    DepthFirst(int v)
    {
        // add a new list with number of vertices as adjacent LinkedLists
        vertices = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // add an edge to the correct node
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
 
    // A utility function that traverses the tree
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
 
        // Recursively visit all nodes adjacent
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS()
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[vertices];
 
        // For all vertices traverse to the bottom and visit all nodes before coming back up and traversing next branch
        for (int i=0; i<vertices; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }
 
    public static void main(String args[])
    {
        DepthFirst g = new DepthFirst(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal");
 
        g.DFS(); // 0 1 2 3
    }
}
