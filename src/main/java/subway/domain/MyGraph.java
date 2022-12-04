package subway.domain;

import java.util.List;
import org.jgrapht.graph.WeightedMultigraph;

public class MyGraph extends WeightedMultigraph<Station, Edge> {

    public MyGraph() {
        super(Edge.class);
    }

    public void addAllVertex(List<Station> stations){
        stations.forEach(this::addVertex);
    }

    public boolean addEdge(Edge edge) {
        return super.addEdge(edge.getSource(), edge.getTarget(), edge);
    }

    public void addAllEdge(List<Edge> edges) {
        edges.forEach(this::addEdge);
    }

    public void setEdgeWeightByDistance(Edge edge) {
        super.setEdgeWeight(edge, edge.getDistance());
    }

    public void setEdgeWeightByTime(Edge edge) {
        super.setEdgeWeight(edge, edge.getTime());
    }
}
