package com.services.admin_nation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrondissementRepository extends JpaRepository<Arrondissement, String> {

}
