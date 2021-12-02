package com.app.travelPointer.model.dto;

import javax.validation.constraints.NotNull;

public class LocalDTO {

    private Long cdLocal;

    @NotNull
    private String nmLocal;

    @NotNull
    private String endLocal;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;

    @NotNull
    private String tipo;

    @NotNull
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
