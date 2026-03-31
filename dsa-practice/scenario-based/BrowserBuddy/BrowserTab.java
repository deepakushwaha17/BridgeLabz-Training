package BrowserBuddy;

public class BrowserTab {

    private PageNode current; // pointer to current page

    // Open a new page 
    public boolean visitPage(String url) {
        PageNode newPage = new PageNode(url);

        if (current != null) {
            current.next = null; // clear forward history
            newPage.prev = current;
            current.next = newPage;
        }

        current = newPage;
        return true;
    }

    // Move backward 
    public String goBack() {
        if (current == null || current.prev == null) {
            return "No previous page available.";
        }

        current = current.prev;
        return current.url;
    }

    // Move forward
    public String goForward() {
        if (current == null || current.next == null) {
            return "No forward page available.";
        }

        current = current.next;
        return current.url;
    }

    // Get current page
    public String getCurrentPage() {
        if (current == null) {
            return "No page opened.";
        }
        return current.url;
    }
}