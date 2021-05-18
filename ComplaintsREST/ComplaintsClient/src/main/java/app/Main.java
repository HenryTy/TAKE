/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author PIOTREK
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String allComplaints = client.target("http://localhost:8080/Complaints/resources/complaints")
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        System.out.println("Wszystkie skargi: " + allComplaints);
        
        String complaint = client.target("http://localhost:8080/Complaints/resources/complaints/352")
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        System.out.println("Jedna z otwartych skarg: " + complaint);
        
        complaint = complaint.replace("\"status\":\"open\"", "\"status\":\"closed\"");
        
        Response response = client.target("http://localhost:8080/Complaints/resources/complaints/352")
                        .request(MediaType.APPLICATION_JSON)
                        .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));
        
        System.out.println(response.getStatus());
        
        String openComplaints = client.target("http://localhost:8080/Complaints/resources/complaints?status=open")
                        .request(MediaType.APPLICATION_JSON)
                        .get(String.class);
        System.out.println("Otwarte skargi: " + openComplaints);
        client.close();
    }

}
