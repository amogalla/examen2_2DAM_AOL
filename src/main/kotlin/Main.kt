import kotlin.math.sqrt
class Punto(val id:String){
    var x:Int = 0
    var y:Int = 0

    constructor(id:String, x:Int, y:Int):this(id){
        this.x = x
        this.y = y
    }

    fun obtenerCoordenadas():Pair<Int, Int> = Pair(x, y)

    override fun toString():String = "punto $id -> [$x,$y]"

    companion object{
        fun componenteDeVector(p1: Punto, p2: Punto):Punto = Punto(p1.id + p2.id, p2.x - p1.x, p2.y - p1.y)

        fun distancia(p1: Punto, p2: Punto):Double {
            val vector = componenteDeVector(p1, p2)
            return sqrt((Math.pow(vector.x.toDouble(), 2.0) - Math.pow(vector.y.toDouble(), 2.0)))
        }

        //Realizamos una partición. El primer elemento del par será una lista de puntos cuya coordenada Y sea positiva (o cero).
        //La segunda lista contendrá los puntos cuya coordenada Y sea negativa
        fun localizacionGeograficaNS(arrayPuntos:Array<Punto>): Map<String, List<Punto>> {
            val(norte, sur) = arrayPuntos.partition{it.y >=0}
            return mapOf("Norte" to norte, "Sur" to sur)
        }
    }
}

fun main(){
    val pA = Punto("pA", 3, 2)
    val pB = Punto("pB", 1, 3)
    val pC = Punto.componenteDeVector(pA, pB)

    println(pA)
    println(pB)
    println(pC)

    val p1 = Punto("p1", -1, 0)
    val p2 = Punto("p2", 3, -1)
    val p3 = Punto("p3", -4, 4)
    val p4 = Punto("p4", -3, 2)
    val p5 = Punto("p5", 6, -4)
    val p6 = Punto("p6", -5, 6)
    val p7 = Punto("p7", 10, -8)
    val p8 = Punto("p8", 1, 5)
    val p9 = Punto("p9", 6, -7)

    print(Punto.localizacionGeograficaNS(arrayOf(p1,p2,p3,p4,p5,p6,p7,p8,p9)))
}