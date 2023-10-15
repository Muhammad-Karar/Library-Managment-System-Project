
import javax.swing.table.DefaultTableModel;

public class LinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void delete(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;
        Node<T> prevNode = null;

        while (currentNode != null && !currentNode.data.equals(data)) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return;
        }

        prevNode.next = currentNode.next;
    }

    public boolean contains(T data) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void display() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }
    
    public Node<T> getHead(){
    return head;
    }
    
    
    public void addRowToObjectArray(DefaultTableModel model) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            T currentData = currentNode.data;
            // Extract the required fields from currentData and populate the row array
            if (currentData instanceof User) {
                User user = (User) currentData;
                if(!user.getName().equals("admin"))
                {Object[] row = {user.getName(), user.getEmail(), user.getGender(),user.getPassword()};
                model.addRow(row);
            }
            }
            else if (currentData instanceof Book) {
                Book book = (Book) currentData;
                Object[] row = {book.getISBN(),book.getTitle(),book.getAuthor()};
                model.addRow(row);
            }
            currentNode = currentNode.next;
        }
    }

}
