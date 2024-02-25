import kotlin.random.Random
import kotlin.random.nextInt

class Carrera(
        val nombreCarrera: String,
        val distanciaTotal: Float, //km de carrera
        val participantes: List<Vehiculo>, //lista con los participantes de la carrera
) {

    var estado = false
    val historialCarrera: MutableMap<String, MutableList<String>> = mutableMapOf()  // clave nomrbe del coche y la lista de las acciones

    /**
     * Obtiene un vehiculo aleatorio al principio de cada turno
     *
     * @return participante random
     * */
    fun obtenerVehiculo() : Vehiculo {
        return participantes.random()
    }


    /**
    *Comprueba si hay algun ganador igualando los km de un coche con los km totales de la pista
    *
    * @param vehiculo:Vehiculo Un vehiculo para comprobar si ha ganado
     * @return string felicitando al ganador
     */
    fun comprobarGanador(vehiculo: Vehiculo):String{
        if ( vehiculo.kilometrosActuales == distanciaTotal ){
            estado = false
            return "Felicidades ${Vehiculo.nombres} ha ganado!!"
        }
        else {
           return "" //no se que retornar y si no retorno nada me da error
        }
    }

    /**
     * Avanaza el vehiculo una cantidad random comprendida entre 10 y 200
     *
     * @param vehiculo:Vehiculo - Un vehiculo para avanzar
     * */
    fun avanzarVehiculo(vehiculo: Vehiculo){

        val kmARecorrer = Random.nextInt(10..201).toFloat()
        vehiculo.realizaViaje(kmARecorrer)

        var numeroFiligranas = Random.nextInt(0..2)
        while (numeroFiligranas > 0) { // bucle que va haciendo el numero de filigranas que hayan salido, se van restando las filigranas restantes hasta que acaba y se sale del bucle
            realizaFiligrana(vehiculo)
            numeroFiligranas--
        }

        if (vehiculo.combustibleActual == 0.0f){ //si se queda sin gasolina el vehiculo, reposta gasolina
            vehiculo.repostar()
        }
    }

    /**
     * Realiza filigrana dependiendo de el numero de filigranas que se introduzcan
     * */
    fun realizaFiligrana(vehiculo: Vehiculo){
        if (vehiculo is Automovil){
            vehiculo.realizarDerrape()
        }else if (vehiculo is Motocicleta){
            vehiculo.realizaCaballito()
        }
    }

/*
    fun obtenerResultados():ResultadoCarrera{ //no se como hacerlo

    }

 */
    /*
    fun registrarAccion(vehiculo: Vehiculo, accion:String){

    }
    */



    /**
     * Inicia la carrera usando todas las funciones necesarias para que la carrera funcione bien.
     * */
    open fun iniciaCarrera() {

        estado = true


        //avanzarvehiculo(Vehiculo y km)

        while (estado) {

            val vehiculo = obtenerVehiculo()

            avanzarVehiculo(vehiculo)
            comprobarGanador(vehiculo)


        }
    }


    /**
     * Representa el resultado final de un vehículo en la carrera, incluyendo su posición final, el kilometraje total recorrido,
     * el número de paradas para repostar, y un historial detallado de todas las acciones realizadas durante la carrera.
     *
     * @property vehiculo El [Vehiculo] al que pertenece este resultado.
     * @property posicion La posición final del vehículo en la carrera, donde una posición menor indica un mejor rendimiento.
     * @property kilometraje El total de kilómetros recorridos por el vehículo durante la carrera.
     * @property paradasRepostaje El número de veces que el vehículo tuvo que repostar combustible durante la carrera.
     * @property historialAcciones Una lista de cadenas que describen las acciones realizadas por el vehículo a lo largo de la carrera, proporcionando un registro detallado de su rendimiento y estrategias.
     */
    data class ResultadoCarrera(
        val vehiculo: Vehiculo,
        val posicion: Int,
        val kilometraje: Float,
        val paradasRepostaje: Int,
        val historialAcciones: List<String>
    )

}

