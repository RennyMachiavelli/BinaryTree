public class NumberTree {
    private NumberNode root;

    public NumberTree() {
        root = null;
    }

    public void insertTreeRep(NumberNode numberNode) {
        boolean finished = false;
        if(root == null)
            root = numberNode;
        else {
            NumberNode currentNode = root;
            while (!finished) {
                if (currentNode.getNumber() < numberNode.getNumber())
                    if(currentNode.getLeft() == null) {
                        currentNode.setLeft(numberNode);
                        finished = true;
                    }
                    else
                        currentNode = currentNode.getLeft();
                else if(currentNode.getRight() == null){
                    currentNode.setRight(numberNode);
                    finished = true;
                }
                else
                    currentNode = currentNode.getRight();
            }
        }
    }

    public void insertTreeRec(NumberNode numberNode) {
        insertNode(root, numberNode);
    }

    public void insertNode(NumberNode currentNode, NumberNode numberNode) {
        if(currentNode == null)
            root = numberNode;
        else if(numberNode.getNumber() < currentNode.getNumber() ) {
            if(currentNode.getLeft() == null){
                currentNode.setLeft(numberNode);
            }
            else
                insertNode(currentNode.getLeft(), numberNode);
        }
        else
            if(currentNode.getRight() == null)
                currentNode.setRight(numberNode);
            else
                insertNode(currentNode.getRight(),numberNode);
    }

    public void displayTree() {
        displayNode(root);
    }

    public void displayNode(NumberNode currentNode) {
        if(currentNode == null)
            System.out.println("The tree is empty");
        else {
            if (currentNode.getLeft() != null)
                displayNode(currentNode.getLeft());

            System.out.print(currentNode.getNumber() + "->");

            if(currentNode.getRight() != null)
                displayNode(currentNode.getRight());
        }
    }
    public void removeNode(NumberNode numberNode) {
        traverseTree(root, numberNode);
    }
    public void traverseTree(NumberNode currentNode, NumberNode numberNode) {
        if(currentNode == null) {
            System.out.println("Tree is empty.");
        }
        else {
            if (currentNode.getNumber() > numberNode.getNumber()) {
                //go left
                if (currentNode.getLeft().getNumber() != numberNode.getNumber())
                    traverseTree(currentNode.getLeft(), numberNode);
                else {
                    //leaf node
                    if (currentNode.getLeft().getLeft() == null && currentNode.getLeft().getRight() == null)
                        currentNode.setLeft(null);
                        //node with child on left only
                    else if (currentNode.getLeft().getLeft() != null && currentNode.getLeft().getRight() == null)
                        currentNode.setLeft(currentNode.getLeft().getLeft());
                        //node with child on right only
                    else if (currentNode.getLeft().getLeft() == null && currentNode.getLeft().getRight() != null)
                        currentNode.setLeft(currentNode.getLeft().getRight());
                }
            }
            else if (currentNode.getNumber() < numberNode.getNumber()) {
                //go right
                if (currentNode.getRight().getNumber() != numberNode.getNumber())
                    traverseTree(currentNode.getRight(), numberNode);
                else {
                    //leaf node
                    if (currentNode.getRight().getLeft() == null && currentNode.getRight().getRight() == null)
                        currentNode.setRight(null);
                        //node with child on left only
                    else if (currentNode.getRight().getLeft() != null && currentNode.getRight().getRight() == null)
                        currentNode.setRight(currentNode.getRight().getLeft());
                        //node with child on right only
                    else if (currentNode.getRight().getLeft() == null && currentNode.getRight().getRight() != null)
                        currentNode.setRight(currentNode.getRight().getRight());
                }
            }
            else if (currentNode.getNumber() == numberNode.getNumber()) {
                if (currentNode.getLeft() == null && currentNode.getRight() == null)
                    traverseTree(null, numberNode);
                else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
                    currentNode.setNumber(currentNode.getLeft().getNumber());
                    currentNode.setLeft(null);
                }
                else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                    currentNode.setNumber(currentNode.getRight().getNumber());
                    currentNode.setRight(null);
                }
                else if (currentNode.getLeft() != null && currentNode.getRight() != null) {
                    currentNode.setNumber(currentNode.getLeft().getNumber());
                    currentNode.setLeft(null);
                }
            }
        }
    }
}
