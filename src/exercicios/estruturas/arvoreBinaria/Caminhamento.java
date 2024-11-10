package exercicios.estruturas.arvoreBinaria;

import java.util.ArrayList;
import java.util.List;

class treeNode {
      int val;
      treeNode left;
      treeNode right;
      treeNode() {}
      treeNode(int val) { this.val = val; }
      treeNode(int val, treeNode left, treeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class Caminhamento {
    public List<Integer> inorderTraversal(treeNode root) {
        List<Integer> lista = new ArrayList<>();
        caminharCentral(root, lista);
        return lista;
    }

    // Central: esquerda, raiz, direita
    private void caminharCentral(treeNode node, List<Integer> lista) {
        if (node == null) {
            return;
        }
        caminharCentral(node.left, lista);
        lista.add(node.val);
        caminharCentral(node.right, lista);
    }

    public List<Integer> preorderTraversal(treeNode root) {
        List<Integer> lista = new ArrayList<>();
        caminharPreOrdem(root, lista);
        return lista;
    }

    // Pre-ordem: raiz, esquerda, direita
    private void caminharPreOrdem(treeNode node, List<Integer> lista) {
        if (node == null) {
            return;
        }
        lista.add(node.val);
        caminharPreOrdem(node.left, lista);
        caminharPreOrdem(node.right, lista);
    }

    public List<Integer> postorderTraversal(treeNode root) {
        List<Integer> lista = new ArrayList<>();
        caminharPosOrdem(root, lista);
        return lista;
    }

    // Pos-ordem: esquerda, direita, raiz
    private void caminharPosOrdem(treeNode node, List<Integer> lista) {
        if (node == null) {
            return;
        }
        caminharPosOrdem(node.left, lista);
        caminharPosOrdem(node.right, lista);
        lista.add(node.val);
    }


}
