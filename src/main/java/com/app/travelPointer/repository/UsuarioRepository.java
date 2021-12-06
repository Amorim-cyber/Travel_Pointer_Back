package com.app.travelPointer.repository;

import com.app.travelPointer.model.Local;
import com.app.travelPointer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findCdUsuarioAndLoginAndSenha(Long cdUsuario, String login, String senha);

    @Query("SELECT usuario "+
            "FROM Usuario usuario "+
            "WHERE usuario.cdUsuario = :cdUsuario AND usuario.login = :login AND usuario.senha <> :senha ")
    Optional<Local>findByUsuarioUpdate(Long cdUsuario, String login, String senha);

    Optional<Usuario> findByLogin(String login);

    Optional<Usuario> findBySenha(String senha);

}
