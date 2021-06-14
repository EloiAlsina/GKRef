package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import static android.view.View.GONE;

public class GameActivity extends Fragment {

    private static final long START_TIME_IN_MILLIS = 720000;
    private static final long TOLOCAL_START_TIME_IN_MILLIS = 60000;
    private static final long TOVISITOR_START_TIME_IN_MILLIS = 60000;
    private static final long LOCAL2M_START_TIME_IN_MILLIS = 120000;
    private static final long VISITOR2M_START_TIME_IN_MILLIS = 120000;

    private TextView exclusion_local, exclusion_visitor, text_view_countdown, score_local, score_visitor, timeout_countdown_local, timeout_countdown_visitor, local_2m_timer1, local_2m_timer2, visitor_2m_timer1, visitor_2m_timer2;
    public static Button next2, next3, next4, end_match, reset, local_up, local_down, visitor_up, visitor_down, timeout_local, timeout_visitor, local_yc, local_rc, visitor_yc, visitor_rc;
    private CountDownTimer mCountDownTimer, ToLocalCountDownTimer, ToVisitorCountDownTimer, Local2mCountDownTimer, Local2mCountDownTimer2, Visitor2mCountDownTimer, Visitor2mCountDownTimer2;
    private boolean mTimerRunning, ToLocalTimerRunning, ToVisitorTimerRunning, Local2mTimerRunning, Local2mTimerRunning2, Visitor2mTimerRunning, Visitor2mTimerRunning2;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private long ToLocalTimeLeftInMillis = TOLOCAL_START_TIME_IN_MILLIS;
    private long ToVisitorTimeLeftInMillis = TOVISITOR_START_TIME_IN_MILLIS;
    private long Local2mTimeLeftInMillis = LOCAL2M_START_TIME_IN_MILLIS;
    private long Visitor2mTimeLeftInMillis = VISITOR2M_START_TIME_IN_MILLIS;

