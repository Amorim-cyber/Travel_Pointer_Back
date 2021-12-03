package com.app.travelPointer.repository;

import com.app.travelPointer.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {

    Optional<Local> findByCdUsuarioAndEndLocal(Long cdUsuario, String endLocal);

    @Query("SELECT local "+
            "FROM Local local "+
            "WHERE local.cdUsuario = :cdUsuario AND local.endLocal = :endLocal AND local.cdLocal <> :cdLocal ")
    Optional<Local>findByLocalUpdate(Long cdUsuario, String endLocal, Long cdLocal);

    @Query("SELECT local "+
            "FROM Local local "+
            "WHERE local.cdUsuario = :cdUsuario")

    Optional<List<Local>> findByCdUsuario(Long cdUsuario);
}
