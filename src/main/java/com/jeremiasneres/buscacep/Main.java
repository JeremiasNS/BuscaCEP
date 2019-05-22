package com.jeremiasneres.buscacep;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

/**
 *
 * @author jeremias
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AtendeClienteService service  = new AtendeClienteService();
        AtendeCliente port = service.getAtendeClientePort();
        try {
            EnderecoERP endereco = port.consultaCEP("77066008");
            System.out.println("Endereço: " + endereco.getEnd());
            System.out.println("Cidade: " + endereco.getCidade());
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("UF: " + endereco.getUf());
        } catch (SQLException_Exception | SigepClienteException ex) {
            System.err.println("Houve um erro inesperado. Por favor tente novamente.");
        }
        
    }
    
}
