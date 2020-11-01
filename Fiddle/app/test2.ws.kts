class Student(val name: String, val code : Int, val sexe: String, val address : String, val age : Int)

val students = listOf(
Student("Lilian", 1000, "H", "31 Avenue Carnot, Biarritz", 21),
Student("Victor", 1001, "H", "314 Chemin Pinaquy Dit Couma, Urcuit", 22),
Student("Lucie", 1002, "F", "71bis rue Pierre de Chevigne, Biarritz", 25),
Student("Ines", 1003, "F", "71bis rue Pierre de Chevigne,Biarritz", 18),
Student("Augustin", 1004, "H", "152 Chemin Errepira, Bidart", 19),
Student("Nicolas", 1005, "H", "2 rue Minjongo, Biarritz", 22),
Student("Maxime", 1006, "H", "Camping Oyambura, Bidart", 22),
Student("Yanis", 1007, "H", "31 Avenue Carnot, Biarritz", 22),
Student("Jade", 1008, "F", "44 allée du train des roses, Brie-Comte-Robert", 19),
)

val studentsTrie = students.sortedBy{it.age}

//println("Avant Tri:")
for (person in students) {
//println("Hello ${person.age}")
}
//println("Après Tri:")
for (person in studentsTrie) {
//println("Hello ${person.age}")
}

var studentsFemme: MutableList<Student> = mutableListOf<Student>()
var studentsHomme: MutableList<Student> = mutableListOf<Student>()

for (person in studentsTrie) {
if (person.sexe == "F"){
studentsFemme.add(person)

}
}

for (person in studentsTrie) {
if (person.sexe == "H"){
studentsHomme.add(person)

}
}

var studentsTest: MutableList<Student> = mutableListOf<Student>()

for (person in studentsTrie) {
studentsTest.add(person)
}

var i = 0

println(studentsTest.first())

for (person in studentsTrie){
if(person.sexe = "H"){
println(person)
}

}

println(studentsTest.first())



println(prenoms)


etudiants[0].name = "Lillian"

println(etudiants)

val etudiantsTrie = etudiants.sortedBy { it.age }

var etudiantsNom: MutableList<String> = mutableListOf<String>()

for (person in etudiantsTrie) {
    if (person.sexe.equals("Sexe.Male") {
                person.name="Hugo"
            }
}

for (person in etudiantsTrie) {
    etudiantsNom.add(person.name)
}

println(etudiantsNom)