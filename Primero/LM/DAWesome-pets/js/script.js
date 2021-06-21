/*
    Este archivo contiene algunas funciones básicas de javascript para algunas de las páginas.
    Nota: cierta funcionalidad está implentada con css en lugar de javascript. Esto es porque en principio no  
    nos planteamos aprender javascript, ya que no entra en el alcance de la asignatura. Hemos decidido dejarlo así
    porque nos parece interesante el haber implementado esa funcionalidad con css.
    Los primeros pasos con javascript se han hecho como experimento y porque la funcionalidad necesaria en los 
    formularios no se puede implementar sólo con estilo.
*/

/*Función que abre el formulario de adopción en una pestaña nueva, enviando los datos de la mascota elegida*/
function adoptar (petId){
    const cadenaUrl = 'formularioAdopcion.html?mascotaElegida=true&idMascota=' + petId;
    window.open(cadenaUrl, "_blank");
}

/*
    Función que prerrellena parte del formulario de adopción al cargarse, si se le han enviado parámetros.
    El método para coger parámetros de la url se ha obtenido de https://www.sitepoint.com/get-url-parameters-with-javascript/
*/
function prerrellenarFormulario(){ 
    const urlParam = new URLSearchParams(window.location.search); /*obtiene la parte de la url que contiene los parámetros*/

    /*extraer los parámetros relevantes a la mascota elegida (en un futuro la funcionalidad se puede ampliar a otros parámetros)*/
    const mascotaElegida = urlParam.get('mascotaElegida'); 
    const miMascotaiD = urlParam.get('idMascota');

    /*rellena los campos para los que tenemos parámetros*/
    if (mascotaElegida) {
        document.getElementById('mascotaElegida').checked = true;
        document.getElementById('idMascota').value = miMascotaiD;
    }

    /*Llama a las funciones sobre las checkboxes*/
    toggleDatosMascota();
    toggleDescripcionVivienda();
}

/*Función que habilita y deshabilita las secciones de datos de la mascota según el valor de mascotaElegida*/
function toggleDatosMascota () {
    /*Obtiene el estatus de la checkbox de mascotaElegida*/
    const valorToggle = document.getElementById('mascotaElegida').checked;

    /*Habilita/deshabilita el campo idMascota dependiendo del estado de la checkbox*/
    document.getElementById('idMascota').disabled = !valorToggle;
    document.getElementById('idMascota').required = valorToggle; /*Cuando está habilitado, el campo debe ser obligatorio*/

    /*Habilitar/deshabilita las secciones de requisitos de mascota 
    dependiendo del estado de la checkbox*/
    document.getElementById('especie').disabled = valorToggle;
    document.getElementById('especie').value= "";

    document.getElementById('sexo').disabled = valorToggle;
    document.getElementById('sexo').value= "";

    document.getElementById('edad').disabled = valorToggle;
    document.getElementById('edad').value= "";

    document.getElementById('tamMascota').disabled = valorToggle;
    document.getElementById('tamMascota').selectedIndex = -1;


}

/*Función que habilita y deshabilita la sección de descripción de vivienda según la opción elegida en Vivienda*/
function toggleDescripcionVivienda(){
    const valorToggle = document.getElementById('otraVivienda').checked;
    document.getElementById('descVivienda').disabled = !valorToggle;
    document.getElementById('descVivienda').required = valorToggle;
}

/*Función que al cargar mascotas.html muestra la mascota pasada como parámetro*/
function mostrarMascota(){
    const urlParam = new URLSearchParams(window.location.search);
    const idMascota = urlParam.get('idMascota')
    if (idMascota) {
        const radioMascota = "check"+idMascota;
        document.getElementById(radioMascota).checked=true;
        window.location = window.location+"#"+idMascota;
    }
}

/*Función que abre el submenu*/
function abrirSubmenu(){
    document.getElementById("submenu-barra").style.display = "block";
    document.getElementById("cerrar-submenu").style.display="unset";
    document.getElementById("abrir-submenu").style.display="none";
}

/*Función que cierra el submenú*/
function cerrarSubmenu(){
    document.getElementById("submenu-barra").style.display = "none";
    document.getElementById("cerrar-submenu").style.display="none";
    document.getElementById("abrir-submenu").style.display="unset";
}