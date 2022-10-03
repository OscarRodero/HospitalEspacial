object Factoria {
    fun GenerarPaciente():Paciente{
        var x = (1..3).random()
        var Compañia:String=""
        var AttReq:String=""
        var Priority:Int=(1..3).random()
        var P = Paciente(Paciente.AsignarNIDI(), "StormTrooper"+Paciente.AsignarNIDI(), GenerarCompañiaSeguros(), GenerarAtencion(x), Priority)
        return P
    }

    fun GenerarSala(x: Int): Sala_de_Espera {
        var MiSala= Sala_de_Espera(x)
        return MiSala
    }
    fun GenerarCompañiaSeguros():String{
        var x = (1..3).random()
        var Compañia:String=""
        when(x){
            1 -> Compañia="Sanitroopers"
            2 -> Compañia="Vaderslas"
            3 -> Compañia="Yodacare"
        }
        return Compañia
    }
    fun GenerarAtencion(x: Int):String{
        var AttReq:String=""
        when(x){
            1 -> AttReq="Quemadura Láser"
            2 -> AttReq="Impacto chorritrónico"
            3 -> AttReq="Otros"
        }
        return AttReq
    }

    fun GenerarTraumatologo(): Sanitario {
        var x = Traumatologo(1, "a")
        return x
    }

    fun GenerarMedicoInterno(): Sanitario {
        var x = Internista(1, "a")
        return x
    }

    fun GenerarRegistro(paciente: Paciente, sanitario: Sanitario, turno: Char): Registro {
        var NuevoRegistro = Registro(paciente, sanitario, turno)
        return NuevoRegistro
    }
}