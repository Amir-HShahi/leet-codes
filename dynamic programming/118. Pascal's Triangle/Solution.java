import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        for (int length = 1; length <= numRows; length++) {
            Integer[] row = new Integer[length];
            row[0] = 1;
            row[length - 1] = 1;
            for (int i = 1; i < row.length - 1; i++) {
                List<Integer> prevRow = rows.get(length - 2); // one for index, one for prev length
                row[i] = prevRow.get(i) + prevRow.get(i - 1);
            }
            rows.add(Arrays.asList(row));
        }
        return rows;
    }
}