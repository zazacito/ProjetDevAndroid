//Créer une classe Etudiant avec les attributs : name, code, sexe, adresse, age
class Etudiant(
        var name: String,
        val code: String,
        val sexe: Sexe,
        val adresse: String,
        val age: Int
) {
    override fun toString(): String {
        return name
    }
}

enum class Sexe { Male, Female, Unknown }

val etudiants = listOf(
        Etudiant(
                name = "Julie",
                code = "P01",
                sexe = Sexe.Female,
                adresse = "Biarritz",
                age = 13
        ),
        Etudiant(
                name = "Jeanne",
                code = "P02",
                sexe = Sexe.Female,
                adresse = "Biarritz",
                age = 23
        ),
        Etudiant(
                name = "André",
                code = "P03",
                sexe = Sexe.Male,
                adresse = "Biarritz",
                age = 45
        ),
        Etudiant(
                name = "Marc",
                code = "P04",
                sexe = Sexe.Male,
                adresse = "Biarritz",
                age = 13
        ), Etudiant(
        name = "Franck",
        code = "P05",
        sexe = Sexe.Unknown,
        adresse = "Biarritz",
        age = 68
),
        Etudiant(
                name = "Patrick",
                code = "P06",
                sexe = Sexe.Male,
                adresse = "Biarritz",
                age = 64
        ),
        Etudiant(
                name = "Juliette",
                code = "P07",
                sexe = Sexe.Female,
                adresse = "Biarritz",
                age = 42
        ), Etudiant(
        name = "Elie",
        code = "P08",
        sexe = Sexe.Unknown,
        adresse = "Biarritz",
        age = 98
), Etudiant(
        name = "Emie",
        code = "P09",
        sexe = Sexe.Female,
        adresse = "Biarritz",
        age = 24
), Etudiant(
        name = "Suzanne",
        code = "P01",
        sexe = Sexe.Male,
        adresse = "Biarritz",
        age = 24
)
)

val ages = etudiants.sortedBy { it.age }
println(ages)
val bySexe = etudiants.groupBy { it.sexe }
println(bySexe)

etudiants.firstOrNull {
    it.sexe == Sexe.Male
}?.name = "Toto"

println(etudiants)

val femme = etudiants.filter { it.sexe == Sexe.Female }
println(femme)

val homme = etudiants.filter { it.sexe == Sexe.Male }
println(homme)

val unknown = etudiants.filter { it.sexe == Sexe.Unknown }
println(unknown)

val prenoms = etudiants.map {
    it.name
}
println(prenoms)

var etudiantsNom: MutableList<String> = mutableListOf<String>()

for (person in etudiants) {
    etudiantsNom.add(person.name)
}

println(etudiantsNom)

val etudiant1 = etudiants.toMutableList()
etudiant1.removeIf{
    it.sexe== Sexe.Female
}

println(etudiant1)
etudiant1.reverse()
println(etudiant1)


etudiant1.clear()
println(etudiant1)



