//package tps.tp4.ex02_ABdeABs;
//
//import java.io.*;
//import java.util.*;
//
//
//class NodeSecondary {
//    String name;
//    NodeSecondary left, right;
//
//    public NodeSecondary(String name) {
//        this.name = name;
//        this.left = this.right = null;
//    }
//}
//
//class TreeSecondary {
//    private NodeSecondary root;
//
//    public TreeSecondary() {
//        this.root = null;
//    }
//
//    public void insert(String name) {
//        root = insertRecursive(root, name);
//    }
//
//    private NodeSecondary insertRecursive(NodeSecondary node, String name) {
//        if (node == null) return new NodeSecondary(name);
//        if (name.compareTo(node.name) < 0) {
//            node.left = insertRecursive(node.left, name);
//        } else if (name.compareTo(node.name) > 0) {
//            node.right = insertRecursive(node.right, name);
//        }
//        return node;
//    }
//
//    public boolean search(String name, StringBuilder path) {
//        return searchRecursive(root, name, path);
//    }
//
//    private boolean searchRecursive(NodeSecondary node, String name, StringBuilder path) {
//        if (node == null) return false;
//
//        path.append(node.name).append(" ");
//        if (node.name.equals(name)) return true;
//
//        if (name.compareTo(node.name) < 0) {
//            path.append("L ");
//            return searchRecursive(node.left, name, path);
//        } else {
//            path.append("R ");
//            return searchRecursive(node.right, name, path);
//        }
//    }
//}
//
//class NodePrimary {
//    int captureRateMod15;
//    NodePrimary left, right;
//    TreeSecondary secondaryTree;
//
//    public NodePrimary(int captureRateMod15) {
//        this.captureRateMod15 = captureRateMod15;
//        this.left = this.right = null;
//        this.secondaryTree = new TreeSecondary();
//    }
//}
//
//class TreePrimary {
//    private NodePrimary root;
//
//    public TreePrimary() {
//        this.root = null;
//    }
//
//    public void insert(int captureRate, String name) {
//        int captureRateMod15 = captureRate % 15;
//        root = insertRecursive(root, captureRateMod15, name);
//    }
//
//    private NodePrimary insertRecursive(NodePrimary node, int captureRateMod15, String name) {
//        if (node == null) {
//            node = new NodePrimary(captureRateMod15);
//        }
//        if (captureRateMod15 < node.captureRateMod15) {
//            node.left = insertRecursive(node.left, captureRateMod15, name);
//        } else if (captureRateMod15 > node.captureRateMod15) {
//            node.right = insertRecursive(node.right, captureRateMod15, name);
//        } else {
//            node.secondaryTree.insert(name);
//        }
//        return node;
//    }
//
//    public boolean search(int captureRate, String name, StringBuilder path) {
//        int captureRateMod15 = captureRate % 15;
//        return searchRecursive(root, captureRateMod15, name, path);
//    }
//
//    private boolean searchRecursive(NodePrimary node, int captureRateMod15, String name, StringBuilder path) {
//        if (node == null) return false;
//
//        path.append("Node(").append(node.captureRateMod15).append(") ");
//        if (captureRateMod15 < node.captureRateMod15) {
//            path.append("L ");
//            return searchRecursive(node.left, captureRateMod15, name, path);
//        } else if (captureRateMod15 > node.captureRateMod15) {
//            path.append("R ");
//            return searchRecursive(node.right, captureRateMod15, name, path);
//        } else {
//            path.append("SecondaryTree ");
//            return node.secondaryTree.search(name, path);
//        }
//    }
//}
//
//public class teste {
//    public static void main(String[] args) throws IOException {
//        // Lê o CSV
//        List<Pokemon> pokemons = readCSV("pokemon.csv");
//
//        TreePrimary tree = new TreePrimary();
//
//        // Ordem fixa para inserção inicial
//        List<Integer> fixedOrder = Arrays.asList(7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14);
//        for (int captureRateMod15 : fixedOrder) {
//            tree.insert(captureRateMod15, "Placeholder");
//        }
//
//        // Inserção dos Pokémons reais
//        for (Pokemon p : pokemons) {
//            tree.insert(p.getCaptureRate(), p.getName());
//        }
//
//        // Pesquisa simulada
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            String input = sc.nextLine();
//            if (input.equals("FIM")) break;
//
//            StringBuilder path = new StringBuilder();
//            boolean found = tree.search(7, input, path); // Exemplo com 7
//            System.out.println(path + (found ? " SIM" : " NÃO"));
//        }
//
//        createLog("853733");
//    }
//
//    public static List<Pokemon> readCSV(String filePath) throws IOException {
//        List<Pokemon> pokemons = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        String line = reader.readLine(); // Ignora o cabeçalho
//        while ((line = reader.readLine()) != null) {
//            String[] data = line.split(",");
//            int id = Integer.parseInt(data[0]);
//            String name = data[1];
//            int captureRate = Integer.parseInt(data[9]);
//            pokemons.add(new Pokemon(id, name, captureRate));
//        }
//        reader.close();
//        return pokemons;
//    }
//
//    private static void createLog(String matricula) {
//        try (FileWriter writer = new FileWriter(matricula + "_arvoreArvore.txt")) {
//            writer.write(matricula + "\t0\t0\n");
//        } catch (IOException e) {
//            System.out.println("Error creating log: " + e.getMessage());
//        }
//    }
//}
