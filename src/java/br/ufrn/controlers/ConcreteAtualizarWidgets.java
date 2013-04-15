package br.ufrn.controlers;

import java.util.HashMap;

/**
 *
 * @author Jorge
 */
public class ConcreteAtualizarWidgets implements AtualizarWidgets{
    
   private HashMap<Integer, AtualizarDumpWidget> dumpWdgets = new HashMap<Integer, AtualizarDumpWidget>();
   private HashMap<Integer, AtualizarPollutionWidget> pollutionWidgets = new HashMap<Integer, AtualizarPollutionWidget>();
   private HashMap<Integer, AtualizarTemperatureWidget> temperatureWidgets = new HashMap<Integer, AtualizarTemperatureWidget>();
    
   private static ConcreteAtualizarWidgets atualizarWidgets;
   
   public static ConcreteAtualizarWidgets getInstance(){
       
       if(atualizarWidgets == null){
           atualizarWidgets = new ConcreteAtualizarWidgets();
       }
       return atualizarWidgets;
   }
   
   public ConcreteAtualizarWidgets() {
    }
    
     //=====PollutionWidget=====
    
   @Override
    public void atualizarIndicePoluicao(Integer area, int indexPolluition) {
        
        AtualizarPollutionWidget pollutionWidget = pollutionWidgets.get(area);
        
        if(pollutionWidget != null){
            pollutionWidget.atualizarIndicePoluicao(area, indexPolluition);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarFluxoDeVeiculos(Integer area, int vehicleFlow) {
         AtualizarPollutionWidget pollutionWidget = pollutionWidgets.get(area);
        
        if(pollutionWidget != null){
            pollutionWidget.atualizarFluxoDeVeiculos(area, vehicleFlow);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

     //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
   @Override
    public void atualizarVelociadeDoVento(Integer area, int windSpeed) {
        AtualizarPollutionWidget pollutionWidget = pollutionWidgets.get(area);
        
        if(pollutionWidget != null){
            pollutionWidget.atualizarVelociadeDoVento(area, windSpeed);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
        
        
        AtualizarTemperatureWidget temperatureWidget = temperatureWidgets.get(area);
        
        if(temperatureWidget != null){
            temperatureWidget.atualizarVelociadeDoVento(area, windSpeed);
        }
        else{
            System.out.println("não existe um temperature widget associado à area "+area);
        }
        
    }

   @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
        AtualizarPollutionWidget pollutionWidget = pollutionWidgets.get(area);
        
        if(pollutionWidget != null){
            pollutionWidget.atualizardirecaoDoVento(area, directionWind);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
        
    }

   @Override
    public void atualizarProbalidadeChuva(Integer area, int willRain) {
        AtualizarPollutionWidget pollutionWidget = pollutionWidgets.get(area);
        
        if(pollutionWidget != null){
            pollutionWidget.atualizarProbalidadeChuva(area, willRain);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarQuantidadeRuido(Integer area, int noise) {
        AtualizarPollutionWidget pollutionWidget = pollutionWidgets.get(area);
        
        if(pollutionWidget != null){
            pollutionWidget.atualizarQuantidadeRuido(area, noise);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //======TemperatureWidget=====
    
   @Override
    public void atualizarTemeperatura(Integer area, int temperature) {
        AtualizarTemperatureWidget temperatureWidget = temperatureWidgets.get(area);
        
        if(temperatureWidget != null){
            temperatureWidget.atualizarTemeperatura(area, temperature);
        }
        else{
            System.out.println("não existe um temperature widget associado à area "+area);
        }
    }

   @Override
    public void atualizarHumidade(Integer area, int humidity) {
        AtualizarTemperatureWidget temperatureWidget = temperatureWidgets.get(area);
        
        if(temperatureWidget != null){
            temperatureWidget.atualizarHumidade(area, humidity);
        }
        else{
            System.out.println("não existe um temperature widget associado à area "+area);
        }
    }

   @Override
    public void atualizarIncidenciaDeIncendio(Integer area, boolean isFire) {
        AtualizarTemperatureWidget temperatureWidget = temperatureWidgets.get(area);
        
        if(temperatureWidget != null){
            temperatureWidget.atualizarIncidenciaDeIncendio(area, isFire);
        }
        else{
            System.out.println("não existe um temperature widget associado à area "+area);
        }
    }

    //=====DumpWidget===
    
   @Override
    public void atualizarQuantidadeLixo(Integer area, int content) {
        AtualizarDumpWidget dumpWidget = dumpWdgets.get(area);
       
        if(dumpWidget != null){
            dumpWidget.atualizarQuantidadeLixo(area, content);
        }
        else{
            System.out.println("não existe um dump widget associado à area "+area);
        }
    }

   @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
        AtualizarDumpWidget dumpWidget = dumpWdgets.get(area);
        
        if(dumpWidget != null){
            dumpWidget.atualizarAgenteProximo(area, agentNearName);
        }
        else{
            System.out.println("não existe um dump widget associado à area "+area);
        }
    }

   @Override
    public void AddAtualizadoresWidgets(Integer area, AtualizarDumpWidget dumpWidget,
            AtualizarPollutionWidget pollutionWidget, AtualizarTemperatureWidget temperatureWidget) {
        
        dumpWdgets.put(area, dumpWidget);
        pollutionWidgets.put(area, pollutionWidget);
        temperatureWidgets.put(area, temperatureWidget);
        
    }

   
    
}
