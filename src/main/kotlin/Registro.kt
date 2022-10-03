class Registro (var PacienteAtendido:Paciente, var MédicoResponsable:Sanitario?, var Turno:Char){
    override fun toString(): String {
        var x = {"Paciente atendido: "+this.PacienteAtendido.NIDI+" Médico Responsable: "+MédicoResponsable+" Turno: "+Turno}
        if (this.MédicoResponsable==null){
            var x = {"Paciente derivado: "+this.PacienteAtendido.NIDI+" Turno: "+Turno}
        }
        return x.toString()
    }
}
