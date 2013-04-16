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
    public void atualizarIndicePoluicao(Integer area, Integer indexPolluition);

    public void atualizarFluxoDeVeiculos(Integer area, Integer vehicleFlow);

    //este metodo deve atualizar o PollutionWidget e o TemperatureWidget
    public void atualizarVelociadeDoVento(Integer area, Integer windSpeed);

    public void atualizardirecaoDoVento(Integer area, String directionWind);

    public void atualizarProbalidadeChuva(Integer area, Integer willRain);

    public void atualizarQuantidadeRuido(Integer area, Integer noise);

    //======TemperatureWidget=====
    public void atualizarTemeperatura(Integer area, Integer temperature);

    public void atualizarHumidade(Integer area, Integer humidity);

    public void atualizarIncidenciaDeIncendio(Integer area, boolean isFire);

    //=====DumpWidget===
    public void atualizarQuantidadeLixo(Integer area, Integer trash);

    public void atualizarAgenteProximo(Integer area, String agentNearName);
}
