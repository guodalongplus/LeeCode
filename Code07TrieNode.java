import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//构造TrideNode
class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}

class Code7TrideNode {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {

        // 构造Trie树 在查找单词前先判断是否存在该单词的前缀,再决定是否回溯,可以提高算法效率
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;  // store words in Trie
        }

        this._board = board;
        // 从二维数组的第一个位置出发
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    //进入迭代前判断是否该位置在 Trie中存在
                    backtracking(row, col, root);
                }
            }
        }

        return this._result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
//        this._board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
                    || newCol >= this._board[0].length) {
                continue;
            }
            //进入迭代前判断是否移动后的位置在 Trie中存在
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
    //当该点为叶子是在树中减去,这条路径就是个单词了,不算前缀就不用比较
        this._board[row][col] = letter;
        if (currNode.children.isEmpty()) {//isEmpty() 如果HashMap中没有键值对或映射，则该方法返回True，否则返回False。
            parent.children.remove(letter);
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'c', 'a', 'r', 'a'},
                        {'S', 't', 'g', 'b'},
                        {'a', 'c', 'o', 'd'}
                };
        String[] s={"cat","dog","abc"};

        Code7TrideNode code=new Code7TrideNode();
        List<String>an=code.findWords(board,s);
        System.out.println(an);

    }
}
