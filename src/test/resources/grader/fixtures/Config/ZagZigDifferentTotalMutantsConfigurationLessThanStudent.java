package delft;

import nl.tudelft.cse1110.andy.codechecker.engine.CheckScript;
import nl.tudelft.cse1110.andy.config.RunConfiguration;
import nl.tudelft.cse1110.andy.config.MetaTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Configuration extends RunConfiguration {

    @Override
    public CheckScript checkScript() {
        return new CheckScript(List.of());
    }

    @Override
    public Map<String, Float> weights() {
        return new HashMap<>() {{
            put("coverage", 0.5f);
            put("mutation", 0.5f);
            put("meta", 0.0f);
            put("codechecks", 0.0f);
        }};
    }

    @Override
    public List<String> classesUnderTest() {
        return List.of("delft.ZagZig");
    }

    @Override
    public List<String> listOfMutants() {
        return DEFAULTS;
    }

    @Override
    public List<MetaTest> metaTests() {
        return List.of();
    }

    @Override
    public int numberOfMutationsToConsider() {
        return 10;
    }

}