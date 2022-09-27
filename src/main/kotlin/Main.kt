fun main() {
    var tiempo:Int=0
    var finSimulacion=false;
    var Sala1 = Factoria.GenerarSala(1)
    var Sala2 = Factoria.GenerarSala(2)
    var Sala3 = Factoria.GenerarSala(3)
    var Tiempo:Int=0
    var PacienteAtendido:Boolean=false
    var ListaMedicos:ArrayList<Sanitario>
    for(i in 0..(10..40).random()){
        var x = (0..1).random()
        if (x==0){
            ListaMedicos.add(Factoria.GenerarTraumatologo())
        }else{
            ListaMedicos.add(Factoria.GenerarMedicoInterno())
        }
    }
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
            PacienteAtendido=false
            if (Sala1.pacientes.size>Sala2.pacientes.size && Sala1.pacientes.size>Sala3.pacientes.size){
                if(!PacienteAtendido){
                    for (i in 0..Sala1.pacientes.size){
                        if (Sala1.pacientes[i].Prio==1){
                            AtenderPaciente(i, Sala1)
                            PacienteAtendido=true
                            break
                        }
                    }
                }
                if(!PacienteAtendido){
                    for (i in 0..Sala1.pacientes.size){
                        if (Sala1.pacientes[i].Prio==2){
                            AtenderPaciente(i, Sala1)
                            PacienteAtendido=true
                            break
                        }
                    }
                }
                if(!PacienteAtendido){
                    AtenderPaciente(0, Sala1)
                    PacienteAtendido=true
                }
            }else if(Sala2.pacientes.size>Sala1.pacientes.size && Sala2.pacientes.size>Sala3.pacientes.size){
                if(!PacienteAtendido){
                    for (i in 0..Sala2.pacientes.size){
                        if (Sala2.pacientes[i].Prio==1){
                            AtenderPaciente(i, Sala2)
                            PacienteAtendido=true
                            break
                        }
                    }
                }
                if(!PacienteAtendido){
                    for (i in 0..Sala2.pacientes.size){
                        if (Sala2.pacientes[i].Prio==2){
                            AtenderPaciente(i, Sala2)
                            PacienteAtendido=true
                            break
                        }
                    }
                }
                if(!PacienteAtendido){
                    AtenderPaciente(0, Sala2)
                    PacienteAtendido=true
                }
            }else if(Sala3.pacientes.size>Sala1.pacientes.size && Sala3.pacientes.size>Sala2.pacientes.size){
                if(!PacienteAtendido){
                    for (i in 0..Sala3.pacientes.size){
                        if (Sala3.pacientes[i].Prio==1){
                            AtenderPaciente(i, Sala3)
                            PacienteAtendido=true
                            break
                        }
                    }
                }
                if(!PacienteAtendido){
                    for (i in 0..Sala3.pacientes.size){
                        if (Sala3.pacientes[i].Prio==2){
                            AtenderPaciente(i, Sala3)
                            PacienteAtendido=true
                            break
                        }
                    }
                }
                if(!PacienteAtendido){
                    AtenderPaciente(0, Sala3)
                    PacienteAtendido=true
                }
            }
            PacienteAtendido=false
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





