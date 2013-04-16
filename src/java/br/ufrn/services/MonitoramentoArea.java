/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

import br.ufrn.controlers.AtualizarWidgets;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class MonitoramentoArea implements AtualizarWidgets {

    private Widget areaIN;
    private Widget informaOUT;
    private Enactor areaEnactor;
    private InformaService informaService;

    public MonitoramentoArea(Integer area) {

        areaIN = WidgetXmlParser.createWidget("Informa/area-widget-input_" + area.toString() + ".xml");
        areaIN.updateData("area", area);
        areaIN.updateData("indexPollution", -100);
        areaIN.updateData("vehicleFlow", -100);
        areaIN.updateData("directionWind", "norte");
        areaIN.updateData("willRain", -100);
        areaIN.updateData("noise", -100);
        areaIN.updateData("temperature", -300);
        areaIN.updateData("humidity", -100);
        areaIN.updateData("windSpeed", -100);
        areaIN.updateData("content", -100);
        areaIN.updateData("agentNearName", "agente 1");


        //OUT Widgets and Service
        informaOUT = WidgetXmlParser.createWidget("Informa/informa-widget-output.xml");

        informaService = new InformaService(informaOUT/*, monitor*/);
        informaOUT.addService(informaService);

        //Enactors
        areaEnactor = EnactorXmlParser.createEnactor("Informa/area-enactor_" + area.toString() + ".xml");

    }

    @Override
    public void atualizarQuantidadeLixo(Integer area, int content) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MonitoramentoArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        areaIN.updateData("content", content);
        System.out.println("atualizado quantidade de lixeira " + area + content);
    }

    @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
        areaIN.updateData("agentNearName", agentNearName);
    }

    @Override
    public void atualizarIndicePoluicao(Integer area, int indexPolluition) {
        areaIN.updateData("indexPollution", indexPolluition);
        System.out.println("atualizado indice de poluicao " + area + indexPolluition);
    }

    @Override
    public void atualizarFluxoDeVeiculos(Integer area, int vehicleFlow) {
        areaIN.updateData("vehicleFlow", vehicleFlow);
    }

    @Override
    public void atualizarVelociadeDoVento(Integer area, int windSpeed) {
        areaIN.updateData("windSpeed", windSpeed);
    }

    @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
        areaIN.updateData("directionWind", directionWind);
    }

    @Override
    public void atualizarProbalidadeChuva(Integer area, int willRain) {
        areaIN.updateData("willRain", willRain);
    }

    @Override
    public void atualizarQuantidadeRuido(Integer area, int noise) {
        areaIN.updateData("noise", noise);
    }

    @Override
    public void atualizarTemeperatura(Integer area, float temperature) {
        areaIN.updateData("temperature", temperature);
        System.out.println("atualizado temeperatura " + area + temperature);
    }

    @Override
    public void atualizarHumidade(Integer area, int humidity) {
        areaIN.updateData("humidity", humidity);
    }

    @Override
    public void atualizarIncidenciaDeIncendio(Integer area, boolean isFire) {
        areaIN.updateData("isFire", isFire);
    }

    @Override
    public void AddAtualizadoresWidgets(Integer area, AtualizarWidgets atualizarWidgetsArea) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
