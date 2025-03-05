class Solution {
    static class Pair{
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList); // For searching in O(1)
        Queue<Pair> q = new LinkedList<>();
        int levelCount = 1;

         // No end word = no transformation required
         if(!hs.contains(endWord)) {
            return 0;
        }

        q.offer(new Pair(beginWord, levelCount));
        hs.remove(beginWord);

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String w = p.word;
            levelCount = p.level;

            if(w.equals(endWord)) return levelCount; // Early return
            
            for(int i = 0; i < w.length(); i++){
                char[] wordArr = w.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    wordArr[i] = c;
                    String newWord = new String(wordArr);
                    if(hs.contains(newWord)) {
                        hs.remove(newWord);
                        q.offer(new Pair(newWord, levelCount + 1));
                    }
                }
            }
        }

      return 0;
    }
}