    public static int screen;
    public static int local_goals, visitor_goals;
    public static int local_final_score, local_final_score2, local_final_score3, local_final_score4;
    public static int visitor_final_score, visitor_final_score2, visitor_final_score3, visitor_final_score4;
    public static int local_parts_result, local_parts_result2, local_parts_result3, local_parts_result4;
    public static int visitor_parts_result, visitor_parts_result2, visitor_parts_result3, visitor_parts_result4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_game, container, false);

        local_2m_timer1=root.findViewById(R.id.local_2m_timer1);
        local_2m_timer2=root.findViewById(R.id.local_2m_timer2);
        visitor_2m_timer1=root.findViewById(R.id.visitor_2m_timer1);
        visitor_2m_timer2=root.findViewById(R.id.visitor_2m_timer2);

        local_yc=root.findViewById(R.id.local_yc);
        local_rc=root.findViewById(R.id.local_rc);
        visitor_yc=root.findViewById(R.id.visitor_yc);
        visitor_rc=root.findViewById(R.id.visitor_rc);

        exclusion_local=root.findViewById(R.id.exclusion_local);
        exclusion_visitor=root.findViewById(R.id.exclusion_visitor);

        next2=root.findViewById(R.id.next2);
        next3=root.findViewById(R.id.next3);
        next4=root.findViewById(R.id.next4);

        end_match=root.findViewById(R.id.end_match);

        local_down = root.findViewById(R.id.local_down);
        local_up = root.findViewById(R.id.local_up);

        timeout_countdown_local=root.findViewById(R.id.timeout_countdown_local);
        timeout_countdown_visitor=root.findViewById(R.id.timeout_countdown_visitor);

        timeout_local = root.findViewById(R.id.timeout_local);
        timeout_visitor = root.findViewById(R.id.timeout_visitor);

        visitor_down = root.findViewById(R.id.visitor_down);
        visitor_up = root.findViewById(R.id.visitor_up);

        score_local = root.findViewById(R.id.score_local);
        score_visitor = root.findViewById(R.id.score_visitor);

        text_view_countdown = root.findViewById(R.id.text_view_countdown);
        reset = root.findViewById(R.id.reset);

        score_local.setText("" + local_goals);
        score_visitor.setText("" + visitor_goals);

        next2.setVisibility(View.INVISIBLE);
        next3.setVisibility(View.INVISIBLE);
        next4.setVisibility(View.INVISIBLE);
        end_match.setVisibility(View.INVISIBLE);


        local_yc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Yellow card to local player", Toast.LENGTH_SHORT).show();
            }
        });

        local_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Red card to local player", Toast.LENGTH_SHORT).show();
            }
        });

        visitor_yc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Yellow card to visitor player", Toast.LENGTH_SHORT).show();
            }
        });

        visitor_rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Red card to visitor player", Toast.LENGTH_SHORT).show();
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Part2.class);
                startActivity(i);
                next3.bringToFront();
                next2.setVisibility(GONE);
                local_final_score=local_goals;
                visitor_final_score=visitor_goals;
                if(local_goals>visitor_goals){
                    local_parts_result=3;
                    visitor_parts_result=1;
                }else {
                    local_parts_result=1;
                    visitor_parts_result = 3;
                }
                if(local_goals==visitor_goals){
                    local_parts_result=2;
                    visitor_parts_result=2;
                }
                local_goals=0;
                visitor_goals=0;
            }
        });

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Part3.class);
                startActivity(i);
                next4.bringToFront();
                local_final_score2=local_final_score+local_goals;
                visitor_final_score2=visitor_final_score+visitor_goals;
                if(local_goals>visitor_goals){
                    local_parts_result2=local_parts_result+3;
                    visitor_parts_result2=visitor_parts_result+1;
                }else {
                    local_parts_result2=local_parts_result+1;
                    visitor_parts_result2 = local_parts_result+3;
                }
                if(local_goals==visitor_goals){
                    local_parts_result2=local_parts_result+2;
                    visitor_parts_result2=local_parts_result+2;
                }
                local_goals=0;
                visitor_goals=0;
            }
        });

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Part4.class);
                startActivity(i);
                end_match.bringToFront();
                local_final_score3=local_final_score2+local_goals;
                visitor_final_score3=visitor_final_score2+visitor_goals;
                if(local_goals>visitor_goals){
                    local_parts_result3=local_parts_result2+3;
                    visitor_parts_result3=visitor_parts_result2+1;
                }else {
                    local_parts_result3=local_parts_result2+1;
                    visitor_parts_result3 = local_parts_result2+3;
                }
                if(local_goals==visitor_goals){
                    local_parts_result3=local_parts_result2+2;
                    visitor_parts_result3=local_parts_result2+2;
                }
                local_goals=0;
                visitor_goals=0;
            }
        });

        end_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), FinalActivity.class);
                startActivity(i);
                local_final_score4=local_final_score3+local_goals;
                visitor_final_score4=visitor_final_score3+visitor_goals;
                if(local_goals>visitor_goals){
                    local_parts_result4=local_parts_result3+3;
                    visitor_parts_result4=visitor_parts_result3+1;
                }else {
                    local_parts_result4=local_parts_result3+1;
                    visitor_parts_result4 = local_parts_result3+3;
                }
                if(local_goals==visitor_goals){
                    local_parts_result4=local_parts_result3+2;
                    visitor_parts_result4=local_parts_result3+2;
                }
                local_goals=0;
                visitor_goals=0;
            }
        });

        local_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                local_goals++;
                score_local.setText("" + local_goals);
            }
        });

        local_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (local_goals == 0) {
                    local_goals = 0;
                } else {
                    local_goals--;
                }
                score_local.setText("" + local_goals);
            }
        });

        visitor_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitor_goals++;
                score_visitor.setText("" + visitor_goals);
            }
        });

        visitor_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visitor_goals == 0) {
                    visitor_goals = 0;
                } else {
                    visitor_goals--;
                }
                score_visitor.setText("" + visitor_goals);
            }
        });

        text_view_countdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Local2mTimerRunning) {
                    Local2mPauseTimer();
                }
                if (Local2mTimerRunning2) {
                    Local2mPauseTimer2();
                }
                if (Visitor2mTimerRunning) {
                    Visitor2mPauseTimer();
                }
                if (Visitor2mTimerRunning2) {
                    Visitor2mPauseTimer2();
                }
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();

        timeout_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ToLocalTimerRunning) {
                    ToLocalPauseTimer();
                } else {
                    ToLocalStartTimer();
                }
                Local2mPauseTimer();
                Local2mPauseTimer2();
                Visitor2mPauseTimer();
                Visitor2mPauseTimer2();
                pauseTimer();
            }
        });

        timeout_visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
                if (ToVisitorTimerRunning) {
                    ToVisitorPauseTimer();
                } else {
                    ToVisitorStartTimer();
                }
            }
        });

        exclusion_local.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (Local2mTimerRunning) {
                   local_2m_timer2.setVisibility(View.VISIBLE);
                   Local2mStartTimer2();
               }else {
                   local_2m_timer1.setVisibility(View.VISIBLE);
                   Local2mStartTimer();
               }
           }
       });


    exclusion_visitor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Visitor2mTimerRunning) {
                visitor_2m_timer2.setVisibility(View.VISIBLE);
                Visitor2mStartTimer2();
            }else {
                visitor_2m_timer1.setVisibility(View.VISIBLE);
                Visitor2mStartTimer();
            }
        }
    });
        return root;
    }

    //----------------------------------------------------------------------------------------------

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimeLeftInMillis = START_TIME_IN_MILLIS;
                updateCountDownText();
                if(screen==0) {
                    next2.setVisibility(View.VISIBLE);
                }
                if(screen==1){
                    next3.setVisibility(View.VISIBLE);
                    next2.setVisibility(GONE);
                }
                if(screen==2){
                    next4.setVisibility(View.VISIBLE);
                }
                if(screen==3){
                    end_match.setVisibility(View.VISIBLE);
                }

                reset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        reset.setVisibility(View.INVISIBLE);
    }


    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        reset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        reset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        text_view_countdown.setText(timeLeftFormatted);
    }

    //--------------------------------------------------------------------------------------------------

    private void ToLocalStartTimer() {
        ToLocalCountDownTimer = new CountDownTimer(ToLocalTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long ToLocalMillisUntilFinished) {
                ToLocalTimeLeftInMillis = ToLocalMillisUntilFinished;
                ToLocalUpdateCountDownText();
            }

            @Override
            public void onFinish() {
                ToLocalTimeLeftInMillis = TOLOCAL_START_TIME_IN_MILLIS;
                ToLocalUpdateCountDownText();
            }
        }.start();

        ToLocalTimerRunning = true;
    }

    private void ToLocalPauseTimer() {
        ToLocalCountDownTimer.cancel();
        ToLocalTimerRunning = false;
    }

    private void ToLocalUpdateCountDownText() {
        int minutes = (int) (ToLocalTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (ToLocalTimeLeftInMillis / 1000) % 60;
        String ToLocalTimeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timeout_countdown_local.setText(ToLocalTimeLeftFormatted);
    }

    //-------------------------------------------------------------------------------------------------------

    private void ToVisitorStartTimer() {
        ToVisitorCountDownTimer = new CountDownTimer(ToVisitorTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long ToVisitorMillisUntilFinished) {
                ToVisitorTimeLeftInMillis = ToVisitorMillisUntilFinished;
                ToVisitorUpdateCountDownText();
            }
            @Override
            public void onFinish() {
                ToVisitorTimerRunning = false;
                ToVisitorTimeLeftInMillis = TOVISITOR_START_TIME_IN_MILLIS;
                ToVisitorUpdateCountDownText();
            }
        }.start();
        ToVisitorTimerRunning = true;
    }

    private void ToVisitorPauseTimer() {
        ToVisitorCountDownTimer.cancel();
        ToVisitorTimerRunning = false;
    }

    private void ToVisitorUpdateCountDownText() {
        int minutes = (int) (ToVisitorTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (ToVisitorTimeLeftInMillis / 1000) % 60;
        String ToVisitorTimeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timeout_countdown_visitor.setText(ToVisitorTimeLeftFormatted);
    }

    //-------------------------------------------------------------------------------------------------------

    private void Local2mStartTimer() {
        Local2mCountDownTimer = new CountDownTimer(Local2mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long Local2mMillisUntilFinished) {
                Local2mTimeLeftInMillis = Local2mMillisUntilFinished;
                Local2mUpdateCountDownText();
            }
            @Override
            public void onFinish() {
                Local2mTimerRunning = false;
                Local2mTimeLeftInMillis = LOCAL2M_START_TIME_IN_MILLIS;
                Local2mUpdateCountDownText();
                local_2m_timer1.setVisibility(View.INVISIBLE);
            }
        }.start();
        Local2mTimerRunning = true;
    }

    private void Local2mPauseTimer() {
        Local2mCountDownTimer.cancel();
        Local2mTimerRunning = false;
    }

    private void Local2mUpdateCountDownText() {
        int minutes = (int) (Local2mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (Local2mTimeLeftInMillis / 1000) % 60;
        String Local2mTimeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        local_2m_timer1.setText(Local2mTimeLeftFormatted);
    }

    //-------------------------------------------------------------------------------------------------------

    private void Local2mStartTimer2() {
        Local2mCountDownTimer2 = new CountDownTimer(Local2mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long Local2mMillisUntilFinished2) {
                Local2mTimeLeftInMillis = Local2mMillisUntilFinished2;
                Local2mUpdateCountDownText2();
            }
            @Override
            public void onFinish() {
                Local2mTimerRunning2 = false;
                Local2mTimeLeftInMillis = LOCAL2M_START_TIME_IN_MILLIS;
                Local2mUpdateCountDownText2();
                local_2m_timer2.setVisibility(View.INVISIBLE);
            }
        }.start();
        Local2mTimerRunning2 = true;
    }

    private void Local2mPauseTimer2() {
        Local2mCountDownTimer2.cancel();
        Local2mTimerRunning2 = false;
    }

    private void Local2mUpdateCountDownText2() {
        int minutes = (int) (Local2mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (Local2mTimeLeftInMillis / 1000) % 60;
        String Local2mTimeLeftFormatted2 = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        local_2m_timer2.setText(Local2mTimeLeftFormatted2);
    }

    //-------------------------------------------------------------------------------------------------------

    private void Visitor2mStartTimer() {
        Visitor2mCountDownTimer = new CountDownTimer(Visitor2mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long Visitor2mMillisUntilFinished) {
                Visitor2mTimeLeftInMillis = Visitor2mMillisUntilFinished;
                Visitor2mUpdateCountDownText();
            }
            @Override
            public void onFinish() {
                Visitor2mTimerRunning = false;
                Visitor2mTimeLeftInMillis = VISITOR2M_START_TIME_IN_MILLIS;
                Visitor2mUpdateCountDownText();
            }
        }.start();
        Visitor2mTimerRunning = true;
    }

    private void Visitor2mPauseTimer() {
        Visitor2mCountDownTimer.cancel();
        Visitor2mTimerRunning = false;
    }

    private void Visitor2mUpdateCountDownText() {
        int minutes = (int) (Visitor2mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (Visitor2mTimeLeftInMillis / 1000) % 60;
        String Visitor2mTimeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        visitor_2m_timer1.setText(Visitor2mTimeLeftFormatted);
    }

    //-------------------------------------------------------------------------------------------------------

    private void Visitor2mStartTimer2() {
        Visitor2mCountDownTimer2 = new CountDownTimer(Visitor2mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long Visitor2mMillisUntilFinished2) {
                Visitor2mTimeLeftInMillis = Visitor2mMillisUntilFinished2;
                Visitor2mUpdateCountDownText2();
            }
            @Override
            public void onFinish() {
                Visitor2mTimerRunning2 = false;
                Visitor2mTimeLeftInMillis = VISITOR2M_START_TIME_IN_MILLIS;
                Visitor2mUpdateCountDownText2();
                visitor_2m_timer2.setVisibility(View.INVISIBLE);
            }
        }.start();
        Visitor2mTimerRunning2 = true;
    }

    private void Visitor2mPauseTimer2() {
        Visitor2mCountDownTimer2.cancel();
        Visitor2mTimerRunning2 = false;
    }

    private void Visitor2mUpdateCountDownText2() {
        int minutes = (int) (Visitor2mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (Visitor2mTimeLeftInMillis / 1000) % 60;
        String Visitor2mTimeLeftFormatted2 = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        visitor_2m_timer2.setText(Visitor2mTimeLeftFormatted2);
    }
}