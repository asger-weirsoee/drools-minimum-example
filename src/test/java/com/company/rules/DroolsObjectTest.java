package com.company.rules;

import java.util.ArrayList;
import java.util.List;

import org.droolsassert.DroolsAssert;
import org.droolsassert.DroolsSession;
import org.droolsassert.TestRules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;

import com.company.model.DroolsObject;

@DroolsSession(resources = "classpath*:**/rules/droolsObjectExample.xlsx",
		builderProperties = "drools.dump.dir = target/dump",
		showStateTransitionPopup = true)
public class DroolsObjectTest extends DroolsAssert {
	
	@RegisterExtension
	public DroolsAssert droolsAssert = this;
	
	@Test
	@TestRules(expectedCount = { "1", "Check_DyrAlder" })
	public void testDroolsObjectExample() {
		KieCommands commandFactory = KieServices.get().getCommands();
		List<Command<?>> commands = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			DroolsObject droolsObject = new DroolsObject();
			droolsObject.put("ruleSet", "set" + i);
			droolsObject.put("DyrAlder", i);
			
			commands.add(commandFactory.newInsert(droolsObject, "ValRes"));
			commands.add(commandFactory.newFireAllRules());
		}
		
		commands.forEach(c -> getSession().execute(c));
	}
	
	@Test
	@TestRules(expectedCount = { "1", "Check_DyrAlder" })
	public void testDroolsObjectExample2() {
		for (int i = 0; i < 10; i++) {
			DroolsObject droolsObject = new DroolsObject();
			droolsObject.put("ruleSet", "set" + i);
			droolsObject.put("DyrAlder", i);
			insertAndFire(droolsObject);
		}
	}
}