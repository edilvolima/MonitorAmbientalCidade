/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.testes;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarWidgets;
import br.ufrn.controlers.ConcreteAtualizarWidgets;
import br.ufrn.controlers.InstanciaWidget;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        
          //atualizarWidgets.atualizarQuantidadeLixo(3, 120);
          //atualizarWidgets.atualizarQuantidadeLixo(1, 150);
          //atualizarWidgets.atualizarQuantidadeLixo(3, 250);
          //atualizarWidgets.atualizarQuantidadeLixo(1, 250);
        try {
             Thread.sleep(5000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
         }
          atualizarWidgets.atualizarQuantidadeLixo(1, 100);
         try {
             Thread.sleep(5000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
         }
          atualizarWidgets.atualizarQuantidadeLixo(4, 235);
          try {
             Thread.sleep(5000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
         }
          //atualizarWidgets.atualizarQuantidadeLixo(2, 230);
          atualizarWidgets.atualizarQuantidadeLixo(2, 150);
          try {
             Thread.sleep(5000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
         }
          atualizarWidgets.atualizarQuantidadeLixo(3, 240);
          
//        atualizarWidgets.atualizarIndicePoluicao(1, 290);
        
    }
}
