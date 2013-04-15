/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import br.ufrn.GUI.MonitorCidade;
import context.arch.discoverer.Discoverer;
import br.ufrn.services.MonitoramentoLixeira;
import br.ufrn.services.MonitoramentoPoluicao;
import br.ufrn.services.MonitoramentoTemperatura;


public class InstanciaWidget {
    
    private final MonitoramentoLixeira mla1;
    private final MonitoramentoLixeira mla2;
    private final MonitoramentoLixeira mla3;
//    private final MonitoramentoLixeira mla4;

    private final MonitoramentoPoluicao mpa1;
    private final MonitoramentoPoluicao mpa2;
    private final MonitoramentoPoluicao mpa3;
//    private final MonitoramentoPoluicao mpa4;
    
    private final MonitoramentoTemperatura mta1;
    private final MonitoramentoTemperatura mta2;
    private final MonitoramentoTemperatura mta3;
//    private final MonitoramentoTemperatura mta4;
    
      
    private static InstanciaWidget INSTANCIA_WIDGET;

    public static InstanciaWidget getInstance() {

        if (INSTANCIA_WIDGET == null) {
            INSTANCIA_WIDGET = new InstanciaWidget();
        }
        return INSTANCIA_WIDGET;
    }
    
    AtualizarWidgets atualizador = ConcreteAtualizarWidgets.getInstance();
    
//      AtualizarWidgets atualizador = ConcreteAtualizarWidgets.getInstance();

    public InstanciaWidget(){
    	Discoverer.start();
        
        System.out.println("Inicializando componentes...");
        
        mta1 = new MonitoramentoTemperatura(1);
    	mpa1 = new MonitoramentoPoluicao(1);
        mla1 = new MonitoramentoLixeira(1);
        
        mta2 = new MonitoramentoTemperatura(2);
        mpa2 = new MonitoramentoPoluicao(2);
        mla2 = new MonitoramentoLixeira(2);
        
        mta3 = new MonitoramentoTemperatura(3);
        mpa3 = new MonitoramentoPoluicao(3);
        mla3 = new MonitoramentoLixeira(3);
        
//        mta1 = new MonitoramentoTemperatura(1, monitor);
//    	mpa1 = new MonitoramentoPoluicao(1, monitor);
//        mla1 = new MonitoramentoLixeira(1, monitor);
//        
//        mta2 = new MonitoramentoTemperatura(2, monitor);
//        mpa2 = new MonitoramentoPoluicao(2, monitor);
//        mla2 = new MonitoramentoLixeira(2, monitor);
//        
//        mta3 = new MonitoramentoTemperatura(3, monitor);
//        mpa3 = new MonitoramentoPoluicao(3, monitor);
//        mla3 = new MonitoramentoLixeira(3, monitor);
//        
//        mta4 = new MonitoramentoTemperatura(4, monitor);
//    	mpa4 = new MonitoramentoPoluicao(4, monitor);
//    	mla4 = new MonitoramentoLixeira(4, monitor);
//    	
        atualizador.AddAtualizadoresWidgets(1, mla1, mpa1, mta1);
        atualizador.AddAtualizadoresWidgets(2, mla2, mpa2, mta2);
        atualizador.AddAtualizadoresWidgets(3, mla3, mpa3, mta3);
//        atualizador.AddAtualizadoresWidgets(4, mla4, mpa4, mta4);
        
        System.out.println("Componentes inicializados com sucesso!");
        
    }
    
    
    public static void main(String[] args) {
        new InstanciaWidget();
    }
    
    
}
