package exercicios.estruturas.tadsFlexiveis;


class ListNode {
      int val;
      listNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, listNode next) { this.val = val; this.next = next; }
}
public class ListaEncadeadaSort {
    public static int getSize(listNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static listNode getNodePos(listNode head, int pos, int count) {
        if (head != null) {
            if (count == pos){
                return head;
            }
            return getNodePos(head.next, pos, count + 1);
        }
        return null;
    }

    public static void swap(listNode head, int entrada, int destino) {
        listNode node1 = getNodePos(head, entrada, 0);
        listNode node2 = getNodePos(head, destino, 0);
        if (node1 != null && node2 !=null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

    }

    public static listNode sortList(listNode head) {
        int tam = getSize(head);
        for (int i = 0; i < tam- 1; i++){
            for (int j = 0; j < tam - i - 1; j++){
                listNode current = getNodePos(head, j, 0);
                listNode prox = getNodePos(head, j + 1, 0);
                if (current.val > prox.val){
                    swap(head, j, j + 1);
                }
            }
        }
        return head;
    }

    public static void showList(listNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            if (head.next == null) {
                System.out.print("null");
            }

            head = head.next;
        }
    }

    public static void main(String[] args) {
        listNode head = new listNode(4);
        head.next = new listNode(2);
        head.next.next = new listNode(1);
        head.next.next.next = new listNode(3);
        System.out.println("Before: ");
        showList(head);
        System.out.println("\nAfter: ");
        listNode sorted = sortList(head);
        showList(sorted);
    }
}
