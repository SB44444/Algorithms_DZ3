package ru.geekbrains;


class node {
    node leftChild, rightChild;
    int value;
    boolean color;
    node(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
        color = true;
    }
}
public class red_BlackTree {

    private static node root = null; //Для доступа к рут создаем static root

    node leftSwap(node myNode) {  // Ф-ция левого поворота
        System.out.printf("leftSwap\n");
        node child = myNode.rightChild;
        node childLeft = child.leftChild;
        child.leftChild = myNode;
        myNode.rightChild = childLeft;

        return child;
    }

    node rightSwap(node myNode) { // Ф-ция правого поворота
        System.out.printf("rightSwap\n");
        node child = myNode.leftChild;
        node childRight = child.rightChild;
        child.rightChild = myNode;
        myNode.leftChild = childRight;
        return child;
    }
        boolean red_true(node myNode) { // Новый узел всегда красного цвета, проверяем условие ф-цией
        if (myNode == null) {
            return false;
        }
            if ((myNode.color == true)) return true;
            else return false;
    }


    void swapColors(node node1, node node2) { // Ф-ция смены цвета
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    node add(node myNode, int value) { // Ф-ция добавления нового эл-та и балансировки дерева

        if (myNode == null) {
            return new node(value);
        }
        if (value < myNode.value) {
            myNode.leftChild = add(myNode.leftChild, value);
        } else if (value > myNode.value) {
            myNode.rightChild = add(myNode.rightChild, value);
        } else {
            return myNode;
        }

        if (red_true(myNode.rightChild) && !red_true(myNode.leftChild)) { // rightChild красный, а leftChild черный или null
            myNode = leftSwap(myNode); // leftSwap
            swapColors(myNode, myNode.leftChild); // Сменить цвет дочернего узла на красный
        }

        if (red_true(myNode.leftChild) && red_true(myNode.leftChild.leftChild)) { // leftChild и справа на ветке ниже узлы красные
            myNode = rightSwap(myNode);
            swapColors(myNode, myNode.rightChild); // Сменить цвет дочернего узла на красный
        }

        if (red_true(myNode.leftChild) && red_true(myNode.rightChild)) { // Оба ребенка красные
            myNode.color = !myNode.color; // Сменить цвет на противоположный
            myNode.leftChild.color = false; // Изменить цвет родителя на черный
            myNode.rightChild.color = false;
        }
        return myNode;
    }
    void caseR_B(node node) { // Ф-ция маркировки узлов R - красный, B - черный
        if (node != null) {
            caseR_B(node.leftChild);
            char c = 'R';
            if (!node.color)
                c = 'B';
            System.out.print(node.value + ""+ c + " ");
            caseR_B(node.rightChild); // Рекусивный обход эл-тов
        }
    }


}