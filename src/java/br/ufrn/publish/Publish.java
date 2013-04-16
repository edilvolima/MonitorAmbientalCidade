/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.publish;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Jorge
 */
public class Publish {
    
    private Client client = Client.create();
    private static String URL_BASE_HUB = "http://127.0.0.1:8084/hub/";
    private String topico;

    public Publish(String topico) {
        this.topico = topico;
    }

    public String getTopico() {
        return topico;
    }
    
    protected void criarTopico(){
        WebResource resource = client.resource(URL_BASE_HUB+"register");
        resource.put(topico);
    }
    
    public void publicar(String mensagem){
        WebResource resource = client.resource(URL_BASE_HUB+"publish/"+topico);
        resource.put(mensagem);
    }
    
}
