import java.time.LocalDateTime
import java.util.Scanner


fun createCompany(reader : Scanner): Employer {
    println("Création de votre entreprise")
    println("Raison sociale : ")
    val raison = readLine()!!
    println("Chiffre d'affaires : ")
    val ca:Double = reader.nextDouble()
    val entreprise = Employer(raison, ca)
    println("Vous venez de créer l'entreprise $entreprise")
    return entreprise
}

fun menu(reader: Scanner, company: Employer) {
    println("--------------------------------------------")
    println("[ 1 ] Consulter ou modifier votre entreprise")
    println("[ 2 ] Recruter un employé")
    println("[ 3 ] Recruter un cadre")
    println("[ 4 ] Afficher les informations de vos employés")
    println("[ 5 ] Augmenter un employé")
    println("[ 6 ] Renvoyer une personne")
    println("[ 7 ] Modifier les informations d'une personne")
    println("[ 8 ] Modifier le grade d'un cadre")
    println("[ 9 ] Quitter")
    println("--------------------------------------------")

    when(readLine()!!) {
        "1" -> {
            infosCompany(reader, company)
            menu(reader, company)
        }
        "2" -> {
            hireEmployee(reader, company)
            menu(reader, company)
        }
        "3" -> {
            hireExecutive(reader, company)
            menu(reader, company)
        }
        "4" -> {
            infosEmployees(company)
            menu(reader, company)
        }
        "5" -> {
            amountEmployee(reader, company)
            menu(reader, company)
        }
        "6" -> {
            fireEmployee(company)
            menu(reader, company)
        }
        "7" -> {
            infosEmployee(reader, company)
            menu(reader, company)
        }
        "8" -> {
            gradeExecutive(company)
            menu(reader, company)
        }
        else -> {
            println("Veuillez saisir une valeur valide")
            menu(reader, company)
        }
    }
}

fun infosCompany(reader : Scanner, company : Employer) {
    println("Souhaitez-vous [ 1 ] consulter ou [ 2 ] modifier des informations de votre entreprise ?")
    when(readLine()!!) {
        "1" -> {
            println(company)
        }
        "2" -> {
            println("Souhaitez-vous modifier [ 1 ] la raison ou [ 2 ] le CA de votre entreprise ?")
            when(readLine()!!) {
                "1" -> {
                    println("Nouvelle raison sociale : ")
                    val name = readLine()!!
                    company.name = name
                    println(company)
                }
                "2" -> {
                    println("Nouveau CA : ")
                    val turnover:Double = reader.nextDouble()
                    company.turnover = turnover
                    println(company)
                }
            }
        }
    }
}

fun hireEmployee(reader : Scanner, company : Employer) {
    println("Recrutement de l'employé")
    println("Prénom : ")
    val firstname = readLine()!!
    println("Nom : ")
    val lastname = readLine()!!
    println("Année de naissance : ")
    val birthYear:Int = reader.nextInt()
    if (LocalDateTime.now().year - birthYear > 16) {
        val employee = Employee(firstname, lastname, birthYear, company)
        company.hireEmployee(employee)
        println(employee)
    }
    else {
        println("L'employé n'a pas l'âge minimum légal requis")
    }
}

fun hireExecutive(reader : Scanner, company : Employer) {
    println("Recrutement du cadre")
    println("Souhaitez-vous [ 1 ] promouvoir un employé ou [ 2 ] recruter une nouvelle personne ?")
    when(readLine()!!) {
        "1" -> {
            println("Prénom : ")
            val firstname = readLine()!!
            println("Nom : ")
            val lastname = readLine()!!
            for (employee in company.employees) {
                if(employee.firstName == firstname && employee.lastName == lastname) {
                    val executive = Executive(employee.firstName, employee.lastName, employee.birthYear, company, Grade.C)
                    company.hireEmployee(executive)
                    company.fireEmployee(employee)
                }
            }
        }
        "2" -> {
            println("Prénom : ")
            val firstname = readLine()!!
            println("Nom : ")
            val lastname = readLine()!!
            println("Année de naissance : ")
            val birthYear:Int = reader.nextInt()
            println("Grade : ")
            val inputGrade = readLine()!!
            var grade = Grade.A
            when(inputGrade) {
                "A" -> grade = Grade.A
                "B" -> grade = Grade.B
                "C" -> grade = Grade.C
            }
            val executive = Executive(firstname, lastname, birthYear, company, grade)
            company.hireEmployee(executive)
            println(executive)
        }
    }
}

fun infosEmployees(company : Employer) {
    println("Souhaitez-vous consulter la liste [ 1 ] des employés, [ 2 ] des cadres ou [ 3 ] des salaires ?")
    when(readLine()!!) {
        "1" -> {
            company.displayName()
        }
        "2" -> {
            company.displayExecutive()
        }
        "3" -> {
            company.displaySalary()
        }
    }
}

fun amountEmployee(reader : Scanner, company : Employer) {
    println("Augmentation d'un employé")
    println("Prénom : ")
    val firstname = readLine()!!
    println("Nom : ")
    val lastname = readLine()!!
    println("Augmentation : ")
    val amount:Double = reader.nextDouble()
    for (employee in company.employees) {
        if (employee.firstName == firstname && employee.lastName == lastname) {
            company.increase(employee, amount)
        }
    }
}

fun fireEmployee(company: Employer) {
    println("Renvoi d'une personne")
    println("Prénom : ")
    val firstname = readLine()!!
    println("Nom : ")
    val lastname = readLine()!!
    for (employee in company.employees) {
        if (employee.firstName == firstname && employee.lastName == lastname) {
            company.fireEmployee(employee)
        }
    }
}

fun infosEmployee(reader : Scanner, company : Employer) {
    println("Les informations de quel employé souhaitez-vous modifier ?")
    println("Prénom : ")
    val firstname = readLine()!!
    println("Nom : ")
    val lastname = readLine()!!
    for (employee in company.employees) {
        if (employee.firstName == firstname && employee.lastName == lastname) {
            println("Souhaitez-vous modifier [ 1 ] le prénom ou [ 2 ] le nom de votre employé ?")
            when(readLine()!!) {
                "1" -> {
                    println("Prénom : ")
                    val firstname = readLine()!!
                    employee.firstName = firstname
                    println(employee)
                }
                "2" -> {
                    println("Nom : ")
                    val lastname = readLine()!!
                    employee.lastName = lastname
                    println(employee)
                }
            }
        }
    }
}

fun gradeExecutive(company: Employer) {
    println("Promotion d'un cadre")
    println("Prénom : ")
    val firstname = readLine()!!
    println("Nom : ")
    val lastname = readLine()!!
    for (employee in company.employees) {
        if (employee.firstName == firstname && employee.lastName == lastname) {
            company.upgrade(employee as Executive)
        }
    }
}