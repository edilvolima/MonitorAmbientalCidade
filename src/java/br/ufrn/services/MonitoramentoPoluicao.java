package br.ufrn.services;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarPollutionWidget;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.storage.Attributes;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;


public class MonitoramentoPoluicao implements AtualizarPollutionWidget{
	
	protected Widget pollutionIN;
	
	protected Widget informaOUT;

	protected Enactor enactorPollution;
		
	protected InformaService informaService;
	

	public MonitoramentoPoluicao(Integer area/*, MonitorCidade monitor*/) {
//		
		//IN Widgets
		pollutionIN = WidgetXmlParser.createWidget("Informa/pollution-widget-input.xml");
                pollutionIN.updateData("area", area);
                pollutionIN.setId("area "+area);
                
		//OUT Widgets and Service
		informaOUT = WidgetXmlParser.createWidget("Informa/informa-widget-output.xml");
                informaOUT.setId("area "+area);
                            
		informaService = new InformaService(informaOUT/*, monitor*/);
		informaOUT.addService(informaService);
		
		//Enactors
		enactorPollution = EnactorXmlParser.createEnactor("Informa/pollution-enactor.xml");
                enactorPollution.setId("area "+area);
		
	}

    @Override
    public void atualizarIndicePoluicao(Integer area, int indexPolluition) {
        pollutionIN.updateData("indexPollution", indexPolluition);
        System.out.println("atualizado indice de poluicao "+area+indexPolluition);
    }

    @Override
    public void atualizarFluxoDeVeiculos(Integer area, int vehicleFlow) {
        pollutionIN.updateData("vehicleFlow", vehicleFlow);
    }

    @Override
    public void atualizarVelociadeDoVento(Integer area, int windSpeed) {
        pollutionIN.updateData("windSpeed", windSpeed);
    }

    @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
        pollutionIN.updateData("directionWind", directionWind);
    }

    @Override
    public void atualizarProbalidadeChuva(Integer area, int willRain) {
        pollutionIN.updateData("willRain", willRain);
    }

    @Override
    public void atualizarQuantidadeRuido(Integer area, int noise) {
        pollutionIN.updateData("noise", noise);
    }
	
}
	