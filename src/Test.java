
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int maze[][] = {
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1}
        };
        //System.out.println(Node.DFS(maze, new Node(0, 0), new Node(4, 5)));
        System.out.println(Node.BFS(maze, new Node(0, 0), new Node(4, 5)));

    }

}

class Node {
    private int row, col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Node up() {
        if (this.getRow() == 0) {
            return null;
        }
        return new Node(this.getRow() - 1, this.getCol());
    }

    public Node right() {
        return new Node(this.getRow(), this.getCol() + 1);
    }

    public Node down() {
        return new Node(this.getRow() + 1, this.getCol());
    }

    public Node left() {
        if (this.getCol() == 0) {
            return null;
        }
        return new Node(this.getRow(), this.getCol() - 1);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getRow();
        result = 31 * result + this.getCol();
        return result;
    }
    //重写hashCode方法，这里使用Effective Java中推荐的hashCode算法

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Node)) return false;
        if (obj.hashCode() != this.hashCode()) return false;
        Node p = (Node) obj;
        return (p.getCol() == this.getCol()) && (p.getRow() == this.getRow());
    }
    //重写equals方法

    public static String DFS(int maze[][], Node start, Node end) {
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        maze[start.getRow()][start.getRow()] = 2;

        Node p;

        while (!stack.isEmpty() && !stack.peek().equals(end)) {
            System.out.println(stack.peek().getRow() + " " + stack.peek().getCol());
            if (((p = stack.peek().up()) != null) && maze[p.getRow()][p.getCol()] == 0) {
                maze[p.getRow()][p.getCol()] = 2;
                stack.push(p);
                System.out.println("up");
                continue;
            }

            p = stack.peek().down();
            if ((p.getRow() < maze.length) && maze[p.getRow()][p.getCol()] == 0) {
                maze[p.getRow()][p.getCol()] = 2;
                stack.push(p);
                System.out.println("down");
                continue;
            }

            if (((p = stack.peek().left()) != null) && maze[p.getRow()][p.getCol()] == 0) {
                maze[p.getRow()][p.getCol()] = 2;
                stack.push(p);
                System.out.println("left");
                continue;
            }

            p = stack.peek().right();
            if ((p.getCol() < maze[0].length) && maze[p.getRow()][p.getCol()] == 0) {
                maze[p.getRow()][p.getCol()] = 2;
                stack.push(p);
                System.out.println("right");
                continue;
            }

            stack.pop();
            System.out.println("back");
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {

            p = stack.pop();
            str.insert(0, "(" + p.getRow() + ")" + " " + "(" + p.getCol() + ")" + "->");
        }
        //将栈中元素出栈并标记为3（即最终路线）


        return str.toString();
    }

    public static String BFS(int[][] maze, Node start, Node end) {
        Node[][] mark = new Node[maze.length][maze[0].length];
        Queue<Node> queue = new LinkedList<Node>();

        //起点的前驱先指向自己，入队
        mark[start.getRow()][start.getCol()] = start;
        queue.offer(start);

        while (!queue.isEmpty()) {      //一次广度优先遍历
            Node p = queue.poll();

            Node n = p.up();
            if (n != null && maze[n.getRow()][n.getCol()] == 0 && mark[n.getRow()][n.getCol()] == null) {
                mark[n.getRow()][n.getCol()] = p;
                if (n.equals(end)) {
                    break;
                }
                queue.offer(n);
            }

            n = p.down();
            if ((n.getRow() < maze.length) && maze[n.getRow()][n.getCol()] == 0 && mark[n.getRow()][n.getCol()] == null) {
                mark[n.getRow()][n.getCol()] = p;
                if (n.equals(end)) {
                    break;
                }
                queue.offer(n);
            }

            n = p.left();
            if ((n != null) && maze[n.getRow()][n.getCol()] == 0 && mark[n.getRow()][n.getCol()] == null) {
                mark[n.getRow()][n.getCol()] = p;
                if (n.equals(end)) {
                    break;
                }
                queue.offer(n);
            }

            n = p.right();
            if ((n.getCol() < maze[0].length) && maze[n.getRow()][n.getCol()] == 0 && mark[n.getRow()][n.getCol()] == null) {
                mark[n.getRow()][n.getCol()] = p;
                if (n.equals(end)) {
                    break;
                }
                queue.offer(n);
            }
        }

        Node p = end;

        StringBuilder string = new StringBuilder();
        while (p != start) {
            //maze[p.getRow()][p.getCol()] = 3;
            string.insert(0, "(" + p.getRow() + ")" + " " + "(" + p.getCol() + ")" + "->");
            p = mark[p.getRow()][p.getCol()];
        }
        //maze[p.getRow()][p.getCol()] = 3;
        string.insert(0, "(" + p.getRow() + ")" + " " + "(" + p.getCol() + ")" + "->");

        return string.toString();
    }


}