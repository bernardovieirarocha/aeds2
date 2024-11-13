package exercicios.estruturas.arvoreBinaria;


//public class SomaFolhasEsquerdaAB {
//    public static int  sumOfLeftLeaves(TreeNode2 root) {
//        if (root == null) return 0;
//
//        // Check if left child is a leaf node
//        if (root.left != null && root.left.left == null && root.left.right == null) {
//            // Return value of left leaf and continue with the right subtree
//            return root.left.val + sumOfLeftLeaves(root.right);
//        }
//
//        // Recursive calls for left and right subtrees
//        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
//    }

//    public static void main(String[] args) {
//        TreeNode2 root = new TreeNode2(3);
//        root.left = new TreeNode2(9);
//        root.right = new TreeNode2(20);
//        root.right.left = new TreeNode2(15);
//        root.right.right = new TreeNode2(7);
//
//        System.out.println(sumOfLeftLeaves(root));
//    }
//}
