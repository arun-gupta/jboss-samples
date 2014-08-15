var wsByteArrayUri = "ws://" + document.location.host + document.location.pathname + "bytearray";
var wsByteBufferUri = "ws://" + document.location.host + document.location.pathname + "bytebuffer";

console.log("Connecting to " + wsByteArrayUri);
console.log("Connecting to " + wsByteBufferUri);

var websocketByteArray = new WebSocket(wsByteArrayUri);
var websocketByteBuffer = new WebSocket(wsByteBufferUri);

websocketByteArray.binaryType = "arraybuffer";
websocketByteBuffer.binaryType = "arraybuffer";

websocketByteArray.onopen = function(evt) { onOpenByteArray(evt); };
websocketByteArray.onmessage = function(evt) { onMessageByteArray(evt); };
websocketByteArray.onerror = function(evt) { onError(evt); };

websocketByteBuffer.onopen = function(evt) { onOpenByteBuffer(evt); };
websocketByteBuffer.onmessage = function(evt) { onMessageByteBuffer(evt); };
websocketByteBuffer.onerror = function(evt) { onError(evt); };

var output = document.getElementById("output");

function onOpenByteArray() {
    console.log("onOpen (byte])");
}

function onOpenByteBuffer() {
    console.log("onOpen (ByteBuffer)");
}

function echoBinaryByteArray() {
    var buffer = new ArrayBuffer(myByteArrayField.value.length);
    var bytes = new Uint8Array(buffer);
    for (var i=0; i<bytes.length; i++) {
        bytes[i] = i;
    }
    websocketByteArray.send(buffer);
    writeToScreen("SENT (byte[]): " + buffer.byteLength + " bytes");
}

function echoBinaryByteBuffer() {
    var buffer = new ArrayBuffer(myByteBufferField.value.length);
    var bytes = new Uint8Array(buffer);
    for (var i=0; i<bytes.length; i++) {
        bytes[i] = i;
    }
    websocketByteBuffer.send(buffer);
    writeToScreen("SENT (ByteBuffer): " + buffer.byteLength + " bytes");
}

function onMessageByteArray(evt) {
    writeToScreen("RECEIVED (byte[]): " + evt.data);
}

function onMessageByteBuffer(evt) {
    writeToScreen("RECEIVED (ByteBuffer): " + evt.data);
}

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function writeToScreen(message) {
    var pre = document.createElement("p");
    pre.style.wordWrap = "break-word";
    pre.innerHTML = message;
    output.appendChild(pre);
}
