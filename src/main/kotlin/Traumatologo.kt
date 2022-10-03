class Traumatologo(NIDI: Int, Nombre: String, Turno:Char, Compañia:String) : Sanitario(NIDI, Nombre, Turno, Compañia){
    companion object{
        var contador:Int=0
        fun AsignarNIDI(): Int {
            this.contador++
            return this.contador
        }
    }
}