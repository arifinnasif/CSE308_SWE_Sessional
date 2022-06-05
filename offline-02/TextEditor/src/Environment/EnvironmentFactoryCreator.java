package Environment;

public class EnvironmentFactoryCreator {
    public static AbstractEnvironmentFactory getFactory(String env) {
        if("C".equalsIgnoreCase(env)) {
            return new CEvinormentFactory();
        } else if("CPP".equalsIgnoreCase(env)) {
            return new CPPEnvironmentFactory();
        } else if("PYTHON".equalsIgnoreCase(env)) {
            return new PythonEnvironmentFactory();
        }
        return null;
    }
}
