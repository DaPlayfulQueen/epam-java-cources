package com.epam.university.java.core.task038;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Task038Test {
    private GraphFactory factory;
    private Task038 instance;

    @Before
    public void setUp() throws Exception {
        factory = TestHelper.getInstance(GraphFactory.class);
        instance = TestHelper.getInstance(Task038.class);
    }

    @Test
    public void getShortestPath1() {
        Graph sourceGraph = factory.newInstance();
        sourceGraph = instance.invokeActions(sourceGraph, Arrays.asList(
                g -> g.createNode(0, 1, 1),
                g -> g.createNode(1, 2, 5),
                g -> g.createNode(2, 3, 4),
                g -> g.createNode(3, 8, 8),
                g -> g.createNode(4, 0, 39),
                g -> g.connectNodes(0, 1),
                g -> g.connectNodes(0, 2),
                g -> g.connectNodes(0, 4),
                g -> g.connectNodes(2, 3),
                g -> g.connectNodes(1, 4),
                g -> g.connectNodes(3, 4)
        ));
        Path path = new Path(instance.getShortestPath(sourceGraph, 0, 4));
        assertEquals("There path is incorrect", path.calculateDistance(), 10);
    }

    @Test
    public void getShortestPath2() {
        Graph sourceGraph = factory.newInstance();
        sourceGraph = instance.invokeActions(sourceGraph, Arrays.asList(
                g -> g.createNode(0, 1, 1),
                g -> g.createNode(1, 2, 5),
                g -> g.createNode(2, 8, 8),
                g -> g.createNode(3, 0, 39),
                g -> g.connectNodes(0, 1),
                g -> g.connectNodes(0, 3),
                g -> g.connectNodes(2, 3),
                g -> g.connectNodes(1, 3)
        ));
        Path path = new Path(instance.getShortestPath(sourceGraph, 0, 4));
        assertEquals("There path is incorrect", path.calculateDistance(), 39);
    }

    @Test
    public void getPathNotExists1() {
        Graph sourceGraph = factory.newInstance();
        sourceGraph = instance.invokeActions(sourceGraph, Arrays.asList(
                g -> g.createNode(0, 1, 1),
                g -> g.createNode(1, 2, 5),
                g -> g.createNode(2, 8, 8),
                g -> g.createNode(3, 0, 39),
                g -> g.connectNodes(0, 1),
                g -> g.connectNodes(0, 3),
                g -> g.connectNodes(2, 3),
                g -> g.connectNodes(1, 3)
        ));
        Path path = new Path(instance.getShortestPath(sourceGraph, 3, 1));
        assertFalse("The path exists", path.isExist());
    }

    @Test
    public void getPathNotExists2() {
        Graph sourceGraph = factory.newInstance();
        sourceGraph = instance.invokeActions(sourceGraph, Arrays.asList(
                g -> g.createNode(0, 1, 1),
                g -> g.createNode(1, 2, 5),
                g -> g.createNode(2, 8, 8),
                g -> g.createNode(3, 0, 39),
                g -> g.createNode(4, 7, 12),
                g -> g.createNode(5, 7, 16),
                g -> g.connectNodes(0, 1),
                g -> g.connectNodes(0, 3),
                g -> g.connectNodes(2, 3),
                g -> g.connectNodes(1, 3),
                g -> g.connectNodes(1, 4),
                g -> g.connectNodes(4, 5)
        ));
        Path path = new Path(instance.getShortestPath(sourceGraph, 4, 2));
        assertFalse("The path exists", path.isExist());
    }


}