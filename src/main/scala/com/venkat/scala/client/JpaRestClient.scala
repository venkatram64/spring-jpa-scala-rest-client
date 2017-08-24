package com.venkat.scala.client

import com.google.gson.Gson
import org.apache.http.client.methods.{HttpDelete, HttpGet, HttpPost}
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.message.BasicHeader
import org.apache.http.protocol.HTTP

/**
  * Created by venkatram.veerareddy on 8/24/2017.
  */
class JpaRestClient {

  def getEmployees(url:String): String = {
    val httpClient = HttpClientBuilder.create().build()
    var content = ""
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines().mkString
      inputStream.close()
    }
    content
  }

  def getEmployeeByid(url:String): String = {
    val httpClient = HttpClientBuilder.create().build()
    var content = ""
    val httpResponse = httpClient.execute(new HttpGet(url))
    val entity = httpResponse.getEntity
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines().mkString
      inputStream.close()
    }
    content
  }

  def deleteEmployeeById(url:String): String = {
    val httpClient = HttpClientBuilder.create().build()
    val httpDelete = new HttpDelete(url)
    httpDelete.setHeader(HTTP.CONTENT_TYPE, "application/json")
    val httpResponse = httpClient.execute(httpDelete)
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString("\n")
      inputStream.close()
    }
    httpClient.close()
    content
  }

  def createEmployee(url:String, employee: Employee): String = {

    val gson = new Gson()
    val strEntity = new StringEntity(gson.toJson(employee))
    strEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"))
    val httpClient = HttpClientBuilder.create().build()
    val httpPost = new HttpPost(url)
    httpPost.setEntity(strEntity)
    val httpResponse = httpClient.execute(httpPost)
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close()
    }
    httpClient.close()
    content
  }

  def updateEmployee(url:String, employee: Employee): String = {

    val gson = new Gson()
    val strEntity = new StringEntity(gson.toJson(employee))
    strEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"))
    val httpClient = HttpClientBuilder.create().build()
    val httpPost = new HttpPost(url)
    httpPost.setEntity(strEntity)
    val httpResponse = httpClient.execute(httpPost)
    val entity = httpResponse.getEntity
    var content = ""
    if(entity != null){
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close()
    }
    httpClient.close()
    content
  }

}
