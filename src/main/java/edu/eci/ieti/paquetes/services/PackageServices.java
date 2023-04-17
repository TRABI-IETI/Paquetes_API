package edu.eci.ieti.paquetes.services;

import edu.eci.ieti.paquetes.model.Package;
import java.util.List;
import java.util.Optional;

public interface PackageServices {
    List<Package> getAllPackage();

    Optional<Package> getPackageById(String id);

    Optional<Package> createPackage(Package packages);

    Optional<Package> updatePackage(String id, Package packages);

    void deletePackage(String id);

    Optional<Package> addNewPlacePackage(String id, String place);

    Optional<Package> deletePlacePackage(String id, String place);

    Optional<Package> createTrabi(String name, Package trabi);
}
