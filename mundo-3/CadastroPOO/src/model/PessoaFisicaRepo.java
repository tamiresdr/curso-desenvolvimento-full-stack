package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisica) {
        // Lógica para alterar uma pessoa física no repositório
    }

    public void excluir(int id) {
        // Lógica para excluir uma pessoa física do repositório pelo ID
    }

    public PessoaFisica obter(int id) {
        // Lógica para obter uma pessoa física do repositório pelo ID
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(pessoasFisicas);
        objectOut.close();
        fileOut.close();
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(nomeArquivo);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Object obj = objectIn.readObject();
        if (obj instanceof ArrayList<?>) {
            ArrayList<?> obj2 = (ArrayList<?>) obj;
            ArrayList<PessoaFisica> pessoasFisicasRecuperadas = new ArrayList<>();
            for (Object item : obj2) {
                if (item instanceof PessoaFisica) {
                    pessoasFisicasRecuperadas.add((PessoaFisica) item);
                }
            }
            pessoasFisicas = pessoasFisicasRecuperadas;
        } else {
            extracted();
        }
        objectIn.close();
        fileIn.close();
    }

	private void extracted() throws IOException {
		throw new IOException("O objeto lido não é uma instância válida de ArrayList<PessoaFisica>.");
	}
}