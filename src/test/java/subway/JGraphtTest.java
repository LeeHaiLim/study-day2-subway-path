package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;
import subway.domain.Station;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        for (String station : shortestPath) {
            System.out.println(station);
        }
        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    void getDijkstraShortestPath_ObjectTest() {
        Station station1 = new Station("11역");
        Station station2 = new Station("22역");
        Station station3 = new Station("33역");

        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex(station1);
        graph.addVertex(station2);
        graph.addVertex(station3);
        graph.addVertex(station1);

        graph.setEdgeWeight(graph.addEdge(station1, station2), 2);
        graph.setEdgeWeight(graph.addEdge(station2, station3), 2);
        graph.setEdgeWeight(graph.addEdge(station1, station3), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<Station> shortestPath = dijkstraShortestPath.getPath(station1, station3).getVertexList();

        assertThat(shortestPath.size()).isEqualTo(3);
    }
}
