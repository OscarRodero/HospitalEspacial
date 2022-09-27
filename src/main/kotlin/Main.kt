fun main() {
    var tiempo:Int=0
    var finSimulacion=false;
    var Sala1 = Factoria.GenerarSala(1)
    var Sala2 = Factoria.GenerarSala(2)
    var Sala3 = Factoria.GenerarSala(3)
    var Tiempo:Int=0
    do {
        if (Tiempo%2==0){
            if (Sala1.pacientes.size<Sala2.pacientes.size && Sala1.pacientes.size<Sala3.pacientes.size){
                Sala1.pacientes.add(Factoria.GenerarPaciente())
            }else if(Sala2.pacientes.size<Sala1.pacientes.size && Sala2.pacientes.size<Sala3.pacientes.size){
                Sala2.pacientes.add(Factoria.GenerarPaciente())
            }else if(Sala3.pacientes.size<Sala1.pacientes.size && Sala3.pacientes.size<Sala2.pacientes.size){
                Sala3.pacientes.add(Factoria.GenerarPaciente())
            }
        }
        if(Tiempo%4==0){
            if (Sala1.pacientes.size>Sala2.pacientes.size && Sala1.pacientes.size>Sala3.pacientes.size){
                for (i in 0..Sala1.pacientes.size){
                    if (Sala1.pacientes[i].Prio==1){
                        AtenderPaciente(i, Sala1)
                        break
                    }
                }
            }else if(Sala2.pacientes.size>Sala1.pacientes.size && Sala2.pacientes.size>Sala3.pacientes.size){

            }else if(Sala3.pacientes.size>Sala1.pacientes.size && Sala3.pacientes.size>Sala2.pacientes.size){

            }
        }
        Thread.sleep(1000)
        Tiempo++
        if (Tiempo>=168){
            finSimulacion=true
        }
    }while(!finSimulacion)
}

fun AtenderPaciente(i: Int, sala: Sala_de_Espera) {
    sala.pacientes.drop(i)
}





