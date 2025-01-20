    function actualizarFechaMinima() {
        const fechaInicial = document.getElementById('fechaTurnoFiltrarInicial');
        const fechaFinal = document.getElementById('fechaTurnoFiltrarFinal');

        // Establecer la fecha mínima del campo "Hasta" igual a la fecha seleccionada en "Desde"
        fechaFinal.min = fechaInicial.value;

        // Si la fecha final es menor que la inicial, actualizarla
        if (fechaFinal.value && fechaFinal.value < fechaInicial.value) {
            fechaFinal.value = fechaInicial.value;
        }

        // Habilitar el campo "Hasta" solo cuando se haya seleccionado una fecha inicial
        fechaFinal.disabled = !fechaInicial.value;
    }

    // Ejecutar la función al cargar la página
    window.onload = function() {
        const fechaFinal = document.getElementById('fechaTurnoFiltrarFinal');
        fechaFinal.disabled = !document.getElementById('fechaTurnoFiltrarInicial').value;
    };