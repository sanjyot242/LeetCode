class Pair{
    String word ;
    int step ;

    Pair(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }

        q.add(new Pair(beginWord,1));;
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().word;
            int step = q.peek().step;
            q.remove();

            if(word.equals(endWord)) return step;

            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String replacedWord = new String(wordArray);

                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord,step+1));
                    }
                }
            }
        }
return 0;
    }
}