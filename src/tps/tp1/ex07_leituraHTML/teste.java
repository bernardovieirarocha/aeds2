@SuppressWarnings("WrongPackageStatement")
public class teste {
    public static void main(String[] args) {
//    MyIO.setCharset("UTF-8");
        String nome;
        String endereco;

        do {
            nome = MyIO.readLine();
            if (!nome.equals("FIM")) {
                endereco = MyIO.readLine();
               System.out.printf("%s %s\n", nome, endereco);
            }

        } while (!nome.equals("FIM"));
    }
}
