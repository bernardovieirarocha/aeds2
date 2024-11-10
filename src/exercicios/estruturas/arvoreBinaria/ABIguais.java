package exercicios.estruturas.arvoreBinaria;
//
//class TreeNode2 {
//    int val;
//    TreeNode2 left;
//    TreeNode2 right;
//    TreeNode2() {}
//    TreeNode2(int val) { this.val = val; }
//    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

//public class ABIguais {
//    public static boolean isSameTree(TreeNode2 p, TreeNode2 q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null || p.val != q.val) {
//            return false;
//        }
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }
//
//    public static void main(String[] args) {
//        TreeNode2 p = new TreeNode2(1, new TreeNode2(2), new TreeNode2(3));
//        TreeNode2 q = new TreeNode2(1, new TreeNode2(2), new TreeNode2(3));
//        System.out.println(isSameTree(p, q));
//    }
//}