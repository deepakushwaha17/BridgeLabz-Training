package BrowserBuddy;

import java.util.Stack;

public class BrowserBuddy {

    private BrowserTab activeTab;
    private Stack<BrowserTab> closedTabs;

    public BrowserBuddy() {
        activeTab = new BrowserTab();
        closedTabs = new Stack<>();
    }

    // Open a new page
    public boolean openPage(String url) {
        return activeTab.visitPage(url);
    }

    // Back navigation 
    public String back() {
        return activeTab.goBack();
    }

    // Forward navigation
    public String forward() {
        return activeTab.goForward();
    }

    // Close current tab
    public boolean closeTab() {
        closedTabs.push(activeTab);
        activeTab = new BrowserTab();
        return true;
    }

    // Restore recently closed tab 
    public String restoreTab() {
        if (closedTabs.isEmpty()) {
            return "No closed tabs to restore.";
        }

        activeTab = closedTabs.pop();
        return "Tab restored. Current page: " + activeTab.getCurrentPage();
    }

    // Show current page
    public String showCurrentPage() {
        return activeTab.getCurrentPage();
    }
}