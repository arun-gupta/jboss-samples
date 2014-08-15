<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebSocket : Binary Messages</title>

    </head>
    <body>
        <h1>WebSocket : Binary Messages</h1>

        <form action=""> 
            <h2>Data is sent/received using byte[]</h2>
            <input onclick="echoBinaryByteArray()" value="Echo" type="button"> 
            <input id="myByteArrayField" value="12345678" type="text"><br>
        </form>
        <form action=""> 
            <h2>Data is sent/received using ByteBuffer</h2>
            <input onclick="echoBinaryByteBuffer()" value="Echo" type="button"> 
            <input id="myByteBufferField" value="12345678" type="text"><br>
        </form>

        <div id="output"></div>
        <script language="javascript" type="text/javascript" src="websocket.js">
        </script>
    </body>
</html>
