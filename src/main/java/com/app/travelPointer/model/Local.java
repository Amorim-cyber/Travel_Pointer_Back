package com.app.travelPointer.model;

import javax.persistence.*;

@Entity
@Table(name = "t_local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cd_local")
    private Long cdLocal;

    @Column(name = "nm_local")
    private String nmLocal;

    @Column(name = "end_local")
    private String endLocal;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cd_usuario")
    private Long cdUsuario;

    public Long getCdLocal() {
        return cdLocal;
    }

    public void setCdLocal(Long cdLocal) {
        this.cdLocal = cdLocal;
    }

    public String getNmLocal() {
        return nmLocal;
    }

    public void setNmLocal(String nmLocal) {
        this.nmLocal = nmLocal;
    }

    public String getEndLocal() {
        return endLocal;
    }

    public void setEndLocal(String endLocal) {
        this.endLocal = endLocal;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Long cdUsuario) {
        this.cdUsuario = cdUsuario;
    }
}
