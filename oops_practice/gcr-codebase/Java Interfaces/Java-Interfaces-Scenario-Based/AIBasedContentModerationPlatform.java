public class AIBasedContentModerationPlatform {

    public static void main(String[] args) {

        String[] posts = {
                "This is a good post",
                "Buy now free offer",
                "This post contains bad language",
                "Limited offer click here",
                "Have a nice day"
        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();

        System.out.println();

        for (String post : posts) {

            System.out.println("Post: " + post);

            if (moderator.detectSpam(post)) {
                System.out.println("Status: Spam Post");
            }
            else if (moderator.checkOffensiveContent(post)) {
                System.out.println("Status: Offensive Post");
            }
            else {
                System.out.println("Status: Valid Post");
            }

            System.out.println();
        }
    }
}

interface TextModeration {

    boolean checkOffensiveContent(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: Offensive language is not allowed.");
    }

    static boolean containsRestrictedWords(String post) {

        String text = post.toLowerCase();

        return text.contains("bad") ||
                text.contains("hate") ||
                text.contains("abuse");
    }
}

interface SpamDetection {

    boolean detectSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: Spam content is not allowed.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public boolean checkOffensiveContent(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public boolean detectSpam(String post) {

        String text = post.toLowerCase();

        return text.contains("buy now") ||
                text.contains("free") ||
                text.contains("click here") ||
                text.contains("offer");
    }

    @Override
    public void displayModerationPolicy() {

        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();

        System.out.println("Posts violating any policy will be rejected.");
    }
}