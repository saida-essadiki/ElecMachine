create database election_machine;
use election_machine;
CREATE TABLE CANDIDATES (
   CANDIDATE_ID INTEGER NOT NULL,
   SURNAME VARCHAR (25),
   FIRST_NAME VARCHAR (25),
   PARTY VARCHAR (50),
   LOCATION VARCHAR (25),
   IKA INTEGER,
   WHY_COMMISSION VARCHAR (250),
   WHAT_ATHES_WANT_EDES VARCHAR (2000),
   PROFESSIONAL VARCHAR (50),
   PRIMARY KEY (CANDIDATE_ID)
);
CREATE TABLE QUESTIONS (
   QUESTION_ID INTEGER NOT NULL,
   QUESTION VARCHAR (3000),
   PRIMARY KEY (QUESTION_ID)
);
CREATE TABLE ANSWERS (
   CANDIDATE_ID INTEGER NOT NULL,
   QUESTION_ID INTEGER NOT NULL,
   ANSWER INTEGER,
   COMMENTS VARCHAR (50),
   PRIMARY KEY (CANDIDATE_ID, QUESTION_ID)
);
#This line is to handle utf8 character needs (like ä and ö) if you have not set utf8 encoding already default for your mysql
ALTER DATABASE election_machine CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO CANDIDATES VALUES (1, "Perch Lake" ,"Joel", "Finland's Christian Democrats (KD)", "Uurainen", 86, "Ideally I'd do something else, but the kingdom is to be corrected. I get along about eight languages, and I am familiar with many fields Urban and rural common sense. "," I want to promote Finland, where no one has to suffer from deprivation or a feeling of powerlessness in influencing their own affairs. "," Member of Parliament ");
INSERT INTO CANDIDATES VALUES (2, "Aintila "," Henrik Jeremias "," Finland's Swedish People's party "," Helsinki ", 47," I am a speech-proof, versatile things a prudent, thorough things to cope with, a variety of common, the business world and public administration worked three children mother. "," - Human livelihood and genuine equality for all, regardless of status - Genuine sovereignty and impartiality - The well-being of the people over corporate profits - Transparency in matters dealt with! "," Local nurse ");
INSERT INTO CANDIDATES VALUES (3, "Aittakumpu", "Alviina", "Left Alliance", "Jämsä", 46, "I know various silent grievances. For example, issues related to corruption and dishonesty. For democracy to work so full honesty is required.", " Finnish markka alongside the euro, and to sell Finland's domestic economy in good shape. Jobs in the public and private sectors; investments and basic income in Finnish marks; much easier business conditions and employment incentives. Discourage tax havens with parallel currency. "," Teacher, Member of Parliament ");
INSERT INTO CANDIDATES VALUES (4, "Ala-Kokko", "Henri", "Green League", "Espoo", 87, "I go ahead, for independence, the countryside, Finnishness and social justice.", "The role of the elderly and carers There is no need for more cuts in services for the elderly and more money for preventive services, support for family care needs to be increased and enough holidays need to be provided for every caregiver, employment needs to be supported and their working conditions need to be monitored We have a lot of hard working young people who need positive experience of the workplace. "," Chief Nurse, Chief shop steward ");
INSERT INTO CANDIDATES VALUES (5, "Ala-Nissilä", "Benjamin", "Suomen Keskusta", "Lappajärvi", 26, "I want a change in the current government activities, the activities have not met the expectations of the Katainen-Stubb government, the state has more debt than never "," Finland's difference from the EU. Introduction of the national central bank's own currency in Finland. Termination of the host country agreement between Finland and NATO and return to neutrality. Securing welfare state services with the help of the central bank, national currency and independent economic policy. "," Metallimies " );
INSERT INTO CANDIDATES VALUES (6, "Lower Reinikka "," Karl-Mikael "," National Coalition ", "the Black Island ", 37," Because I am brave and honest -. Ylipäänsäkin parliament should choose only those with the right kind of education and Education."," The reform of working life and educational institutions - people's individuality must be taken into account through flexible working hours, mobile work, teaching methods. The 8-hour system is old-fashioned and needs reform. More creativity in working life! K "," Lecturer in Physical Education ");
INSERT INTO CANDIDATES VALUES (7, "Lower Forest", "Grain", "Green Alliance", "Eagle", 82, "If you want the same expenditure to continue in the next parliamentary term, skip this candidate. If you want a change then you are at the right address.", " It is absolutely paramount to build good relations with non-EU countries as well. We need more trade to increase our exports and create new jobs while maintaining existing ones. "," Junior Hockey Club Liaison Manager ");
INSERT INTO CANDIDATES VALUES (8, "Olando-Kahiluoto", "Sara", "Green Alliance", "Nokia", 21, "I want to contribute to the well-being of society through politics. Defending Finland's military non-alignment and foreign policy neutrality."," Supporting the University of Education and non-profit research. These issues include opposition to EU, EMU, NATO and TTIP memberships. "," Lecturer in Mother Tongue and Literature ");
INSERT INTO CANDIDATES VALUES (9, "Alasalmi", "Otto", "Finnish Social Democratic Party", "Varkaus", 30, "Finland needs new ideas and I can find them. This country needs to cooperate. I look forward, I believe in the better and I defend the weakest . "," Leaving the EU is the most important thing! I've never done paid work, so entrepreneurship is also a matter of the heart! No NATO, no EU, no TTIP, no GMO, no euro! YES INDEPENDENCE AND PEOPLE! Finland must also have a Constitutional Court that oversees what the government does and the legality of its decisions! The EEA Agreement is enough for us! It guarantees training, mobility and trade within the EU! "," Freelancer ");
INSERT INTO CANDIDATES VALUES (10, "Alatalo", "Cosmo", " Center Party of Finland", "Tampere ", 68," I am an energetic matters common to the nurse, and I have 20 years of experience in the management of human affairs. In recent municipal elections, I received a sign of trust ääniharavan station in my city . "," Politicians do not create jobs, but constructive frameworks. The employment rate must be raised to the level of Sweden, and structural reforms in the public sector as well as in the labor market must be made to substantially reduce taxation and barriers to employment. Unnecessary rules and prohibitions on entrepreneurship and the economy. I will focus on preventing unemployment and exclusion. "," Student / Employee ");
# CANDIDATE 11&12 are missed- something wrong in their data.
INSERT INTO CANDIDATES VALUES (13, "Alho", "Inna", "National Coalition Party", "Kouvola", 62, "I want to promote the growth of holistic well-being without interest-oriented policy orientation.", "Promoting employment and investing in education are key to future well-being. Work is a guarantee of well-being at both the individual and collective levels. Therefore, barriers to employment must be removed. Education is the key to the future - now is the time to start developing Finnish school and learning! " ,"mixed worker ");
INSERT INTO CANDIDATES VALUES (14, "Alhojärvi", "Mikael", "Finnish Communist Party", "Lappeenranta", 19, "Unlike Parliament, not just one, but several new perspectives.", "A fighter for fundamental rights. Transparency, reliability and keeping his promises, the jacket will not turn even after the election. "," Lieutenant Colonel evp, taxi driver ");
INSERT INTO CANDIDATES VALUES (15, "Alho Noro "," Jasmine "," Green League "," Tampere ", 53," I am ready to run even larger structural reforms to improve Finland's competitiveness. I am confident the Finns that they themselves know what is best for themselves and not so much power. "," Long-term experience in working with people - company, sports and organizers. Working in municipal politics in the 80's and 90's ... "," Photographer, ark.yo ");
INSERT INTO CANDIDATES VALUES (16, "Alijärvi", "Daniel", "Finnish Social Democratic Party", "Helsinki", 20, "I keep my word", "Decision-making needs future MPs who are competent, cooperative, experienced and have good leadership skills.", " specialist ");
INSERT INTO CANDIDATES VALUES (17, "Allahmoradi", "Tuomas", "Vasemmistoliitto", "Inkoo", 73, "Fär att det behäv nägon som "," Own country strawberry, other country blueberry "," Mediapastori ");
INSERT INTO CANDIDATES VALUES (18, "Anderson", "Otto", "Swedish People's Party of Finland", "Vantaa", 45, "Through my special assistant work, I have solid experience in national politics. I control the various twists and turns and get things done.", " parliament is needed pirated Technological development is the greatest force for change in society, and it must be taken into account päätäksentekoprosessissa I DI / physicist and teacher, knowledgeable contributor agriculture and forestry practitioner"," sijaispappi ");
INSERT INTO CANDIDATES VALUES (19, "Andersson" ," Cosmo "," Left "," Joensuu ", 41," I think it should be dedicated member of parliament who is freedom and social justice based on the values, strong opinions, and the ability COOPERATION. "," I'm irreligious supporter of individual freedom. NATO affirmative, supporter of nuclear power. "," Member of Parliament ");
INSERT INTO CANDIDATES VALUES (20, "Andersson", "Essi", "Swedish People's Party of Finland", "Kouvola", 63, "FINLAND'S ECONOMIC OUTLOOK IS A DISASTERFUL) It is important to start raising the Finnish economy. from some other alliance. "," I have a strong scientific education as a doctor of physics and as a software entrepreneur a lot of experience in society, including public administration. Vision and ability to reform is my strength. "," master builder ");

