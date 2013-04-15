package br.ufrn.services;

import br.ufrn.GUI.MonitorCidade;
import br.ufrn.controlers.AtualizarDumpWidget;
import context.arch.enactor.Enactor;
import context.arch.enactor.EnactorXmlParser;
import context.arch.storage.Attributes;
import context.arch.widget.Widget;
import context.arch.widget.WidgetXmlParser;


public class MonitoramentoLixeira implements AtualizarDumpWidget{
	
	protected Widget dumpIN;
	
	protected Widget informaOUT;

	protected Enactor enactorDump;
	
	protected InformaService informaService;
	

	public MonitoramentoLixeira(Integer area/*, MonitorCidade monitor*/) {
		
//                                         
		//IN Widgets
		dumpIN = WidgetXmlParser.createWidget("Informa/dump-widget-input.xml");
                dumpIN.updateData("enableNotificatons", false);
                dumpIN.updateData("area", area);
                dumpIN.updateData("agentNearName", "agente 1");
                dumpIN.setId(Integer.toString(area));
                        
                
		//OUT Widgets and Service
		informaOUT = WidgetXmlParser.createWidget("Informa/informa-widget-output.xml");
                            
                            
		informaService = new InformaService(informaOUT/*, monitor*/);
		informaOUT.addService(informaService);
		
		//Enactors
		enactorDump = EnactorXmlParser.createEnactor("Informa/dump-enactor.xml");
                            

	}

    @Override
    public void atualizarQuantidadeLixo(Integer area, int content) {
//        String id = dumpIN.getId();
//        if(Integer.parseInt(id) == area){
            dumpIN.updateData("content", content);
            dumpIN.updateData("enableNotificatons", true);
            dumpIN.updateData("enableNotificatons", false);
            System.out.println("atualizado quantidade de lixeira "+area+content);
//        }
            
    }

    @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
         //if(dumpIN.getNonConstantAttributeValue("area")) {
            dumpIN.updateData("agentNearName", agentNearName);
        //}
    }
	
}
	