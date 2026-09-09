class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }
        int currRow = 0;
        int direction = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rows[currRow] = rows[currRow] + c;
            if (currRow == 0) {
                direction = 1;
            } else if (currRow == numRows - 1) {
                direction = -1;
            }
            currRow = currRow + direction;
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result = result + rows[i];
        }
        return result;
    }
}
