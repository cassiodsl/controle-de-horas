package br.com.jovens.controledehoras.activity.acao;

import java.net.URISyntaxException;

import android.net.Uri;
import android.util.Log;
import br.com.jovens.controledehoras.activity.CalendarioActivity;
import br.com.jovens.controledehoras.activity.helper.SelecionadorArquivoHelper;
import br.com.jovens.controledehoras.activity.util.MensagemUtil;

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
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void executarSelecionadorArquivo(){
		SelecionadorArquivoHelper selecionadorArquivo = calendario.getSelecionadorArquivo();
		selecionadorArquivo.showFileChooser();
	}

}
