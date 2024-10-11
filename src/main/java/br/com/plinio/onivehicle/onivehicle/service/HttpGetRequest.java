package br.com.plinio.onivehicle.onivehicle.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetRequest {
    private String vehicle;
    private String vehicleBrandCode;
    private String vehicleModelCode;
    private String vehicleYearsCode;
    private String getVehicleValue;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleYears;
    private String vehicleValue;

    public String getVehicleYearsCode() {
        return vehicleYearsCode;
    }

    public void setVehicleYearsCode(String vehicleYearsCode) {
        this.vehicleYearsCode = vehicleYearsCode;
        System.out.println(vehicleYearsCode);
    }

    public String getGetVehicleValue() {
        return getVehicleValue;
    }

    public void setGetVehicleValue(String getVehicleValue) {
        this.getVehicleValue = getVehicleValue;
        System.out.println(getVehicleValue);
    }

    public String getVehicleYears() {
        return vehicleYears;
    }

    public void setVehicleYears(String vehicleYears) {
        this.vehicleYears = vehicleYears;
        System.out.println(vehicleYears);
    }

    public String getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(String vehicleValue) {
        this.vehicleValue = vehicleValue;
        System.out.println(vehicleValue);
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
        System.out.println(vehicleBrand);
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
        System.out.println(vehicleModel);
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getVehicleBrandCode() {
        return vehicleBrandCode;
    }

    public String getVehicleModelCode() {
        return vehicleModelCode;
    }

    public void setVehicleModelCode(String vehicleModelCode) {
        this.vehicleModelCode = vehicleModelCode;
        System.out.println(vehicleModelCode);
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
        System.out.println(vehicle);
    }

    public void setVehicleBrandCode(String vehicleBrandCode) {
        this.vehicleBrandCode = vehicleBrandCode;
        System.out.println(vehicleBrandCode);
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
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/" + this.vehicle + "/marcas/" + this.vehicleBrandCode + "/modelos"))
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

    public String getVehicleModelData (){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas/" + vehicleBrandCode + "/modelos/" + vehicleModelCode + "/anos"))
                .build();
        HttpResponse<String> response = null;
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public String getVehicleYearData(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/" + vehicle + "/marcas/" + vehicleBrandCode + "/modelos/" + vehicleModelCode + "/anos/" + vehicleYearsCode))
                .build();
        HttpResponse<String> reponse = null;
        try{
            reponse = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return reponse.body();
    }


}