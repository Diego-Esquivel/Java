/***********************************************************************
*
*   Author: Diego G Esquivel
*   Date: 10/10/2021
*   Purpose: To get me an A on the howmework
*   Name: DoublyLinkedList.java
*   
*
*************************************************************************/
public class DoublyLinkedList {
	private Node head;
	private Node tail;
	
	public DoublyLinkedList ( ) {
		head = null;
		tail = null;
	};
	public DoublyLinkedList ( Node node ) {
		head = node;
		tail = node;
	};
	
	public boolean isEmpty ( ) {
		if ( head == null )
			return true;
		else
			return false;
	};
	
	public int size ( ) { 
		Node temp = head;
        Node rTemp = head;
		int size = 0;
		if ( head == null ) {
			return size;
		}
		else {
			while ( temp != null ) {
                while ( rTemp != null ) {
                    rTemp = rTemp.getRight();
                    size++;
                }
				temp = temp.getNext();
                rTemp = temp;
				size ++;
			}
		}
		return size;
	};
    public int length ( ) { 
		Node temp = head;
		int size = 0;
		if ( head == null ) {
			return size;
		}
		else {
			while ( temp != null ) {
				temp = temp.getNext();
				size ++;
			}
		}
		return size;
	};
	
	public void add ( String value ) {
		Node temp = head;
		if ( head == null ) {
			head = new Node ( value );
			tail = head;
		}
		else {
			temp = tail;	
			temp.setNext( value );
			tail = temp.getNext();
		}
	};

    public void insertTo ( String node, String value ) {
        Node temp = head;
        Node rTemp = head;
        if ( head == null ) {
            head = new Node ( node );
            tail = head;
            head.setRight( value );
        }
        else {
            while ( temp.getData() != node  && temp != tail) {
                temp = temp.getNext();
            }
        }
        if (temp.getData() == node) {
            rTemp = temp;
            while( rTemp.getRight() != null ) {
                rTemp = rTemp.getRight();
            }
            rTemp.setRight( value );
        }
        else {
            temp.setNext(node);
            tail = temp.getNext();
            temp = tail;
            rTemp = temp;
            rTemp.setRight( value );
        }
    }

    public String getRight ( String source ) {
        Node temp = head;
        String _value = "";
        while ( temp.getData() != source && temp != null ) {
            temp = temp.getNext();
        }
        temp = temp.getRight();
        while ( temp != null ) {
            _value += temp.getData() + "\t";
            temp = temp.getRight();
        }
        return _value;
    }
    public int getRightSize ( String source ) {
        int count = 0;
        Node temp = getNode(source);
        while ( temp.getRight() != null ){
            count ++;
            temp = temp.getRight();
        }
        return count;
    }
    public Node getNode ( String data ) {
        Node _value = head;
        while ( _value.getData() != data && _value != null )
            _value = _value.getNext();
        return _value;
    }
    Boolean isAdjacent ( String source, String data ){
        Boolean _value = false;
        Node node = getNode(source);
        Node temp = node;
        if(head == null)
            return false;
        else {
            while ( temp.getData() != data && temp.getRight() != null )
                    temp = temp.getRight();
                if ( temp.getData() == data )
                    _value = true;
        }
        return _value;
    }

    public void printRight ( Node node ) {
        Node temp = node;
        while ( temp != null ) {
            System.out.print(temp.getData() + "\t");
            temp = temp.getRight();
        }
    }
	
	public void print ( ) {
		Node temp = head;
		while ( temp != null ) {
            printRight(temp);
			System.out.println( );
			temp = temp.getNext();
		}
	}
    
    public String to_printRight ( Node node ) {
        Node temp = node;
        String return_ = "";
        while ( temp != null ) {
            return_ += temp.getData() + "\t";
            temp = temp.getRight();
        }
        return return_;
    }
	
	public String to_print ( ) {
		Node temp = head;
        String return_ = "";
		while ( temp != null ) {
            return_ += to_printRight(temp) + "\n";
			temp = temp.getNext();
		}
        return return_;
    };
}