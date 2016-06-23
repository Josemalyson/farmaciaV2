package br.com.farmacia.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.farmacia.entidades.Produto;
import br.com.farmacia.servicos.ProdutoServico;
import br.com.farmacia.vo.VendaVo;

@ManagedBean
public class PedidoControlador extends CoreControlador {

	private static final long serialVersionUID = -5526946400684258997L;

	private VendaVo vendaVo;
	
	@Inject
	private ProdutoServico produtoServico;

	@PostConstruct
	public void init() {
		vendaVo = new VendaVo();
	}

	public List<Produto> completeTheme(String query) {
        List<Produto> allThemes = produtoServico.listar();
        List<Produto> filteredThemes = new ArrayList<Theme>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Theme skin = allThemes.get(i);
            if(skin.getName().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }

	public VendaVo getVendaVo() {
		return vendaVo;
	}

	public void setVendaVo(VendaVo vendaVo) {
		this.vendaVo = vendaVo;
	}

}
