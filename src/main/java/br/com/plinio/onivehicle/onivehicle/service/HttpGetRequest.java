package br.com.plinio.onivehicle.onivehicle.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetRequest {
    private String vehicle;
    private int vehicleBrand;

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
        System.out.println(vehicle);
    }

    public void setVehicleBrand(int vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
        System.out.println(vehicleBrand);
    }

    public String getVehicleData (){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/" + this.vehicle + "/marcas"))
                .build();

        HttpResponse <String> response = null;
        try {

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e){

            System.out.println("por que está dando erro?");

            throw new RuntimeException(e);
        }

        return response.body();
    }

    public String getVehicleBrandData (){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas/" + vehicleBrand + "/modelos"))
                .build();
        HttpResponse <String> response = null;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}