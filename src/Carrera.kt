import kotlin.random.Random
import kotlin.random.nextInt

class Carrera(
        val nombreCarrera: String,
        val distanciaTotal: Float, //km de carrera
        val participantes: List<Vehiculo>, //lista con los participantes de la carrera
) {

    var estado = false
    val historialCarrera: MutableMap<String, MutableList<String>> // clave nomrbe del coche y


    fun obtenerVehiculo() : Vehiculo {
        return participantes.random()
    }



    fun comprobarGanador(distanciaRecorrida:Float):String{
        if (distanciaRecorrida == distanciaTotal ){
            estado = false
            return "Felicidades ${Vehiculo.nombres} ha ganado!!"
        }
            estado = true

    }

    fun avanzarVehiculo(vehiculo: Vehiculo){
        val kmARecorrer = Random.nextInt(10..201).toFloat()
        vehiculo.realizaViaje(kmARecorrer)
    }


    fun iniciaCarrera() {

        estado = true


        //avanzarvehiculo(Vehiculo y km)

        while (estado) {

            val vehiculo = obtenerVehiculo()


            //avanzarVehiculo(vehiculo)

            //Actualizar posiciones

            //Comprobar si hay ganador



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