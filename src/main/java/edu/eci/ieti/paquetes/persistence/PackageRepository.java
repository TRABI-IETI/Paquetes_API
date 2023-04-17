package edu.eci.ieti.paquetes.persistence;

import edu.eci.ieti.paquetes.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends MongoRepository<Package, String> {
}
