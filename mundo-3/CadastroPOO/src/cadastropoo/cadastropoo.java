package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class cadastropoo {
    public static void main(String[] args) {
        // Instanciar um repositório de pessoas físicas (repo1)
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        // Adicionar duas pessoas físicas, utilizando o construtor completo
        PessoaFisica pessoa1 = new PessoaFisica(1, "João", "1234567890", 30);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Maria", "0987654321", 25);
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);

        // Invocar o método de persistência em repo1, fornecendo um nome de arquivo fixo
        try {
            repo1.persistir("pessoasFisicas.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Instanciar outro repositório de pessoas físicas (repo2)
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        // Invocar o método de recuperação em repo2, fornecendo o mesmo nome de arquivo utilizado anteriormente
        try {
            repo2.recuperar("pessoasFisicas.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exibir os dados de todas as pessoas físicas recuperadas
        System.out.println("Pessoas Físicas:");
        for (PessoaFisica pessoa : repo2.obterTodos()) {
            pessoa.exibir();
            System.out.println();
        }

        // Instanciar um repositório de pessoas jurídicas (repo3)
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        // Adicionar duas pessoas jurídicas, utilizando o construtor completo
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "Empresa A", "12345678901234");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2, "Empresa B", "98765432109876");
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);

        // Invocar o método de persistência em repo3, fornecendo um nome de arquivo fixo
        try {
            repo3.persistir("pessoasJuridicas.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Instanciar outro repositório de pessoas jurídicas (repo4)
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        // Invocar o método de recuperação em repo4, fornecendo o mesmo nome de arquivo utilizado anteriormente
        try {
            repo4.recuperar("pessoasJuridicas.dat");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exibir os dados de todas as pessoas jurídicas recuperadas
        System.out.println("Pessoas Jurídicas:");
        for (PessoaJuridica pessoa : repo4.obterTodos()) {
            pessoa.exibir();
            System.out.println();
        }
    }
}