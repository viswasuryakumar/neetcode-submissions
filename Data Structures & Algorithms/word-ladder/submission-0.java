class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // endWord must be reachable

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord); // avoid revisiting; treat as "visited"

        int level = 1; // beginWord itself counts as the first word in the sequence

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;

                char[] chars = word.toCharArray();
                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[pos] = c;
                        String candidate = new String(chars);
                        if (wordSet.contains(candidate)) {
                            wordSet.remove(candidate); // mark visited immediately
                            queue.offer(candidate);
                        }
                    }
                    chars[pos] = original; // restore before trying next position
                }
            }
            level++;
        }

        return 0; // endWord never reached
    }
}