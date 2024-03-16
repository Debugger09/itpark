// Sélectionner l'élément sidebar et le toggle
const sidebar = document.getElementById('sidebar');
const toggle = document.querySelector('.toggle');

// Ajouter un écouteur d'événements pour le toggle
toggle.addEventListener('click', function() {
    console.log("dddd");
    sidebar.classList.toggle('hidden');
});



document.addEventListener("DOMContentLoaded", function() {
    const currentLocation = window.location.pathname;
    const links = document.querySelectorAll('.sidebar-menu li a');

    // Supprimer la classe 'active' de tous les liens
    links.forEach(link => {
        link.parentElement.classList.remove('active');
    });

    // Ajouter la classe 'active' uniquement à l'élément parent du lien correspondant à l'URL actuelle
    links.forEach(link => {
        console.log(link);
        const href = link.getAttribute('href');
        if (currentLocation.endsWith(href)) {
            link.parentElement.classList.add('active');
        }
    });
});
