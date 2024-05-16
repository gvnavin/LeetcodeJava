import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
// not working, few test cases passing
public class TopView {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> topView(Node root) {
        Map<Integer, Integer> levelToValueMap = new TreeMap<>();
        recur(root, levelToValueMap, 0);

        System.out.println(levelToValueMap);

        ArrayList<Integer> ret = new ArrayList<>();
        for (int value : levelToValueMap.values()) {
            ret.add(value);
        }
        
        return ret;
    }

    void recur(Node root, Map<Integer, Integer> levelToValueMap, int level) {
        if (root == null) {
            return;
        }

        levelToValueMap.putIfAbsent(level, root.data);
        recur(root.left, levelToValueMap, level - 1);
        recur(root.right, levelToValueMap, level + 1);
    }
}
