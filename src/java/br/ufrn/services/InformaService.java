/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

//import br.ufrn.interfaces.AtualizacoesLixeira;
import br.ufrn.GUI.MonitorCidade;
import context.arch.comm.DataObject;
import context.arch.service.Service;
import context.arch.service.helper.FunctionDescription;
import context.arch.service.helper.FunctionDescriptions;
import context.arch.service.helper.ServiceInput;
import context.arch.widget.Widget;


public class InformaService extends Service {
    
    public static final String SERVICE = "informaService";
	
    public static final String POLLUTION = "pollutionMonitor";
    public static final String WILL_RAIN = "willRainMonitor";
    public static final String ACID_RAIN = "acidRainMonitor";
    public static final String NOISE = "noiseMonitor";
    public static final String TEMPERATURE = "temperatureMonitor";
    public static final String BEATIFUL_WEATHER = "beautifulWeatherMonitor";
    public static final String IS_FIRE = "isFireMonitor";
    public static final String HOT_DRY = "hotDryMonitor";
    public static final String TRASH = "trashMonitor";
    public static final String GATHERING = "trashGathering";
    
    private MonitorCidade cidade = MonitorCidade.getInstance();
    
       
            @SuppressWarnings("serial")
            public InformaService(final Widget widget) {
                    super(widget, SERVICE,
                                    new FunctionDescriptions() {
                            { // constructor
                                    // POLLUTION FUNCTIONS
                                    add(new FunctionDescription(
                                                    POLLUTION, 
                                                    "avisa sobre o nível de poluição.", 
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                    add(new FunctionDescription(
                                                    WILL_RAIN, 
                                                    "avisa sobre o nível de poluição.", 
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                    add(new FunctionDescription(
                                                    ACID_RAIN,
                                                    "avisa sobre possibilidade de chuva acida.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    NOISE,
                                                    "avisa sobre barulhos muito altos em faixas de horários proibidos.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   // TEMPERATURE FUNCTIONS
                                   add(new FunctionDescription(
                                                    TEMPERATURE,
                                                    "mostra a temperatura.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    BEATIFUL_WEATHER,
                                                    "mostra a temperatura aparente (sensação térmica).",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    IS_FIRE,
                                                    "avisa se existe algum incêndios.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   add(new FunctionDescription(
                                                    HOT_DRY,
                                                    "chama o service de coleta.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                                   // DUMP FUNCTIONS
                                   add(new FunctionDescription(
                                                    TRASH,
                                                    "mostra o nível de lixo da lixeira e avisa quando a lixeira esta bem próxima de encher.",
                                                    widget.getNonConstantAttributes()));//,
                                                    //FunctionDescription.FUNCTION_ASYNC));
                                   add(new FunctionDescription(
                                                    GATHERING,
                                                    "chama um agente de coleta mais próximo.",
                                                    widget.getNonConstantAttributes(),
                                                    FunctionDescription.FUNCTION_SYNC));
                            }
                    });

            }

            @Override
             public DataObject execute(ServiceInput serviceInput) {
                    
                   String functionName = serviceInput.getFunctionName(); 
                    
                    /**
                     *POLLUTION FUNCTIONS
                     */
                                       
                    //Index Pollution
                    if (functionName.equals(POLLUTION)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresP[] = context.split(";");

                        if (valoresP[2].equals("TRAFEGO_ON")) {
                            cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                        else if (valoresP[2].equals("TRAFEGO_OFF")){
                            cidade.atualizaFluxoVeiculos(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                        else {
                            cidade.atualizaNivelPoluicao(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                            
                    }   
                   
                    //Will Rain
                    else if (functionName.equals(WILL_RAIN)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresP[] = context.split(";");
                        
                        if (valoresP[2].equals("RAIN_ON")) {
                            cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                        else if (valoresP[2].equals("RAIN_OFF")){
                            cidade.atualizaProbabilidaDeChuva(Integer.parseInt(valoresP[0]), valoresP[2]);
                        }
                        
                    }
                    
                    //Acid Rain
                    else if (functionName.equals(ACID_RAIN)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresP[] = context.split(";");
                                                
                        if (valoresP[2].equals("AQUI")) {
                            cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], null);
                        }else if (valoresP[2].equals("OUTRO")) {
                            cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], valoresP[3]);
                        }else if (valoresP[2].equals("ACID_OFF")) {
                            cidade.atualizaChuvaAcida(Integer.parseInt(valoresP[0]), valoresP[2], null);
                        }
                    }
                    
                    //Noise
                    else if (functionName.equals(NOISE)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresP[] = context.split(";");
                        
                        cidade.atualizaQuantidadeRuido(Integer.parseInt(valoresP[0]),valoresP[2], Integer.parseInt(valoresP[3]));                  
                    }
                    
                    /**
                     *TEMPERATURE FUNCTIONS
                     */      
                    
                    // Temperature
                    else if (functionName.equals(TEMPERATURE)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresT[] = context.split(";");
                        
                        cidade.atualizaTemperatura(Integer.parseInt(valoresT[0]), Integer.parseInt(valoresT[2]));
                    }
                    
                    // beautiful Weather
                    else if (functionName.equals(BEATIFUL_WEATHER)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresT[] = context.split(";");
                        
                        if(valoresT[2].equals("BEAUTIFUL_ON")) {
                            cidade.atualizaClimaBom(Integer.parseInt(valoresT[0]), true);                       
                        }
                        else if(valoresT[2].equals("BEAUTIFUL_OFF")) {
                            cidade.atualizaClimaBom(Integer.parseInt(valoresT[0]), false);                       
                        }
                        
                    }
                    
                    //is fire?
                    else if (functionName.equals(IS_FIRE)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresT[] = context.split(";");
                        
                        if(valoresT[2].equals("FIRE_ON")) {
                            cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresT[0]), true); 
                        }
                        else if(valoresT[2].equals("FIRE_OFF")) {
                            cidade.atualizaIncidenciaDeIncendio(Integer.parseInt(valoresT[0]), false); 
                        }
                    }
                    
                    // Hot and dry weather
                    else if (functionName.equals(HOT_DRY)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresT[] = context.split(";");
                        
                        if(valoresT[2].equals("HOTDRY_ON")) {
                            cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresT[0]), true); 
                        }
                        else if(valoresT[2].equals("HOTDRY_OFF")) {
                            cidade.atualizaClimaQuenteESeco(Integer.parseInt(valoresT[0]), false); 
                        }
                        
                    }
                    
                    /**
                     *DUMP FUNCTIONS
                     */      
                    
//                     Dump situation
                    
                    else if (functionName.equals(TRASH)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresD[] = context.split(";");
                        System.out.println(context);
                                               
                        if (valoresD[2].equals("VAZIA")) {
                            cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]), valoresD[2]);   
                            System.out.println("usando funcao do servico para "+valoresD[1]+" da area "+valoresD[0]);
                        }else if (valoresD[2].equals("ENCHENDO")) {
                            cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]),valoresD[2]);   
                            System.out.println("usando funcao do servico para "+valoresD[1]+" da area "+valoresD[0]);
                        }else if (valoresD[2].equals("CHEIA")) {
                            cidade.atualizaQuantidadeLixo(Integer.parseInt(valoresD[0]),valoresD[2]);  
                            System.out.println("usando funcao do servico para "+valoresD[1]+" da area "+valoresD[0]);
                        }                      
                    }
                    // alerts you when is borderline calls and agent catcher.
                    else if (functionName.equals(GATHERING)) {
                        String context = serviceInput.getInput().getAttributeValue("area");
                        String valoresD[] = context.split(";");
                        System.out.println(context);
                                                
                        if (valoresD[2].equals("LIMITE")) {
                            cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]),valoresD[2], null);
                            //System.out.println("usando funcao do servico para"+valoresD[1]+"da area"+valoresD[0]);
                        }else if (valoresD[2].equals("CHEIA")) {
                            cidade.atualizaAgenteProximo(Integer.parseInt(valoresD[0]),valoresD[2], valoresD[3]);
                            //System.out.println("usando funcao do servico para"+valoresD[1]+"da area"+valoresD[0]);
                        }                                             
                    }
                    
                    return null;
                    //return new DataObject();

            }
}

