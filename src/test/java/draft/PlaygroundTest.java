package draft;

import org.droolsassert.DroolsAssert;
import org.droolsassert.TestRules;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;

import java.util.ArrayList;
import java.util.List;

public class PlaygroundTest extends DroolsAssert {

    @RegisterExtension
    public DroolsAssert droolsAssert = this;


    @Test
    @TestRules(expectedCount = { "1", "Check_DyrAlder" })
    public void testDroolsObjectExample() {
        KieCommands commandFactory = KieServices.get().getCommands();
        List<Command<?>> commands = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            DroolsObject inputObject = new DroolsObject();
            inputObject.put("ruleSet", "set" + i);
            inputObject.put("DyrAlder", i);

            commands.add(commandFactory.newInsert(inputObject, "ValRes"));
            commands.add(commandFactory.newFireAllRules());
        }

        commands.forEach(c -> getSession().execute(c));
    }
}