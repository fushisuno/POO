package controller;

import model.Recepcionista;
import model.Funcionario;
import model.Pessoa;
import model.Profissional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import dao.ExceptionDAO;
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.ProfissionalDAO;
import dao.RecepcionistaDAO;

public class RecepcionistaController {

    public void createSimpleRecepcionista(int idFuncionario) throws Exception {
        if (idFuncionario > 0) {
            Recepcionista recepcionista = new Recepcionista(idFuncionario);
            recepcionista.createRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }
    
    public void createFullRecepcionista(String nome, String telefone, String rg, String cpf, LocalDate dataNascimento, String sexo, String profissao, String endereco, String login, String senha, String cargo) throws Exception {
        if (nome != null) {
        	Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        	pessoa.createPessoa(pessoa);
        	pessoa = new PessoaDAO().getPessoaByCpf(pessoa.getCpf());
        	
        	Funcionario funcionario = new Funcionario(login, senha, cargo);
        	funcionario.createFuncionario(funcionario, pessoa.getIdPessoa());
        	funcionario = new FuncionarioDAO().getFuncionarioByCpf(pessoa.getCpf());
        	
        	
        	Recepcionista recepcionista = new Recepcionista(funcionario.getIdFuncionario());
            
            recepcionista.createRecepcionista(recepcionista);
        } else {
            throw new Exception("Preencha os campos corretamente!");
        }
    }

    public void updateRecepcionista(String nome, String telefone, String rg, String cpf, LocalDate dataNascimento, String sexo, String profissao, String endereco, String login, String senha, String cargo) throws Exception {
        if (nome != null) {
        	Pessoa pessoa = new Pessoa(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
        	pessoa.setIdPessoa(new PessoaDAO().getPessoaByCpf(pessoa.getCpf()).getIdPessoa());
        	pessoa.updatePessoa(pessoa);
        	
        	Funcionario funcionario = new Funcionario(login, senha, cargo);
        	funcionario.setIdFuncionario(new FuncionarioDAO().getFuncionarioByCpf(pessoa.getCpf()).getIdFuncionario());
        	funcionario.updateFuncionario(funcionario);
        	
        	
        	Recepcionista recepcionista = new Recepcionista(funcionario.getIdFuncionario());
        	recepcionista.updateRecepcionista(recepcionista);
        } else {
             throw new Exception("Preencha os campos corretamente!");
         }
    }

    public void deleteRecepcionista(String cpf) throws Exception {
    	Recepcionista recepcionista = new RecepcionistaDAO().getRecepcionistaByCpf(cpf);
        if (recepcionista.getIdRecepcionista() > 0) {
            new RecepcionistaDAO().deleteRecepcionista(recepcionista.getIdRecepcionista());
        } else {
            throw new Exception("ID do Recepcionista é inválido!");
        }
    }
   
    public Recepcionista getRecepcionistaByCpf(String cpf) throws Exception {
        if (cpf != null && !cpf.isEmpty()) {
        	Recepcionista recepcionista = new RecepcionistaDAO().getRecepcionistaByCpf(cpf);
            return recepcionista;
        } else {
            throw new Exception("CPF é inválido!");
        }
    }

    public List<Recepcionista> getAllRecepcionistas() throws ExceptionDAO {
        try {
        	return new RecepcionistaDAO().getAllRecepcionistas();
        } catch (ExceptionDAO e) {
            throw new ExceptionDAO("Erro ao buscar recepcionistas: " + e.getMessage());

        }
    }
    
    public Recepcionista getRecepcionistaByLogin(String username) throws Exception {
        if (username != null && !username.isEmpty()) {
            return new RecepcionistaDAO().getRecepcionistaByLogin(username);
        } else {
            throw new Exception("CPF é inválido!");
        }
    }
}