select * from CANDIDATES;


# insert values ​​into the table questions
INSERT INTO QUESTIONS VALUES (1, "It is too easy to live on social security in Finland");
INSERT INTO QUESTIONS VALUES (2, "The opening hours of trade and other shops must be liberalized.");
INSERT INTO QUESTIONS VALUES (3, "Finland needs to move to a basic income that would replace the current minimum level of social security.");
INSERT INTO QUESTIONS VALUES (4, "The employee must be guaranteed by law a minimum working time.");
INSERT INTO QUESTIONS VALUES (5, "The duration of earnings-related occupational safety must be shortened.");
INSERT INTO QUESTIONS VALUES (6, "Outside the euro, Finland would do better.");
INSERT INTO QUESTIONS VALUES (7, "Food taxation can afford to tighten.");
INSERT INTO QUESTIONS VALUES (8, "The state and municipal finances must be balanced primarily by cutting spending.");
INSERT INTO QUESTIONS VALUES (9, "Child benefits must be increased and taxed.");
INSERT INTO QUESTIONS VALUES (10, "Finland cannot afford social and health services on the current scale.");
INSERT INTO QUESTIONS VALUES (11, "NATO membership would strengthen Finland's security policy position.");
INSERT INTO QUESTIONS VALUES (12, "Finland needs more police.");
INSERT INTO QUESTIONS VALUES (13, "Immigration to Finland must be restricted due to the threat of terrorism.");
INSERT INTO QUESTIONS VALUES (14, "Russia's policy of interests is a threat to Finland.");
INSERT INTO QUESTIONS VALUES (15, "In network surveillance, state security is more important than the protection of citizens' privacy.");
INSERT INTO QUESTIONS VALUES (16, "Finland must participate in the fight against Isis by training Iraqi government forces.");
INSERT INTO QUESTIONS VALUES (17, "The terminally ill must have the right to assisted death.");
INSERT INTO QUESTIONS VALUES (18, "Health and social services must be provided primarily as public services.");
INSERT INTO QUESTIONS VALUES (19, "Authorities need to address the problems of families with children more sensitively.");


