package exercicio_medicamento;

import java.util.ArrayList;
import java.util.List;


public class Util {

	private List<Medicamento> medicamento = new ArrayList<Medicamento>();
	private List<Pessoa> pessoa = new ArrayList<Pessoa>();
	private List<Prescricao> prescricao = new ArrayList<Prescricao>();

	public Medicamento cadastraMedicamento(Medicamento m) {
		m.setId(medicamento.size() + 1);
		medicamento.add(m);
		return m;
	}

	public Pessoa cadastraPessoa(Pessoa p) {
		p.setId(pessoa.size() + 1);
		pessoa.add(p);
		return p;
	}

	public Prescricao criaPresc(Prescricao pres) {
		
		pres.setId(prescricao.size() + 1);
		prescricao.add(pres);
		return pres;
	}

	public List<Pessoa> listarPessoas() {
		return pessoa;
	}
	
	public List<Medicamento> listarMedicamentos() {
		return medicamento;
	}
	
	public List<Prescricao> listarPrescricoes() {
		return prescricao;
	}
	
	public Pessoa findByPessoaId (final Integer id) {
		return pessoa.stream()
				.filter(p -> id.equals(p.getId()))
				.findAny()
				.orElse(null);
	} 
	
	public Medicamento findByMedicamentoId (final Integer id) {
		return medicamento.stream()
				.filter(p -> id.equals(p.getId()))
				.findAny()
				.orElse(null);
	}
	
	public Prescricao findByPrescricaoId (final Integer id) {
		return prescricao.stream()
				.filter(p -> id.equals(p.getId()))
				.findAny()
				.orElse(null);
	}
	
	public Pessoa updatePessoa (final Integer id, Pessoa p) {
		Pessoa cad = findByPessoaId(id);
		if(cad != null) {
			pessoa.remove(cad);
			p.setId(cad.getId());
			pessoa.add(p);
			return p;
		}
		return null;
	}
	public Medicamento updateMedicamento (final Integer id, Medicamento m) {
		Medicamento cad = findByMedicamentoId(id);
		if(cad != null) {
			medicamento.remove(cad);
			m.setId(cad.getId());
			medicamento.add(m);
			return m;
		}
		return null;
	}
	
	public void deletePessoa (final Integer id) {
		Pessoa cad = findByPessoaId(id);
		if(cad != null) {
			pessoa.remove(cad);
		}
	}
	
	public void deleteMedicamento (final Integer id) {
		Medicamento cad = findByMedicamentoId(id);
		if(cad != null) {
			medicamento.remove(cad);
		}
	}
	
	public void deletePrescricao (final Integer id) {
		Prescricao cad = findByPrescricaoId(id);
		if(cad != null) {
			prescricao.remove(cad);
		}
	}
	
	public List<Medicamento> findByAdministracao (final EnumAdminitracao tipo) {
		return medicamento.stream()
				.filter(m -> m.getTipo().equals(tipo)) 
				.toList();
	}
	public void clearData() {
		medicamento.clear();
		pessoa.clear();
		prescricao.clear();
	}
}
