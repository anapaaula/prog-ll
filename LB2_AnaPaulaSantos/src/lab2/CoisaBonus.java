package lab2;

public class CoisaBonus {
	public static void main(String[] args) {
        disciplina();
        System.out.println("---");
        financas();
        System.out.println("-----");


    }
    public static void disciplina(){
        int[] pesos = {3, 7, 8};
        Disciplina prog1 = new Disciplina(3,pesos);
        prog1.cadastraNota(1,7.0);
        prog1.cadastraNota(2,7.6);
        prog1.cadastraNota(3,10);
        prog1.aprovado();
        prog1.cadastraHoras(4);
        System.out.println(prog1.toString());

        Disciplina prog2 = new Disciplina(4);
        prog2.cadastraNota(3, 8.0);
        prog2.cadastraNota(1, 8.0);
        prog2.cadastraHoras(3);
        prog2.aprovado();
        System.out.println(prog2.toString());
    }
    private static void financas() {
        int dinheiroGuardado = 10000;
        int historicoDeGanhos = 4;
        RegistroFinancas minhaFinanca = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);

        minhaFinanca.adicionaGanhos(12000, 1);
        minhaFinanca.adicionaGanhos(72100, 2);
        minhaFinanca.pagaDespesa(20000, "Aluguel de março 2021");
        minhaFinanca.pagaDespesa(3000, "Cento de salgados para happy hour com as garotas");
        minhaFinanca.pagaDespesa(3000);
        System.out.println(minhaFinanca.exibeGanhos());
        System.out.println(minhaFinanca.toString());
        System.out.println(minhaFinanca.listarDetalhes());

    }

}