# insert values ​​into the table answers(only answer all for candidate 1 and 1 answer for candidate 2
INSERT INTO ANSWERS VALUES (1, 1, 2, "candidate 1's answer to question 1");
INSERT INTO ANSWERS VALUES (1, 2, 4, "candidate 1's answer to question 2");
INSERT INTO ANSWERS VALUES (1, 3, 3, "candidate 1's answer to question 3");
INSERT INTO ANSWERS VALUES (1, 4, 2, "candidate 1's answer to question 4");
INSERT INTO ANSWERS VALUES (1, 5, 1, "candidate 1's answer to question 5");
INSERT INTO ANSWERS VALUES (1, 6, 2, "candidate 1's answer to question 6");
INSERT INTO ANSWERS VALUES (1, 7, 5, "candidate 1's answer to question 7");
INSERT INTO ANSWERS VALUES (1, 8, 2, "candidate 1's answer to question 8");
INSERT INTO ANSWERS VALUES (1, 9, 4, "candidate 1's answer to question 9");
INSERT INTO ANSWERS VALUES (1, 10, 1, "candidate 1's answer to question 10");
INSERT INTO ANSWERS VALUES (1, 11, 1, "candidate 1's answer to question 11");
INSERT INTO ANSWERS VALUES (1, 12, 2, "candidate 1's answer to question 12");
INSERT INTO ANSWERS VALUES (1, 13, 4, "candidate 1's answer to question 13");
INSERT INTO ANSWERS VALUES (1, 14, 5, "candidate 1's answer to question 14");
INSERT INTO ANSWERS VALUES (1, 15, 3, "candidate 1's answer to question 15");
INSERT INTO ANSWERS VALUES (1, 16, 1, "candidate 1's answer to question 16");
INSERT INTO ANSWERS VALUES (1, 17, 4, "candidate 1's answer to question 17");
INSERT INTO ANSWERS VALUES (1, 18, 4, "candidate 1's answer to question 18");
INSERT INTO ANSWERS VALUES (1, 19, 3, "candidate 1's answer to question 19");

