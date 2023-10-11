function send(x,y,r) {
    $.ajax({
        type: "GET",
        url: "controller",
        data: {
            X: x,
            Y: y,
            R: r
        },
        success: function (){
            location.reload();
        },
        dataType: "html"
    });
}

$("input[type=text]").on("input", function(){
    var val = $(this).val();
    if(!((val >= -5 && val <= 5) || val == '-')) {
        alert("Слышь, значение должно быть от -5 до 5 а не " + val + " !!!");
        $(this).val("");
    }
});

$("form input[name=x]").on("click", function(){
    $("form input[name=x]").removeClass("active");
    $(this).addClass("active");
});

$("form .check").on("click", function(){
    var x = $("form input[name=x].active").val();
    var y = $("form input[name=y]").val();
    var r = $("form input[name=r]:checked").val();
    if(x && y.length > 0 && r.length > 0) {
        send(x, y, r);
    }
    else {
        alert("НАМ НУЖНЫ X, Y и R !!!")
    }
});

$("svg").on("click", function (event) {
    var svgOffset = $(this).offset();
    var X = event.pageX - svgOffset.left;
    var Y = event.pageY - svgOffset.top;
    var r = $("form input[name=r]:checked").val();


    if(!r) alert("Выберите значение R!!!");
    else {
        var planeX = ((X - 150) / (120 / r)).toFixed(1);
        var planeY = ((150 - Y) / (120 / r)).toFixed(1);

        send(planeX, planeY, r);

    }

});