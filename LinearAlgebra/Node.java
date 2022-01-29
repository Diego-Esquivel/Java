public class Node {
    private String key;
    private Node next;
    private Node right;
    
        Node ( ) {
            next = null;
            right = null;
        }
        Node ( String data ) {
            key = data;
            next = null;
            right = null;
        }

        void setData ( String data ) {
            key = data;
        }
        void setNext ( String data ) {
            next = new Node ( data );
        }
        void setRight ( String data ) {
            right = new Node ( data );
        }

        String getData ( ) {
            return key;
        }
        Node getNext (  ) {
            return next;
        }
        Node getRight (  ) {
            return right;
        }
}