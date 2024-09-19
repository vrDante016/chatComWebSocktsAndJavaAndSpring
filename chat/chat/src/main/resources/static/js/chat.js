var socket = new SockJS('/gs-guide-websocket');
var stompClient = Stomp.over(socket); // Corrigido o nome

stompClient.connect({}, function(frame) {
    console.log('Connected: ' + frame);

    stompClient.subscribe('/topic/public', function(messageOutput) {
        showMessage(JSON.parse(messageOutput.body));
    });
});

function sendMessage() {
    var from = document.getElementById('from').value;
    var content = document.getElementById('content').value;

    if (stompClient && stompClient.connected) {
        stompClient.send("/app/send", {}, JSON.stringify({
            'from': from,
            'content': content,
            'moment': new Date()
        }));
    } else {
        console.log('Connection not established');
    }
}

function showMessage(message) {
    var response = document.getElementById('response');
    response.innerHTML += '<br>' + message.from + ': ' + message.content;
}
