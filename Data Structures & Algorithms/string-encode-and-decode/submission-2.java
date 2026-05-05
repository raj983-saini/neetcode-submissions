
class Solution {

    // Encode: Convert List<String> to a single string using length-prefix
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decode: Convert encoded string back to List<String>
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            // find '#'
            while (str.charAt(j) != '#') j++;
            int length = Integer.parseInt(str.substring(i, j));
            j++; // skip '#'
            String word = str.substring(j, j + length);
            result.add(word);
            i = j + length;
        }
        return result;
    }
}
