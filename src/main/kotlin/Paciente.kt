class Paciente(var NIDI:Int, var Nombre: String, var CompañiaSeguros: String, var AtencionRequerida: String, var Prio: Int) {

    companion object{
        var contador:Int=0
        fun AsignarNIDI(): Int {
            this.contador++
            return this.contador
        }
    }
}