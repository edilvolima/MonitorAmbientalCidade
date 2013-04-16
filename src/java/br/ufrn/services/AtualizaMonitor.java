/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.services;

/**
 *
 * @author Zeff
 */
public interface AtualizaMonitor {
    
    //Atualiza icones sobre poluicao
    public void atualizaNivelPoluicao(Integer area, String levelPollution);

    public void atualizaFluxoVeiculos(Integer area, String vehicleFlow);

    public void atualizaProbabilidaDeChuva(Integer area, String willRain);

    public void atualizaChuvaAcida(Integer area, String localAcidRain, String directionWind);

    public void atualizaQuantidadeRuido(Integer area, String noise, Integer db);

    //atualiza icones sobre temperatura
    public void atualizaTemperatura(Integer area, Integer temperature);

    public void atualizaClimaBom(Integer area, boolean clima);

    public void atualizaIncidenciaDeIncendio(Integer area, boolean isFire);

    public void atualizaClimaQuenteESeco(Integer area, boolean hotDry);

    //atualizar icones sobre o lixo
    public void atualizaQuantidadeLixo(Integer area, String content);

    public void atualizaAgenteProximo(Integer area, String status, String agentNearName);
}
