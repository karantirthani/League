package dsa.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CustomNode {
    String name;
    boolean isEngineer;
    List<CustomNode> reportees;
    public CustomNode(String name) {
        this.name = name;
        reportees = new ArrayList<>();
    }
}

public class EmployeeTree {
    public void traversal(CustomNode customNode) {
        if (customNode!= null) {
            System.out.print(customNode.name + " ");
            for (CustomNode reportee: customNode.reportees) {
                traversal(reportee);
            }
        }
    }
    public List<CustomNode> removeNonEngineersUtil(CustomNode node) {
        if (node == null) {
            return null;
        }
        List<CustomNode> newReportees = new ArrayList<>();
        for (CustomNode reportee: node.reportees) {
            newReportees.addAll(removeNonEngineersUtil(reportee));
        }
        if (node.isEngineer) {
            node.reportees = newReportees;
            return List.of(node);
        } else {
            return newReportees;
        }
    }

    public CustomNode removeNonEngineers(CustomNode node) {
        CustomNode newNode = new CustomNode(node.name);
        newNode.isEngineer = true;
        newNode.reportees = removeNonEngineersUtil(node);
        return newNode;
    }
}
