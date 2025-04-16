import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        for (int length = 1; length <= numRows; length++) {
            rows.add(generateRow(length));
        }
        return rows;
    }

    private List<Integer> generateRow(int rowNum) {
        List<Integer> row = new ArrayList<Integer>(rowNum);
        row.add(1);
        int prevValue = 1;
        for (int i = 1; i < rowNum; i++) {
            prevValue = prevValue * (rowNum - i);
            prevValue = prevValue / i;
            row.add(prevValue);
        }
        return row;
    }
}
