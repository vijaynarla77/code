package Local;



public class Test extends BeforeAfter
{
	@org.testng.annotations.Test
	public void Tc001() throws Exception
	{
		test=extent.createTest("Verifying youtube with latest songs.......");
		Implementation im = new Implementation(driver);
		im.sampleimp();
	}
	@org.testng.annotations.Test
	public void Tc002() throws Exception
	{
		test=extent.createTest("Verifying youtube with latest songs.......");
		Implementation im = new Implementation(driver);
		im.sampleimp();
	}


}
