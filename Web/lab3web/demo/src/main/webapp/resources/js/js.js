function enable_graph() {
    if (graph_click_enabled) {
        elt.removeEventListener('click', handleGraphClick);
        graph_click_enabled = false;
    } else {
        elt.addEventListener('click', handleGraphClick);
        graph_click_enabled = true;
    }
}

enable_graph();

function handleGraphClick (evt) {
    var r_val = document.getElementById('ker:txt').value;

    if (r_val <= 0.000001) {
        alert("Choose R!");
        return;
    }

    const rect = elt.getBoundingClientRect();
    const x = evt.clientX - rect.left;
    const y = evt.clientY - rect.top;

    // Note, pixelsToMath expects x and y to be referenced to the top left of
    // the calculator's parent container.
    const mathCoordinates = calculator.pixelsToMath({x: x, y: y});

    send_intersection_rq(mathCoordinates.x - 0.424, mathCoordinates.y + 0.202, r_val);
}

function send_intersection_rq(xValue, yValue, rValue){

    document.getElementById('ker:x_input').value = xValue.toFixed(3);
    document.getElementById('ker:y').value = yValue.toFixed(3);
    drawPointXY(xValue.toFixed(3), yValue.toFixed(3))
}