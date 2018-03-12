public class MainMethod {
    public static void main(String[] args){
        NumberTree nt = new NumberTree();
        /*
        nt.insertTreeRec(new NumberNode(7));
        nt.insertTreeRec(new NumberNode(11));
        nt.insertTreeRec(new NumberNode(8));
        nt.insertTreeRec(new NumberNode(1));
        nt.insertTreeRec(new NumberNode(5));
        nt.insertTreeRec(new NumberNode(3));
        nt.insertTreeRec(new NumberNode(6));
        nt.insertTreeRec(new NumberNode(9));
        nt.insertTreeRec(new NumberNode(4));
        nt.insertTreeRec(new NumberNode(-1));
        */
        nt.insertTreeRec(new NumberNode(7));
        nt.insertTreeRec(new NumberNode(9));
        nt.insertTreeRec(new NumberNode(5));
        nt.insertTreeRec(new NumberNode(3));
        nt.insertTreeRec(new NumberNode(4));
        nt.insertTreeRec(new NumberNode(10));
        nt.insertTreeRec(new NumberNode(8));



        /*nt.displayTree();
        nt.removeNode(new NumberNode(-1));
        System.out.println();
        */
        nt.displayTree();
        nt.deleteTree(new NumberNode(9));
        System.out.println();
        nt.displayTree();
        /*
        nt.removeNode(new NumberNode(7));
        System.out.println();
        nt.displayTree();
        */
        /*
        nt.insertTreeRec(new NumberNode(7));
        nt.insertTreeRec(new NumberNode(1));
        nt.insertTreeRec(new NumberNode(2));

        nt.displayTree();
        nt.removeNode(new NumberNode(2));
        System.out.println();
        nt.displayTree();
        */
    }
}