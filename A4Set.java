import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class A4Set<E extends Comparable<E>> implements Set<E>  {
	
	
	private class Node {
		private E e;
		private Node left;
		private Node right;
		private boolean color; 
		
		public Node(E e, boolean color){
			this.e = e;
			this.color = color;
		}
		
	}
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private int size = 0;
	
	public A4Set () {
		
	}
	
	//Node Helper method
	private boolean isRed(Node n) {
		if (n == null)
			return false;
		return n.color == RED;
	}

	//rotate subtree of Node n right
	private Node rotateRight(Node n) {
		Node rot = n.left;
        n.left = rot.right;
        rot.right = n;
        rot.color = rot.right.color;
        rot.right.color = RED;
        return rot;
	}
	
	//rotate subtree of Node n left
	private Node rotateLeft(Node n) {
        Node rot = n.right;
        n.right = rot.left;
        rot.left = n;
        rot.color = rot.left.color;
        rot.left.color = RED;
        return rot;
    }
	private void flipColors(Node n) {
		n.color = !n.color;
		n.right.color = !n.right.color;
		n.left.color = !n.left.color;
	}
	
	
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if (e == null) 
			throw new IllegalArgumentException();
		if (contains(e) == true) {
			return false;
		}
		size++;
		root = add(root, e);
		return true;
	}
	
	private Node add(Node n, E e) {

		if(n == null) {
			return new Node(e, RED);
		}
		
		int compared = e.compareTo(n.e);
		
		if (compared < 0) {
			n.left = add(n.left, e);
		}
		else if (compared > 0) {
			n.right = add(n.right, e);
		}
		else {
			n.e = e;
		}
		
		// to rebalance tree if necessary and enforce invariant
		
		if(isRed(n.right) && !isRed(n.left))
			n = rotateLeft(n);
		if(isRed(n.left) && isRed(n.left.left))
			n = rotateRight(n);
		if(isRed(n.right) && !isRed(n.left))
			flipColors(n);
		
		
		
		return n;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root = null;
	}
	
	@Override
	public boolean contains(Object obj) {
		
		
		
		return contains(root, obj);
	}
	
	private boolean contains(Node n, Object obj) {
		while(n != null) {
			int compare = ((E) obj).compareTo(n.e);
			if (compare < 0)
				n = n.left;
			else if (compare > 0)
				n = n.right;
			else
				return true;
		}
		
		
		return false;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String toString() {
		return null;
	}

	
	//BONUS
//	@Override
//	public boolean remove(Object obj) {
//		if (obj == null)
//			throw new IllegalArgumentException();
//		
//		if(contains(obj) != true)
//			return false;
//		
//		if (!isRed(root.left) && !isRed(root.right))
//            root.color = RED;
//		
//		
//		root = remove(root, obj);
//		return true;
//	}
//	
//	private Node remove(Node n, Object obj) {
//		
//	}

	
	
	
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	

	

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
