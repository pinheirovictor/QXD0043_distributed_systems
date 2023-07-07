# -*- coding: utf-8 -*-
import socket
import json
import random

while 1:
    HOST = "localhost"
    PORT = 12000
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect((HOST, PORT))

    resposta=""
    objRef = "" 

    requestId = 0
    decimal = input("digite o valor em decimal \n")

    methodId = input("digite o metodo\n")

    if methodId == '1':
        objRef = "toHex"  
    elif methodId == '2':
        objRef = "toBin"
    elif methodId == '3':
        objRef = "toOctal"
    
    args = {
        "decimal" : decimal,
        "funcao" : objRef,
        "resposta" : resposta
    }

    x = {
        "messageType" : 0,
        "requestId" : requestId,
        "objectReference" : objRef,
        "methodId" : methodId,
        "arguments" : args
    }

    jsonObject = json.dumps(x)
    
    msg = jsonObject + "\r\n"

    sock.send(msg.encode())

    data = sock.recv(1024)

    y = json.loads(data)

    if (y["messageType"] == '0'):
        continue

    z = y["arguments"]

    if ( y["requestId"] == x["requestId"] ):
        print ("resposta : " + z["resposta"] + " \n")
    else:
        print ("Request nao é sua")

    requestId = requestId + 1
 

   
