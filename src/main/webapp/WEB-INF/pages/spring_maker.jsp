<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="https://bootswatch.com/lumen/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../resources/page.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3">&nbsp;</div>
        <div class="col-md-6 text-center"><img src="../../resources/java-day1.png"></div>
        <div class="col-md-3">&nbsp;</div>
    </div>
    <div class="row">
        <div class="col-md-3">&nbsp;</div>
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <span class="glyphicon glyphicon-bookmark"></span> Demo de Internet de las cosas</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
                            <a href="#" class="btn btn-primary btn-lg" role="button" data-value="H"><span class="glyphicon glyphicon-user"></span> <br/>Alegre</a>
                            <a href="#" class="btn btn-warning btn-lg" role="button" data-value="S"><span class="glyphicon glyphicon-user"></span> <br/>Triste</a>
                            <a href="#" class="btn btn-danger btn-lg" role="button" data-value="A"><span class="glyphicon glyphicon-user"></span> <br/>Enojado</a>
                            <a href="#" class="btn btn-primary btn-lg" role="button" data-value="L"><span class="glyphicon glyphicon-user"></span> <br/>Amor</a>
                        </div>
                        <div class="col-xs-6 col-md-6">
                            <a href="#" class="btn btn-success btn-lg" role="button" data-value="X"><span class="glyphicon glyphicon-flash"></span> <br/>Temperatura?</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-md-6 text-right">
                            Temperatura actual:
                        </div>
                        <div class="col-xs-6 col-md-6" id="temperature" style="font-weight: bolder">

                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-xs-12 col-md-12">
                            <a href="http://www.creaengine.com/" class="btn btn-success btn-lg btn-block" role="button"><span class="glyphicon glyphicon-globe"></span> Website</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">&nbsp;</div>
    </div>
</div>
<script type="text/javascript"
        src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
    $(document).ready(
        function() {
            setInterval(function() {
                $.ajax({
                    url: "info",
                    type: 'GET',
                    dataType: 'json',
                    crossDomain: true,
                    async: false,
                    complete: function(resp) {
                        json = resp.responseJSON;
                        console.log(json);
                        if (json.response != "ACK"){
                            $('#temperature').text(json.response + " C");
                        }
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                    },
                });
            }, 3000);

        $(".btn").click(function(e) {
            e.preventDefault();
            value = $(this).data("value");
            $.ajax({
                url: "process?name="+value,
                type: 'GET',
                dataType: 'json',
                crossDomain: true,
                async: false,
                complete: function(resp) {
                    json = resp.responseJSON;
                    console.log(json);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                },
            });
            //
        });
    });
</script>
</body>
</html>