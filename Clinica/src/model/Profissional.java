package model;

import java.sql.Date;

import dao.ProfissionalDAO;
import dao.ExceptionDAO;

public class Profissional extends Funcionario {
    private int idProfissional;
    private String especialidade;
    private String registroConselho;
    private Date dataInscricao;
    
    public Profissional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profissional(String nome, String telefone, String rg, String cpf, Date dataNascimento, String sexo,
			String profissao, String endereco) {
		super(nome, telefone, rg, cpf, dataNascimento, sexo, profissao, endereco);
		// TODO Auto-generated constructor stub
	}

	public Profissional(String login, String senha, String cargo) {
		super(login, senha, cargo);
		// TODO Auto-generated constructor stub
	}

	public Profissional(String especialidade, String registroConselho, Date dataInscricao) {
		super();
		this.especialidade = especialidade;
		this.registroConselho = registroConselho;
		this.dataInscricao = dataInscricao;
	}

	public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroConselho() {
        return registroConselho;
    }

    public void setRegistroConselho(String registroConselho) {
        this.registroConselho = registroConselho;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public void createProfissional(Profissional Profissional) throws ExceptionDAO {
        new ProfissionalDAO().createProfissional(Profissional);
    }

    public void updateProfisssional(Profissional Profissional) throws ExceptionDAO {
        new ProfissionalDAO().updateProfisssional(Profissional);
    }

    public void deleteProfissional(int idProfissional) throws ExceptionDAO {
        new ProfissionalDAO().deleteProfissional(idProfissional);
    }
}