package org.akhdan.simplequiz;

public class Questions {
    public String mQuestions[] = {
            "Manakah yang termasuk planet pertama dalam tata surya kita?",
            "Manakah yang termasuk planet kedua dalam tata surya kita?",
            "Manakah yang termasuk planet ketiga dalam tata surya kita?",
            "Manakah yang termasuk planet keempat dalam tata surya kita?",
            "Manakah yang termasuk planet kelima dalam tata surya kita?",
            "Manakah yang termasuk planet keenam dalam tata surya kita?",
            "Manakah yang termasuk planet ketujuh dalam tata surya kita?",
            "Manakah yang termasuk planet kedelapan dalam tata surya kita?"
    };

    private String mChoices[][] = {
            {"Merkurius", "Venus", "Mars", "Saturnus"},
            {"Jupiter", "Venus", "Bumi", "Neptunus"},
            {"Bumi", "Jupiter", "Neptunus", "Venus"},
            {"Jupiter", "Saturnus", "Mars", "Bumi"},
            {"Jupiter", "Neptunus", "Mars", "Saturnus"},
            {"Uranus", "Venus", "Mars", "Saturnus"},
            {"Saturnus", "Neptunus", "Uranus", "Bumi"},
            {"Neptunus", "Venus", "Mars", "Saturnus"}
    };

    public String mCorrectAnswer[] = {
            "Merkurius",
            "Venus",
            "Bumi",
            "Mars",
            "Jupiter",
            "Saturnus",
            "Uranus",
            "Neptunus"
    };

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswer[a];
        return answer;
    }
}
