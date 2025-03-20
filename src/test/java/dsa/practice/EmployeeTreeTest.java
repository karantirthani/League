package dsa.practice;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EmployeeTreeTest {
    EmployeeTree employeeTree;

    @Before
    public void setUp() throws Exception {
        employeeTree = new EmployeeTree();
    }

    @Test
    public void removeNonEngineers() {
        CustomNode root = new CustomNode("E1");
        root.isEngineer = true;
        CustomNode e2 = new CustomNode("E2");
        e2.isEngineer = true;
        CustomNode e4 = new CustomNode("E4");
        e4.isEngineer = true;
        CustomNode ne2 = new CustomNode("NE2");
        e2.reportees = Arrays.asList(e4, ne2);
        CustomNode ne1 = new CustomNode("NE1");
        CustomNode e5 = new CustomNode("E5");
        e5.isEngineer = true;
        ne1.reportees = Arrays.asList(e5);
        CustomNode e3 = new CustomNode("E3");
        e3.isEngineer = true;
        root.reportees = Arrays.asList(e2, ne1, e3);
        employeeTree.traversal(root);
        CustomNode newRoot = employeeTree.removeNonEngineers(root);
        System.out.println();
        employeeTree.traversal(newRoot);
    }
}