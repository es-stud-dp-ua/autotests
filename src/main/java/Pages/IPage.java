package Pages;
public interface IPage {
	public  boolean isSignedIn();
	public boolean isPageOpened();
	Page signIn(String login, String pass);
	Page signOut();
	RegistPage Register();
	ContactPage OpenContactPage();
	ContentPage switchTo(MenuItem m);
}
