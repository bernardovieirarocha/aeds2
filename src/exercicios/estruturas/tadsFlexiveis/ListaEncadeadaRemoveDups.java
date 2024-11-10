package exercicios.estruturas.tadsFlexiveis;

class listNode {
      int val;
      listNode next;
      listNode() {}
      listNode(int val) { this.val = val; }
      listNode(int val, listNode next) { this.val = val; this.next = next; }

    public listNode deleteDuplicates(listNode head) {
        listNode init = head;
        listNode prox = head.next;

        while (prox != null) {
            if (init.val == prox.val) {
                init.next = prox.next;
                prox = prox.next;
            }  else {
                prox = prox.next;
                init = init.next;
            }
        }
        return head;
    }
}

public class ListaEncadeadaRemoveDups {
    public static void main(String[] args) {
        listNode head = new listNode(1);
        head.next = new listNode(1);
        head.next.next = new listNode(2);
        head.next.next.next = new listNode(3);
        head.next.next.next.next = new listNode(3);
        head.next.next.next.next.next = new listNode(4);
        head.next.next.next.next.next.next = new listNode(5);
        head.next.next.next.next.next.next.next = new listNode(5);
        head.next.next.next.next.next.next.next.next = new listNode(6);
        head.next.next.next.next.next.next.next.next.next = new listNode(7);

        listNode result = head.deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + " -> ");
            if (result.next == null) {
                System.out.print("null");
            }
            result = result.next;
        }
    }
}
