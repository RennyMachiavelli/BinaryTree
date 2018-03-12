public class NumberTree {
    private NumberNode root;

    public NumberTree() {
        root = null;
    }

    public void insertTreeRep(NumberNode numberNode) {
        boolean finished = false;
        if (root == null)
            root = numberNode;
        else {
            NumberNode currentNode = root;
            while (!finished) {
                if (currentNode.getNumber() < numberNode.getNumber())
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(numberNode);
                        finished = true;
                    } else
                        currentNode = currentNode.getLeft();
                else if (currentNode.getRight() == null) {
                    currentNode.setRight(numberNode);
                    finished = true;
                } else
                    currentNode = currentNode.getRight();
            }
        }
    }

    public void insertTreeRec(NumberNode numberNode) {
        insertNode(root, numberNode);
    }

    public void insertNode(NumberNode currentNode, NumberNode numberNode) {
        if (currentNode == null)
            root = numberNode;
        else {
            if (numberNode.getNumber() < currentNode.getNumber()) {
                if (currentNode.getLeft() == null)
                    currentNode.setLeft(numberNode);
                else
                    insertNode(currentNode.getLeft(), numberNode);
            } else if (currentNode.getRight() == null)
                currentNode.setRight(numberNode);
            else
                insertNode(currentNode.getRight(), numberNode);
        }
    }

    public void displayTree() {
        displayNode(root);
    }

    public void displayNode(NumberNode currentNode) {
        if (currentNode == null)
            System.out.println("The tree is empty");
        else {
            if (currentNode.getLeft() != null)
                displayNode(currentNode.getLeft());

            System.out.print(currentNode.getNumber() + "->");

            if (currentNode.getRight() != null)
                displayNode(currentNode.getRight());
        }
    }

    public void deleteTree(NumberNode numberNode) {
        root = deleteNode(root, numberNode);
    }

    public NumberNode deleteNode(NumberNode currentNode, NumberNode numberNode) {
        if (currentNode == null)
            return (currentNode);

        if (currentNode.getNumber() < numberNode.getNumber())
            currentNode.setRight(deleteNode(currentNode.getRight(), numberNode));
        else if (currentNode.getNumber() > numberNode.getNumber())
            currentNode.setLeft(deleteNode(currentNode.getLeft(), numberNode));
        else {
            if (currentNode.getLeft() == null)
                return (currentNode.getRight());
            else if (currentNode.getRight() == null)
                return (currentNode.getLeft());

            currentNode.setNumber(minValue(currentNode.getRight()));
            currentNode.setRight((deleteNode(currentNode.getRight(), currentNode)));
        }
        return (currentNode);
    }
    public int minValue(NumberNode numberNode) {
        while(numberNode.getLeft() != null){
            numberNode = numberNode.getLeft();
        }
        return(numberNode.getNumber());
    }
}
