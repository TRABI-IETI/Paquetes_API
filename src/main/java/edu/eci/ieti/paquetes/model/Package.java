package edu.eci.ieti.paquetes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "package_collection")
public class Package {
    @Id
    private String id;
    private String name;
    private ArrayList<String> places = new ArrayList<>();
    private float price;
    private String description;
    private String duration;
    private String idUsuario;

    public Package() {
    }

    public Package(String id, String name, ArrayList<String> places, float price, String description, String duration, String idUsuario) {
        this.id = id;
        this.name = name;
        this.places = places;
        this.price = price;
        this.description = description;
        this.duration = duration;
        this.idUsuario = idUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void update(Package packages){
        this.name = packages.getName();
        this.price = packages.getPrice();
        this.description = packages.getDescription();
        this.duration = packages.getDuration();
        this.places = packages.getPlaces();
    }

    public void addNewPlace(String name) {
        places.add(name);
    }

    public void removePlace(String place) {
        places.remove(place);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
