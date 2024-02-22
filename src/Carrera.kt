class Carrera(
        val nombre: String,
        val distanciaTotal: Float,
        val participantes: List<Vehiculo>
) {

    var estado = false

    fun obtenerVehiculo() : Vehiculo {
        return participantes.random()
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