/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.testes;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarWidgets;
import br.ufrn.controlers.ConcreteAtualizarWidgets;
import br.ufrn.controlers.InstanciaWidget;

/**
 *
 * @author Zeff
 */
public class Teste {
     public static void main(String[] args) {
        
        MonitorCidade monitorCidade = MonitorCidade.getInstance();
        monitorCidade.setVisible(true);
        
        InstanciaWidget instanciaWidget = InstanciaWidget.getInstance();
        AtualizarWidgets atualizarWidgets = ConcreteAtualizarWidgets.getInstance();
        
//        AtualizarWidgets atualizarWidgets = new ConcreteAtualizarWidgets();
        
//        atualizarWidgets.atualizarTemeperatura(2, 10);
//        atualizarWidgets.atualizarTemeperatura(3, 30);
          atualizarWidgets.atualizarQuantidadeLixo(3, 0);
          //atualizarWidgets.atualizarQuantidadeLixo(1, 150);
          //atualizarWidgets.atualizarQuantidadeLixo(1, 250);
          //atualizarWidgets.atualizarQuantidadeLixo(1, 250);
          //atualizarWidgets.atualizarQuantidadeLixo(2, 100);
          //atualizarWidgets.atualizarQuantidadeLixo(2, 0);
         // atualizarWidgets.atualizarQuantidadeLixo(3, 250);
          //atualizarWidgets.atualizarQuantidadeLixo(2, 100);
          //atualizarWidgets.atualizarQuantidadeLixo(3, 0);
//        atualizarWidgets.atualizarIndicePoluicao(1, 290);
        
    }
}
