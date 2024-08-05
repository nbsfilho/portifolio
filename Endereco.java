
public class Endereco {
    private String rua;
    private int numero;
    private String cep;

    public Endereco(String rua, int numero, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public void informacao() {
        System.out.println("Endereço: " + rua + ", " + numero + ", CEP: " + cep);
    }
}




public class Pessoa {
    private String nome;
    private String cpf;
    private Endereco endereco;

    public Pessoa(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void informacao() {
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        endereco.informacao();
    }

    public void mudarEndereco(String rua, int numero, String cep) {
        this.endereco = new Endereco(rua, numero, cep);
    }
}


import java.util.ArrayList;

public class Aluno extends Pessoa {
    private int matricula;
    private String curso;
    private ArrayList<Disciplina> disciplinas;

    public Aluno(String nome, String cpf, Endereco endereco, int matricula, String curso) {
        super(nome, cpf, endereco);
        this.matricula = matricula;
        this.curso = curso;
        this.disciplinas = new ArrayList<>();
    }

    public void mudarCurso(String curso) {
        this.curso = curso;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    @Override
    public void informacao() {
        super.informacao();
        System.out.println("Matrícula: " + matricula + ", Curso: " + curso);
        for (Disciplina disciplina : disciplinas) {
            disciplina.informacao();
        }
    }
}


public class Disciplina {
    private String nome;
    private double nota1;
    private double nota2;

    public Disciplina(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public double calcularNota() {
        return (nota1 + nota2) / 2;
    }

    public void informacao() {
        System.out.println("Disciplina: " + nome + ", Nota 1: " + nota1 + ", Nota 2: " + nota2 + ", Média: " + calcularNota());
    }
}

