fun main() {
    var pepino = Vehiculo("VITI","Seat","Ibiza",12.3F, 10.0F, 144.0F)
    println(pepino.obtenerInformacion())
    println(pepino.realizaViaje(160.0F)) // Si pongo un valor muy alto y sin hibrido me sale bien
    println(pepino)
    println("-------------------------------------------")
    println()
    var coche = Automovil("Paco","Cupra","Formentor",10.0f,10.0f,100f,false)
    println(coche)
    println(coche.realizarDerrape())
    //println(coche.cambiarCondicionBritanica(true)) unresolved reference? y como cambio la condicion?
    println(coche)
    println("-------------------------------------------")
    println()

    var moto = Motocicleta("Elia el loco","BMW","SI",5.0f,1.0f,2000f,1000)
    println(moto)
    println(moto.realizaViaje(4.0f)) // valor pequeño da negativo, valor grande esta bien
    println(moto.realizaCaballito())
    println(moto.calcularAutonomia())
    println(moto.repostar(200.0f))
    println(moto)
    println("-------------------------------------------")
    println()
}