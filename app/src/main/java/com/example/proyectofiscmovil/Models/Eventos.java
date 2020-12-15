package com.example.proyectofiscmovil.Models;

public class Eventos {

    private String fechaEvento,nombreCli,apellidoCli,ubicaciónEvento,horaInicioEvento,horaFinalevento;

    public Eventos(String fechaEvento, String horaInicioEvento, String horaFinalevento,String ubicaciónEvento,String nombreCli, String apellidoCli){
        this.fechaEvento = fechaEvento;
        this.ubicaciónEvento = ubicaciónEvento;
        this.horaInicioEvento = horaInicioEvento;
        this.horaFinalevento = horaFinalevento;
        this.nombreCli = nombreCli;
        this.apellidoCli = apellidoCli;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }


    public String getNombreCli() {
        return nombreCli;
    }

    public String getApellidoCli() {
        return apellidoCli;
    }



    public String getUbicaciónEvento() {
        return ubicaciónEvento;
    }



    public String getHoraInicioEvento() {
        return horaInicioEvento;
    }



    public String getHoraFinalevento() {
        return horaFinalevento;
    }





}
