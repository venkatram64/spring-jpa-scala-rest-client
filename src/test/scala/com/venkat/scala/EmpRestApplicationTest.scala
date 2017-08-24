package com.venkat.scala

import com.venkat.scala.client.{Address, Employee, JpaRestClient}
import org.junit.{Before, Test}
import org.junit.runner.RunWith
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles(Array("test"))
@RunWith(classOf[SpringRunner])
//@SpringBootTest(classes = Array(classOf[PhoenixConnection], classOf[EmployeeService]))
@EnableConfigurationProperties
class EmpRestApplicationTest {

	var restClient:JpaRestClient = _

	@Before
	def setup : Unit = {
		restClient = new JpaRestClient
	}

	@Test
	def getEmpRecords(): Unit = {
		println(restClient.getEmployees("http://localhost:8090/employee/employees"))
	}

	@Test
	def getEmpRecordById(): Unit = {
		println(restClient.getEmployees("http://localhost:8090/employee/emp/"+"1"))
	}

	@Test
	def deleteEmpRecordById(): Unit = {
		println(restClient.deleteEmployeeById("http://localhost:8090/employee/"+"5"))
	}

	@Test
	def createEmpRecord(): Unit = {
		val address = new Address("East Square", "Rochester, NY", "12976")
		val employee = new Employee("James","Bond","james.bond@gmail.com", 50, address)
		println(restClient.createEmployee("http://localhost:8090/employee/createEmp",employee))
	}

	@Test
	def updateEmpRecord(): Unit = {
		val address = new Address("East Square drive", "Rochester, NY", "12976")
		val employee = new Employee("James","Bond","james.bond@gmail.com", 51, address)
		println(restClient.createEmployee("http://localhost:8090/employee/createEmp",employee))
	}

}
