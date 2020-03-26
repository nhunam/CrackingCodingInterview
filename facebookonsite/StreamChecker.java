package facebookonsite;
class StreamChecker {
    
    class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    public void query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
        //for (int i = 0; i < sb.length() && node != null; i++) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord) {
                System.out.println(sb.substring(i, sb.length()).toString());
            }
        }
    }

    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
            //for (int i= 0; i < len ; i++) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
    
    public static void main(String[] args) {
    	String[] words = {"dog", "cat", "at"};
    	StreamChecker sc = new StreamChecker(words);
    	//sc.query('d');
    	//sc.query('o');
    	//sc.query('a');
    	//sc.query('g');
    	sc.query('c');
    	sc.query('a');
    	sc.query('t');
    }
}