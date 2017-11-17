var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#updatesHistory").show();
    }
    else {
        $("#updatesHistory").hide();
    }
    $("#statusUpdate").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        var employeeToObserve = $("#employee-id")[0].value;
        if (employeeToObserve == "") {
            employeeToObserve = "all"; // default
        }
        stompClient.subscribe('/topic/onlineStatus/' + employeeToObserve, function (updateMsg) {
            showStatusUpdate(JSON.parse(updateMsg.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showStatusUpdate(updateMsg) {
    $("#statusUpdate").append("<tr><td>" + updateMsg.user + " is " + updateMsg.status + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});

