package com.Brayan_Vargas.taller1;

import com.Brayan_Vargas.taller1.dao.*;
import com.Brayan_Vargas.taller1.model.*;
import com.Brayan_Vargas.taller1.repository.*;
import com.Brayan_Vargas.taller1.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Taller1Application {

	public static void main(String[] args) {
		SpringApplication.run(Taller1Application.class, args);
/*
		UserrServiceImp userr= c.getBean(UserrServiceImp.class);
		PersonServiceImp person= c.getBean(PersonServiceImp.class);

		Person p1=new Person();
		List<PersonRole> roles1=new ArrayList<>();

		Rolee rol1=new Rolee();
		rol1.setRoleName("Administrador");



		PersonRolePK pk1=new PersonRolePK();
		pk1.setPersPersId(p1.getPersId());
		pk1.setRoleRoleId(rol1.getRoleId());

		PersonRole pr1=new PersonRole();
		pr1.setPerson(p1);
		pr1.setRolee(rol1);
		pr1.setId(pk1);

		roles1.add(pr1);

		p1.setPersonRoles(roles1);

		person.savePerson(p1);

		Userr user = new Userr();
		user.setUserName("admin");
		user.setUserPassword("{noop}123456789");
		user.setPerson(p1);

		userr.saveUserr(user);*/
	}
/*
	@Bean
	public CommandLineRunner thymeleafTaller2(UserrRepository userrRepository, PersonRepository personRepository, PersonRoleRepository personRoleRepository, RoleRepository roleRepository,
											  InstitutionRepository institutionRepository, PhysicalspacetypeRepository physicalspacetypeRepository, CampusRepository campusRepository, PhysicalspaceRepository physicalspaceRepository){
		return args -> {

			Person p1=new Person();
			List<PersonRole> roles1=new ArrayList<>();

			Rolee rol1=new Rolee();
			rol1.setRoleName("admin");

			roleRepository.save(rol1);
			personRepository.save(p1);

			PersonRolePK pk1=new PersonRolePK();
			pk1.setPersPersId(p1.getPersId());
			pk1.setRoleRoleId(rol1.getRoleId());

			PersonRole pr1=new PersonRole();
			pr1.setPerson(p1);
			pr1.setRolee(rol1);
			pr1.setId(pk1);

			roles1.add(pr1);

			p1.setPersonRoles(roles1);

			Userr user = new Userr();
			user.setUserName("admin");
			user.setUserPassword("{noop}123");
			user.setPerson(p1);

			personRoleRepository.save(pr1);

			userrRepository.save(user);

				System.out.println(userrRepository.findByUserName("admin").get(0).getPerson().getPersonRoles().get(0).getRolee().getRoleName());
			System.out.println(userrRepository.findByUserName("admin").get(0).getUserPassword());
			//USER 2

			Person p2=new Person();
			List<PersonRole> roles2=new ArrayList<>();

			Rolee rol2=new Rolee();
			rol2.setRoleName("Operator");

			roleRepository.save(rol2);
			personRepository.save(p2);

			PersonRolePK pk2=new PersonRolePK();
			pk2.setPersPersId(p2.getPersId());
			pk2.setRoleRoleId(rol2.getRoleId());

			PersonRole pr2=new PersonRole();
			pr2.setPerson(p2);
			pr2.setRolee(rol2);
			pr2.setId(pk2);

			roles2.add(pr2);

			p2.setPersonRoles(roles2);

			Userr user2 = new Userr();
			user2.setUserName("operator");
			user2.setUserPassword("{noop}123");
			user2.setPerson(p2);

			personRoleRepository.save(pr2);

			userrRepository.save(user2);

			System.out.println(userrRepository.findByUserName("operator").get(0).getPerson().getPersonRoles().get(0).getRolee().getRoleName());


			//INSTITUTION

			Institution inst =new Institution();

			inst.setInstName("inst");
			inst.setInstAcademicserverurl("https://inst");
			inst.setInstAcadextradataurl("https://inst");
			inst.setInstAcadloginurl("https://inst");
			inst.setInstAcadpersoninfodocurl("https://inst");
			inst.setInstAcadpersoninfoidurl("https://inst");
			inst.setInstAcadphysicalspacesurl("https://inst");
			inst.setInstAcadprogrammedcoursesurl("https://inst");
			inst.setInstLdapurl("https://inst");

			institutionRepository.save(inst);


			//PHYSICAL SPACE TYPE

			Physicalspacetype physpctype=new Physicalspacetype();
			physpctype.setPhyspctypeName("phystype");
			physpctype.setPhyspctypeImpliescomm("comm");
			physpctype.setInstitution(inst);

			physicalspacetypeRepository.save(physpctype);

			//CAMPUS

			Institutioncampus instCam=new Institutioncampus();
			instCam.setInstcamName("campus");
			instCam.setInstcamOccupation(new BigDecimal(0));
			instCam.setInstitution(inst);

			campusRepository.save(instCam);


			//PHYSICAL SPACE

			Physicalspace physicalspace=new Physicalspace();
			physicalspace.setPhyspcName("pyspc");
			physicalspace.setPhyspcExtid("12345");
			physicalspace.setInstitutioncampus(instCam);
			physicalspace.setPhysicalspacetype(physpctype);

			physicalspaceRepository.save(physicalspace);


		};
	}
	*/


	@Bean
	public CommandLineRunner thymeleafTaller2(UserrDAO userrRepository, PersonDAO personRepository, PersonRoleDAO personRoleRepository, RoleDAO roleRepository,

											  InstitutionService institutionRepository, PhysicalspaceTypeService physicalspacetypeRepository, CampusService campusRepository, PhysicalspaceService physicalspaceRepository,
											  HatParameterService hatParameterService){
		return args -> {

			Person p1=new Person();
			List<PersonRole> roles1=new ArrayList<>();

			Rolee rol1=new Rolee();
			rol1.setRoleName("admin");

			roleRepository.save(rol1);
			personRepository.save(p1);

			PersonRolePK pk1=new PersonRolePK();
			pk1.setPersPersId(p1.getPersId());
			pk1.setRoleRoleId(rol1.getRoleId());

			PersonRole pr1=new PersonRole();
			pr1.setPerson(p1);
			pr1.setRolee(rol1);
			pr1.setId(pk1);

			roles1.add(pr1);

			p1.setPersonRoles(roles1);

			Userr user = new Userr();
			user.setUserName("admin");
			user.setUserPassword("{noop}123");
			user.setPerson(p1);

			personRoleRepository.save(pr1);

			userrRepository.save(user);

			System.out.println(userrRepository.findByName("admin").get(0).getPerson().getPersonRoles().get(0).getRolee().getRoleName());
			System.out.println(userrRepository.findByName("admin").get(0).getUserPassword());
			//USER 2

			Person p2=new Person();
			List<PersonRole> roles2=new ArrayList<>();

			Rolee rol2=new Rolee();
			rol2.setRoleName("Operator");

			roleRepository.save(rol2);
			personRepository.save(p2);

			PersonRolePK pk2=new PersonRolePK();
			pk2.setPersPersId(p2.getPersId());
			pk2.setRoleRoleId(rol2.getRoleId());

			PersonRole pr2=new PersonRole();
			pr2.setPerson(p2);
			pr2.setRolee(rol2);
			pr2.setId(pk2);

			roles2.add(pr2);

			p2.setPersonRoles(roles2);

			Userr user2 = new Userr();
			user2.setUserName("operator");
			user2.setUserPassword("{noop}123");
			user2.setPerson(p2);

			personRoleRepository.save(pr2);

			userrRepository.save(user2);

			System.out.println(userrRepository.findByName("operator").get(0).getPerson().getPersonRoles().get(0).getRolee().getRoleName());


			//INSTITUTION

			Institution inst =new Institution();

			inst.setInstName("inst");
			inst.setInstAcademicserverurl("https://inst");
			inst.setInstAcadextradataurl("https://inst");
			inst.setInstAcadloginurl("https://inst");
			inst.setInstAcadpersoninfodocurl("https://inst");
			inst.setInstAcadpersoninfoidurl("https://inst");
			inst.setInstAcadphysicalspacesurl("https://inst");
			inst.setInstAcadprogrammedcoursesurl("https://inst");
			inst.setInstLdapurl("https://inst");

			institutionRepository.saveInstitution(inst);


			//PHYSICAL SPACE TYPE

			Physicalspacetype physpctype=new Physicalspacetype();
			physpctype.setPhyspctypeName("phystype");
			physpctype.setPhyspctypeImpliescomm("comm");
			physpctype.setInstitution(inst);

			physicalspacetypeRepository.savePhysicalspaceTypeService(physpctype);

			//CAMPUS

			Institutioncampus instCam=new Institutioncampus();
			instCam.setInstcamName("campus");
			instCam.setInstcamOccupation(new BigDecimal(0));
			instCam.setInstitution(inst);

			campusRepository.saveCampus(instCam);


			//PHYSICAL SPACE

			Physicalspace physicalspace=new Physicalspace();
			physicalspace.setPhyspcName("pyspc");
			physicalspace.setPhyspcExtid("12345");
			physicalspace.setInstitutioncampus(instCam);
			physicalspace.setPhysicalspacetype(physpctype);

			physicalspaceRepository.savePhysicalspace(physicalspace);

			//HAT PARAMETER

			HatParameter hatParameter = new HatParameter();
			hatParameter.setParamName("hat1");
			hatParameter.setParamType("type1");
			hatParameter.setParamValue("5");
			hatParameter.setInstitution(inst);

			hatParameterService.saveHatParameter(hatParameter);

		};
	}
}
