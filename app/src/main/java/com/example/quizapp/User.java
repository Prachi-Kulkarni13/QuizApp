package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class User extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore=0, questionAttempted =0,currentPos;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);
        userName=getIntent().getStringExtra("name");
        questionTV=findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModelArrayList =new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos=random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()))
                    currentScore++;
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase()))
                    currentScore++;
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase()))
                    currentScore++;
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase()))
                    currentScore++;
                questionAttempted++;
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(User.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV=bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn=bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText(userName+"'s score is \n"+currentScore+"/10");
        TextView performance=bottomSheetView.findViewById(R.id.textView2);
        if (currentScore<=3)
            performance.setText("Poor");
        else if (currentScore>3 && currentScore<=5)
            performance.setText("Satisfactory");
        else if (currentScore>5 && currentScore<8)
            performance.setText("Good");
        else
            performance.setText("Great");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted =0;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted: "+ questionAttempted +"/10");
        if (questionAttempted ==10)
            showBottomSheet();
        else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("Which data structure is used as LIFO?","Array","Int","Stack","Queue","Stack"));
        quizModelArrayList.add(new QuizModel("Which of the following is not a high level programming language?","Assembly","Java","C++","Python","Assembly"));
        quizModelArrayList.add(new QuizModel("Identify the scope resolution operator.",":","::","?:","None","::"));
        quizModelArrayList.add(new QuizModel("Total types of constructors in C++ are","1","2","3","4","3"));
        quizModelArrayList.add(new QuizModel("What is used to access data members of a class?","Dot","Arrow","Dot or Arrow","None of the above","Dot or Arrow"));
        quizModelArrayList.add(new QuizModel("What is the universal class for exception handling?","Object","Errors","Exceptions","Maths","Exceptions"));
        quizModelArrayList.add(new QuizModel("How many catch blocks you can use with single try block?","Only 2","Only 1","Maximun 256","As many as required","As many as required"));
        quizModelArrayList.add(new QuizModel("Encapsulation means?","Data hiding","Inheritance","Polymorphism","None of the above","Data hiding"));
        quizModelArrayList.add(new QuizModel("Which operator overloads using the friend function?","=","->","*","()","*"));
        quizModelArrayList.add(new QuizModel("Which feature of OOPs describes reusability of code?","Inheritance","Abstraction","Polymorphism","Encapsulation","Inheritance"));
        quizModelArrayList.add(new QuizModel("Which operator can be used to free the memory allocated for an object in C++?","Unallocate","Free()","Control","delete","delete"));
        quizModelArrayList.add(new QuizModel("Which keyword should be used to declare static variables?","const","common","static","stat","static"));
        quizModelArrayList.add(new QuizModel("Which feature can be implemented using encapsulation?","Polymorphism","Inheritance","Overloading","Abstraction","Abstraction"));
        quizModelArrayList.add(new QuizModel("Which among the following is called first, automatically, whenever an object is created?","Class","Constructor","New","Trigger","Constructor"));
        quizModelArrayList.add(new QuizModel("Which type of members can’t be accessed in derived classes of a base class?","All can be accrssed","Protected","Private","Public","Private"));
    }
}