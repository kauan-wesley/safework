const form = document.getElementById("contactForm");

form.addEventListener("submit", function(event) {

    event.preventDefault();

    const nome = document.getElementById("nome").value;

    alert(
        "Olá, " + nome +
        "! Sua mensagem foi recebida."
    );

    form.reset();

});