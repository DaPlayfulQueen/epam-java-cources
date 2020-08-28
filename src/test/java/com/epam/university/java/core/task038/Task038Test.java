package com.epam.university.java.core.task038;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task038Test {
    private GraphFactory factory;
    private Task038 instance;

    @Before
    public void setUp() throws Exception {
        factory = TestHelper.getInstance(GraphFactory.class);
        instance = TestHelper.getInstance(Task038.class);
    }

    @Test
    public void getShortestPath() {
        Graph sourceGraph = factory.newInstance(5);
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
        Path path1 = new Path(instance.getShortestPath(sourceGraph, 0, 3));
        Path path2 = new Path(instance.getShortestPath(sourceGraph, 0, 4));
        Path path3 = new Path(instance.getShortestPath(sourceGraph, 0, 2));
        assertEquals("The path is incorrect", 10, path1.calculateDistance());
        assertEquals("The path is incorrect", 38, path2.calculateDistance());
        assertEquals("The path is incorrect", 3, path3.calculateDistance());
    }

    @Test
    public void getShortestPathNotExist() {
        Graph sourceGraph = factory.newInstance(5);
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
        Path path1 = new Path(instance.getShortestPath(sourceGraph, 3, 1));
        Path path2 = new Path(instance.getShortestPath(sourceGraph, 1, 0));
        Path path3 = new Path(instance.getShortestPath(sourceGraph, 4, 0));

        assertFalse("The path exists", path1.isExist());
        assertFalse("The path exists", path2.isExist());
        assertFalse("The path exists", path3.isExist());
    }

}