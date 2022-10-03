fun main() {
    //Declaración de variables del main
    var finSimulacion=false;
    var Sala1 = Factoria.GenerarSala(1)
    var Sala2 = Factoria.GenerarSala(2)
    var Sala3 = Factoria.GenerarSala(3)
    var Tiempo:Int=0
    var PacienteAtendido:Boolean=false
    var ListaMedicos = ArrayList<Sanitario>()
    var ListaRegistro = ArrayList<Registro>()
    var ListaRegistroDerivados = ArrayList<Registro>()
    var Turno='M'
    //Creación de los 2 médicos que cubrirán cada turno.
    for(i in 0..2){
        cambiarTurno(Turno)
        ListaMedicos.add(Factoria.GenerarTraumatologo(Turno))
        ListaMedicos.add(Factoria.GenerarMedicoInterno(Turno))
    }
    //Inicio de la simulación.
    do {
        //Comprobación de las salas y posterior adición de un paciente generado de forma aleatoria
        if (Tiempo%2==0){
            if (Sala1.pacientes.size<Sala2.pacientes.size && Sala1.pacientes.size<Sala3.pacientes.size){
                Sala1.pacientes.add(Factoria.GenerarPaciente())
            }else if(Sala2.pacientes.size<Sala1.pacientes.size && Sala2.pacientes.size<Sala3.pacientes.size){
                Sala2.pacientes.add(Factoria.GenerarPaciente())
            }else if(Sala3.pacientes.size<Sala1.pacientes.size && Sala3.pacientes.size<Sala2.pacientes.size){
                Sala3.pacientes.add(Factoria.GenerarPaciente())
            }else if(Sala1.pacientes.size==Sala2.pacientes.size && Sala1.pacientes.size<Sala3.pacientes.size){
                var x = (0..1).random()
                if (x==0){
                    Sala1.pacientes.add(Factoria.GenerarPaciente())
                }else{
                    Sala2.pacientes.add(Factoria.GenerarPaciente())
                }
            }else if(Sala2.pacientes.size==Sala3.pacientes.size && Sala2.pacientes.size<Sala1.pacientes.size){
                var x = (0..1).random()
                if (x==0){
                    Sala3.pacientes.add(Factoria.GenerarPaciente())
                }else{
                    Sala2.pacientes.add(Factoria.GenerarPaciente())
                }
            }else if(Sala1.pacientes.size==Sala3.pacientes.size && Sala1.pacientes.size<Sala2.pacientes.size){
                var x = (0..1).random()
                if (x==0){
                    Sala1.pacientes.add(Factoria.GenerarPaciente())
                }else{
                    Sala3.pacientes.add(Factoria.GenerarPaciente())
                }
            }else if(Sala1.pacientes.size==Sala2.pacientes.size && Sala2.pacientes.size==Sala3.pacientes.size){
                var x =(0..2).random()
                when(x){
                    0 -> Sala1.pacientes.add(Factoria.GenerarPaciente())
                    1 -> Sala2.pacientes.add(Factoria.GenerarPaciente())
                    2 -> Sala3.pacientes.add(Factoria.GenerarPaciente())
                }
            }
        }
        //Comprobación del estado de las salas y la atención a los pacientes.
        if(Tiempo%4==0){
            PacienteAtendido=false
            if (Sala1.pacientes.size>Sala2.pacientes.size && Sala1.pacientes.size>Sala3.pacientes.size){
                if(!PacienteAtendido){
                    BucleAtencion@ for (i in 0..Sala1.pacientes.size-1){
                        if (Sala1.pacientes[i].Prio==1){
                            for (j in 0..ListaMedicos.size-1){
                                if (ListaMedicos[j].Compañia==Sala1.pacientes[i].CompañiaSeguros){
                                    if(Sala1.pacientes[i].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala1.pacientes[i].CompañiaSeguros)|| Sala1.pacientes[i].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala1.pacientes[i].CompañiaSeguros)){
                                        ListaRegistro.add(Factoria.GenerarRegistro(Sala1.pacientes[i], ListaMedicos[j], Turno))
                                        AtenderPaciente(i, Sala1)
                                        PacienteAtendido=true
                                        break@BucleAtencion
                                    }
                                }
                            }
                            if(PacienteAtendido==false){
                                DerivarPaciente(Sala1.pacientes[i], Turno)
                                PacienteAtendido=true
                                break@BucleAtencion
                            }
                        }
                    }
                }
                if(!PacienteAtendido){
                    BucleAtencion@ for (i in 0..Sala1.pacientes.size-1){
                        if (Sala1.pacientes[i].Prio==2){
                            for (j in 0..ListaMedicos.size-1){
                                if (ListaMedicos[j].Compañia==Sala1.pacientes[i].CompañiaSeguros){
                                    if(Sala1.pacientes[i].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala1.pacientes[i].CompañiaSeguros)|| Sala1.pacientes[i].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala1.pacientes[i].CompañiaSeguros)){
                                        ListaRegistro.add(Factoria.GenerarRegistro(Sala1.pacientes[i], ListaMedicos[j], Turno))
                                        AtenderPaciente(i, Sala1)
                                        PacienteAtendido=true
                                        break@BucleAtencion
                                    }
                                }
                            }
                            if(PacienteAtendido==false){
                                DerivarPaciente(Sala1.pacientes[i], Turno)
                                PacienteAtendido=true
                                break@BucleAtencion
                            }
                        }
                    }
                }
                if(!PacienteAtendido){
                    for (j in 0..ListaMedicos.size-1){
                        if (ListaMedicos[j].Compañia==Sala1.pacientes[0].CompañiaSeguros){
                            if(Sala1.pacientes[0].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala1.pacientes[0].CompañiaSeguros)|| Sala1.pacientes[0].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala1.pacientes[0].CompañiaSeguros)){
                                ListaRegistro.add(Factoria.GenerarRegistro(Sala1.pacientes[0], ListaMedicos[j], Turno))
                                AtenderPaciente(0, Sala1)
                                PacienteAtendido=true
                                break
                            }
                        }
                    }
                    if(PacienteAtendido==false){
                        DerivarPaciente(Sala1.pacientes[0], Turno)
                        PacienteAtendido=true
                    }
                }
            }else if(Sala2.pacientes.size>Sala1.pacientes.size && Sala2.pacientes.size>Sala3.pacientes.size){
                if(!PacienteAtendido){
                    BucleAtencion@ for (i in 0..Sala2.pacientes.size-1){
                        if (Sala2.pacientes[i].Prio==1){
                            for (j in 0..ListaMedicos.size-1){
                                if (ListaMedicos[j].Compañia==Sala2.pacientes[i].CompañiaSeguros){
                                    if(Sala2.pacientes[i].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala1.pacientes[i].CompañiaSeguros)|| Sala2.pacientes[i].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala2.pacientes[i].CompañiaSeguros)){
                                        ListaRegistro.add(Factoria.GenerarRegistro(Sala2.pacientes[i], ListaMedicos[j], Turno))
                                        AtenderPaciente(i, Sala2)
                                        PacienteAtendido=true
                                        break@BucleAtencion
                                    }
                                }
                            }
                            if(PacienteAtendido==false){
                                DerivarPaciente(Sala2.pacientes[i], Turno)
                                PacienteAtendido=true
                                break@BucleAtencion
                            }
                        }
                    }
                }
                if(!PacienteAtendido){
                    BucleAtencion@ for (i in 0..Sala2.pacientes.size-1){
                        if (Sala2.pacientes[i].Prio==2){
                            for (j in 0..ListaMedicos.size-1){
                                if (ListaMedicos[j].Compañia==Sala2.pacientes[i].CompañiaSeguros){
                                    if(Sala2.pacientes[i].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala2.pacientes[i].CompañiaSeguros)|| Sala2.pacientes[i].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala2.pacientes[i].CompañiaSeguros)){
                                        ListaRegistro.add(Factoria.GenerarRegistro(Sala2.pacientes[i], ListaMedicos[j], Turno))
                                        AtenderPaciente(i, Sala2)
                                        PacienteAtendido=true
                                        break@BucleAtencion
                                    }
                                }
                            }
                            if(PacienteAtendido==false){
                                DerivarPaciente(Sala2.pacientes[i], Turno)
                                PacienteAtendido=true
                                break@BucleAtencion
                            }
                        }
                    }
                }
                if(!PacienteAtendido){
                    for (j in 0..ListaMedicos.size-1){
                        if (ListaMedicos[j].Compañia==Sala2.pacientes[0].CompañiaSeguros){
                            if(Sala2.pacientes[0].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala2.pacientes[0].CompañiaSeguros)|| Sala2.pacientes[0].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala2.pacientes[0].CompañiaSeguros)){
                                ListaRegistro.add(Factoria.GenerarRegistro(Sala1.pacientes[0], ListaMedicos[j], Turno))
                                AtenderPaciente(0, Sala2)
                                PacienteAtendido=true
                                break
                            }
                        }
                    }
                    if(PacienteAtendido==false){
                        DerivarPaciente(Sala2.pacientes[0], Turno)
                        PacienteAtendido=true
                    }
                }
            }else if(Sala3.pacientes.size>Sala1.pacientes.size && Sala3.pacientes.size>Sala2.pacientes.size){
                if(!PacienteAtendido){
                    BucleAtencion@ for (i in 0..Sala3.pacientes.size-1){
                        if (Sala3.pacientes[i].Prio==1){
                            for (j in 0..ListaMedicos.size-1){
                                if (ListaMedicos[j].Compañia==Sala3.pacientes[i].CompañiaSeguros){
                                    if(Sala3.pacientes[i].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala3.pacientes[i].CompañiaSeguros)|| Sala3.pacientes[i].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala3.pacientes[i].CompañiaSeguros)){
                                        ListaRegistro.add(Factoria.GenerarRegistro(Sala3.pacientes[i], ListaMedicos[j], Turno))
                                        AtenderPaciente(i, Sala3)
                                        PacienteAtendido=true
                                        break@BucleAtencion
                                    }
                                }
                            }
                            if(PacienteAtendido==false){
                                DerivarPaciente(Sala3.pacientes[i], Turno)
                                PacienteAtendido=true
                                break@BucleAtencion
                            }
                        }
                    }
                }
                if(!PacienteAtendido){
                    BucleAtencion@ for (i in 0..Sala3.pacientes.size-1){
                        if (Sala3.pacientes[i].Prio==2){
                            for (j in 0..ListaMedicos.size-1){
                                if (ListaMedicos[j].Compañia==Sala3.pacientes[i].CompañiaSeguros){
                                    if(Sala3.pacientes[i].AtencionRequerida.equals("Impacto chorritrónico")&& ListaMedicos[j] is Internista && ListaMedicos[j].Compañia.equals(Sala3.pacientes[i].CompañiaSeguros)|| Sala3.pacientes[i].AtencionRequerida.equals("Quemadura Láser")&& ListaMedicos[j] is Traumatologo && ListaMedicos[j].Compañia.equals(Sala3.pacientes[i].CompañiaSeguros)){
                                        ListaRegistro.add(Factoria.GenerarRegistro(Sala3.pacientes[i], ListaMedicos[j], Turno))
                                        AtenderPaciente(i, Sala3)
                                        PacienteAtendido=true
                                        break@BucleAtencion
                                    }
                                }
                            }
                            if(PacienteAtendido==false){
                                DerivarPaciente(Sala3.pacientes[i], Turno)
                                PacienteAtendido=true
                                break@BucleAtencion
                            }
                        }
                    }
                }
            }
            PacienteAtendido=false
        }
        if(Tiempo%10==0){
            cambiarTurno(Turno)
        }
        Thread.sleep(1000)
        Tiempo++
        if (Tiempo>=3){
            finSimulacion=true
        }
    }while(!finSimulacion)
    if(ListaRegistro.size>0){
        ListaRegistro.forEach(){
            println(it.toString())
        }
    }
    if(ListaRegistroDerivados.size>0){
        ListaRegistroDerivados.forEach(){
            println(it.toString())
        }
    }
}
fun cambiarTurno(Turno:Char):Char{ //Función que cambia el turno
    if(Turno.equals('M')){
        Turno.equals('T')
    }else if(Turno.equals('T')){
        Turno.equals('N')
    }else{
        Turno.equals('M')
    }
    return Turno
}
fun AtenderPaciente(i: Int, sala: Sala_de_Espera) { //Función que borra los pacientes de las listas de espera
    sala.pacientes.drop(i)
}
fun DerivarPaciente(x:Paciente, y:Char):Registro{ //Función que crea el registro para derivar pacientes.
    var Derivado = Registro(x,null, y)
    return Derivado
}




