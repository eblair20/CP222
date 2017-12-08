/**
 * some methods utilize logic from class work
 */
public class BSTree<K extends Comparable<K>,V> implements IDict<K,V> {

  TreeNode<K,V> root;
  TreeNode<K,V> current;
  int size;
  int array_size;
  K[] array;

  public BSTree(){
    root = null;
    current = null;
    size = 0;
    array = (K[])new Comparable[array_size];
  }

    public V add(K k, V v){
        current = root;
        if(current == null) {
            root = new TreeNode<K,V>(k,v);
            current = root;
           return current.getValue();
        }
        helper(k,v);
        size++;
        return current.getValue();
        //return null;
      }
    public void helper(K k, V v) {
          //Does the new node fit as a direct child
      if((k.compareTo(current.getKey()) < 0 && current.getLeft() == null) ||
        (k.compareTo(current.getKey()) > 0  && current.getRight() == null) ){
              if(k.compareTo(current.getKey()) < 0) {
                  current.setLeft(new TreeNode<K,V>(k,v));
                  current = current.getLeft();
              }
              else {
                  current.setRight(new TreeNode<K,V>(k,v));
                  current = current.getRight();
              }
              return;
          }
          //Place the node with one of the children
        if(k.compareTo(current.getKey()) < 0) {
              current = current.getLeft();
          }
          else {
              current = current.getRight();
          }
          helper(k,v);
      }

    //adapted from class code to take in two generics for keys and values instead
    //of an integer
    public V remove(K k) {
        // Find the node to remove and it's parent
        TreeNode<K,V> parent = null;
        // start at the root
        current = root;
        // while we haven't found the key
        while(current.getKey() != k) {
            if(k.compareTo(current.getKey()) > 0) {
                // walk right
                parent = current;
                current = current.getRight();
            } else {
                // walk left
                parent = current;
                current = current.getLeft();
            }
        }

        //is a leaf
        if(current.getRight() == null || current.getLeft() == null) {
            if(parent.getRight() == null) {
              parent.setRight(null);
            }
            if(parent.getLeft() == null)  {
              parent.setLeft(null);
            }
            //current = root;
            current.setValue(null);
            return current.getValue();
        }

        if(current.getRight() == null || current.getLeft() == null) {
            // Set the parent to point at the child
            if(current.getRight() == null) {
                if(parent.getRight() == null) {
                    parent.setRight(current.getLeft());
                } else {
                    parent.setLeft(current.getLeft());
                }
            } else {
                if(parent.getRight() == null) {
                    parent.setRight(current.getRight());
                } else {
                    parent.setLeft(current.getRight());
                }
            }
            current.setValue(null);
            return current.getValue();
        }

        TreeNode<K,V> swapparent = current;
        TreeNode<K,V> swapnode = current.getRight();
        while(swapnode.getLeft() != null) {
            swapparent = swapnode;
            swapnode = swapnode.getLeft();
        }
        // Have left most node, set the left most parent to the right child
        swapparent.setLeft(swapnode.getRight());
        swapnode.setLeft(current.getLeft());
        swapnode.setRight(current.getRight());
        if(parent.getRight() == null) {
          parent.setRight(swapnode);
        }
        if(parent.getLeft() == null)  {
          parent.setLeft(swapnode);
        }
        current.setValue(null);
        return current.getValue();
    }

    public int size(){
      return size;
    }

    public V fetch(K k) {
        current = root;
        while(current.getKey()!= k) {
            if(k.compareTo(current.getKey()) > 0) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }
        // We have found the key or ran out of children
        return current.getValue();
    }

    //need traversal to recall keys
    //array size is causing an out of bounds problem
    public K[] traverse(TreeNode<K,V> node) {
      int array_size =  0;
      array_size++;
      array = (K[])new Comparable[array_size];
      if (node == null) {
        node.getKey();
      } else if (current.isLeaf() == true) {
        node.getKey();
        array[array_size - 1] = node.getKey();
      } else {
        TreeNode<K,V> left = node.getLeft();
        TreeNode<K,V> right = node.getRight();
        array[array_size - 1] = node.getKey();
        traverse(left);
        traverse(right);
      }
      return array;
    }

    public K[] keys() {
      TreeNode<K,V> node = root;
      traverse(root);
      K[] final_array = array;
      return final_array;
    }
}
