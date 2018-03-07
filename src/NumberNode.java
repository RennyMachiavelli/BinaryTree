public class NumberNode {
    private int number;
    private NumberNode left;
    private NumberNode right;

    public NumberNode(int number, NumberNode left, NumberNode right) {
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public NumberNode(int number) {
        this.number = number;
        left = null;
        right = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NumberNode getRight() {
        return right;
    }

    public void setRight(NumberNode right) {
        this.right = right;
    }

    public NumberNode getLeft() {
        return left;
    }

    public void setLeft(NumberNode left) {
        this.left = left;
    }
}

