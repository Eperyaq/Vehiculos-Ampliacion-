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

    fun obtenerdistancia():Vehiculo{
        Vehiculo.realizarviaje(distancia.random(10..200)) // lo he puesto aunque no funcione para preguntar

    }

    fun comprobarGanador(){
        if (distanciaTotal == )
    }

    fun iniciaCarrera() {

        estado = true

        while (estado) {

            val vehiculo = obtenerVehiculo()

            TODO("Obtener la distancia que el vehiculo debe recorrer entre 10 y 200")

            //avanzarVehiculo(vehiculo)

            //Actualizar posiciones

            //Comprobar si hay ganador



        }
    }


}