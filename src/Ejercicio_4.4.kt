class Coche(var color: String?,
            marca: String?,
            modelo: String?,
            numeroCaballos: Int?,
            numeroPuertas: Int?,
            matricula: String?){


    var matricula = matricula
        set(value){
            if(value?.length == 7){
                field = value
            } else {
                throw IllegalArgumentException("La matrícula debe tener 7 caracteres")
            }
        }

    var numeroPuertas = numeroPuertas
        set(value){
            if(value in 3..5){
                field = value
            } else {
                throw IllegalArgumentException("El número de puertas debe estar entre 3 y 5")
            }
        }

    var numeroCaballos = numeroCaballos
        set(value){
            if(value in 70 ..700){
                field = value
            } else {
                throw IllegalArgumentException("El número de caballos debe estar entre 70 y 700")
            }
        }


    val marca = marca
        get() = field?:"".lowercase().replaceFirstChar { it.uppercase() }

    val modelo = modelo
        get() = field?:"".lowercase().replaceFirstChar { it.uppercase() }


    init {
        require(!marca.isNullOrEmpty()){"La marca es un campo obligatorio."}
        require(!modelo.isNullOrEmpty()){"El modelo es un campo obligatorio."}
        require(numeroCaballos != null){"El número de caballos es un campo obligatorio."}
        require(numeroPuertas != null){"El número de puertas es un campo obligatorio."}
        require(!matricula.isNullOrEmpty()){"La matrícula es un campo obligatorio."}


        require(matricula.length == 7){"La matrícula debe tener 7 caracteres."}
        require(numeroCaballos in 70 .. 700){"El número de caballos debe ser un valor dentro del rango 70-700"}
        require(numeroPuertas in 3..5){"El número de puertas debe ser un valor entre 3 y 5"}
    }


    override fun toString(): String{
       return "El coche de color $color, marca $marca, modelo $modelo y matrícula $matricula, tiene" +
               "$numeroCaballos números de caballo y $numeroPuertas números de puertas."
    }
}

fun main(){

    val coche1 = Coche("Blanco", null, "", 70, 4, "1234567")
    val coche2 = Coche("Negro", "Toyota", "Corolla", 60, 4, "1234567")
    val coche3 = Coche("Azul", "Seat", "Leon", 78, 2, "1234567")
    val coche4 = Coche("Rosa", "Diego", "Cano", 78, 4, "134567")
    val coche5 = Coche("Amarillo", "Antonio", "Caro", 78, 4, "134567")


    try {
        coche5.numeroCaballos = 20
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    try {
        coche2.numeroPuertas = 1
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    try {
        coche1.matricula= "123456"
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }

    try {
        coche4.matricula = ""
    } catch (e: IllegalArgumentException) {
        println("**ERROR** $e")
    }
}
