package edu.eci.ieti.paquetes.services.Impl;

import edu.eci.ieti.paquetes.exception.PackageNotFoundException;
import edu.eci.ieti.paquetes.model.Package;
import edu.eci.ieti.paquetes.persistence.PackageRepository;
import edu.eci.ieti.paquetes.services.PackageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServicesImpl implements PackageServices {
    @Autowired
    PackageRepository packageRepository;


    @Override
    public List<Package> getAllPackage() {
        return packageRepository.findAll();
    }

    @Override
    public Optional<Package> getPackageById(String id) {
        return Optional.ofNullable(packageRepository.findById(id).orElseThrow(() -> new PackageNotFoundException(id)));
    }

    @Override
    public Optional<Package> createPackage(Package packages) {
        packageRepository.save(packages);
        return packageRepository.findById((packages.getId()));
    }

    @Override
    public Optional<Package> updatePackage(String id, Package packages) {
        if(!packageRepository.existsById(id)){
            throw new PackageNotFoundException(packages.getId());
        }else {
            Optional<Package> package1 = packageRepository.findById(id);
            package1.get().update(packages);
            packageRepository.save(package1.get());
        }
        return packageRepository.findById(id);
    }

    @Override
    public void deletePackage(String id) {
        if(!packageRepository.existsById(id)){
            throw new PackageNotFoundException(id);
        }else {
            Optional<Package> packages = packageRepository.findById(id);
            packageRepository.delete(packages.get());
        }

    }

    @Override
    public Optional<Package> addNewPlacePackage(String id, String place) {
        Package p = this.getPackageById(id).orElseThrow();
        p.addNewPlace(place);
        this.updatePackage(id, p);
        return packageRepository.findById(id);
    }

    @Override
    public Optional<Package> deletePlacePackage(String id, String place) {
        Package p = this.getPackageById(id).orElseThrow();
        p.removePlace(place);
        this.updatePackage(id, p);
        return packageRepository.findById(id);
    }

    @Override
    public Optional<Package> createTrabi(String name, Package trabi) {
        packageRepository.save(trabi);
        return Optional.empty();
    }
}
