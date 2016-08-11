package jvmdbbroker.plugin.http

import jvmdbbroker.core._

// http plugin tag interface
trait HttpPlugin {}

// generate request string from body, including signature
trait HttpRequestPlugin {
    def generateRequestBody(msg:HttpMsgDefine,body:HashMapStringAny):String
}

trait RawHttpRequestPlugin {
    def generateRequestBody(msg:HttpMsgDefine,body:HashMapStringAny):Array[Byte]
}

// generate signature and put signature and other necessary fields into body
trait HttpSignPlugin {
    def sign(msg:HttpMsgDefine,signatureKey:String,body:HashMapStringString):Unit
}

// parse contentStr to body, return resultCode
trait HttpResponsePlugin {
    def parseContent(msg:HttpMsgDefine, contentStr:String, body: HashMapStringAny ): Int
}
