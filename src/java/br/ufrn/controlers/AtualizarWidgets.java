/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controlers;

import javax.ws.rs.PathParam;

/**
 *
 * @author Jorge
 */
public interface AtualizarWidgets {

    public void AddAtualizadoresWidgets(Integer area, AtualizarWidgets atualizarWidgetsArea);
    //=====PollutionWidget=====
    public void atualizarIndicePoluicao(Integer area, int indexPolluition);

    public void atualizarFluxoDeVeiculos(Integer area, int vehicleFlow);

    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    public void atualizarVelociadeDoVento(Integer area, int windSpeed);

    public void atualizardirecaoDoVento(Integer area, String directionWind);

    public void atualizarProbalidadeChuva(Integer area, int willRain);

    public void atualizarQuantidadeRuido(Integer area, int noise);

    //======TemperatureWidget=====
    public void atualizarTemeperatura(Integer area, int temperature);

    public void atualizarHumidade(Integer area, int humidity);

    public void atualizarIncidenciaDeIncendio(Integer area, boolean isFire);

    //=====DumpWidget===
    public void atualizarQuantidadeLixo(Integer area, int trash);

    public void atualizarAgenteProximo(Integer area, String agentNearName);
}
