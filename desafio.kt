// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, var email: String){
    override fun toString(): String = "Nome: $nome, Email: $email"
}

data class ConteudoEducacional(val nome: String, var duracao: Int = 60, val nivel: Nivel){
    override fun toString(): String = "Nome: $nome, Duração: $duracao horas, Nível: $nivel"
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario){
        inscritos.add(usuario)
    }
}

fun mostrarFormacao(curso: Formacao){
    println("\nDescrição: " + curso.component1())
    curso.component2().forEach(){
        conteudo -> println("$conteudo")
    }
    
}

fun mostrarInscritos(curso: Formacao){
    println("\nAlunos: " + curso.nome)
    curso.inscritos.forEach(){
        alunos -> println("$alunos")
    }
    
}

fun main() {
    val conteudo = ConteudoEducacional("Doker Fundamentals", nivel = Nivel.INTERMEDIARIO)
    val conteudo1 = ConteudoEducacional("Dominando a linguagem de Programação Java", 120, Nivel.BASICO) 
    val conteudo2 = ConteudoEducacional("Dominando a linguagem de Programação Kotlin", 120, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Primeiros Passos com SQL", 30, Nivel.BASICO)
    val conteudo4 = ConteudoEducacional("Refinando Sua Técnica com desafios de Código em Java", 30, Nivel.INTERMEDIARIO)
    val conteudo5 = ConteudoEducacional("Refinando Sua Técnica com desafios de Código em Kotlin", nivel = Nivel.INTERMEDIARIO)
    val conteudo6 = ConteudoEducacional("Explorando o Spring Framwork com Java e Kotlin", 200 , Nivel.AVANCADO)
    
    val formacao = Formacao("Bootcamp TQI kotlin - Backend Developer", mutableListOf(conteudo, conteudo1, conteudo2, conteudo3))
    val user = Usuario("Rodrigo Moura", "rodrigo.carvalho.1998@gmail.com")
    val user1 = Usuario("Venilton FalvoJr","venilto.falvojr@dio.com")
    
    formacao.matricular(user)
    formacao.matricular(user1)
    mostrarFormacao(formacao)
    mostrarInscritos(formacao)
    
    var formacao1 = Formacao("Bootcamp TQI kotlin - 2º Edição", mutableListOf(conteudo, conteudo1, conteudo4, conteudo2, conteudo5, conteudo3, conteudo6))
    formacao1.matricular(user)
    mostrarFormacao(formacao1)
    mostrarInscritos(formacao1)
}