import java.util.ArrayList;
import java.util.HashMap;

public class LeftView {
    // https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        HashMap<Integer, Integer> levelToValueMap = new HashMap<>();
        recur(root, levelToValueMap, 0);
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < levelToValueMap.size(); i++) {
            ret.add(levelToValueMap.get(i));
        }
        return ret;
    }

    void recur(Node root, HashMap<Integer, Integer> levelToValueMap, int level) {
        if (root == null) {
            return;
        }

        levelToValueMap.putIfAbsent(level, root.data);
        recur(root.left, levelToValueMap, level + 1);
        recur(root.right, levelToValueMap, level + 1);
    }
}
