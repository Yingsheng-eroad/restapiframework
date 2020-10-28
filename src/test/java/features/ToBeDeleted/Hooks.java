//package stepDefinitions;
//
//import com.cucumber.listener.Reporter;
//import utils.BaseUtil;
//import io.cucumber.java.*;
//
//public class Hooks extends BaseUtil{
//
//
//    private BaseUtil base;
//
//    public Hooks(BaseUtil base) {
//        this.base = base;
//
//    }
////    @Before
////    public void beforeScenario(Scenario scenario) {
////        base.scenarioDef.(scenario.getName());
////    }
//    @Before
//    public void InitializeTest(Scenario scenario) {
//
//        base.scenarioDef = base.features.createNode(scenario.getName());
//
//        System.out.println("Starting the test");
//
//    }
//
//
//    @After
//    public void TearDownTest(Scenario scenario) {
//        if (scenario.isFailed()) {
//            System.out.println(scenario.getName());
//        }
//        System.out.println("Tests Completed");
//
//    }
//
//    @BeforeStep
//    public void BeforeEveryStep(Scenario scenario) {
//
//        System.out.println("Before every step " + scenario.getId());
//
//        //((PickleStep)((PickleStepTestStep)
//    }
//
//    @AfterStep
//    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
//
//        System.out.println("Before every step " + scenario.getId());
//    }
//
//}