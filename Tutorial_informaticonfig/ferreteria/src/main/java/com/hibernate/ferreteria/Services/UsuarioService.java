package com.hibernate.ferreteria.Services;

import com.hibernate.ferreteria.Repositorios.Repo_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private Repo_Usuario repoUsuario;


    @Override
    public UserDetails loadUserByUsername(String nombreUsuario)
            throws UsernameNotFoundException {
        var usuario = repoUsuario.findByUsername(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado" + nombreUsuario));

        return new User(usuario.getUsuario(), usuario.getPassword(),
                List.of(new SimpleGrantedAuthority("Role: " + usuario.getRol())));
    }



}
