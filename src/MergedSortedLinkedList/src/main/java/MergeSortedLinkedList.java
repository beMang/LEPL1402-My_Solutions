/**
 * Question:
 *
 * You are asked to merge two sorted linked list (see the TODO below)
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class MergeSortedLinkedList {


    /**
     * You receive two linked list containing elements in increasing order
     * You are asked to return a new linked list that contains the
     * elements of both linkedlist in increasing order.
     * The previous linkedList should remain unchanged
     *
     * The complexity of your method should be in O(n+m)
     * where n = size of list1, m = size of list2
     * @param list1 the first list containing elements in increasing order
     * @param list2 the second list containing elemennt in increasiung order
     * @return a list that contains the elements of list1 and list2 in increasing order
     */
    public static Node merge(Node list1, Node list2) {
        Node head;
        if(list1.value<=list2.value){
            head = new Node(list1.value,null);
            list1 = list1.next;
        } else {
            head = new Node(list2.value, null);
            list2 = list2.next;
        }
        Node merged = head;
        while (list1!=null || list2!=null){
            if(list1==null){
                merged.next = new Node(list2.value, null);
                list2 = list2.next;
            } else if(list2==null){
                merged.next = new Node(list1.value, null);
                list1 = list1.next;
            } else {
                if(list1.value<=list2.value){
                    merged.next = new Node(list1.value,null);
                    list1 = list1.next;
                } else {
                    merged.next = new Node(list2.value, null);
                    list2 = list2.next;
                }
            }
            merged = merged.next;
        }
        return head;
    }


    static class Node {

        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }


}
