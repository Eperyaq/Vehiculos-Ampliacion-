

open class Vehiculo(val marca:String, val modelo:String, val capacidadCombustible: Float, var combustibleActual:Float, var kilometrosActuales:Float) {
// hay que meterle un nombre  y comprobar que no haya ninguno igual con un conjunto o con una lista y comprobar que no haya ninguno igual
    //el nnombre va en  un companion object
    companion object {
        const val KM_POR_LITRO = 10f //Cada L recorre 10 km
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

    /*
    * Realiza un viaje y resta gasolina, si sale negativo son los km que le faltan para llegar al destino
    * problemitass
    **/
    //realizaViaje(distancia: Float) -> Float: Realiza un viaje hasta donde da combustibleActual. Ajusta el combustible gastado y el kilometraje realizado de acuerdo con el viaje. Devuelve la distancia restante.
    open fun realizaViaje(distancia:Float): Float{
        if (distancia < calcularAutonomia()){
            var diferencia =  calcularAutonomia() - distancia

            actualizarKm(diferencia)
            return 0f
        }else {
            var diferencia2 =  distancia - calcularAutonomia()
            return diferencia2
        }

    }
    /*
    * Actualiza el combustible para ver cuanto queda
    *
    * @Params restante:Float -> Indica el valor a restar
    * */
    fun actualizarCombustible(restante:Float) =  combustibleActual - restante

    fun actualizarKm(restar : Float) = kilometrosActuales + restar


/*
* Echas gasolina
*
* @Params Cantidad- Double -> Cantidad a repostar
*
* @Return echargasolina- Float -> Gasolina echada si es mayor que la capacidad queda al tope, si no, se suma al combustible actual
* */
    fun repostar(cantidad:Float = 0f):Float{

        if (cantidad > capacidadCombustible - combustibleActual){
            var echargasolina= capacidadCombustible //hacer el caluclo para que de lo que ha repostado porque si ya tienes 10l y le metes 40 commo el tope es 30 te sobra 20
            return  echargasolina
        }else if(cantidad <= 0){
             combustibleActual=  capacidadCombustible
            return  combustibleActual
        } else{
            var echargasolina = cantidad + combustibleActual
            return echargasolina // o cantidad? porque dice que devuelve la cantidad respostada es decir lo que ha metido, la variable cantidad
        }
    }


    override fun toString(): String {
        return "Marca: $marca, Modelo: $modelo, Capacidad Combustible: $capacidadCombustible, Combusible Actual: $combustibleActual, Kilometros actuales: $kilometrosActuales"
    }


}