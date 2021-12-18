package lab2;

import java.util.Arrays;
/**
 * 
 * Calcula a média aritmética dos alunos, de acordo com a disciplina. E por padrão
 * cada disciplina possui 4 notas ao total.
 * 
 * 
 * @author Ana Paula
 */
public class Disciplina {
	private String nomeDisciplina;
    private double[] notas;
    private int horas;
    private double media;
    private double soma;
    private int[] notasPesos;
    private double somaDivisao;
    private int numeroNotas;
/**
 * @param nomeDisciplina é o nome da disciplina que o aluno deseja cadastrar 
 */
    Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];

    }
    
    Disciplina(int numeroNotas) {
        this.numeroNotas = numeroNotas;
        this.notas = new double[numeroNotas];
    }
    
    Disciplina(int numeroNotas, int[] notasPesos) {
        this.notasPesos = notasPesos;
        this.numeroNotas = numeroNotas;
        this.notas = new double[numeroNotas];
    }

    
 /**
  * @param horas são as horas cadastradas de estudo na disciplina
  */
    public void cadastraHoras(int horas) {
        this.horas += horas;

    }
 /**
  * Cadastra a nota na disciplina de acordo com sua posição, e seguindo 
  * o padrão de 4 notas. 
  * 
  * @param nota a posição da nota
  * @param valorNota e o valor da nota
  */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;

    }
/**
 * Verifica se o aluno foi aprovado ou não na disciplina fazendo a média aritmética
 * das notas cadastradas até o momento.
 * 
 * @return boolean true se o aluno passou, e false se o aluno não passou
 */
    public boolean aprovado() {

        if (this.notasPesos == null) {
            for (double nota : this.notas) {
                this.soma += nota;
            }

            this.media = this.soma / this.notas.length;
            this.soma = 0;

        } else {

            for (int i = 0; i < this.notasPesos.length; i++) {
                this.somaDivisao += this.notasPesos[i] * this.notas[i];
                this.soma += this.notasPesos[i];

            }
            this.media = this.somaDivisao / this.soma;
            this.somaDivisao = 0;
        }
        return this.media >= 7.0;

    }
/**
 *@return string informando o nome, as horas de estudo, a média e a lista das notas da disciplina 
 */
    public String toString() {
        if (this.notasPesos != null) {
            return String.format("Media: %.1f Lista das notas: ", this.media) + (Arrays.toString(this.notas)) + " Lista de pesos: " + (Arrays.toString(this.notasPesos));

        } else {
            if (this.numeroNotas != 0) {
                return String.format("Media: %.1f Lista das notas: ", this.media) + (Arrays.toString(this.notas));
            } else {
                return this.nomeDisciplina + " " + this.horas + " " + this.media + " " + (Arrays.toString(this.notas));
            }
        }
    }
}