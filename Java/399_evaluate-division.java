
class Solution {
    record Edge(String neighbor, double weight ){} // worry about this later.

    // componentId: is the "id" of the component that this node belongs to
    // coefficient: coefficient of this node within its component 
    record NodeData(String componentId, double coeff) {} // coefficient of this node within its component 

    private Map<String, List<Edge>> constructGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        Function<String , List<Edge>> emptyLsitSupplier  = _queryKey -> new ArrayList<>();
        for(int i = 0; i < equations.size(); ++i) {
            String top = equations.get(i).get(0);
            String bottom = equations.get(i).get(1);
            double value = values[i]; // if this makes your life easier
            graph.computeIfAbsent(top, emptyLsitSupplier ).add(new Edge(bottom, value));
            graph.computeIfAbsent(bottom, emptyLsitSupplier ).add(new Edge(top, 1.0/value));
        }
        return graph;
    }

    private void traverseComponent(Map<String, List<Edge>> graph,
                                   Map<String, NodeData> nodeData,
                                   String componentLabel, // componentId
                                   String currentNode,
                                   double coefficient) {
        // acts as "visited" && saves the actual NodeData
        nodeData.put(currentNode, new NodeData(componentLabel, coefficient));
        for (Edge edge : graph.get(currentNode)) {
            String neighbor = edge.neighbor();
            if (!nodeData.containsKey(neighbor)) {
                traverseComponent(graph,
                                  nodeData,
                                  componentLabel,
                                  neighbor,
                                  coefficient * edge.weight());
            }
        }
    }

    private Map<String, NodeData> analyseGraph(Map<String, List<Edge>> graph) {
        Map<String, NodeData> nodeData = new HashMap<>();
        
        for(String node : graph.keySet()) {
            if (!nodeData.containsKey(node)) {
                traverseComponent(graph, nodeData, node, node, 1);
            }
        }
        return nodeData;
    }

    private double evaluateQuery(Map<String, NodeData> components, String topNode, String bottomNode) {
        if(!components.containsKey(topNode) || !components.containsKey(bottomNode)){
            return -1;
        }
        NodeData topData = components.get(topNode);
        NodeData bottomData = components.get(bottomNode);
        if( !topData.componentId().equals(bottomData.componentId()) ){
            return -1;
        }
        return  bottomData.coeff() / topData.coeff() ;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = constructGraph(equations, values);
        Map<String, NodeData> components = analyseGraph(graph);

        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); ++i) {
            results[i] = evaluateQuery(components, queries.get(i).get(0), queries.get(i).get(1));
        }
        return results;
    }
}

/*

{
    a=[Edge[neighbor=b, weight=2.0]],
    b=[
        Edge[neighbor=a, weight=0.5],
        Edge[neighbor=c, weight=3.0]
    ],
    c=[Edge[neighbor=b, weight=0.3333333333333333]]
}


 */