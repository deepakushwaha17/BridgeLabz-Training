package BrowserBuddy;

public class BrowserBuddyMain {

    public static void main(String[] args) {

        BrowserBuddy browser = new BrowserBuddy();

        browser.openPage("google.com");
        browser.openPage("openai.com");
        browser.openPage("github.com");

        System.out.println(browser.back());   
        System.out.println(browser.back());     
        System.out.println(browser.forward());  

        browser.closeTab();                     

        System.out.println(browser.restoreTab()); 
        System.out.println(browser.showCurrentPage());
    }
}
