object Factoria {
    fun GenerarPaciente():Paciente{ //Función que genera un paciente.
        var x = (1..3).random()
        var Compañia:String=""
        var AttReq:String=""
        var Priority:Int=(1..3).random()
        var P = Paciente(Paciente.AsignarNIDI(), "StormTrooper"+Paciente.AsignarNIDI(), GenerarCompañiaSeguros(), GenerarAtencion(x), Priority)
        return P
    }

    fun GenerarSala(x: Int): Sala_de_Espera { //Función que genera una sala de espera.
        var MiSala= Sala_de_Espera(x)
        return MiSala
    }
    fun GenerarCompañiaSeguros():String{ //Función que genera una compañia de seguros aleatoria
        var x = (1..3).random()
        var Compañia:String=""
        when(x){
            1 -> Compañia="Sanitroopers"
            2 -> Compañia="Vaderslas"
            3 -> Compañia="Yodacare"
        }
        return Compañia
    }
    fun GenerarAtencion(x: Int):String{ //Función que genera un dolor aleatorio para el paciente.
        var AttReq:String=""
        when(x){
            1 -> AttReq="Quemadura Láser"
            2 -> AttReq="Impacto chorritrónico"
            3 -> AttReq="Otros"
        }
        return AttReq
    }

    fun GenerarTraumatologo(turno: Char): Sanitario { //Función que crea un Traumatólogo. (Traumatólogo hereda de Sanitario)
        var nidi = Traumatologo.AsignarNIDI()
        var x = Traumatologo(nidi, "Traumatólogo: "+nidi, turno, GenerarCompañiaSeguros())
        return x
    }

    fun GenerarMedicoInterno(turno: Char): Sanitario { //Función que crea un Internista. (Internista hereda de Sanitario)
        var nidi = Internista.AsignarNIDI()
        var x = Traumatologo(nidi, "Traumatólogo: "+nidi, turno, GenerarCompañiaSeguros())
        return x
    }

    fun GenerarRegistro(paciente: Paciente, sanitario: Sanitario, turno: Char): Registro { //Función que genera un nuevo registro con los parámetros otorgados.
        var NuevoRegistro = Registro(paciente, sanitario, turno)
        return NuevoRegistro
    }
}