package com.company.rules;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.droolsassert.DroolsAssert;
import org.droolsassert.DroolsSession;
import org.droolsassert.TestRules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;

import com.company.model.InputObject;

@DroolsSession(resources = "classpath*:**/rules/inputObjectExample.xlsx",
		builderProperties = "drools.dump.dir = target/dump",
		showStateTransitionPopup = true)
public class InputObjectTest extends DroolsAssert {
	
	@RegisterExtension
	public DroolsAssert droolsAssert = this;
	
	@Test
	@TestRules(expected = {"check_Date"})
	public void testInputObjectExample() {
		KieCommands commandFactory = KieServices.get().getCommands();
		List<Command<?>> commands = new ArrayList<>();
		
		InputObject inputObject = new InputObject();
		inputObject.setDate(new Date());

		commands.add(commandFactory.newInsert(inputObject, "ValRes"));
		commands.add(commandFactory.newFireAllRules());

		commands.forEach(c -> getSession().execute(c));
	}

}