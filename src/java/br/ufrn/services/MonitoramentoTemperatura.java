package br.ufrn.services;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarTemperatureWidget;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.storage.Attributes;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;


public class MonitoramentoTemperatura implements AtualizarTemperatureWidget{
	
	protected Widget temperatureIN;
		
	protected Widget informaOUT;

	protected Enactor enactorTemperature;
		
	protected InformaService informaService;
	

	public MonitoramentoTemperatura(Integer area/*, MonitorCidade monitor*/) {
		
		//IN Widgets
		temperatureIN = WidgetXmlParser.createWidget("Informa/temperature-widget-input.xml");
                temperatureIN.updateData("area", area);
                temperatureIN.setId("area "+area);
                       
                
		//OUT Widgets and Service
		informaOUT = WidgetXmlParser.createWidget("Informa/informa-widget-output.xml");
                informaOUT.setId("area "+area);
                            
		informaService = new InformaService(informaOUT/*, monitor*/);
		informaOUT.addService(informaService);
		
		//Enactors
		enactorTemperature = EnactorXmlParser.createEnactor("Informa/temperature-enactor.xml");
                enactorTemperature.setId("area "+area);
	}

    @Override
    public void atualizarTemeperatura(Integer area, int temperature) {
        temperatureIN.updateData("temperature", temperature);
        System.out.println("atualizado temeperatura "+area+temperature);
    }

    @Override
    public void atualizarHumidade(Integer area, int humidity) {
        temperatureIN.updateData("humidity", humidity);
    }

    @Override
    public void atualizarIncidenciaDeIncendio(Integer area, boolean isFire) {
        temperatureIN.updateData("isFire", isFire);
    }

    @Override
    public void atualizarVelociadeDoVento(Integer area, int windSpeed) {
        temperatureIN.updateData("windSpeed", windSpeed);
    }
	
}
	