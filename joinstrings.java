public class joinstrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        StringNode[] strings = new StringNode[n];

        for (int i = 0; i < n; i++) {
            strings[i] = new StringNode(io.getWord());
        }

        int index = 0;

        for (int j = 0; j < n - 1; j++) {
            int a = io.getInt() - 1;
            int b = io.getInt() - 1;
            strings[a].append(strings[b]);
            index = a;
        }

        for(StringNode line = strings[index]; line != null; line = line.next) 
        System.out.print(line.s);
        
        io.close();
    }

    public static class StringNode {
        public String s;
        StringNode last = this, next;

        StringNode(String s){
            this.s = s;
        }

        void append(StringNode s){
            last.next = s;
            last = s.last;
        }
    }
}
