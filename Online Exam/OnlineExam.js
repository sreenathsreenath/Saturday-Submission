var Questions = new Array(
    "1. The father of C,C++ & Unix is",
    "2. The Open source among following is ",
    "3. Pancake Sorting Algorithm and BASIC Interpreter was written by",
    "4. Larry page and Sergei Brinn are Co-Founders of",
    "5. The first computer to defeat Chess Grandmaster was",
    "6.Which one is the first fully supported 64-bit operating system",
    "7. Computer Hard Disk was first introduced in 1956 by",
    "8. Which of the following is not a web browser",
    "9. In computer world, Trojan refer to",
    "10. Which protocol is used to send e-mail",
    "11.  In which year '@' sign was first chosen for its use in e-mail address",
    "12. Which one is the latest one from PARAM SuperSries computers",
    "13. Who is also know as the father of Indian Supercomputing",
    "14. A computer use which type of number system to calculate and to store data",
    "15. What is the shortcut for saving "

);
NoOfQuestions = Questions.length;
QuestionNo = 0;
selectedAnswer=15;
marks=0
Choosed = false;
Answers = new Array(NoOfQuestions);
CorrectAnswers = new Array(NoOfQuestions);
for (var i = 0 ; i < NoOfQuestions ; i++)
	{
	    Answers[i] = new Array(4);
	}

    // [0][0] [0][1] [0][2] [0][3]
    // [1][0] [1][1] [1][2] [1][3]...

Answers[0][0] = "Forouzan";
Answers[0][1] = "Dennis Ritchie";
Answers[0][2] = "Andrew Tenenbaum";
Answers[0][3] = "Dijkstra";
CorrectAnswers[0] = 2;


Answers[1][0] = "Windows XP";
Answers[1][1] = "Mac OS X";
Answers[1][2] = "Linux Ubuntu";
Answers[1][3] = "Sun Solaris";
CorrectAnswers[1] = 4;

Answers[2][0] = "Steve Jobs";
Answers[2][1] = "Steve William";
Answers[2][2] = "Bill Gates";
Answers[2][3] = "Jerry yang";
CorrectAnswers[2] = 3;


Answers[3][0] = "Yahoo";
Answers[3][1] = "Rediff";
Answers[3][2] = "Google";
Answers[3][3] = "Apple";
CorrectAnswers[3] = 3;

Answers[4][0] = "Chess Zeus";
Answers[4][1] = "Armageddon";
Answers[4][2] = "White Knight";
Answers[4][3] = "Deep Blue";
CorrectAnswers[4] = 4;

Answers[5][0] = "Windows Vista"; 
Answers[5][1] = " Mac";
Answers[5][2] = "Linux";
Answers[5][3] = "Windows XP";
CorrectAnswers[5] = 3;


Answers[6][0] = "Dell"; 
Answers[6][1] = " Microsoft ";
Answers[6][2] = " Apple ";
Answers[6][3] = " IBM ";
CorrectAnswers[6] = 4;


Answers[7][0] = "Mosaic"; 
Answers[7][1] = " www";
Answers[7][2] = " Facebook";
Answers[7][3] = " Netscpe navigator  ";
CorrectAnswers[7] = 3;



Answers[8][0] = "Virus"; 
Answers[8][1] = "Worm";
Answers[8][2] = "Malware";
Answers[8][3] = " Spyware  ";
CorrectAnswers[8] = 3;


Answers[9][0] = "HTTP"; 
Answers[9][1] = "POP3";
Answers[9][2] = "SMTP";
Answers[9][3] = " SSH  ";
CorrectAnswers[9] = 3;


Answers[10][0] = "1976"; 
Answers[10][1] = "1977";
Answers[10][2] = "1972";
Answers[10][3] = " 1980  ";
CorrectAnswers[10] = 3;


Answers[11][0] = "PARAM Yuva II"; 
Answers[11][1] = "PARAM 10000";
Answers[11][2] = "PARAM Padma";
Answers[11][3] = "PARAMnet ";
CorrectAnswers[11] = 1;


Answers[12][0] = "Ragunath Mashelkar"; 
Answers[12][1] = "Vijay Bhatkar";
Answers[12][2] = " Jayant Narlikar";
Answers[12][3] = "Nandan Nilekani ";
CorrectAnswers[12] = 2;



Answers[13][0] = "decimal"; 
Answers[13][1] = " octal";
Answers[13][2] = "binary";
Answers[13][3] = " hexadecimal ";
CorrectAnswers[13] = 3;

Answers[14][0] = "ctrl+s"; 
Answers[14][1] = " ctrl+v";
Answers[14][2] = "ctrl+x";
Answers[14][3] = " ctrl+z ";
CorrectAnswers[14] = 1;




function AnswerChoosed(ans) {
    selectedAnswer = ans;   
    Choosed=true; 
}

function nextQuestion() {
    if (Choosed) {
        if (selectedAnswer == CorrectAnswers[QuestionNo]) {
            marks++;
        }
    if (QuestionNo < NoOfQuestions-1) {
        QuestionNo++;
        loadQuestion();
        Choosed=false;
    } else {
        alert("End of Examination \n"+"Marks Are : "+marks+"");
    }
  } else {
      alert("Please Select any option...");
  }
}

function loadQuestion() {
    document.getElementById("Question").innerHTML=Questions[QuestionNo];
    document.getElementById("Option0").innerHTML = "(a) " + Answers[QuestionNo][0];
	document.getElementById("Option1").innerHTML = "(b) " + Answers[QuestionNo][1];
	document.getElementById("Option2").innerHTML = "(c) " + Answers[QuestionNo][2];
	document.getElementById("Option3").innerHTML = "(d) " + Answers[QuestionNo][3];
    document.getElementById("Opt1").checked = false;	
	document.getElementById("Opt2").checked = false;	
	document.getElementById("Opt3").checked = false;	
	document.getElementById("Opt4").checked = false;
}
