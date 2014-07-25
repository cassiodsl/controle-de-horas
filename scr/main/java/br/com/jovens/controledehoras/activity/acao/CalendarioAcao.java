package br.com.jovens.controledehoras.activity.acao;

import java.net.URISyntaxException;
import java.util.List;

import android.net.Uri;
import android.util.Log;
import br.com.controledehoras.core.beans.RegistroArquivo;
import br.com.controledehoras.core.csv.CSVHelper;
import br.com.jovens.controledehoras.activity.CalendarioActivity;
import br.com.jovens.controledehoras.activity.helper.SelecionadorArquivoHelper;
import br.com.jovens.controledehoras.activity.util.MensagemUtil;
import br.com.jovens.controledehoras.dao.ApontamentoDAO;
import br.com.jovens.controledehoras.entity.ApontamentoEntity;

public class CalendarioAcao {
	
	private CalendarioActivity calendario;
	
	public CalendarioAcao(CalendarioActivity calendario){
		this.calendario = calendario;
	}

	public void executarArquivoSelecionado(Uri uri) {
		SelecionadorArquivoHelper selecionadorArquivo = calendario.getSelecionadorArquivo();
		selecionadorArquivo.setUri(uri);
		
		Log.d("CSV", "Uri Arquivo: " + selecionadorArquivo.getUri().toString());
		try {
			String path = selecionadorArquivo.getPath();
			MensagemUtil.exibirMensagemLonga(calendario, path);
			
			// Inserir chamada a biblioteca controle-horas-core
			List<RegistroArquivo> registros = CSVHelper.getInstance().obterRegistrosDoArquivo(path);
			//TODO: salvar registros no banco, verificar se j� existe
			/*
			 * Ser� necess�rio incluir um botao no calendario para excluir registros de um determinado dia.
			 * Caso haja atualiza��es no dia, nao poder�o somar e sim substituir
			 * 
			 * Coloquei os comandos abaixo apenas como exemplo, tem que arrumar os parametros e classes
			 * Por exemplo, a diferen�a entra Apontamento e RegistroArquivo
			 */
			
			for (RegistroArquivo registro : registros) {
				List<RegistroArquivo> regEncontrados= new ApontamentoDAO(null).selectApontamentoByApontamento(registro);
				if(regEncontrados==null || regEncontrados.isEmpty()){
					new ApontamentoDAO(null).save(new ApontamentoEntity(registro));//passar apontamento
				}
			}
			MensagemUtil.exibirMensagemLonga(calendario, "Quantidade de registros: " + registros.size());//remover
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (Exception x){
			x.printStackTrace();
		}
	}

	public void executarSelecionadorArquivo(){
		SelecionadorArquivoHelper selecionadorArquivo = calendario.getSelecionadorArquivo();
		selecionadorArquivo.showFileChooser();
	}

}
