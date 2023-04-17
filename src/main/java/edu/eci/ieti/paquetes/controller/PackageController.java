package edu.eci.ieti.paquetes.controller;

import edu.eci.ieti.paquetes.model.Package;
import edu.eci.ieti.paquetes.services.PackageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/packages")
public class PackageController {

    PackageServices packageServices;
    public PackageController(@Autowired PackageServices packageServices){
        this.packageServices = packageServices;
    }

    @GetMapping
    public ResponseEntity<?> getAllPackages(){
        return ResponseEntity.ok(packageServices.getAllPackage());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPackageById(@PathVariable("id") String id){
        return ResponseEntity.ok(packageServices.getPackageById(id));
    }

    @PostMapping
    public ResponseEntity<?> createPackage(@RequestBody Package packages){
        return ResponseEntity.ok(packageServices.createPackage(packages));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updatePackage(@RequestBody Package packages, @PathVariable("id") String id){
        return ResponseEntity.ok(packageServices.updatePackage(id, packages));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePackage(@PathVariable("id") String id){
        packageServices.deletePackage(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{id}/{place}")
    public ResponseEntity<?> addNewPlacePackage(@PathVariable("id") String id, @PathVariable("place") String place){
        return ResponseEntity.ok(packageServices.addNewPlacePackage(id, place));

    }

    @DeleteMapping("{id}/{place}")
    public ResponseEntity<?> deletePlacePackage(@PathVariable("id") String id, @PathVariable("place") String place){
        return ResponseEntity.ok(packageServices.deletePlacePackage(id, place));
    }



}
