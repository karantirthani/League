package dsa.practice.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnionFind {
    Map<String, Double> conversions;
    Map<String, String> parent;

    public UnionFind() {
        conversions = new HashMap<>();
        parent = new HashMap<>();
    }

    String find(String a) {
        if (!parent.containsKey(a)) {
            return a;
        }
        String topParent = find(parent.get(a));
        conversions.put(a, conversions.get(a) * conversions.get(parent.get(a)));
        parent.put(a, topParent);
        return topParent;
    }

    void union(String a, String b, double x) {
        parent.put(b, a);
        conversions.put(b, x);
        conversions.putIfAbsent(a, 1.0);
    }

    double query (String from, String to) {
        if (!find(from).equals(find(to)) || !conversions.containsKey(to) || !conversions.containsKey(from) ) {
            return -1;
        }
        return conversions.get(to) / conversions.get(from);
    }
}
public class FindDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        int i=0;
        for (List<String> equation: equations) {
            uf.union(equation.get(0), equation.get(1), values[i]);
//            uf.union(equation.get(1), equation.get(0), 1/values[i]);
            i++;
        }

        double[] output = new double[queries.size()];
        i=0;
        for (List<String> query: queries) {
            output[i++] = uf.query(query.get(0), query.get(1));
        }
        return output;
    }
}
