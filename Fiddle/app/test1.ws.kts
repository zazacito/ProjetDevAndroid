open class Figure(){
    open fun aire()  {
    }
    open fun perimetre() {
    }
}
class Rectangle ( val longueur: Double, val largeur :Double) : Figure(){
    override fun perimetre(){
        println("Perimetre=" + 2*(longueur + largeur))
    }
    override fun aire() {
        println("Aire=" + longueur * largeur)
    }
}
class Cercle ( val rayon: Double): Figure(){
    override fun perimetre(){
        println("Perimetre=" + 2 * Math.PI * rayon)
    }
    override fun aire() {
        println("Aire=" + Math.PI * rayon * rayon)
    }
}
class Triangle(val adjacent: Double, val oppose: Double) : Figure(){
    override fun perimetre() {
        println("Perimetre=" + adjacent + oppose + Math.sqrt((adjacent * adjacent) + (oppose * oppose) ))
    }
    override fun aire() {
        println("Aire=" + (adjacent * oppose)/2)
    }
}
class Sphere ( val rayon: Double): Figure(){
    override fun aire() {
        println("Aire=" + 4 * Math.PI * rayon * rayon)
    }
}
var rectangle = Rectangle (12.0,14.0)
var cercle = Cercle(12.0)
var triangle = Triangle(10.0 , 40.0 )
var sphere = Sphere(8.0)
rectangle.perimetre()
rectangle.aire()
cercle.perimetre()
cercle.aire()
triangle.perimetre()
triangle.aire()
sphere.aire()