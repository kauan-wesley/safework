
const form = document.getElementById("contactForm");

if (form) {
    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const nome = document.getElementById("nome").value.trim();

        alert(
            "Olá, " + nome +
            "! Sua mensagem foi recebida."
        );

        form.reset();
    });
}
