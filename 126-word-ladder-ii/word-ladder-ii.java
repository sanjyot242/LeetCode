class Solution {
    HashMap<String,Integer> map;
    List<List<String>>  ans;
    String b;

    private void dfs(String word , List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int step = map.get(word);
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] wordArray = word.toCharArray();
                wordArray[i] = ch;
                String replacedWord = new String(wordArray);
                if(map.containsKey(replacedWord) && map.get(replacedWord) +1 == step ){
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        int wordListLength = wordList.size();
        for(int i=0;i<wordListLength;i++){
            st.add(wordList.get(i));
        }
        Queue<String> q = new LinkedList<>();
        map = new HashMap<>();
        b = beginWord;
        q.add(beginWord);
        map.put(beginWord,1);
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek();
            int step = map.get(word);
            q.remove();

            if(word.equals(endWord)) break;

            for(int i=0 ; i< word.length();i++){
                for(char ch = 'a'; ch<='z';ch++){
                    char[]  wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);
                    if(st.contains(replacedWord)){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        map.put(replacedWord , step+1);
                    }
                }
            }
        }

        ans = new ArrayList<>();

        //break redirects here 
        if(map.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans ;
    }
}