import java.util.ArrayList;
import java.util.HashMap;

// https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// not working
public class BottomView {
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        HashMap<Integer, Integer> levelToValueMap = new HashMap<>();
        recur(root, levelToValueMap, 0);

        System.out.println(levelToValueMap);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer key : levelToValueMap.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ret.add(levelToValueMap.get(i));
        }
        return ret;
    }

    void recur(Node root, HashMap<Integer, Integer> levelToValueMap, int level) {
        if (root == null) {
            return;
        }

        levelToValueMap.put(level, root.data);
        recur(root.left, levelToValueMap, level - 1);
        recur(root.right, levelToValueMap, level + 1);
    }
}
