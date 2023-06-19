package model;


import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        // Lógica para alterar uma pessoa jurídica no repositório
    }

    public void excluir(int id) {
        // Lógica para excluir uma pessoa jurídica do repositório pelo ID
    }

    public PessoaJuridica obter(int id) {
        // Lógica para obter uma pessoa jurídica do repositório pelo ID
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(pessoasJuridicas);
        objectOut.close();
        fileOut.close();
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(nomeArquivo);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        Object obj = objectIn.readObject();
        if (obj instanceof ArrayList<?>) {
            ArrayList<?> obj2 = (ArrayList<?>) obj;
            ArrayList<PessoaJuridica> pessoasJuridicasRecuperadas = new ArrayList<>();
            for (Object item : obj2) {
                if (item instanceof PessoaJuridica) {
                    pessoasJuridicasRecuperadas.add((PessoaJuridica) item);
                }
            }
            pessoasJuridicas = pessoasJuridicasRecuperadas;
        } else {
            extracted();
        }
        objectIn.close();
        fileIn.close();
    }

	private void extracted() throws IOException {
		throw new IOException("O objeto lido não é uma instância válida de ArrayList<PessoaJuridica>.");
	}
    
    }

        
        