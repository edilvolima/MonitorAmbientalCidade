package br.ufrn.controlers;

import br.ufrn.services.MonitoramentoArea;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class ConcreteAtualizarWidgets implements AtualizarWidgets{
    
   private HashMap<Integer, AtualizarWidgets> areaWdgets = new HashMap<Integer, AtualizarWidgets>();
   
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
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition) {
        
        AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarIndicePoluicao(area, indexPolluition);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow) {
         AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarFluxoDeVeiculos(area, vehicleFlow);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

     //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
   @Override
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed) {
        AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarVelociadeDoVento(area, windSpeed);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
        
    }

   @Override
    public void atualizardirecaoDoVento(Integer area, String directionWind) {
       AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizardirecaoDoVento(area, directionWind);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
        
    }

   @Override
    public void atualizarProbalidadeChuva(Integer area, Integer willRain) {
       AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarProbalidadeChuva(area, willRain);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarQuantidadeRuido(Integer area, Integer noise) {
        AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarQuantidadeLixo(area, noise);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //======TemperatureWidget=====
    
   @Override
    public void atualizarTemeperatura(Integer area, Integer temperature) {
        AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarTemeperatura(area, temperature);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarHumidade(Integer area, Integer humidity) {
      AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarHumidade(area, humidity);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void atualizarIncidenciaDeIncendio(Integer area, boolean isFire) {
       AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarIncidenciaDeIncendio(area, isFire);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

    //=====DumpWidget===
    
   @Override
    public void atualizarQuantidadeLixo(Integer area, Integer content) {
        AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarQuantidadeLixo(area, content);
        }else{
            System.out.println("não existe um areawidget associado à area "+area);
        }
    }

   @Override
    public void atualizarAgenteProximo(Integer area, String agentNearName) {
      AtualizarWidgets atualizar = areaWdgets.get(area);
        
        if(atualizar != null){
            atualizar.atualizarAgenteProximo(area, agentNearName);
        }else{
            System.out.println("não existe um pollution widget associado à area "+area);
        }
    }

   @Override
    public void AddAtualizadoresWidgets(Integer area, AtualizarWidgets atualizarWidgetsArea) {
        
        areaWdgets.put(area, atualizarWidgetsArea);
        
    }

   
    
}
