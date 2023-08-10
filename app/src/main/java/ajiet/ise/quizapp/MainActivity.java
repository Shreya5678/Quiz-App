package ajiet.ise.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button trueButton;
    private Button falseButton;
    private TextView scoreTextView;

    private String[] questions = {
            "Is the Earth flat?",
            "Water boils at 100 degrees Celsius, right?",
            "Is the capital of France Paris?",
            "Is the sun a star?",
            // Add more questions here
    };

    private boolean[] answers = {
            false,
            true,
            true,
            true,
            // Add corresponding answers here
    };

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        scoreTextView = findViewById(R.id.scoreTextView);

        updateQuestion();

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }

    private void updateQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
    }

    private void checkAnswer(boolean userAnswer) {
        if (userAnswer == answers[currentQuestionIndex]) {
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
        updateQuestion();
        updateScore();
    }

    private void updateScore() {
        scoreTextView.setText("Score: " + score + "/" + questions.length);
    }
}
