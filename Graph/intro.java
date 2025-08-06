public class intro {
    int adjMatrix[][];

    Graph(int nodes){
        adjMatrix = new int[nodes][nodes];// 4*4 with value 0

    }
    public void addEdgeInMatrix(int edges[][]){
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            //directed
            if(isDirected){
                adjMatrix[u][v] = 1;
            }else{
                 //undirected
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;

            }
            
           
        }
    }
}
