package maduna.junior.courtcounter;
        import android.content.DialogInterface;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity
 {


    // Tracks the SCORE
    // for Team A
    int scoreTeamA = 0;
    // for Team B
    int scoreTeamB = 0;

    // Track the STATISTIC
    // for Team A
    int faultTeamA = 0;
    int yellowCardTeamA = 0;
    int redCardTeamA = 0;
    // for Team B
    int faultTeamB = 0;
    int yellowCardTeamB = 0;
    int redCardTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the "Goal" button is clicked for Team A.
     */
    public void teamAGoal(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method is called when the "Fault" button is clicked for Team A.
     */
    public void teamAFault(View view) {
        faultTeamA = faultTeamA + 1;
        displayFaultTeamA(faultTeamA);
    }

    /**
     * This method is called when the "Yellow Card" button is clicked for Team A.
     */
    public void teamAYellowCard(View view) {
        yellowCardTeamA = yellowCardTeamA + 1;
        displayYellowCardTeamA(yellowCardTeamA);
    }

    /**
     * This method is called when the "Red Card" button is clicked for Team A.
     */
    public void teamARedCard(View view) {
        redCardTeamA = redCardTeamA + 1;
        displayRedCardTeamA(redCardTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_a_team);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays statistics for Team A - Fault
     */
    public void displayFaultTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fault_teamA);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays statistics for Team A - Yellow Card
     */
    public void displayYellowCardTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_teamA);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays statistics for Team A - Red Card
     */
    public void displayRedCardTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_teamA);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method is called when the "Goal" button is clicked for Team B.
     */
    public void teamBGoal(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method is called when the "Fault" button is clicked for Team B.
     */
    public void teamBFault(View view) {
        faultTeamB = faultTeamB + 1;
        displayFaultTeamB(faultTeamB);
    }

    /**
     * Increments total number of yellow cards for team B when button is clicked
     */
    public void teamBYellowCard(View view) {
        yellowCardTeamB = yellowCardTeamB + 1;
        displayYellowTeamB(yellowCardTeamB);
    }

    /**
     * Increments total number of red cards for team B when button is clicked
     */
    public void teamBRedCard(View view) {
        redCardTeamB = redCardTeamB + 1;
        displayRedCardTeamB(redCardTeamB);
    }

    /**
     * Displays score for team B
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score_b_team);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Foul stats team B
     */
    public void displayFaultTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fault_teamB);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Yellow card stats for team B
     */
    public void displayYellowTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.yellow_teamB);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Red card stats for team B
     */
    public void displayRedCardTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.red_teamB);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Method is called when the Reset button is clicked....resets score to zero for both teams
     */
    public void reset(View v) {
        // Team A
        scoreTeamA = 0;
        faultTeamA = 0;
        yellowCardTeamA = 0;
        redCardTeamA = 0;
        displayForTeamA(scoreTeamA);
        displayRedCardTeamA(redCardTeamA);
        displayYellowCardTeamA(yellowCardTeamA);
        displayFaultTeamA(faultTeamA);

        // Team B
        scoreTeamB = 0;
        faultTeamB = 0;
        yellowCardTeamB = 0;
        redCardTeamB = 0;
        displayForTeamB(scoreTeamB);
        displayRedCardTeamB(redCardTeamB);
        displayYellowTeamB(yellowCardTeamB);
        displayFaultTeamB(faultTeamB);
    }

     /**
      * This method is called when the Match Stats  button is clicked to display the full match stats
      */
    public void calculateStats(View v)
    {
        /**
         * Format the match statistics
         */

        String homeScore = "Home Team Total Goals : " + scoreTeamA;
        String homeFoul = "Home Team Total Fouls: " + faultTeamA;
        String homeRed = "Home Team Total Red Cards : " + redCardTeamA;
        String homeYellow = "Home Team Total Yellow Cards : " + yellowCardTeamA;

        String awayScore = "Away Team Total Goals : " + scoreTeamB;
        String awayFoul = "Away Team Total Fouls: " + faultTeamB;
        String awayRed = "Away Team Total Red Cards : " + redCardTeamB;
        String awayYellow = "Away Team Total Yellow Cards : " + yellowCardTeamB;




        /**
         * Displays an Alert Dialog with the full Match Statistics
         */
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(homeScore + "\t" + awayScore + "\n" + homeFoul + "\t" + awayFoul + "\n" + homeYellow + "\t" + awayYellow + "\n" + homeRed + "\t" + awayRed)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setTitle("Match Statistics")
                .create();
        myAlert.show();

    }

}