INSERT INTO ANSWERS VALUES (2, 1, 4, "candidate 2's answer to question 1");
INSERT INTO ANSWERS VALUES (2, 2, 5, "candidate 2's answer to question 2");
INSERT INTO ANSWERS VALUES (2, 3, 3, "candidate 2's answer to question 3");
INSERT INTO ANSWERS VALUES (2, 4, 2, "candidate 2's answer to question 4");
INSERT INTO ANSWERS VALUES (2, 5, 4, "candidate 2's answer to question 5");
INSERT INTO ANSWERS VALUES (2, 6, 5, "candidate 2's answer to question 6");
INSERT INTO ANSWERS VALUES (2, 7, 3, "candidate 2's answer to question 7");
INSERT INTO ANSWERS VALUES (2, 8, 1, "candidate 2's answer to question 8");
INSERT INTO ANSWERS VALUES (2, 9, 1, "candidate 2's answer to question 9");
INSERT INTO ANSWERS VALUES (2, 10, 2, "candidate 2's answer to question 10");
INSERT INTO ANSWERS VALUES (2, 11, 4, "candidate 2's answer to question 11");
INSERT INTO ANSWERS VALUES (2, 12, 5, "candidate 2's answer to question 12");
INSERT INTO ANSWERS VALUES (2, 13, 3, "candidate 2's answer to question 13");
INSERT INTO ANSWERS VALUES (2, 14, 2, "candidate 2's answer to question 14");
INSERT INTO ANSWERS VALUES (2, 15, 4, "candidate 2's answer to question 15");
INSERT INTO ANSWERS VALUES (2, 16, 5, "candidate 2's answer to question 16");
INSERT INTO ANSWERS VALUES (2, 17, 3, "candidate 2's answer to question 17");
INSERT INTO ANSWERS VALUES (2, 18, 4, "candidate 2's answer to question 18");
INSERT INTO ANSWERS VALUES (2, 19, 5, "candidate 2's answer to question 19");

