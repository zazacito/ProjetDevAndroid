class Etudiant(val name: String){
    init{
        println("je suis en train de créer un étudiant")

    }
}

val etudiant=Etudiant(name: "toto")

println("Mon nom est ${etudiant.name}")