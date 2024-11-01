import java.io.*;

public class nicknames {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio(System.in, System.out);
        while (io.hasMoreTokens()){
            avlTree AVL = new avlTree();
            int names = io.getInt();
            for (int i = 0; i < names; i++){
                String name = io.getWord();
                AVL.root = AVL.insert(AVL.root, name);
            }
            int nicknames = io.getInt();
            for (int i = 0; i < nicknames; i++){
                String nickname = io.getWord();
                int count = AVL.find(nickname);
                io.write(count + "\n");
            }
            io.close();
        }
    }
}

class vertex {
        public vertex parent;
        public vertex right;
        public vertex left;
        public String key;
        public int height = 1;
        public int size;
        public int count = 1;

        public vertex(String key) {
        this.parent = null;
        this.right = null;
        this.left = null;
        this.key = key;
        this.size = 1;
        }
}

class avlTree {
    vertex root;
    public vertex insert(vertex T, String key) {
        if (T == null) return new vertex(key);
        if (T.key.compareTo(key) < 0) {
            T.right = insert(T.right, key);
            if (T.right != null) {
                T.right.parent = T;
            }
        } else if (T.key.compareTo(key) > 0) {
            T.left = insert(T.left, key);
            if (T.left != null) {
                T.left.parent = T;
            }
        } else {
            T.count++;
            return T;
        }
        T.height = 1 + Math.max(height(T.left), height(T.right));
        T.size = T.count + size(T.left) + size(T.right);

        int balance = balanceFactor(T);

        if (balance > 1) {
            if (balanceFactor(T) < 0) {
                T.left = rotateLeft(T.left);
            }
            return rotateRight(T);
        }

        if (balance < -1) {
            if (balanceFactor(T) > 0) {
                T.right = rotateRight(T.right);
            }
            return rotateLeft(T);
        }

        return T;
    }

    public int balanceFactor(vertex T) {
        return T == null ? 0 : height(T.left) - height(T.right);
    }

    public int height(vertex T) {
        return T == null ? -1 : T.height;
    }

    public int size(vertex T) {
        return T == null ? 0: T.size;
    }

    public vertex rotateLeft(vertex T) {
        vertex node = T.right;
        T.right = node.left;
        if (node.left != null) {
            node.left.parent = T;
        }
        node.left = T;
        node.parent = T.parent;
        T.parent = node;
        T.height = 1 + Math.max(height(T.left), height(T.right));
        T.size = 1 + size(T.left) + size(T.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public vertex rotateRight(vertex T) {
        vertex node = T.left;
        T.left = node.right;
        if (node.right != null) {
            node.right.parent = T;
        }
        node.right = T;
        node.parent = T.parent;
        T.parent = node;
        T.height = 1 + Math.max(height(T.left), height(T.right));
        T.size = 1 + size(T.left) + size(T.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public int find(String prefix) {
        char nextChar = (char) (prefix.charAt(prefix.length() - 1) + 1);
        String nextPrefix = prefix.substring(0, prefix.length() - 1) + nextChar;
        int prefixRank = calculateRank(root, prefix);
        int nextPrefixRank = calculateRank(root, nextPrefix);
        return nextPrefixRank - prefixRank;
    }

    public int calculateRank(vertex T, String key) {
        int rankValue = 0;

        while (T != null) {
            int compare = key.compareTo(T.key);

            if (compare < 0) {
                T = T.left;
            } else if (compare > 0) {
                rankValue += size(T.left) + T.count;
                T = T.right;
            } else {
                rankValue += size(T.left);
                break;
            }
        }
        return rankValue;
    }
}