INSERT INTO ANSWERS VALUES (3, 1, 2, "candidate 3's answer to question 1");
INSERT INTO ANSWERS VALUES (3, 2, 1, "candidate 3's answer to question 2");
INSERT INTO ANSWERS VALUES (3, 3, 2, "candidate 3's answer to question 3");
INSERT INTO ANSWERS VALUES (3, 4, 5, "candidate 3's answer to question 4");
INSERT INTO ANSWERS VALUES (3, 5, 2, "candidate 3's answer to question 5");
INSERT INTO ANSWERS VALUES (3, 6, 4, "candidate 3's answer to question 6");
INSERT INTO ANSWERS VALUES (3, 7, 1, "candidate 3's answer to question 7");
INSERT INTO ANSWERS VALUES (3, 8, 1, "candidate 3's answer to question 8");
INSERT INTO ANSWERS VALUES (3, 9, 2, "candidate 3's answer to question 9");
INSERT INTO ANSWERS VALUES (3, 10, 4, "candidate 3's answer to question 10");
INSERT INTO ANSWERS VALUES (3, 11, 5, "candidate 3's answer to question 11");
INSERT INTO ANSWERS VALUES (3, 12, 3, "candidate 3's answer to question 12");
INSERT INTO ANSWERS VALUES (3, 13, 1, "candidate 3's answer to question 13");
INSERT INTO ANSWERS VALUES (3, 14, 4, "candidate 3's answer to question 14");
INSERT INTO ANSWERS VALUES (3, 15, 4, "candidate 3's answer to question 15");
INSERT INTO ANSWERS VALUES (3, 16, 3, "candidate 3's answer to question 16");
INSERT INTO ANSWERS VALUES (3, 17, 3, "candidate 3's answer to question 17");
INSERT INTO ANSWERS VALUES (3, 18, 3, "candidate 3's answer to question 18");
INSERT INTO ANSWERS VALUES (3, 19, 1, "candidate 3's answer to question 19");

INSERT INTO ANSWERS VALUES (4, 1, 4, "candidate 4's answer to question 1");
INSERT INTO ANSWERS VALUES (4, 2, 4, "candidate 4's answer to question 2");
INSERT INTO ANSWERS VALUES (4, 3, 3, "candidate 4's answer to question 3");
INSERT INTO ANSWERS VALUES (4, 4, 4, "candidate 4's answer to question 4");
INSERT INTO ANSWERS VALUES (4, 5, 1, "candidate 4's answer to question 5");
INSERT INTO ANSWERS VALUES (4, 6, 1, "candidate 4's answer to question 6");
INSERT INTO ANSWERS VALUES (4, 7, 2, "candidate 4's answer to question 7");
INSERT INTO ANSWERS VALUES (4, 8, 4, "candidate 4's answer to question 8");
INSERT INTO ANSWERS VALUES (4, 9, 5, "candidate 4's answer to question 9");
INSERT INTO ANSWERS VALUES (4, 10, 3, "candidate 4's answer to question 10");
INSERT INTO ANSWERS VALUES (4, 11, 2, "candidate 4's answer to question 11");
INSERT INTO ANSWERS VALUES (4, 12, 4, "candidate 4's answer to question 12");
INSERT INTO ANSWERS VALUES (4, 13, 4, "candidate 4's answer to question 13");
INSERT INTO ANSWERS VALUES (4, 14, 1, "candidate 4's answer to question 14");
INSERT INTO ANSWERS VALUES (4, 15, 1, "candidate 4's answer to question 15");
INSERT INTO ANSWERS VALUES (4, 16, 2, "candidate 4's answer to question 16");
INSERT INTO ANSWERS VALUES (4, 17, 4, "candidate 4's answer to question 17");
INSERT INTO ANSWERS VALUES (4, 18, 5, "candidate 4's answer to question 18");
INSERT INTO ANSWERS VALUES (4, 19, 3, "candidate 4's answer to question 19");


select * from ANSWERS;