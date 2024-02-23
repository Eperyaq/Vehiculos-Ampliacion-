fun String.capitalizar(): String {
    val palabras: MutableList<String> = this.trim().split(" ").toMutableList()

    for (i in 0..palabras.size - 1) {
        palabras[i] = palabras[i].trim().lowercase().replaceFirstChar { it.uppercase() }
    }

    //return palabras.joinToString(" ") { palabra -> palabra.trim().lowercase().replaceFirstChar { it.uppercase() } }

    return palabras.joinToString(" ")
    //return this.trim().lowercase().replaceFirstChar { it.uppercase() }
}

open class Vehiculo(
        nombre: String, val marca:String, val modelo:String, val capacidadCombustible: Float, var combustibleActual:Float, var kilometrosActuales:Float) {

    val nombre: String = nombre.capitalizar()

    init {
        require(!existeNombre(nombre)) { "Ya existe el nombre $nombre." }
    }

// hay que meterle un nombre  y comprobar que no haya ninguno igual con un conjunto o con una lista y comprobar que no haya ninguno igual
    //el nnombre va en  un companion object
    companion object {
        const val KM_POR_LITRO = 10f //Cada L recorre 10 km

        val nombres: MutableSet<String> = mutableSetOf()
        private fun existeNombre(nombre: String) : Boolean {
            return !nombres.add(nombre)
        }
    }

    /**
     *
     * Obtienes los km que se pueden recorrer con los litros de gasolina que tienes
     **/
    fun obtenerInformacion():String{
        return "Con $combustibleActual L de combustible se pueden recorrer %.2f".format(calcularAutonomia())
    }

    /**
     * Calcula la autonomia del vehiculo, los kilometros que puede hacer el coche
     */
    open fun calcularAutonomia() = combustibleActual * KM_POR_LITRO // = 100.0

    /**
    * Realiza un viaje y resta gasolina, si sale negativo son los km que le faltan para llegar al destino
    *
    **/
    //realizaViaje(distancia: Float) -> Float: Realiza un viaje hasta donde da combustibleActual. Ajusta el combustible gastado y el kilometraje realizado de acuerdo con el viaje. Devuelve la distancia restante.
    open fun realizaViaje(distancia:Float): Float{

        val distanciaARecorrer = minOf(calcularAutonomia(), distancia)

        actualizarCombustible(distanciaARecorrer)
        actualizarKm(distanciaARecorrer)

        return distancia - distanciaARecorrer //retorna los km que quedan por hacer

    }
    /**
    * Actualiza el combustible para ver cuanto queda
    *
    * @Params restante:Float -> Indica el valor a restar
    * */
    open fun actualizarCombustible(distancia:Float) {
        combustibleActual -= distancia / KM_POR_LITRO
    }

    private fun actualizarKm(distancia : Float) {
        kilometrosActuales += distancia
    }


/**
* Echas gasolina
*
* @Params Cantidad- Double -> Cantidad a repostar
*
* @Return echargasolina- Float -> Gasolina echada si es mayor que la capacidad queda al tope, si no, se suma al combustible actual
* */
    fun repostar(cantidad:Float = 0f):Float{

        val lleno = capacidadCombustible - combustibleActual

        val cantidadARepostar =
            if (cantidad <= 0)
                lleno
            else
                minOf(lleno, cantidad + combustibleActual)

        combustibleActual += cantidadARepostar

        return cantidadARepostar

    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales"
    }


}